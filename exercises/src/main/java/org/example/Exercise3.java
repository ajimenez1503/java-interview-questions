package org.example;

import java.util.HashMap;

enum PARAM_KIND {
    QUERY,
    FRAGMENT
}

public class Exercise3 {

    private final HashMap<String, String> queryParams;
    private final HashMap<String, String> fragmentParams;
    private StringBuffer url;

    public Exercise3(String urlStr) throws Exception {
        if (urlStr.isEmpty()) {
            throw new Exception("urlStr is empty.");
        }
        queryParams = new HashMap<String, String>();
        fragmentParams = new HashMap<String, String>();
        parseURL(urlStr);
    }

    private void parseParams(String urlParams, PARAM_KIND kind) {
        HashMap<String, String> map = kind == PARAM_KIND.QUERY ? queryParams : fragmentParams;
        String[] params = urlParams.split("&");
        for (String param : params) {
            if (param.contains("=")) {
                String[] parts = param.split("=");
                map.put(parts[0], parts[1]);
            } else {
                map.put(param, "");
            }
        }
    }

    private void parseURL(String urlStr) throws Exception {

        int indexOfStartQuery = urlStr.indexOf('?');
        int indexOfStartFragment = urlStr.indexOf('#');

        if (indexOfStartQuery != -1
                && indexOfStartFragment != -1
                && indexOfStartFragment < indexOfStartQuery) {
            throw new Exception("urlStr is not correct. ? should come before the # as noted in RFC 3986");
        }
        if (indexOfStartQuery != -1 && indexOfStartFragment != -1) {
            url = new StringBuffer(urlStr.substring(0, indexOfStartQuery));
            parseParams(urlStr.substring(indexOfStartQuery + 1, indexOfStartFragment), PARAM_KIND.QUERY);
            parseParams(urlStr.substring(indexOfStartFragment + 1), PARAM_KIND.FRAGMENT);
        } else if (indexOfStartQuery != -1) {
            url = new StringBuffer(urlStr.substring(0, indexOfStartQuery));
            parseParams(urlStr.substring(indexOfStartQuery + 1), PARAM_KIND.QUERY);
        } else if (indexOfStartFragment != -1) {
            url = new StringBuffer(urlStr.substring(0, indexOfStartFragment));
            parseParams(urlStr.substring(indexOfStartFragment + 1), PARAM_KIND.FRAGMENT);
        } else {
            url = new StringBuffer(urlStr);
        }
    }

    private void addParams(PARAM_KIND kind) {
        boolean isFirst = true;
        HashMap<String, String> params = kind == PARAM_KIND.QUERY ? queryParams : fragmentParams;

        for (HashMap.Entry<String, String> entry : params.entrySet()) {
            if (isFirst) {
                if (kind == PARAM_KIND.QUERY) {
                    url.append("?");
                } else {
                    url.append("#");
                }
                url.append(entry.getKey());
                if (!entry.getValue().isEmpty()) {
                    url.append("=" + entry.getValue());
                }
                isFirst = false;
            } else {
                url.append("&" + entry.getKey());
                if (!entry.getValue().isEmpty()) {
                    url.append("=" + entry.getValue());
                }
            }
        }
    }

    private String buildUrl() {
        addParams(PARAM_KIND.QUERY);
        addParams(PARAM_KIND.FRAGMENT);

        // Return the modified URL
        return url.toString();
    }

    /*
     * @brief: Update a URL given the required tracking parameters and whether
     * such new parameters should be added in the query or fragment component.
     * Existing parameters should be left unchanged, i.e. remain in either query
     * or fragment.
     *
     * Note: ? should come before the # as noted in RFC 3986
     */
    public String updateURLForSharing(
            HashMap<String, String> requiredParams,
            PARAM_KIND kind) {

        if (requiredParams.isEmpty()) {
            return buildUrl();
        }

        if (kind == PARAM_KIND.FRAGMENT) {
            queryParams.keySet().removeAll(requiredParams.keySet());
            fragmentParams.putAll(requiredParams);
        } else {
            fragmentParams.keySet().removeAll(requiredParams.keySet());
            queryParams.putAll(requiredParams);
        }

        return buildUrl();
    }

}