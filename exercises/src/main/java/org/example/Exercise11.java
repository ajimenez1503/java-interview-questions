package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Exercise11 {

    static public int maxWordCount(String fileName) {
        Map<String, Integer> map = new HashMap<>();
        try {
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Arrays.stream(data.split("\\W+")).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(map);
        Optional<Map.Entry<String, Integer>> result = map.entrySet().stream().max((Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue().compareTo(e2.getValue()));

        System.out.println(result);

        return result.get().getValue();
    }
}
