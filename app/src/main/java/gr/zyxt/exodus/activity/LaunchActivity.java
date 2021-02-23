package gr.zyxt.exodus.activity;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import gr.zyxt.exodus.core.contracts.LaunchContract;
import gr.zyxt.exodus.core.presenters.LaunchPresenter;

/**
 * Launch activity. Determines whether it should proceed to
 * the on boarding process, or to the main control.
 */
public class LaunchActivity extends AppCompatActivity implements LaunchContract.View {
    private LaunchContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPresenter(new LaunchPresenter(this));

        presenter.coordinate();
    }

    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setPresenter(LaunchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Context provideContext() {
        return this;
    }
}
