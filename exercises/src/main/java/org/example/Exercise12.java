package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Exercise12 {

    static public String removeX(String N, char X) {
        List<Character> listChars = N.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        listChars.remove((Character) X);
        System.out.println(listChars);

        StringBuilder result = new StringBuilder(listChars.size());
        listChars.stream().forEachOrdered(c -> result.append(c));
        return result.toString();
    }
}
