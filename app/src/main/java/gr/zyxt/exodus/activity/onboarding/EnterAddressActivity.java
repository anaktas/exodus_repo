package gr.zyxt.exodus.activity.onboarding;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.core.contracts.AddressContract;
import gr.zyxt.exodus.core.presenters.AddressPresenter;

public class EnterAddressActivity extends AppCompatActivity implements AddressContract.View {
    private EditText mAddress;
    private AddressContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_address);

        setPresenter(new AddressPresenter(this));

        mAddress = findViewById(R.id.address);
        Button continueBtn = findViewById(R.id.continue_button);

        continueBtn.setOnClickListener(v -> {
            String address = mAddress.getText().toString().trim();
            presenter.continueToNextScreen(address);
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
    public void setPresenter(AddressContract.Presenter presenter) {
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
