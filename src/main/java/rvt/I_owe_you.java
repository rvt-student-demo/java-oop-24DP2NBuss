package rvt;

import java.util.*;

public class I_owe_you {
    HashMap<String, Double> iou = new HashMap<>(); // te glabājam, kam un cik esam parādā

    public void setSum(String toWhom, double amount) {
        iou.put(toWhom, amount); // saglabājam vai atjaunojam parāda summu konkrētam cilvēkam
    }

    public double howMuchDoIOweTo(String toWhom) {
        return iou.getOrDefault(toWhom, 0.0); // ja cilvēka nav sarakstā, atgriež 0
    }
}

