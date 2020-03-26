package gr.zyxt.exodus.enumeration;

import androidx.annotation.StringRes;
import gr.zyxt.exodus.R;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 * Created on 24, March, 2020
 */
public enum ReasonEnum {
    REASON_1(R.string.reason_1),
    REASON_2(R.string.reason_2),
    REASON_3(R.string.reason_3),
    REASON_4(R.string.reason_4),
    REASON_5(R.string.reason_5),
    REASON_6(R.string.reason_6);

    @StringRes
    private int description;

    ReasonEnum(@StringRes int description) {
        this.description = description;
    }

    @StringRes
    public int getDescription() {
        return description;
    }
}
