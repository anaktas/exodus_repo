package gr.zyxt.exodus.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.core.contracts.SettingsContract;
import gr.zyxt.exodus.core.presenters.SettingsPresenter;

public class SettingsActivity extends AppCompatActivity implements SettingsContract.View {
    private EditText mFullName;
    private EditText mAddress;

    private SettingsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setPresenter(new SettingsPresenter(this));

        mFullName = findViewById(R.id.full_name);
        mAddress = findViewById(R.id.address);

        Button save = findViewById(R.id.save_button);
        save.setOnClickListener(v -> {
            String fullName = mFullName.getText().toString();
            String address = mAddress.getText().toString();

            presenter.save(fullName, address);
        });

        presenter.loadData();
    }

    @Override
    public void onBackPressed() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(this, MainControlsActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }, 200);
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setPresenter(SettingsContract.Presenter presenter) {
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

    @Override
    public void onLoadData(String fullName, String address) {
        mFullName.setText(fullName);
        mAddress.setText(address);
    }
}
