package gr.zyxt.exodus.activity.onboarding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.core.contracts.FullNameContract;
import gr.zyxt.exodus.core.presenters.FullNamePresenter;

public class EnterFullNameActivity extends AppCompatActivity implements FullNameContract.View {
    private EditText mFullName;

    private FullNameContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_full_name);

        setPresenter(new FullNamePresenter(this));

        mFullName = findViewById(R.id.full_name);
        Button continueBtn = findViewById(R.id.continue_button);

        continueBtn.setOnClickListener(v -> {
            String fullName = mFullName.getText().toString().trim();
            presenter.continueToNextScreen(fullName);
        });
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
    public void setPresenter(FullNameContract.Presenter presenter) {
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
