package gr.zyxt.exodus.activity.onboarding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.core.contracts.WelcomeContract;
import gr.zyxt.exodus.core.presenters.WelcomePresenter;

public class WelcomeActivity extends AppCompatActivity implements WelcomeContract.View {
    private WelcomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setPresenter(new WelcomePresenter(this));

        Button continueBtn = findViewById(R.id.continue_button_welcome);

        continueBtn.setOnClickListener(v -> presenter.continueToNextScreen());
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        // Prevent user to click the back button
    }

    @Override
    public void setPresenter(WelcomeContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Context provideContext() {
        return this;
    }

    @Override
    public Activity provideActivity() {
        return this;
    }
}
