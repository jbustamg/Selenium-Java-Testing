package org.epo.dg5.utils;

import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.epo.dg5.utils.Locators.*;
import static org.epo.dg5.utils.Messages.*;
import static org.junit.Assert.*;

@Slf4j
public class FrontendStepsReport {
    CommonMethods commonMethods = new CommonMethods();

    @Step("^I validate \\\"([^\\\"]*)\\\" attribute exist have value$")
    public void validElementExist(String field) {
            String[] textElements = commonMethods.findElementShadowRoot(String.format(SECTION, field)).getText().split("\n");
            commonMethods.formElementExist(textElements[0], textElements[1]);
    }
    @Step("^I am able to select a date of change  \"([^\"]*)\"$")
    public void iAmAbleToSelectADateOfChange(String date) {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        if(date.equals("CURRENT")){
             WebElement element = commonMethods.findElementShadowRoot("[data-testid='radio-group']  *.undefined:nth-of-type(1) label");
             JavascriptExecutor js = (JavascriptExecutor)getDriver();
             js.executeScript("arguments[0].click()", element);
         } else if (date.equals("MANUAL")) {
             WebElement element = commonMethods.findElementShadowRoot("[data-testid='radio-group']  *.undefined:nth-of-type(2) label");
             JavascriptExecutor js = (JavascriptExecutor)getDriver();
             js.executeScript("arguments[0].click()", element);
             WebElement calendarInput = commonMethods.findElementShadowRoot("[id='changeDate']");
             DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
             LocalDate today = LocalDate.now();
             String formattedDate = "\""+today.format(dateTimeFormatter)+"\"";
             js.executeScript("arguments[0].value ="+ formattedDate,calendarInput);
         }
         else{
             log.info("The entry gave on the gherkin is not defined");
         }
    }
    @Step("^I am able to select a date of deletion  \"([^\"]*)\"$")
    public void iAmAbleToSelectADateOfDeletion(String date) {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        if(date.equals("CURRENT")){
            WebElement element = commonMethods.findElementShadowRoot("[name='deletionDateSelection']  *.undefined:nth-of-type(1) label");
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].click()", element);
        } else if (date.equals("MANUAL")) {
            WebElement element = commonMethods.findElementShadowRoot("[name='deletionDateSelection']  *.undefined:nth-of-type(2) label");
            JavascriptExecutor js = (JavascriptExecutor)getDriver();
            js.executeScript("arguments[0].click()", element);
            WebElement calendarInput = commonMethods.findElementShadowRoot("[id='deletionDate']");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate today = LocalDate.now();
            String formattedDate = "\""+today.format(dateTimeFormatter)+"\"";
            js.executeScript("arguments[0].value ="+ formattedDate,calendarInput);
        }
        else{
            log.info("The entry gave on the gherkin is not defined");
        }
    }
    @Step("^I validate \\\"([^\\\"]*)\\\" exist$")
    public void validExist(String field) {
        String[] textElements = commonMethods.findElementShadowRoot(String.format(SECTION, field)).getText().split("\n");
        if(textElements[0].equals("Root")) textElements[0] = "phone";
        assertNotNull(MESSAGE_NULL,textElements[0]);
    }
    @Step("^I validate the text fields the original \\\"([^\\\"]*)\\\"$")
    public void validNationalityAfterCancel(String country){
        WebElement value = commonMethods.findElementShadowRoot(NATIONALITY_VALUE);
        String countryAfterCancel = value.getText();
        assertEquals(country,countryAfterCancel);
    }
    @Step("I validate the fields is empty")
    public void emptyNationality(){
        WebElement value = commonMethods.findElementShadowRoot(DROPDOWN_FIELD);
        assertNull(value);
    }
    @Step("I validate the fields is not empty")
    public void notEmptyNationality(){
        WebElement value = commonMethods.findElementShadowRoot(DROPDOWN_FIELD);
        assertFalse(value.getAttribute("value").isEmpty());
    }
    @Step("^I press edit \\\"([^\\\"]*)\\\"$")
    public void edit(String field){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonEdit = commonMethods.findElementShadowRoot(String.format(EDIT_BUTTON,field));
        commonMethods.waitWebElement(String.format(EDIT_BUTTON,field),"");
        commonMethods.scrollDown(buttonEdit);
        buttonEdit.click();
    }
    @Step("I am able to press withdraw")
    public void iPressWithdraw(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement changedMessageAppears = commonMethods.findElementShadowRoot("[class='mt-l text-warning']");
        Assert.assertNotNull(MESSAGE_CHANGED_NULL,changedMessageAppears);
        this.edit("name");
        WebElement buttonWithdraw = commonMethods.findElementShadowRoot("[data-testid='withdrawRequest-button']");
        commonMethods.waitWebElement("[data-testid='withdrawRequest-button']","");
        commonMethods.scrollDown(buttonWithdraw);
        buttonWithdraw.click();
        WebElement buttonConfirmWithDraw = commonMethods.findElementShadowRoot("[data-testid='approve-button']");
        commonMethods.waitWebElement("[data-testid='approve-button']","");
        buttonConfirmWithDraw.click();
    }
    @Step("I am able to press withdraw for Registration")
    public void iPressWithdrawRegistration(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonWithdraw = commonMethods.findElementShadowRoot("[data-testid='withdrawRequest-button']");
        commonMethods.waitWebElement("[data-testid='withdrawRequest-button']","");
        commonMethods.scrollDown(buttonWithdraw);
        buttonWithdraw.click();
        WebElement buttonConfirmWithDraw = commonMethods.findElementShadowRoot("[data-testid='approve-button']");
        commonMethods.waitWebElement("[data-testid='approve-button']","");
        buttonConfirmWithDraw.click();
    }
    @Step("I am able to press withdraw for deletion")
    public void iPressWithdrawDeletion(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonWithdraw = commonMethods.findElementShadowRoot("[data-testid='withdrawRequest-button']");
        commonMethods.waitWebElement("[data-testid='withdrawRequest-button']","");
        commonMethods.scrollDown(buttonWithdraw);
        buttonWithdraw.click();
        WebElement buttonConfirmWithDraw = commonMethods.findElementShadowRoot("[data-testid='approve-button']");
        try {
            Thread.sleep(20000);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buttonConfirmWithDraw.click();
        getDriver().navigate().refresh();
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        commonMethods.waitWebElement(String.format(EDIT_BUTTON,"name"),"");
        this.edit("name");
    }
    @Step("^I fill the \\\"([^\\\"]*)\\\" and the \\\"([^\\\"]*)\\\"$")
    public void fillName(String name, String lastname){
        WebElement firstName = commonMethods.findElementShadowRoot(EDIT_FIELD_FIRSTNAME);
        WebElement lastName = commonMethods.findElementShadowRoot(EDIT_FIELD_LASTNAME);
        firstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        lastName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        firstName.sendKeys(name);
        lastName.sendKeys(lastname);
    }
    @Step("^I fill the \\\"([^\\\"]*)\\\" and the \\\"([^\\\"]*)\\\" with evidence$")
    public void fillNameEvidence(String name, String lastname){
       this.uploadFile("name");
       this.fillName(name,lastname);
    }
    @Step("^I validate I am able to press the dropdown to select a \\\"([^\\\"]*)\\\" with evidence$")
    public void iValidateIAmAbleToPressTheDropdownToSelectAWithEvidence(String nationality) {
        this.uploadFile("nationality");
        this.fillDropdown(nationality);
    }
    @Step("I validate I am able to edit my address")
    public void iValidateIAmAbleToEditMyAddress() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        String[] address = {"Galapagos NV","Galapagos NV","BE-2800","Generaal De Wittelaan, L11 A3","Mechelen"};
        int index = 1;
        WebElement Field;
        for (String addressField:address) {
            if (index != 5) {
                Field = commonMethods.findElementShadowRoot(String.format(REGISTRATION_ADDRESS, index));
            } else {
                Field = commonMethods.findElementShadowRoot(REGISTRATION_ADDRESS_CITY);
            }
            Field.clear();
            Field.sendKeys(addressField);
            index++;
        }
    }
    @Step("I press the submit button")
    public void submitButton(){
        WebElement button = commonMethods.findElementShadowRoot(SUBMIT_BUTTON);
        commonMethods.scrollDown(button);
        button.click();
    }
    @Step("I press the Save and Review button")
    public void saveAndReviewButton(){
        WebElement button = commonMethods.findElementShadowRoot(SAVE_AND_REVIEW_BUTTON);
        commonMethods.scrollDown(button);
        button.click();
    }
    @Step("I press the cancel request of deletion")
    public void iPressCancelRequestDeletion(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement button = commonMethods.findElementShadowRoot("[data-testid='stepper-action-cancelRequest']");
        commonMethods.scrollDown(button);
        commonMethods.waitWebElement("[data-testid='stepper-action-cancelRequest']","");
        button.click();
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonConfirmWithDraw = commonMethods.findElementShadowRoot("[data-testid='approve-button']");
        try {
            Thread.sleep(10000);

        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        buttonConfirmWithDraw.click();
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        this.edit("name");
    }
    @Step("I press Submit")
    public void iPressSubmit(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement button = commonMethods.findElementShadowRoot("[data-testid='stepper-action-submit']");
        commonMethods.scrollDown(button);
        commonMethods.waitWebElement("[data-testid='stepper-action-submit']","");
        button.click();
    }
    @Step("I validate I am able to press cancel")
    public void cancelButton(){
        WebElement element = commonMethods.findElementShadowRoot(CANCEL_BUTTON);
        commonMethods.scrollDown(element);
        element.click();
    }
    @Step("^I validate \\\"([^\\\"]*)\\\" the field is not editable$")
    public void validateNotEditable(String field){
        assertNull(MESSAGE_NULL,commonMethods.findElementShadowRoot(String.format(FIELD_TEXT_INPUT, field, field)));
    }
    @Step("^I validate the field is not check able$")
    public void validateNotCheckable(){
        assertNotNull(MESSAGE_NULL,commonMethods.findElementShadowRoot(FIELD_CHECKBOX_DISABLED));
    }
    @Step("^I validate \\\"([^\\\"]*)\\\" the field is editable$")
    public void validateEditable(String field){
        String value = "34-12345-123456789";
        String string = "catharses";
        switch(field){
            case "telephone":
                field = "phone";
                List <WebElement> codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                List <WebElement> areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                List <WebElement> numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                if(codeCountrys.size()==0){
                    this.add("telephone");
                    codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                    areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                    numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                }
                commonMethods.modifyPhoneNumber(codeCountrys,areaCountrys,numberCountrys,value);
                break;
            case "fax":
                codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                if(codeCountrys.size()==0){
                    this.add(field);
                    codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                    areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                    numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                }
                commonMethods.modifyPhoneNumber(codeCountrys,areaCountrys,numberCountrys,value);
                break;
            case "email":
                List <WebElement> mails = commonMethods.findElementsShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                for (WebElement aux : mails) {
                    aux.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                    aux.sendKeys(string);
                }
                break;
            case "website":
                List<WebElement> websites = commonMethods.findElementsShadowRoot(String.format(FIELD_TEXT_INPUT, field, field));
                for (WebElement website : websites) {
                    website.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                    website.sendKeys(string);
                }
                break;
            case "DataProtection":
                List <WebElement> personalInfos = commonMethods.findElementsShadowRoot(OPTION_PERSONAL_INFO_CHECK);
                List <WebElement> addressInfos = commonMethods.findElementsShadowRoot(OPTION_ADDRESS_INFO_CHECK);
                for (WebElement personalInfo: personalInfos) {
                    personalInfo.click();
                }
                for (WebElement addressInfo: addressInfos) {
                    addressInfo.click();
                }
                break;
            case "PublicallyVisible":
                WebElement checkboxValue = commonMethods.findElementShadowRoot(String.format(OPTION_DATA_PROTECTED,field));
                checkboxValue.click();
                break;
            case "button":
                WebElement button = commonMethods.findElementShadowRoot(UPLOAD_FILE_BUTTON);
                assertNotNull(MESSAGE_NULL,button);
                break;
        }
    }
    @Step("^I empty the \\\"([^\\\"]*)\\\"$")
    public void setEmptyField(String field){
        switch(field){
            case "telephone":
                field = "phone";
                List <WebElement> codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                List <WebElement> areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                List <WebElement> numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                commonMethods.modifyPhoneNumber(codeCountrys,areaCountrys,numberCountrys,"");
             break;
            case "fax":
                codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                commonMethods.modifyPhoneNumber(codeCountrys,areaCountrys,numberCountrys,"");
            break;
            case "email":
                List <WebElement> elements = commonMethods.findElementsShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                for (WebElement webElement : elements) {
                    webElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                }
            break;
            case "website":
                elements = commonMethods.findElementsShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                for (WebElement element : elements) {
                    element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                }
            break;
        }
    }
    @Step("^I am fill the \\\"([^\\\"]*)\\\" with the \\\"([^\\\"]*)\\\" value$")
    public void setFillField(String field,String value){
        switch(field){
            case "telephone":
                field = "phone";
                List <WebElement> codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                List <WebElement> areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                List <WebElement> numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                if(codeCountrys.isEmpty()){
                    this.add("telephone");
                    codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                    areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                    numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                }
                commonMethods.modifyPhoneNumber(codeCountrys,areaCountrys,numberCountrys,value);
                break;
            case "fax":
                codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                if(codeCountrys.isEmpty()){
                    this.add(field);
                    codeCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_COUNTRY_CODE,field));
                    areaCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_AREA_CODE,field));
                    numberCountrys = commonMethods.findElementsShadowRoot(String.format(FIELD_NUMBER,field));
                }
                commonMethods.modifyPhoneNumber(codeCountrys,areaCountrys,numberCountrys,value);
                break;
            case "email":
                List <WebElement> mails = commonMethods.findElementsShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                WebElement auxMail;
                if(mails.isEmpty()){
                    this.add("email");
                    auxMail = commonMethods.findElementShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                }
                else{
                    int index = mails.size()-1;
                    mails.get(index).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
                    auxMail = mails.get(index);
                }
                auxMail.sendKeys(value);
                break;
            case "website":
                List <WebElement> websites = commonMethods.findElementsShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                WebElement auxWebsite;
                if(websites.isEmpty()){
                    this.add("website");
                    auxWebsite = commonMethods.findElementShadowRoot(String.format(FIELD_TEXT_INPUT,field,field));
                }
                else{
                    int index = websites.size()-1;
                    websites.get(index).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
                    auxWebsite = websites.get(index);
                }
                auxWebsite.sendKeys(value);
            break;
            case "DataProtection":
                WebElement object = commonMethods.findElementShadowRoot(String.format(OPTION_PERSONAL_INFO_CHECK,value));
                object.click();
            break;
            case "PublicallyVisible":
                if(value.equals("selectAllConsented")){
                    value = String.format(OPTION_DATA_PROTECTED,value);
                }
                else{
                    value = String.format(OPTION_DATA_PROTECTED_ITEMS,value);
                }
                WebElement checkboxValue = commonMethods.findElementShadowRoot(value);
                checkboxValue.click();
            break;

        }
    }
    @Step("^I add a \\\"([^\\\"]*)\\\"$")
    public void add(String field) {
        String addId = field;
        if(field.equals("telephone")){
            addId = "phone";
        }
        WebElement add = commonMethods.findElementShadowRoot(String.format(ADD, field,addId));
        add.click();
    }
    @Step("^I validate I am able to delete a \\\"([^\\\"]*)\\\"$")
    public void delete(String field) {
        String addId = field;
        if(field.equals("telephone")){
            addId = "phone";
        }
        WebElement delete = commonMethods.findElementShadowRoot(String.format(DELETE, field,addId));
        delete.click();
    }
    @Step("^I validate I am able to press the dropdown to select a \\\"([^\\\"]*)\\\"$")
    public void fillDropdown(String field) {
        WebElement value = commonMethods.findElementShadowRoot(DROPDOWN_INPUT);
        commonMethods.scrollDown(value);
        value.click();
        commonMethods.waitWebElement("[data-baseweb='select'] [aria-expanded='true']","");
        List<WebElement> options = commonMethods.findElementsShadowRoot(OPTIONS_DROPDOWN_DISPLAY);
        WebElement elementOfList = options.stream().filter(webElement -> webElement.getText().contains(field)).findFirst().orElseThrow(() -> new NullPointerException("The element not exist "));
        commonMethods.scrollDown(elementOfList);
        elementOfList.click();
    }
    @Step("I am able to check for understood the articles for my deletion")
    public void iCheckUnderstoodArticlesDeletion() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonCheck = commonMethods.findElementShadowRoot("[name='deletionConfirmed']");
        commonMethods.waitWebElement("[name='deletionConfirmed']","");
        buttonCheck.click();
    }
    @Step("^I validate I am not able to press the dropdown to select a \\\"([^\\\"]*)\\\" doesn't exist$")
    public void validateValueNotInDropdown(String field) {
        WebElement value = commonMethods.findElementShadowRoot(DROPDOWN_INPUT);
        value.click();
        List<WebElement> options = commonMethods.findElementsShadowRoot(OPTIONS_DROPDOWN_DISPLAY);
        assertTrue(options.stream().filter(webElement -> webElement.getText().contains(field)).findFirst().isEmpty());
    }

    @Step("I validate I am able to press X")
    public void xButton(){
        WebElement element = commonMethods.findElementShadowRoot(X_BUTTON);
        element.click();
    }
    @Step("I verify the field error has error")
    public void checkErrorField(){
        commonMethods.waitWebElement(ERROR_FIELD,"");
        boolean status = commonMethods.findElementsShadowRoot(String.format(ERROR_FIELD)).isEmpty();
        assertFalse("The validation of the component was not done",status);
    }
    @Step("^I upload a evidence file for \\\"([^\\\"]*)\\\"$")
    public void uploadFile(String value) {
        String url = getDriver().getCurrentUrl();
        Serenity.getDriver().navigate().to("https://drive.google.com/file/d/1B4oyIwgRW9NF0D03q9sUe1SddGFgOULi/view?usp=sharing");
        WebElement downloadEvidenceDoc = Serenity.getDriver().findElement(By.xpath(DOWNLOAD_BUTTON_DOC));
        downloadEvidenceDoc.click();
        commonMethods.openURL(url);
        this.edit(value);
        this.validateEditable(value);
        WebElement uploadFileButton = commonMethods.findElementShadowRoot(INPUT_FILE);
        uploadFileButton.sendKeys(FILE_PATH);
        WebElement uploadConfirm = commonMethods.findElementShadowRoot(REGISTRATION_UPLOAD_FILE);
        uploadConfirm.click();
    }
    @Step("I verify I am able to delete the uploaded evidence file")
    public void deletingEvidence(){
        WebElement deletingEvidence = commonMethods.findElementShadowRoot(EDITION_DELETE_EVIDENCE);
        deletingEvidence.click();
    }
    @Step("I validate the link for download appears")
    public void downloadLinkDocument(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        assertNotNull("The link document is not displayed!",commonMethods.findElementShadowRoot(DOWNLOAD_DOCUMENT_LINK));
    }
    @Step("I validate the link for download documents deficiencies appears")
    public void downloadLinkDocumentDeficiencies(){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        assertNotNull("The link document is not displayed!",commonMethods.findElementShadowRoot("[data-testid='downloadDeletionDeficiencyForm-button']"));
    }
    @Step("I download the document")
    public void downloadDocument(){
        String url = commonMethods.findElementShadowRoot(DOWNLOAD_DOCUMENT_LINK).getAttribute("href");
        Serenity.getDriver().navigate().to(url);
        File dir = new File("/home/selenium/Downloads/");
        File[] dir_contents = dir.listFiles();
        assertNull(MESSAGE_NULL,dir_contents);
    }
    @Step("^I select \\\"([^\\\"]*)\\\" part of contracting state$")
    public void iSelectPartOfContractingState(String value) {
        WebElement check = commonMethods.findElementShadowRoot(String.format(CHECKBOX_NATIONALITY_FIELD, "1"));
        commonMethods.waitWebElement(String.format(CHECKBOX_NATIONALITY_FIELD, "1"),"");
        commonMethods.scrollDown(check);
        switch (value) {
            case "Yes":
                check.click();
                break;
            case "No":
                 check = commonMethods.findElementShadowRoot(String.format(CHECKBOX_NATIONALITY_FIELD, "2"));
                 check.click();
                break;
        }
    }
    @Step("^I validate the dropdown \\\"([^\\\"]*)\\\" showed the \\\"([^\\\"]*)\\\" selected$")
    public void checkCountryShowed(String dropdown, String value) {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        List <WebElement> dropdowns = commonMethods.findElementsShadowRoot(REGISTRATION_DROPDOWNS_SELECTED);
        WebElement element=null;
        switch (dropdown){
            case "nationality":
                element = dropdowns.get(0);
                break;
            case "language":
                element = dropdowns.get(1);
                break;
            case "country":
                element = dropdowns.get(2);
                break;
        }
        assert element != null;
        commonMethods.scrollDown(element);
        element.click();
        commonMethods.waitWebElement("[data-baseweb='select'] [aria-expanded='true']","");
        List<WebElement> options = commonMethods.findElementsShadowRoot(OPTIONS_DROPDOWN_DISPLAY);
        WebElement elementOfList = options.stream().filter(webElement -> webElement.getText().contains(value)).findFirst().orElseThrow(() -> new NullPointerException("The element not exist"));
        commonMethods.scrollDown(elementOfList);
        elementOfList.click();
    }
    @Step("I press the next button")
    public void nextButton(){
        commonMethods.waitWebElement(REGISTRATION_NEXT_BUTTON,"");
        WebElement next = commonMethods.findElementShadowRoot(REGISTRATION_NEXT_BUTTON);
        commonMethods.scrollDown(next);
        next.click();
        WebElement errorMessageCheck = commonMethods.findElementShadowRoot("[data-testid='FeedbackErrorIcon']");
        Assert.assertNull("Error en al hacer submit",errorMessageCheck);
    }
    @Step("^I filled the \\\"([^\\\"]*)\\\" with the value \\\"([^\\\"]*)\\\"$")
    public void setFieldValue(String field, String value){
        List<String> cssSelectors = new ArrayList<String>();
        boolean flag = false;
        switch (field){
            case "website":
                cssSelectors.add(REGISTRATION_WEBSITE);
            break;
            case "email":
                cssSelectors.add(REGISTRATION_MAIL);
            break;
            case "telephone":
                cssSelectors.add(REGISTRATION_PHONE_COUNTRY_CODE);
                cssSelectors.add(REGISTRATION_PHONE_AREA_CODE);
                cssSelectors.add(REGISTRATION_PHONE_NUMBER);
                flag = true;
            break;
            case "fax":
                cssSelectors.add(REGISTRATION_FAX_COUNTRY_CODE);
                cssSelectors.add(REGISTRATION_FAX_AREA_CODE);
                cssSelectors.add(REGISTRATION_FAX_NUMBER);
                flag = true;
            break;
        }
        if(flag) {
            commonMethods.modifyPhoneNumber(commonMethods.findElementsShadowRoot(cssSelectors.get(0)),commonMethods.findElementsShadowRoot(cssSelectors.get(1)),commonMethods.findElementsShadowRoot(cssSelectors.get(2)), value);
        }
        else {
            for (String cssSelector : cssSelectors) {
                WebElement element = commonMethods.findElementShadowRoot(cssSelector);
                element.clear();
                element.sendKeys(value);
            }
        }
    }
    @Step("^I validate the \\\"([^\\\"]*)\\\" is showed$")
    public void checkShowed(String value) {
        List<String> cssSelectors = new ArrayList<String>();
        switch (value){
            case "website":
                cssSelectors.add(REGISTRATION_WEBSITE);
            break;
            case "telephone":
                cssSelectors.add(REGISTRATION_PHONE_COUNTRY_CODE);
                cssSelectors.add(REGISTRATION_PHONE_AREA_CODE);
                cssSelectors.add(REGISTRATION_PHONE_NUMBER);
            break;
            case "fax":
                cssSelectors.add(REGISTRATION_FAX_COUNTRY_CODE);
                cssSelectors.add(REGISTRATION_FAX_AREA_CODE);
                cssSelectors.add(REGISTRATION_FAX_NUMBER);
            break;
        }
        for (String cssSelector: cssSelectors) {
            WebElement element= commonMethods.findElementShadowRoot(cssSelector);
            Assert.assertFalse(element.getAttribute("value").isEmpty());
        }

    }
    @Step("^I select a ticket in PWB for the \\\"([^\\\"]*)\\\"$")
    public void iSelectATicketInPWBForThe(String frepid){
        WebElement task = getDriver().findElement(By.xpath(String.format(PWB_TASK,frepid)));
        task.click();
    }
    @Step("^I select a ticket in PWB for the name \\\"([^\\\"]*)\\\"$")
    public void iSelectATicketInPWBForTheName(String name){
        WebElement task = getDriver().findElement(By.xpath(String.format(PWB_TASK_NAME,name)));
        task.click();
    }
    @Step("I claim the ticket PWB")
    public void iClaimTheTicketPWB() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        commonMethods.waitWebElement(PWB_CLAIM,"pwb");
        WebElement buttonClaim = commonMethods.findElementShadowRootPwb(PWB_CLAIM);
        buttonClaim.click();
        commonMethods.waitWebElement("[data-testid='unclaim-task-button']","pwb");
    }
    @Step("I am able to edit the the changes")
    public void iAmAbleToEditTheTheChanges() {
        commonMethods.waitWebElement(PWB_EDIT,"pwb");
        WebElement buttonEdit = commonMethods.findElementShadowRootPwb(PWB_EDIT);
        commonMethods.scrollDown(buttonEdit);
        buttonEdit.click();
        WebElement buttonClear = commonMethods.findElementShadowRootPwb(PWB_CLEAR);
        commonMethods.scrollDown(buttonClear);
        buttonClear.click();
        WebElement buttonCancelEdit = commonMethods.findElementShadowRootPwb(PWB_CANCEL_EDIT);
        commonMethods.scrollDown(buttonCancelEdit);
        buttonCancelEdit.click();
    }
    @Step("I am able to see all the representative data")
    public void iAmAbleToSeeAllTheRepresentativeData() {
        commonMethods.waitWebElement(PWB_INFO_REP,"pwb");
        WebElement RepresentativeInfoPanel = commonMethods.findElementShadowRootPwb(PWB_INFO_REP);
        commonMethods.scrollDown(RepresentativeInfoPanel);
        RepresentativeInfoPanel.click();
    }
    @Step("I approve the changes with comment")
    public void iApproveTheChangesWithComment() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonApprove = commonMethods.findElementShadowRootPwb(String.format(PWB_RADIO,"1"));
        commonMethods.waitWebElement(String.format(PWB_RADIO,"1"),"pwb");
        commonMethods.scrollDown(buttonApprove);
        commonMethods.waitWebElement(String.format(PWB_RADIO,"1"),"pwb");
        buttonApprove.click();
        WebElement textBox = commonMethods.findElementShadowRootPwb(PWB_COMMENT);
        textBox.sendKeys("Approved");
    }
    @Step("I found deficiencies on the changes with comment")
    public void iFoundDeficienciesTheChangesWithComment() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonDeficiencies = commonMethods.findElementShadowRootPwb(String.format(PWB_RADIO,"2"));
        commonMethods.waitWebElement(String.format(PWB_RADIO,"2"),"pwb");
        commonMethods.scrollDown(buttonDeficiencies);
        commonMethods.waitWebElement(String.format(PWB_RADIO,"2"),"pwb");
        buttonDeficiencies.click();
        WebElement textBox = commonMethods.findElementShadowRootPwb(PWB_COMMENT);
        textBox.sendKeys("Deficiencies");
    }
    @Step("I confirm the approve of the changes")
    public void iConfirmTheApproveOfTheChanges() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonConfirm = commonMethods.findElementShadowRootPwb(PWB_CONFIRM);
        commonMethods.waitWebElement(PWB_CONFIRM,"pwb");
        commonMethods.scrollDown(buttonConfirm);
        buttonConfirm.click();
    }
    @Step("^I field the frepid \\\"([^\\\"]*)\\\"$")
    public void iFieldFreid(String frepid){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonApprove = commonMethods.findElementShadowRootPwb(String.format(PWB_RADIO,"1"));
        commonMethods.waitWebElement(String.format(PWB_RADIO,"1"),"pwb");
        commonMethods.scrollDown(buttonApprove);
        commonMethods.waitWebElement(String.format(PWB_RADIO,"1"),"pwb");
        buttonApprove.click();
        WebElement textBox = commonMethods.findElementShadowRootPwb("[id='previousFrepIds']");
        textBox.sendKeys(frepid);
    }
    @Step("I press in remedy deletion deficiency button")
    public void iPressInRemedyDeletionDeficiencyButton() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonRemedyDeletionDeficiency = commonMethods.findElementShadowRoot("[data-testid='remedyDeletionDeficiency-button']");
        commonMethods.waitWebElement("[data-testid='remedyDeletionDeficiency-button']","");
        commonMethods.scrollDown(buttonRemedyDeletionDeficiency);
        buttonRemedyDeletionDeficiency.click();
    }
    @Step("I click in delete")
    public void iClickInDelete() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        WebElement buttonDeletion = commonMethods.findElementShadowRoot("[data-testid='request-deletion-button']");
        commonMethods.waitWebElement("[data-testid='request-deletion-button']","");
        commonMethods.scrollDown(buttonDeletion);
        buttonDeletion.click();
    }
    @Step("^I go to \"([^\"]*)\" for \"([^\"]*)\"$")
    public void gotoSectionFlow(String section, String flow){
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        if(commonMethods.findElementShadowRoot(EDIT_FIELD_FIRSTNAME) == null) {
            WebElement cancelRequest = commonMethods.findElementShadowRoot(REGISTRATION_CANCEL_REQUEST);
            commonMethods.scrollDown(cancelRequest);
            cancelRequest.click();
            WebElement cancelYesRequest = commonMethods.findElementShadowRoot(REGISTRATION_YES_CANCEL_REQUEST);
            cancelYesRequest.click();
        }
        switch (section){
            case "Section 2":
                this.fillSectionOne(flow);
                this.nextButton();
                break;
            case "Section 3":
                this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                break;
            case "Section 4":
                this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                break;
            case "Section 5":
                this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                this.fillSectionFour(flow);
                this.nextButton();
                break;
            case "Section 6":
                this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                this.fillSectionFour(flow);
                this.nextButton();
                this.fillSectionFive();
                this.nextButton();
                break;
            case "Section Done":
                this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                this.fillSectionFour(flow);
                this.nextButton();
                this.fillSectionFive();
                this.nextButton();
                this.nextButton();
                break;
        }
    }
    @Step("^I go to \"([^\"]*)\"$")
    public void gotoSection(String section){
        String flow = "";
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        if(commonMethods.findElementShadowRoot(EDIT_FIELD_FIRSTNAME) == null) {
            WebElement cancelRequest = commonMethods.findElementShadowRoot(REGISTRATION_CANCEL_REQUEST);
            commonMethods.scrollDown(cancelRequest);
            cancelRequest.click();
            WebElement cancelYesRequest = commonMethods.findElementShadowRoot(REGISTRATION_YES_CANCEL_REQUEST);
            cancelYesRequest.click();
        }
        switch (section){
            case "Section 2":
                this.fillSectionOne(flow);
                this.nextButton();
            break;
            case "Section 3":
                 this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
            break;
            case "Section 4":
                 this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
            break;
            case "Section 5":
                 this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                this.fillSectionFour(flow);
                this.nextButton();
            break;
            case "Section 6":
                 this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                this.fillSectionFour(flow);
                this.nextButton();
                this.fillSectionFive();
                this.nextButton();
            break;
            case "Section Done":
                this.fillSectionOne(flow);
                this.nextButton();
                this.fillSectionTwo();
                this.nextButton();
                this.fillSectionThree();
                this.nextButton();
                this.fillSectionFour(flow);
                this.nextButton();
                this.fillSectionFive();
                this.nextButton();
                this.nextButton();
            break;
        }
    }
    @Step("I download the document evidence")
    public void iDownloadTheDocumentEvidence() {
        Serenity.getDriver().navigate().to("https://drive.google.com/file/d/1B4oyIwgRW9NF0D03q9sUe1SddGFgOULi/view?usp=sharing");
        WebElement downloadEvidenceDoc = Serenity.getDriver().findElement(By.xpath(DOWNLOAD_BUTTON_DOC));
        downloadEvidenceDoc.click();
    }
    @Step("I validate I am able to check I passed the European qualifying examination")
    public void iValidateIAmAbleToCheckIPassedTheEuropeanQualifyingExamination() {
        WebElement qualified = commonMethods.findElementShadowRoot(REGISTRATION_QUALIFIED);
        qualified.click();
    }
    @Step("^I validate I am able to signed by \"([^\"]*)\"$")
    public void iValidateIAmAbleToSigned(String signed) {
        WebElement signedBy = commonMethods.findElementShadowRoot("[name='signedBy']");
        signedBy.clear();
        signedBy.sendKeys("/"+ signed +"/");
    }
    @Step("^I validate I am able to check to share my public information us \"([^\"]*)\"$")
    public void iValidateIAmAbleToCheckToShareMyPublicInformation(String check) {
        commonMethods.waitWebElement("[ name='publicationPersonalData']","");
        if(check.equals("personal")) {
            WebElement personal = commonMethods.findElementShadowRoot("[ name='publicationPersonalData']");
            personal.click();
        } else if (check.equals("postal")) {
            WebElement postal = commonMethods.findElementShadowRoot("[ name='publicationPostalAddress']");
            postal.click();
        }
        else{
            log.info("The value doesn't exist");
        }

    }
    @Step("^I validate I am able to write the \"([^\"]*)\" of European Qualifying Examination$")
    public void iValidateIAmAbleToWriteTheOfEuropeanQualifyingExamination(String year) {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        commonMethods.waitWebElement("[id='yearOfEuropeanQualifyingExamination']","");
        WebElement auxYear = commonMethods.findElementShadowRoot("[id='yearOfEuropeanQualifyingExamination']");
        auxYear.sendKeys(year);
    }
    @Step("^I validate I am able to write the \"([^\"]*)\" date Of Oral Proceeding$")
    public void iValidateIAmAbleToWriteTheDateOfOralProceeding(String date) {
        commonMethods.waitWebElement("[id='dateOfOralProceedings']","");
        WebElement auxYear = commonMethods.findElementShadowRoot("[id='dateOfOralProceedings']");
    }
    @Step("I validate the payment is confirmed")
    public void iValidateThePaymentIsConfirmed() {
        commonMethods.waitWebElementNotExit(By.cssSelector(SPINNER));
        commonMethods.waitWebElement("[name='paymentConfirmed']","");
        WebElement paymentConfirmed = commonMethods.findElementShadowRoot("[name='paymentConfirmed']");
        paymentConfirmed.click();
    }
    @Step("I add evidence on the registration")
    public void iAddEvidenceOnTheRegistration() {
        this.fillSectionFive();
    }
    public void fillSectionOne(String flow){
        commonMethods.waitWebElement(EDIT_FIELD_FIRSTNAME,"");
        this.fillName("LYSANDER","SPOONER");
        this.iSelectPartOfContractingState("Yes");

        this.checkCountryShowed("nationality", "Austria");
        this.checkCountryShowed("language", "French");


        WebElement street = commonMethods.findElementShadowRoot("[id='address.addressLine4']");
        street.clear();
        street.sendKeys("test");
        WebElement city = commonMethods.findElementShadowRoot("[ name='address.addressCity']");
        city.clear();
        city.sendKeys("test");

        this.checkCountryShowed("country", "Austria");
        if(flow.equals("")) {
            WebElement qualified = commonMethods.findElementShadowRoot(REGISTRATION_QUALIFIED);
            qualified.click();
        }
        WebElement signedBy = commonMethods.findElementShadowRoot("[name='signedBy']");
        signedBy.clear();
        signedBy.sendKeys("/test/");
    }
    public void fillSectionTwo(){
        commonMethods.waitWebElement("[ name='publicationPersonalData']","");
    }
    public void fillSectionThree(){

        commonMethods.waitWebElement("[ aria-label='PhoneCountryCodeInput']","");

    }
    public void fillSectionFour(String flow){
        if(flow.equals("")) {
            this.iValidateIAmAbleToWriteTheOfEuropeanQualifyingExamination("2022");
        }
        else{
            this.iValidateThePaymentIsConfirmed();
        }
    }
    public void fillSectionFive(){
        commonMethods.waitWebElement("[data-testid='epo-upload']","");
        List <WebElement> uploadButtons = commonMethods.findElementsShadowRoot("[data-testid='epo-upload']");
        List <WebElement> inputFileButton = commonMethods.findElementsShadowRoot(INPUT_FILE);
        commonMethods.scrollDown(uploadButtons.get(0));
        inputFileButton.get(0).sendKeys(FILE_PATH);
        inputFileButton.get(1).sendKeys(FILE_PATH);
        inputFileButton.get(2).sendKeys(FILE_PATH);
        uploadButtons.get(0).click();
        uploadButtons.get(1).click();
        uploadButtons.get(2).click();
    }

}
