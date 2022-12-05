package org.example;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exercise13 {
    private final static String SHORTEN_URL = "http://short.com/";
    private final static int MIN_KEYWORD = 0;

    private final static int MAX_KEYWORD = 20;
    private final static int MAX_RANDOM_KEYWORD = 4;
    Random random;
    Object lock;
    // { "POTATO" : "http://looooong.net/another/somepath"}
    private Map<String, URL> map;


    public Exercise13() {
        map = new HashMap<>();
        lock = new Object();
        random = new Random();
    }

    public URL generateShortenUrl(URL originalUrl, String keyword) throws Exception {
        if (originalUrl == null) {
            throw new Exception("originalUrl is null");
        }
        if (keyword == null) {
            throw new Exception("keyboard is null");
        }
        if (keyword.length() == MIN_KEYWORD || keyword.length() > MAX_KEYWORD) {
            throw new Exception("'" + keyword + "'  longer than max " + MAX_KEYWORD);
        }
        synchronized (lock) {
            if (map.containsKey(keyword)) {
                throw new Exception("'" + keyword + "' already exists");
            }
            map.put(keyword, originalUrl);
        }
        return new URL(SHORTEN_URL + keyword);
    }

    private String generateRandomKeyword() {
        // 4 characters

        StringBuilder randomKeyword = new StringBuilder();
        for (int i = 0; i < MAX_RANDOM_KEYWORD; i++) {
            randomKeyword.append((char) random.nextInt((int) Character.MAX_VALUE));
//            randomKeyword.append((char) random.nextInt((int) Character.MIN_VALUE, (int) Character.MAX_VALUE));
        }
        return randomKeyword.toString();
    }

    public URL generateShortenUrl(URL originalUrl) throws Exception {
        if (originalUrl == null) {
            throw new Exception("originalUrl is null");
        }

        String randomKeyword = generateRandomKeyword();

        synchronized (lock) {
            // Ensure the randomKeyword does not already exists
            while (map.containsKey(randomKeyword)) {
                randomKeyword = generateRandomKeyword();
            }
            return generateShortenUrl(originalUrl, randomKeyword);
        }
    }
}
