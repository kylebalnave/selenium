package com.selenium.steps.selenium1;

import com.selenium.exceptions.StepException;
import com.selenium.steps.CookieOptions;
import com.selenium.steps.*;
import com.selenium.steps.Selenium1Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * @author kyleb2
 */
public class CreateCookie extends Selenium1Step implements IStep {

    public CreateCookie(WebDriver wd, String param1, String param2) throws StepException {
        super(wd, param1, param2);
    }

    @Override
    public Object run() {
        Cookie cookie = null;
        if (param2 != null) {
            CookieOptions cOptions = new CookieOptions(param1, param2);
            boolean hasPath = cOptions.getPath() != null;
            boolean hasDomain = cOptions.getDomain() != null;
            boolean hasMaxAge = cOptions.getExpiration() != null;
            if (hasDomain && hasPath) {
                cookie = new Cookie(cOptions.getName(),
                        cOptions.getValue(),
                        cOptions.getDomain(),
                        cOptions.getPath(),
                        cOptions.getExpiration(),
                        cOptions.isSecure());
            } else if (!hasDomain && hasPath) {
                cookie = new Cookie(cOptions.getName(), cOptions.getValue(), cOptions.getPath());
            } else {
                cookie = new Cookie(cOptions.getName(), cOptions.getValue());
            }
        }
        return cookie;
    }

    @Override
    public String getDescription() {
        return String.format("Create cookie %s with value %s", param1.split("=")[0], param1.split("=")[1]);
    }

}
