package org.example;

import java.util.HashMap;
import java.util.Map;

public class Exercise6 {


    static public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] sSplited = s.split("\\s+");
        if (sSplited.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {
                map.put(pattern.charAt(i), sSplited[i]);
            } else {
                if (!sSplited[i].equals(map.get(pattern.charAt(i)))) {
                    return false;
                }
            }
        }
        return true;
    }
}
