package org.example;


import org.junit.jupiter.api.Test;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Exercise13Test {

    private final static String SHORTEN_URL = "http://short.com/";
    private final static int MAX_RANDOM_KEYWORD = 4;

    @Test
    void givenUrl_whenGenerate_thenCheckValue() throws Exception {
        String keyword = "POTATO";
        Exercise13 urlShorten = new Exercise13();
        URL generatedUrl = urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"), keyword);
        assertEquals(new URL(SHORTEN_URL + keyword), generatedUrl);
    }

    @Test
    void givenUrl_whenGenerateTheSameKeyword_thenException() throws Exception {
        String keyword = "POTATO";
        Exercise13 urlShorten = new Exercise13();
        urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"), keyword);
        Exception exception = assertThrows(Exception.class, () -> {
            urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"), keyword);
        });
        assertTrue(exception.getMessage().contains("already exists"));
    }

    @Test
    void givenUrl_whenGenerateURLWithKeywordLongerThan20_thenException() throws Exception {
        String keyword = "123456789012345678901234567890";
        Exercise13 urlShorten = new Exercise13();
        Exception exception = assertThrows(Exception.class, () -> {
            urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"), keyword);
        });
        assertTrue(exception.getMessage().contains("longer than max"));
    }

    @Test
    void givenUrl_whenRandom_thenCheckValue() throws Exception {
        Exercise13 urlShorten = new Exercise13();
        URL generatedUrl = urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"));
        assertTrue(generatedUrl.toString().contains(SHORTEN_URL));
        assertEquals(SHORTEN_URL.length() + MAX_RANDOM_KEYWORD, generatedUrl.toString().length());
    }


    @Test
    void givenUrl_whenRandom_thenCheckValuesAreRandom() throws Exception {
        Exercise13 urlShorten = new Exercise13();
        URL generatedUrl1 = urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"));
        URL generatedUrl2 = urlShorten.generateShortenUrl(new URL("http://looooong.net/another/somepath"));
        assertNotEquals(generatedUrl2, generatedUrl1);
    }
}
