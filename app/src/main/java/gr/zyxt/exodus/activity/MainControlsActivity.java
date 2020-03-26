package gr.zyxt.exodus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.adapter.ReasonAdapter;
import gr.zyxt.exodus.enumeration.ReasonEnum;
import gr.zyxt.exodus.preference.Pref;
import gr.zyxt.exodus.util.Utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import static android.content.Intent.ACTION_VIEW;

public class MainControlsActivity extends AppCompatActivity implements ReasonAdapter.OnItemClickListener {
    @BindView(R.id.settings)
    ImageView mSettings;
    @BindView(R.id.reason_list)
    RecyclerView mReasonList;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controls);
        ButterKnife.bind(this);

        mSettings.setOnClickListener(v -> goToSettings());

        loadList();
    }

    @Override
    public void onBackPressed() {
        // Prevent user to click the back button
    }

    private void goToSettings() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            startActivity(new Intent(this, SettingsActivity.class));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }, 200);
    }

    private void loadList() {
        mAdapter = new ReasonAdapter(Utils.getReasonList(), this);
        mLayoutManager = new LinearLayoutManager(this);
        mReasonList.setLayoutManager(mLayoutManager);
        mReasonList.setHasFixedSize(false);
        mReasonList.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(ReasonEnum reason, int position) {
        String fullName = Pref.getInstance().getFullName();
        String address = Pref.getInstance().getAddress();
        String smsBody = getString(R.string.sms_text, ("" + (position + 1)), fullName, address);
        Intent intent = new Intent(ACTION_VIEW, Uri.parse("sms:13033"));
        intent.putExtra("sms_body", smsBody);
        startActivity(Intent.createChooser(intent, "Αποστολή μέσω: "));
    }
}
