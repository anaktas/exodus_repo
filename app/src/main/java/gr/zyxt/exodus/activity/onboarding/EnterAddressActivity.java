package gr.zyxt.exodus.activity.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.activity.MainControlsActivity;
import gr.zyxt.exodus.preference.Pref;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterAddressActivity extends AppCompatActivity {
    @BindView(R.id.address)
    EditText mAddress;
    @BindView(R.id.continue_button)
    Button mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_address);
        ButterKnife.bind(this);

        mContinue.setOnClickListener(v -> continueToNextScreen());
    }

    @Override
    public void onBackPressed() {
        // Prevent user to click the back button
    }

    private void continueToNextScreen() {
        String address = mAddress.getText().toString().trim();

        if (TextUtils.isEmpty(address)) {
            Toast.makeText(this, "Παρακαλώ συμπληρώστε το πεδίο", Toast.LENGTH_LONG).show();
        } else {
            Pref.getInstance().setAddress(address);
            Handler handler = new Handler();
            handler.postDelayed(() -> {
                startActivity(new Intent(this, MainControlsActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }, 200);
        }
    }
}
