package gr.zyxt.exodus.preference;

import android.content.Context;
import android.content.SharedPreferences;

import gr.zyxt.exodus.App;

/**
 * The app's preference instance.
 *
 * @author Anastasios Daris (t.daris@7linternational.com)
 * Created on 24, March, 2020
 */
public class Pref {
    /**
     * Shared preferences file name.
     */
    private static final String PREF_FILE_NAME = "exodus_prefs";
    /**
     * Preference key of the full name.
     */
    private static final String KEY_FULL_NAME = "full_name";
    /**
     * Preference key of the address.
     */
    private static final String KEY_ADDRESS = "address";
    /**
     * Singleton instance.
     */
    private static Pref sInstance;
    /**
     * {@link SharedPreferences} local instance.
     */
    private SharedPreferences mPrefs;

    /**
     * Private singleton constructor.
     */
    private Pref() {
        mPrefs = App.getInstance().getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Public {@link Pref} instance access method.
     *
     * @return a {@link Pref} instance.
     */
    public synchronized static Pref getInstance() {
        if (sInstance == null) sInstance = new Pref();

        return sInstance;
    }

    /**
     * Stores the full name into the prefs.
     *
     * @param fullName user's full name
     */
    public void setFullName(String fullName) {
        mPrefs.edit().putString(KEY_FULL_NAME, fullName).apply();
    }

    /**
     * Returns the full name from the prefs.
     *
     * @return user's full name
     */
    public String getFullName() {
        return mPrefs.getString(KEY_FULL_NAME, null);
    }

    /**
     * Stores the address into the prefs.
     *
     * @param address user's address
     */
    public void setAddress(String address) {
        mPrefs.edit().putString(KEY_ADDRESS, address).apply();
    }

    /**
     * Returns the address from the prefs.
     *
     * @return user's address
     */
    public String getAddress() {
        return mPrefs.getString(KEY_ADDRESS, null);
    }
}
