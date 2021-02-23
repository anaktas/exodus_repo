package gr.zyxt.exodus.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import gr.zyxt.exodus.R;
import gr.zyxt.exodus.adapter.ReasonAdapter;
import gr.zyxt.exodus.core.contracts.MainControlsContract;
import gr.zyxt.exodus.core.presenters.MainControlsPresenter;
import gr.zyxt.exodus.enumeration.ReasonEnum;

public class MainControlsActivity extends AppCompatActivity implements
        ReasonAdapter.OnItemClickListener,
        MainControlsContract.View {
    private RecyclerView mReasonList;

    private MainControlsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_controls);

        setPresenter(new MainControlsPresenter(this));

        ImageView settings = findViewById(R.id.settings);

        mReasonList = findViewById(R.id.reason_list);

        settings.setOnClickListener(v -> {
            if (presenter != null) presenter.goToSettings();
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        if (presenter != null) presenter.loadReasons();
    }

    @Override
    public void onBackPressed() {
        // Prevent user to click the back button
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroy();
    }

    @Override
    public void onItemClick(ReasonEnum reason, int position) {
        if (presenter != null) presenter.sendSMS(reason, position);
    }

    @Override
    public void setPresenter(MainControlsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onLoadReasons(ArrayList<ReasonEnum> reasons) {
        ReasonAdapter adapter = new ReasonAdapter(reasons, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mReasonList.setLayoutManager(layoutManager);
        mReasonList.setHasFixedSize(false);
        mReasonList.setAdapter(adapter);
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
