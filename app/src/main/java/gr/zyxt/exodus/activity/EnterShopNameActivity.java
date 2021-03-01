package gr.zyxt.exodus.activity;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.core.contracts.EnterShopNameContract;
import gr.zyxt.exodus.core.presenters.EnterShopNamePresenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;

public class EnterShopNameActivity extends AppCompatActivity implements EnterShopNameContract.View {
    private EditText shopName;
    private Button continueButton;

    private EnterShopNameContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_shop_name);

        setPresenter(new EnterShopNamePresenter(this));

        shopName = findViewById(R.id.shop_name);
        continueButton = findViewById(R.id.continue_button);

        continueButton.setOnClickListener(v -> {
            String name = shopName.getText().toString().trim();
            presenter.sendSMS(name);
        });
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
    public void setPresenter(EnterShopNameContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Context provideContext() {
        return this;
    }
}