package gr.zyxt.exodus.core.presenters;

import android.content.Intent;
import android.net.Uri;

import gr.zyxt.exodus.R;
import gr.zyxt.exodus.core.contracts.EnterShopNameContract;

import static android.content.Intent.ACTION_VIEW;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class EnterShopNamePresenter implements EnterShopNameContract.Presenter {
    private EnterShopNameContract.View view;

    public EnterShopNamePresenter(EnterShopNameContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void sendSMS(String shopName) {
        if (view != null) {
            String smsBody = view.provideContext().getString(R.string.sms_txt_shop, shopName);
            Intent intent = new Intent(ACTION_VIEW, Uri.parse("sms:13032"));
            intent.putExtra("sms_body", smsBody);
            view.provideContext().startActivity(Intent.createChooser(intent, "Αποστολή μέσω: "));
        }
    }
}
