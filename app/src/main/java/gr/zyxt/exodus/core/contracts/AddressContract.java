package gr.zyxt.exodus.core.contracts;

import android.app.Activity;
import android.content.Context;

/**
 * The MVP contract of the "enter address" screen.
 *
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class AddressContract {
    /**
     * The view interface of the MVP contract.
     */
    public interface View {
        /**
         * Sets the presenter of the view/
         *
         * @param presenter {@link Presenter}
         */
        void setPresenter(Presenter presenter);

        /**
         * Provides the necessary {@link Context} reference to the presenter.
         *
         * @return {@link Context}
         */
        Context provideContext();

        /**
         * Provides the necessary {@link Activity} reference to the presenter.
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
         * Destroys the presenter and clears any provided reference.
         */
        void onDestroy();

        /**
         * Continues to the next screen.
         *
         * @param address the user's address
         */
        void continueToNextScreen(String address);
    }
}
