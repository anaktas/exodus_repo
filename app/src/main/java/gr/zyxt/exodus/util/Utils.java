package gr.zyxt.exodus.util;

import java.util.ArrayList;

import gr.zyxt.exodus.enumeration.ReasonEnum;

/**
 * @author Anastasios Daris (t.daris@7linternational.com)
 * Created on 24, March, 2020
 */
public class Utils {
    public static ArrayList<ReasonEnum> getReasonList() {
        ArrayList<ReasonEnum> reasonList = new ArrayList<>();
        reasonList.add(0, ReasonEnum.REASON_1);
        reasonList.add(1, ReasonEnum.REASON_2);
        reasonList.add(2, ReasonEnum.REASON_3);
        reasonList.add(3, ReasonEnum.REASON_4);
        reasonList.add(4, ReasonEnum.REASON_5);
        reasonList.add(5, ReasonEnum.REASON_6);

        return reasonList;
    }
}
