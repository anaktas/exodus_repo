package gr.zyxt.exodus.core.presenters;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import gr.zyxt.exodus.R;
import gr.zyxt.exodus.activity.MainControlsActivity;
import gr.zyxt.exodus.core.contracts.AddressContract;
import gr.zyxt.exodus.preference.Pref;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class AddressPresenter implements AddressContract.Presenter {
    private AddressContract.View view;

    public AddressPresenter(AddressContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void continueToNextScreen(String address) {
        if (view != null) {
            if (TextUtils.isEmpty(address)) {
                Toast.makeText(view.provideContext(), "Παρακαλώ συμπληρώστε το πεδίο", Toast.LENGTH_LONG).show();
            } else {
                Pref.getInstance().setAddress(address);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    view.provideContext().startActivity(new Intent(view.provideContext(), MainControlsActivity.class));
                    view.provideActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }, 200);
            }
        }
    }
}
