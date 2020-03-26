package gr.zyxt.exodus.activity;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.activity.onboarding.WelcomeActivity;
import gr.zyxt.exodus.preference.Pref;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Launch activity. Determines whether it should proceed to
 * the on boarding process, or to the main control.
 */
public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        coordinate();
    }

    /**
     * Coordinates the navigation of the activities during launch.
     */
    public void coordinate() {
        String fullName = Pref.getInstance().getFullName();
        String address = Pref.getInstance().getAddress();

        boolean isFullNameEmpty = TextUtils.isEmpty(fullName);
        boolean isAddressEmpty = TextUtils.isEmpty(address);

        boolean continueToWelcome = isFullNameEmpty || isAddressEmpty;

        if (continueToWelcome) {
            startActivity(new Intent(this, WelcomeActivity.class));
        } else {
            startActivity(new Intent(this, MainControlsActivity.class));
        }
    }
}
