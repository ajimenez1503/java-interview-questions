package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise1SecondMax {

    public static Integer find2Max(ArrayList<Integer> list) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Cannot pass empty list");
        }
        if (list.size() == 1) {
            return list.get(0);
        }

        Integer max = Math.max(list.get(0), list.get(1)), max2 = Math.min(list.get(0), list.get(1));
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) > max) {
                max2 = max;
                max = list.get(i);
            } else if (list.get(i) > max2) {
                max2 = list.get(i);
            }
        }
        return max2;
    }

}
