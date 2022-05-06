package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Exercise2 {

    /**
     * Find the number of times the following conditions became true in a list of integer.
     * i -j == list[i] - list[j]
     * No efficient approach using two loops.
     *
     * @param list The list of integer.
     * @throws Exception If list is empty.
     */
    public static Integer countImpl1(ArrayList<Integer> list) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Cannot pass empty list");
        }

        Integer count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i - j == list.get(i) - list.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Find the number of times the following conditions became true in a list of integer.
     * i -j == list[i] - list[j]
     * Efficient approach using a map.
     *
     * @param list The list of integer.
     * @throws Exception If list is empty.
     */
    public static Integer countImpl2(ArrayList<Integer> list) throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Cannot pass empty list");
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (map.containsKey(i - list.get(i))) {
                map.put(i - list.get(i), map.get(i - list.get(i)) + 1);
            } else {
                map.put(i - list.get(i), 1);
            }
        }
        Integer count = 0;
        for (Integer value : map.values()) {
            count += (int) Math.pow(value, 2);
        }
        return count;
    }
}
