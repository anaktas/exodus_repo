package gr.zyxt.exodus.core.presenters;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;

import gr.zyxt.exodus.R;
import gr.zyxt.exodus.activity.SettingsActivity;
import gr.zyxt.exodus.core.contracts.MainControlsContract;
import gr.zyxt.exodus.enumeration.ReasonEnum;
import gr.zyxt.exodus.preference.Pref;
import gr.zyxt.exodus.util.Utils;

import static android.content.Intent.ACTION_VIEW;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class MainControlsPresenter implements MainControlsContract.Presenter {
    private MainControlsContract.View view;

    public MainControlsPresenter(MainControlsContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void loadReasons() {
        if (view != null) {
            view.onLoadReasons(Utils.getReasonList());
        }
    }

    @Override
    public void sendSMS(ReasonEnum reason, int position) {
        if (view != null) {
            String fullName = Pref.getInstance().getFullName();
            String address = Pref.getInstance().getAddress();
            String smsBody = view.provideContext().getString(R.string.sms_text, ("" + (position + 1)), fullName, address);
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("sms:13033"));
            intent.putExtra("sms_body", smsBody);
            view.provideContext().startActivity(Intent.createChooser(intent, "Αποστολή μέσω: "));
        }
    }

    @Override
    public void goToSettings() {
        if (view != null) {
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                view.provideContext().startActivity(new Intent(view.provideContext(), SettingsActivity.class));
                view.provideActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }, 200);
        }
    }
}
