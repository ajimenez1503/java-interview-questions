package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise10 {

    static public List<Integer> calc_buckets(int[] latencies, int number_of_buckets, int bucket_width) {

        if (latencies.length == 0) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>(Collections.nCopies(number_of_buckets, 0));
        int index;
        for (int i = 0; i < latencies.length; i++) {
            index = latencies[i] / bucket_width;
            if (index >= number_of_buckets) {
                index = number_of_buckets - 1;
            }
            result.set(index, result.get(index) + 1);
        }

        return result;
    }
}
