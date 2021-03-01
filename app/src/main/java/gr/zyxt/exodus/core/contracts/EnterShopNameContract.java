package gr.zyxt.exodus.core.contracts;

import android.content.Context;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class EnterShopNameContract {
    public interface View {
        void setPresenter(Presenter presenter);
        Context provideContext();
    }

    public interface Presenter {
        void onDestroy();
        void sendSMS(String shopName);
    }
}
