package org.example;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class Exercise14 {


    private static void findWords(
            Set<String> result,
            String currentString,
            Set<AbstractMap.SimpleEntry<Integer, Integer>> checkedCell,
            int i, int j,
            Character[][] array,
            Set<String> validWords) {
        AbstractMap.SimpleEntry<Integer, Integer> currentCell = new AbstractMap.SimpleEntry<>(i, j);
        if (checkedCell.contains(currentCell)) {
            return;
        }
        checkedCell.add(currentCell);

        currentString += array[i][j];
        if (validWords.contains(currentString)) {
            result.add(currentString);
        }

        if (i + 1 < array.length) {
            findWords(result, currentString, new HashSet<>(checkedCell), i + 1, j, array, validWords);
            if (j + 1 < array[i].length) {
                findWords(result, currentString, new HashSet<>(checkedCell), i + 1, j + 1, array, validWords);
            }
            if (j - 1 >= 0) {
                findWords(result, currentString, new HashSet<>(checkedCell), i + 1, j - 1, array, validWords);
            }
        }
        if (j + 1 < array.length) {
            findWords(result, currentString, new HashSet<>(checkedCell), i, j + 1, array, validWords);
        }

        if (i - 1 >= 0) {
            findWords(result, currentString, new HashSet<>(checkedCell), i - 1, j, array, validWords);
            if (j - 1 >= 0) {
                findWords(result, currentString, new HashSet<>(checkedCell), i - 1, j - 1, array, validWords);
            }
            if (j + 1 < array[i].length) {
                findWords(result, currentString, new HashSet<>(checkedCell), i - 1, j + 1, array, validWords);
            }
        }
        if (j - 1 >= 0) {
            findWords(result, currentString, new HashSet<>(checkedCell), i, j - 1, array, validWords);
        }
    }

    static public Set<String> findWords(Character[][] array, Set<String> validWords) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                findWords(result, "", new HashSet<>(), i, j, array, validWords);
            }
        }
        return result;
    }
}
