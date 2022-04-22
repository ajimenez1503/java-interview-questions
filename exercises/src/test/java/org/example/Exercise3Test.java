package org.example;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class Exercise3Test {

    @Test
    public void testBasicQuery() throws Exception {
        String urlStr = "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("utm_source", "Facebook");
        requiredParams.put("utm_campaign", "test");
        requiredParams.put("utm_medium", "Social");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/?utm_campaign=test&utm_medium=Social&utm_source=Facebook",
                url.updateURLForSharing(requiredParams, PARAM_KIND.QUERY)
        );
    }

    @Test
    public void testBasicFragment() throws Exception {
        String urlStr = "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("utm_source", "Facebook");
        requiredParams.put("utm_campaign", "test");
        requiredParams.put("utm_medium", "Social");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/#utm_campaign=test&utm_medium=Social&utm_source=Facebook",
                url.updateURLForSharing(requiredParams, PARAM_KIND.FRAGMENT)
        );
    }

    @Test
    public void testEmptyURL() {
        try {
            Exercise3 url = new Exercise3("");
        } catch (Exception e) {
            assertEquals("urlStr is empty.", e.getMessage());
        }
    }

    @Test
    public void testEmptyParams() throws Exception {
        String urlStr = "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/";
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://www.telegraph.co.uk/theatre/what-to-see/renaming-colston-hall-dreary-failure-imagination/",
                url.updateURLForSharing(new HashMap<String, String>(), PARAM_KIND.QUERY)
        );
    }

    @Test
    public void testWrongOrderParams() {
        try {
            String urlStr = "https://example.com#key1=value1?key2=value2";
            HashMap<String, String> requiredParams = new HashMap<String, String>();
            requiredParams.put("key3", "value3");
            Exercise3 url = new Exercise3(urlStr);

        } catch (Exception e) {
            assertEquals("urlStr is not correct. ? should come before the # as noted in RFC 3986", e.getMessage());
        }
    }

    @Test
    public void testEmptyQueryParamValue() throws Exception {
        String urlStr = "https://example.com";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("key1", "value1");
        requiredParams.put("key2", "");
        requiredParams.put("key3", "value3");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://example.com?key1=value1&key2&key3=value3",
                url.updateURLForSharing(requiredParams, PARAM_KIND.QUERY)
        );
    }

    @Test
    public void testEmptyFragmentParamValue() throws Exception {
        String urlStr = "https://example.com";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("key1", "value1");
        requiredParams.put("key2", "");
        requiredParams.put("key3", "value3");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://example.com#key1=value1&key2&key3=value3",
                url.updateURLForSharing(requiredParams, PARAM_KIND.FRAGMENT)
        );
    }

    @Test
    public void testContainQueryParam() throws Exception {
        String urlStr = "https://example.com?key0=value0&key2";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("key1", "value1");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://example.com?key1=value1&key2&key0=value0",
                url.updateURLForSharing(requiredParams, PARAM_KIND.QUERY)
        );
    }

    @Test
    public void testContainFragmentParam() throws Exception {
        String urlStr = "https://example.com#key0=value0&key2";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("key1", "value1");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://example.com#key1=value1&key2&key0=value0",
                url.updateURLForSharing(requiredParams, PARAM_KIND.FRAGMENT)
        );
    }

    @Test
    public void testOverWriteQueryParam() throws Exception {
        String urlStr = "https://example.com?key0=value0&key2#key1=value1";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("key2", "newvalue2");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://example.com?key0=value0#key1=value1&key2=newvalue2",
                url.updateURLForSharing(requiredParams, PARAM_KIND.FRAGMENT)
        );
    }

    @Test
    public void testOverWriteFragmentParam() throws Exception {
        String urlStr = "https://example.com?key1=value1#key0=value0&key2";
        HashMap<String, String> requiredParams = new HashMap<String, String>();
        requiredParams.put("key2", "newvalue2");
        Exercise3 url = new Exercise3(urlStr);
        assertEquals(
                "https://example.com?key1=value1&key2=newvalue2#key0=value0",
                url.updateURLForSharing(requiredParams, PARAM_KIND.QUERY)
        );
    }
}
