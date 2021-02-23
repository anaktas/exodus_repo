package gr.zyxt.exodus.core.presenters;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;

import gr.zyxt.exodus.R;
import gr.zyxt.exodus.activity.onboarding.EnterAddressActivity;
import gr.zyxt.exodus.core.contracts.FullNameContract;
import gr.zyxt.exodus.preference.Pref;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class FullNamePresenter implements FullNameContract.Presenter {
    private FullNameContract.View view;

    public FullNamePresenter(FullNameContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void continueToNextScreen(String fullName) {
        if (view != null) {
            if (TextUtils.isEmpty(fullName)) {
                Toast.makeText(view.provideContext(), "Παρακαλώ συμπληρώστε το πεδίο", Toast.LENGTH_LONG).show();
            } else {
                Pref.getInstance().setFullName(fullName);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    view.provideContext().startActivity(new Intent(view.provideContext(), EnterAddressActivity.class));
                    view.provideActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }, 200);
            }
        }
    }
}
