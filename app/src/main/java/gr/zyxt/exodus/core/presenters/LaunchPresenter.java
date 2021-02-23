package gr.zyxt.exodus.core.presenters;

import android.content.Intent;
import android.text.TextUtils;

import gr.zyxt.exodus.activity.MainControlsActivity;
import gr.zyxt.exodus.activity.onboarding.WelcomeActivity;
import gr.zyxt.exodus.core.contracts.LaunchContract;
import gr.zyxt.exodus.preference.Pref;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class LaunchPresenter implements LaunchContract.Presenter {
    private LaunchContract.View view;

    public LaunchPresenter(LaunchContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void coordinate() {
        if (view != null) {
            String fullName = Pref.getInstance().getFullName();
            String address = Pref.getInstance().getAddress();

            boolean isFullNameEmpty = TextUtils.isEmpty(fullName);
            boolean isAddressEmpty = TextUtils.isEmpty(address);

            boolean continueToWelcome = isFullNameEmpty || isAddressEmpty;

            if (continueToWelcome) {
                view.provideContext().startActivity(
                        new Intent(
                                view.provideContext(),
                                WelcomeActivity.class
                        )
                );
            } else {
                view.provideContext().startActivity(
                        new Intent(
                                view.provideContext(),
                                MainControlsActivity.class
                        )
                );
            }
        }
    }
}
