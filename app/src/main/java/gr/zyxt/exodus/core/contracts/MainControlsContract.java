package gr.zyxt.exodus.core.contracts;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;

import gr.zyxt.exodus.enumeration.ReasonEnum;

/**
 * The MVP contract of the main controls screen.
 *
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class MainControlsContract {
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
         * Loads the reasons list in the view.
         *
         * @param reasons {@link ArrayList<ReasonEnum>}
         */
        void onLoadReasons(ArrayList<ReasonEnum> reasons);

        /**
         * Provides the necessary {@link Context} to the presenter.
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
    }

    /**
     * The presenter interface of the MVP contract.
     */
    public interface Presenter {
        /**
         * Destroys the presenter and clears any dependency.
         */
        void onDestroy();

        /**
         * Loads the reasons into the view.
         */
        void loadReasons();

        /**
         * Opens the SMS app nd prefills all the necessary fields.
         *
         * @param reason {@link ReasonEnum}
         * @param position the tapped position
         */
        void sendSMS(ReasonEnum reason, int position);

        /**
         * Opens the settings screen.
         */
        void goToSettings();
    }
}
