package gr.zyxt.exodus.core.contracts;

import android.content.Context;

/**
 * The launch screen MVP contract.
 *
 * @author Anastasios Daris (t.daris@7linternational.com)
 */
public class LaunchContract {
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
         * Provides the necessary {@link Context} reference to the presenter.
         *
         * @return {@link Context}
         */
        Context provideContext();
    }

    /**
     * The presenter interface of the MVP contract.
     */
    public interface Presenter {
        /**
         * Destroys the presenter and clears any dependency reference on it.
         */
        void onDestroy();

        /**
         * Coordinates the navigation of the activities during launch.
         */
        void coordinate();
    }
}
