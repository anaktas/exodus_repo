package gr.zyxt.exodus;

import android.app.Application;

import gr.zyxt.exodus.preference.Pref;

/**
 * Application instance.
 *
 * @author Anastasios Daris (t.daris@7linternational.com)
 * Created on 24, March, 2020
 */
public class App extends Application {
    /**
     * Singleton instance
     */
    private static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        // Warm up the preferences instance
        Pref.getInstance();
    }

    /**
     * Singleton instance access method.
     *
     * @return {@link App}
     */
    public static App getInstance() {
        return sInstance;
    }
}
