package org.epo.dg5.utils;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.epo.dg5.utils.Messages.*;
import static org.epo.dg5.utils.Locators.*;
import static org.junit.Assert.*;

@Slf4j
public class CommonMethods extends PageObject
{
    public WebElement findElementShadowRoot(String cssSelector){
        WebElement shadowRootParent = getDriver().findElement(By.cssSelector("#lc-rep-user-area-mfe"));
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        return (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector(arguments[1])", shadowRootParent, cssSelector);
    }
    public List<WebElement> findElementsShadowRoot(String cssSelector){
        WebElement shadowRootParent = getDriver().findElement(By.cssSelector("#lc-rep-user-area-mfe"));
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        return (List<WebElement>) js.executeScript("return arguments[0].shadowRoot.querySelectorAll(arguments[1])", shadowRootParent, cssSelector);
    }
    public WebElement findElementShadowRootPwb(String cssSelector){
        WebElement shadowRootParent = getDriver().findElement(By.cssSelector("#app lc-rep-inbox-mfe"));
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        return (WebElement) js.executeScript("return arguments[0].shadowRoot.querySelector(arguments[1])", shadowRootParent, cssSelector);
    }
    public void formElementExist(String label,String value){
        assertFalse(label.isEmpty());
        String [] check =value.split(",");
        if(check[0].contains("Invalid")){
            fail(ERROR_VALUE_NOT_EXIST);
        } else if (value.contains("-")) {
            if(label.contains("Representative number")){
                fail(ERROR_VALUE_NOT_EXIST);
            }
        }else{
                assertFalse(ERROR_VALUE_NOT_EXIST,false);
        }
    }
    public void waitWebElement(String cssSelector,String find){
        ExpectedCondition<Boolean> isElementExist = (webdriver) -> {
            boolean booleanResult;
            try {
                log.debug("Trying to perform {} over element", "VERIFY_ELEMENT_EXISTENCE");
                if(find.equals("pwb")) {
                    booleanResult = null != this.findElementShadowRootPwb(cssSelector);
                }
                else{
                    booleanResult = null != this.findElementShadowRoot(cssSelector);
                }
            } catch (
                    WebDriverException var4) {
                booleanResult = Boolean.FALSE;
            }    return booleanResult;};
        new WebDriverWait(Serenity.getDriver(),30).until(isElementExist);
    }
    public void waitWebElementNotExit(By locator){
        ExpectedCondition<Boolean> elementNotExist = (webdriver) -> {
            boolean booleanResult;
            try {
                log.debug("Trying to perform {} over element", "VERIFY_ELEMENT_NOT_EXISTENCE");
                    booleanResult = null == getDriver().findElement(locator);
            } catch (
                    WebDriverException var4) {
                booleanResult = Boolean.TRUE;
            }
            return booleanResult;
        };
        new WebDriverWait(Serenity.getDriver(),50).until(elementNotExist);
    }
    public void waitWebElementExit(By locator){
        ExpectedCondition<Boolean> elementExist = (webdriver) -> {
            boolean booleanResult;
            try {
                log.debug("Trying to perform {} over element", "VERIFY_ELEMENT_EXISTENCE");
                booleanResult = null != getDriver().findElement(locator);
            } catch (
                    WebDriverException var4) {
                booleanResult = Boolean.FALSE;
            }
            return booleanResult;
        };
        new WebDriverWait(Serenity.getDriver(),50).until(elementExist);
    }
    public void modifyPhoneNumber(List <WebElement> codecountrys,List <WebElement> areacountrys,List <WebElement> numbercountrys,String value){
        String[] aux = value.split("-");
        int index = codecountrys.size()-1;
        codecountrys.get(index).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        areacountrys.get(index).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        numbercountrys.get(index).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        codecountrys.get(index).sendKeys(aux[0]);
        areacountrys.get(index).sendKeys(aux[1]);
        numbercountrys.get(index).sendKeys(aux[2]);
    }
    public void openURL(String url){
        getDriver().get(url);
        try {
            getDriver().findElement(By.xpath(CERT_CLICK)).click();
        } catch (Exception e) {
            log.info(ERROR_LOGIN,e.getMessage());
        }
    }
    public void openSection(String section){
        CommonMethods commonMethods = new CommonMethods();
        try {
            getDriver().get(ENVIRONMENT);
            getDriver().findElement(By.xpath(CERT_CLICK)).click();
        } catch (Exception e) {
            log.info(ERROR_LOGIN,e.getMessage());
        }
        WebElement dataRepresentative = null;
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        switch (section){
            case "MyData":
                this.waitWebElementExit(By.cssSelector("*[data-nua='representative-profile']"));
                dataRepresentative = getDriver().findElement(By.cssSelector("*[data-nua='representative-profile']"));
                break;
            case "Registration":
                this.waitWebElementExit(By.cssSelector("*[data-nua='user-initials-badge']"));
                dataRepresentative = getDriver().findElement(By.cssSelector("*[data-nua='user-initials-badge']"));
                dataRepresentative.click();
                this.waitWebElementExit(By.cssSelector("*[data-nua='menu-right-drawer']"));
                this.waitWebElementExit(By.cssSelector("*[data-nua='user-info-container']"));
                this.waitWebElementExit(By.cssSelector("*[data-nua='request-registration-btn']"));
                dataRepresentative = getDriver().findElement(By.cssSelector("*[data-nua='request-registration-btn']"));
                new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-nua='request-registration-btn']")));
                break;
            case "reentry":
                this.waitWebElementExit(By.cssSelector("*[data-nua='user-initials-badge']"));
                dataRepresentative = getDriver().findElement(By.cssSelector("*[data-nua='user-initials-badge']"));
                dataRepresentative.click();
                this.waitWebElementExit(By.cssSelector("*[data-nua='menu-right-drawer']"));
                this.waitWebElementExit(By.cssSelector("*[data-nua='user-info-container']"));
                this.waitWebElementExit(By.cssSelector("*[data-nua='request-reentry-btn']"));
                dataRepresentative = getDriver().findElement(By.cssSelector("*[data-nua='request-reentry-btn']"));
                new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("*[data-nua='request-reentry-btn']")));
                break;
        }
        assert dataRepresentative != null;
        dataRepresentative.click();
    }
    public void scrollDown(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
