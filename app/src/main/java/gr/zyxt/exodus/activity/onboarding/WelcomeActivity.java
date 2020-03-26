package gr.zyxt.exodus.activity.onboarding;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.zyxt.exodus.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.continue_button_welcome)
    Button mContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        mContinue.setOnClickListener(v -> continueToNextScreen());
    }

    @Override
    public void onBackPressed() {
        // Prevent user to click the back button
    }

    private void continueToNextScreen() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(this, EnterFullNameActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }, 200);
    }
}
