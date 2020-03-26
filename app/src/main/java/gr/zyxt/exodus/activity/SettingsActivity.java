package gr.zyxt.exodus.activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.preference.Pref;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    @BindView(R.id.full_name)
    EditText mFullName;
    @BindView(R.id.address)
    EditText mAddress;
    @BindView(R.id.save_button)
    Button mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        mSave.setOnClickListener(v -> save());

        loadData();
    }

    @Override
    public void onBackPressed() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(this, MainControlsActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }, 200);
    }

    private void loadData() {
        String fullName = Pref.getInstance().getFullName().trim();
        String address = Pref.getInstance().getAddress().trim();

        mFullName.setText(fullName);
        mAddress.setText(address);
    }

    private void save() {
        String fullName = mFullName.getText().toString();
        String address = mAddress.getText().toString();

        if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(address)) {
            Toast.makeText(this, "Παρακαλώ συμπληρώστε το πεδίο", Toast.LENGTH_LONG).show();
            return;
        }

        Pref.getInstance().setFullName(fullName.trim());
        Pref.getInstance().setAddress(address.trim());

        onBackPressed();
    }
}
