package gr.zyxt.exodus.core.contracts;

import android.app.Activity;
import android.content.Context;

/**
 * The MVP contract of the settings screen.
 *
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class SettingsContract {
    /**
     * The view interface of the MVP contract.
     */
    public interface View {
        /**
         * Sets the presenter of the view.
         *
         * @param presenter {@link Presenter}
         */
        void setPresenter(Presenter presenter);

        /**
         * Provides a {@link Context} reference to the presenter.
         *
         * @return {@link Context}
         */
        Context provideContext();

        /**
         * Provides an {@link Activity} reference to the presenter.
         *
         * @return {@link Activity}
         */
        Activity provideActivity();

        /**
         * Loads the settings data to the view.
         *
         * @param fullName the user's full name
         * @param address the user's address
         */
        void onLoadData(String fullName, String address);
    }

    /**
     * The presenter interface of the MVP contract.
     */
    public interface Presenter {
        /**
         * Destroys the presenter and clears any provided reference to it.
         */
        void onDestroy();

        /**
         * Loads the settings data to the view.
         */
        void loadData();

        /**
         * Saves the personal data of the user to the preference.
         *
         * @param fullName user's full name
         * @param address user's address
         */
        void save(String fullName, String address);
    }
}
