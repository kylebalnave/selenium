package com.selenium.steps;

import java.util.Date;

/**
 *
 * @author kyleb2
 */
public class CookieOptions {

    protected Date expiration;
    protected String name;
    protected String value;
    protected String path;
    protected String domain;
    protected boolean secure;
    
    public CookieOptions(String keyValue, String options) {
        this(keyValue, options, false);
    }

    public CookieOptions(String keyValue, String options, boolean isSecure) {
        String[] keyValueParts = getKeyValueParts(keyValue);
        name = keyValueParts[0];
        value = keyValueParts[1];
        for (String option : options.split(",")) {
            String[] opParts = getKeyValueParts(option);
            String opKey = opParts[0];
            String opValue = opParts[1];
            if (opKey.equals("path")) {
                path = opValue;
            } else if (opKey.equals("max_age")) {
                long expirationMs = new Date().getTime() + Integer.valueOf(opValue) * 1000;
                expiration = new Date(expirationMs);
            } else if (opKey.equals("domain")) {
                domain = opValue;
            }
        }
    }

    protected String[] getKeyValueParts(String keyValue) {
        String[] result = new String[2];
        String[] parts = keyValue.split("=");
        result[0] = parts[0].trim();
        result[1] = parts[1].trim();
        return result;
    }

    public String getPath() {
        return path;
    }

    public String getDomain() {
        return domain;
    }

    public Date getExpiration() {
        return expiration;
    }

    public boolean isSecure() {
        return secure;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
    

}
