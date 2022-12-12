package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Exercise18 {

    Map<String, Queue<Long>> map;
    int gap;
    int numRequest;

    Exercise18(int numRequest, int gap) {
        map = new HashMap<>();
        this.numRequest = numRequest;
        this.gap = gap; // epoch
    }


    boolean isAllowed(String userId) {
        Long currentTime = System.currentTimeMillis();
        if (map.containsKey(userId)) {
            if (currentTime - map.get(userId).peek() > gap) {
                map.get(userId).poll();
            }
            if (map.get(userId).size() >= numRequest) {
                return false; //skip
            }
        } else {
            map.put(userId, new LinkedList<>());
        }
        map.get(userId).add(currentTime);
        return true;
    }
}
