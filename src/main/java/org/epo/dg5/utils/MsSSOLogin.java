package org.epo.dg5.utils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MsSSOLogin extends PageObject {
    public static final String MS_URL = "https://login.microsoftonline.com/";
    private static final Logger log = LoggerFactory.getLogger(MsSSOLogin.class);

    @FindBy(css = "input[type='email']")
    private WebElementFacade emailInput;
    @FindBy(css = "input[type='password']")
    private WebElementFacade passwordInput;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElementFacade submitButton;
    @net.serenitybdd.core.annotations.findby.FindBy(id = "idBtn_Back")
    WebElementFacade noButton;
    @FindBy(id = "displayName")
    private WebElementFacade displayemail;


    public void processMSAuthentication(String email, String password) {
        withTimeoutOf(30, ChronoUnit.SECONDS).waitFor(ExpectedConditions.urlContains(MS_URL));
        withTimeoutOf(50, ChronoUnit.SECONDS).waitForCondition()
                .withMessage("Login should succeed and page other than MS login should be open").until(wd -> {
                    if (wd.getCurrentUrl().startsWith(MS_URL)) {
                        login(email, password);
                        log.info("get here");
                        return false;
                    } else {
                        return true;
                    }
                });
    }

    public void login(String email, String password) {
        emailInput.waitUntilEnabled().sendKeys(email);
        submitButton.click();
        withTimeoutOf(10, ChronoUnit.SECONDS).waitFor(visibilityOf(displayemail));

        passwordInput.waitUntilEnabled().sendKeys(password);
        submitButton.click();
        withTimeoutOf(10, ChronoUnit.SECONDS).waitFor(not(urlContains(MS_URL)));
    }

    public void getNetwork (){
        LogEntries logEntries = getDriver().manage().logs().get(org.openqa.selenium.logging.LogType.PERFORMANCE);
        for (LogEntry entry : logEntries) {
            System.out.println((String.format("%s %s %s\n", new Date(entry.getTimestamp()), entry.getLevel(),
                    entry.getMessage())));
        }
    }
}