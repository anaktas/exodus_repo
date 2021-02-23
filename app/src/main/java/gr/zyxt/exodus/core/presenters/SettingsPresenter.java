package gr.zyxt.exodus.core.presenters;

import android.text.TextUtils;
import android.widget.Toast;

import gr.zyxt.exodus.core.contracts.SettingsContract;
import gr.zyxt.exodus.preference.Pref;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class SettingsPresenter implements SettingsContract.Presenter {
    private SettingsContract.View view;

    public SettingsPresenter(SettingsContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void loadData() {
        if (view != null) {
            view.onLoadData(
                    Pref.getInstance().getFullName().trim(),
                    Pref.getInstance().getAddress().trim()
            );
        }
    }

    @Override
    public void save(String fullName, String address) {
        if (view != null) {
            if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(address)) {
                Toast.makeText(view.provideContext(), "Παρακαλώ συμπληρώστε το πεδίο", Toast.LENGTH_LONG).show();
                return;
            }

            Pref.getInstance().setFullName(fullName.trim());
            Pref.getInstance().setAddress(address.trim());

            view.provideActivity().onBackPressed();
        }
    }
}
