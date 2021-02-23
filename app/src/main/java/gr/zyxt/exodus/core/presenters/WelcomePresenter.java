package gr.zyxt.exodus.core.presenters;

import android.content.Intent;
import android.os.Handler;

import gr.zyxt.exodus.R;
import gr.zyxt.exodus.activity.onboarding.EnterFullNameActivity;
import gr.zyxt.exodus.core.contracts.WelcomeContract;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class WelcomePresenter implements WelcomeContract.Presenter {
    private WelcomeContract.View view;

    public WelcomePresenter(WelcomeContract.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void continueToNextScreen() {
        if (view != null) {
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                view.provideContext().startActivity(new Intent(view.provideContext(), EnterFullNameActivity.class));
                view.provideActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }, 200);
        }
    }
}
