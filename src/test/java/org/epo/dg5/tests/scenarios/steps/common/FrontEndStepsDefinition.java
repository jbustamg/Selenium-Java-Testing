package org.epo.dg5.tests.scenarios.steps.common;

import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.epo.dg5.utils.*;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.epo.dg5.utils.Locators.*;
import static org.epo.dg5.utils.Operations.USER_MAIL;
import static org.epo.dg5.utils.Operations.USER_PASS;
import static org.junit.Assert.assertTrue;


@Slf4j
public class FrontEndStepsDefinition {

    @Steps
    CommonMethods commonMethods;
    MsSSOLogin  msSSOLogin;
    ProcessIdCleaning dbClean = new ProcessIdCleaning();
    @Given("I log-in with an authorised user in NUA")
    public void login(){
        String hostURL = "https://epo.mtls.okta.com";
        String user = "TCS test user 99790";
        //String user = "TCS test user 99791";
        //String user = "TCS test user 99784";
        String nodeURL = "https://marina.internal.epo.org/test-automation/selenoid-k8s-master/wd/hub";
        CertificateHandler.startNewSessionWithCertificate(nodeURL,hostURL, user);
        commonMethods.openURL(hostURL);
    }
    @Given("^I log-in with an authorised \\\"([^\\\"]*)\\\" in NUA$")
    public void loginDifUsers(String user){
        //dbClean.setCleanTheDB(user);
        String hostURL = "https://epo.mtls.oktapreview.com";
        String nodeURL = "https://marina.internal.epo.org/test-automation/selenoid-k8s-master/wd/hub";
        user = "TCS test user "+ user;
        CertificateHandler.startNewSessionWithCertificate(nodeURL,hostURL, user);
    }
    @Given("DG5 Administrative Employee is logged in to PWB")
    public void dgAdministrativeEmployeeIsLoggedInToPWB(){
        getDriver().get("https://login.microsoftonline.com/");
        msSSOLogin.processMSAuthentication(USER_MAIL, USER_PASS);
        getDriver().get("https://endurance.internal.epo.org/inbox-intg/inbox/");
        boolean display = getDriver().findElement(By.xpath("//*[contains(text(),'Teams')]")).isDisplayed();
        assertTrue(display);
        getDriver().findElement(By.xpath("//*[contains(text(),'Teams')]")).click();
    }
    @When("I navigate to the desired NUA menu section MyData")
    public void navegation(){commonMethods.openURL(ENVIRONMENT);}
    @When("^I navigate to the desired NUA menu section \\\"([^\\\"]*)\\\"$")
    public void navegationSection(String section){
        commonMethods.openSection(section);}
    FrontendStepsReport frontendStepsReport = new FrontendStepsReport();
    @Then("^I validate \\\"([^\\\"]*)\\\" attribute exist have value$")
    public void validElementExist(String field){
        frontendStepsReport.validElementExist(field);}
    @Then("^I validate \\\"([^\\\"]*)\\\" exist$")
    public void validExist(String field){
        frontendStepsReport.validExist(field);}
    @And("^I validate the text fields the original \\\"([^\\\"]*)\\\"$")
    public void validNationalityAfterCancel(String country){ frontendStepsReport.validNationalityAfterCancel(country);}
    @And("I validate the fields is empty")
    public void emptyNationality(){ frontendStepsReport.emptyNationality();}
    @And("I validate the fields is not empty")
    public void notEmptyNationality(){
        frontendStepsReport.notEmptyNationality();}
    @When("^I fill the \\\"([^\\\"]*)\\\" and the \\\"([^\\\"]*)\\\"$")
    public void fillName(String name, String lastname){
        frontendStepsReport.fillName(name,lastname);}
    @When("^I fill the \\\"([^\\\"]*)\\\" and the \\\"([^\\\"]*)\\\" with evidence$")
    public void fillNameEvidence(String name, String lastname){
        frontendStepsReport.fillNameEvidence(name,lastname);}
    @And("I press the submit button")
    public void submitButton(){
        frontendStepsReport.submitButton();}
    @And("I press the next button")
    public void nextButton(){
        frontendStepsReport.nextButton();}
    @Then("I validate I am able to press cancel")
    public void cancelButton(){
        frontendStepsReport.cancelButton();}
    @Then("^I validate \\\"([^\\\"]*)\\\" the field is not editable$")
    public void validateNotEditable(String field){
        frontendStepsReport.validateNotEditable(field);}
    @Then("^I validate I am able to press the dropdown to select a \\\"([^\\\"]*)\\\"$")
    public void fillDropdown(String field) {
        frontendStepsReport.fillDropdown(field);}
    @And("^I validate I am not able to press the dropdown to select a \\\"([^\\\"]*)\\\" doesn't exist$")
    public void validateValueNotInDropdown(String field) {
        frontendStepsReport.validateValueNotInDropdown(field);}
    @And("I validate I am able to press X")
    public void xButton(){
        frontendStepsReport.xButton();}
    @Then ("^I validate \\\"([^\\\"]*)\\\" the field is editable$")
    public void validateEditable(String field){
        frontendStepsReport.validateEditable(field);}
    @Then ("^I add a \\\"([^\\\"]*)\\\"$")
    public void add(String field){
        frontendStepsReport.add(field);}
    @Then ("^I validate I am able to delete a \\\"([^\\\"]*)\\\"$")
    public void delete(String field){
        frontendStepsReport.delete(field);}
    @When ("^I press edit \\\"([^\\\"]*)\\\"$")
    public void editField(String field){
        frontendStepsReport.edit(field);}
    @Then ("^I empty the \\\"([^\\\"]*)\\\"$")
    public void setEmptyField(String field){
        frontendStepsReport.setEmptyField(field);}
    @And ("I verify the field error has error")
    public void checkErrorField(){
        frontendStepsReport.checkErrorField();}
    @Then("^I am fill the \\\"([^\\\"]*)\\\" with the \\\"([^\\\"]*)\\\" value$")
    public void setFillField(String field, String value){
        frontendStepsReport.setFillField(field,value);}
    @Then("^I validate the field is not check able$")
    public void validateNotCheckable(){
        frontendStepsReport.validateNotCheckable();}
    @Then("^I upload a evidence file for \\\"([^\\\"]*)\\\"$")
    public void uploadFile(String value) throws Exception {
        frontendStepsReport.uploadFile(value);}
    @When("^I select \\\"([^\\\"]*)\\\" part of contracting state$")
    public void iSelectPartOfContractingState(String value) {
        frontendStepsReport.iSelectPartOfContractingState(value);}
    @When("^I validate the dropdown \\\"([^\\\"]*)\\\" showed the \\\"([^\\\"]*)\\\" selected$")
    public void checkCountryShowed(String dropdown, String value){
        frontendStepsReport.checkCountryShowed(dropdown,value);
    }
    @When("^I validate the \\\"([^\\\"]*)\\\" is showed$")
    public void checkShowed(String value) {
        frontendStepsReport.checkShowed(value);
    }
    @When("^I go to \"([^\"]*)\"$")
    public void gotoSection(String section){
        frontendStepsReport.gotoSection(section);
    }
    @When("^I go to \"([^\"]*)\" for \"([^\"]*)\"$")
    public void gotoSectionFlow(String section, String flow){
        frontendStepsReport.gotoSectionFlow(section,flow);
    }
    @Then("^I filled the \\\"([^\\\"]*)\\\" with the value \\\"([^\\\"]*)\\\"$")
    public void setFieldValue(String field, String value){
        frontendStepsReport.setFieldValue(field,value);}
    @Then("I verify I am able to delete the uploaded evidence file")
    public void deletingEvidence(){frontendStepsReport.deletingEvidence();}
    @Then ("I validate the link for download appears")
    public void downloadLinkDocument(){ frontendStepsReport.downloadLinkDocument();}
    @Then("I validate the link for download documents deficiencies appears")
    public void downloadLinkDocumentDeficiencies(){frontendStepsReport.downloadLinkDocumentDeficiencies();}
    @Then ("I download the document")
    public void downloadDocument(){ frontendStepsReport.downloadDocument();}
    @When("^I select a ticket in PWB for the \\\"([^\\\"]*)\\\"$")
    public void iSelectATicketInPWBForThe(String frepid){ frontendStepsReport.iSelectATicketInPWBForThe(frepid);}
    @When("^I select a ticket in PWB for the name \\\"([^\\\"]*)\\\"$")
    public void iSelectATicketInPWBForTheName(String name){ frontendStepsReport.iSelectATicketInPWBForTheName(name);}
    @When("I claim the ticket PWB")
    public void iClaimTheTicketPWB() {
        frontendStepsReport.iClaimTheTicketPWB();
    }
    @When("I am able to edit the the changes")
    public void iAmAbleToEditTheTheChanges() {
        frontendStepsReport.iAmAbleToEditTheTheChanges();
    }
    @When("I am able to see all the representative data")
    public void iAmAbleToSeeAllTheRepresentativeData() {
        frontendStepsReport.iAmAbleToSeeAllTheRepresentativeData();
    }
    @Then("I approve the changes with comment")
    public void iApproveTheChangesWithComment() {
        frontendStepsReport.iApproveTheChangesWithComment();
    }
    @When("^I field the frepid \\\"([^\\\"]*)\\\"$")
    public void iFieldFreid(String frepid){
        frontendStepsReport.iFieldFreid(frepid);
    }
    @Then("I found deficiencies on the changes with comment")
    public void iFoundDeficienciesTheChangesWithComment() {
        frontendStepsReport.iFoundDeficienciesTheChangesWithComment();
    }
    @Then("I confirm the approve of the changes")
    public void iConfirmTheApproveOfTheChanges() {
        frontendStepsReport.iConfirmTheApproveOfTheChanges();
    }
    @When("^I validate I am able to press the dropdown to select a \\\"([^\\\"]*)\\\" with evidence$")
    public void iValidateIAmAbleToPressTheDropdownToSelectAWithEvidence(String nationality) {
        frontendStepsReport.iValidateIAmAbleToPressTheDropdownToSelectAWithEvidence(nationality);
    }
    @When("I validate I am able to edit my address")
    public void iValidateIAmAbleToEditMyAddress() {
        frontendStepsReport.iValidateIAmAbleToEditMyAddress();
    }

    @And("I download the document evidence")
    public void iDownloadTheDocumentEvidence() {
        frontendStepsReport.iDownloadTheDocumentEvidence();
    }

    @When("I validate I am able to check I passed the European qualifying examination")
    public void iValidateIAmAbleToCheckIPassedTheEuropeanQualifyingExamination() {
        frontendStepsReport.iValidateIAmAbleToCheckIPassedTheEuropeanQualifyingExamination();
    }
    @Then("^I validate I am able to signed by \"([^\"]*)\"$")
    public void iValidateIAmAbleToSigned(String signed) {
        frontendStepsReport.iValidateIAmAbleToSigned(signed);
    }
    @When("I am able to check for understood the articles for my deletion")
    public void iCheckUnderstoodArticlesDeletion() {
        frontendStepsReport.iCheckUnderstoodArticlesDeletion();
    }
    @When("^I validate I am able to check to share my public information us \"([^\"]*)\"$")
    public void iValidateIAmAbleToCheckToShareMyPublicInformation(String check) {
        frontendStepsReport.iValidateIAmAbleToCheckToShareMyPublicInformation(check);
    }
    @When("^I validate I am able to write the \"([^\"]*)\" of European Qualifying Examination$")
    public void iValidateIAmAbleToWriteTheOfEuropeanQualifyingExamination(String year) {
        frontendStepsReport.iValidateIAmAbleToWriteTheOfEuropeanQualifyingExamination(year);
    }
    @When("^I validate I am able to write the \"([^\"]*)\" date Of Oral Proceeding$")
    public void iValidateIAmAbleToWriteTheDateOfOralProceeding(String date) {
        frontendStepsReport.iValidateIAmAbleToWriteTheDateOfOralProceeding(date);
    }
    @When("I add evidence on the registration")
    public void iAddEvidenceOnTheRegistration() {
        frontendStepsReport.iAddEvidenceOnTheRegistration();
    }
    @And("^I am able to select a date of change \"([^\"]*)\"$")
    public void iAmAbleToSelectADateOfChange(String date) {
        frontendStepsReport.iAmAbleToSelectADateOfChange(date);
    }
    @Then("^I am able to select a date of deletion  \"([^\"]*)\"$")
    public void iAmAbleToSelectADateOfDeletion(String date) {
        frontendStepsReport.iAmAbleToSelectADateOfDeletion(date);
    }
    @Then("I press the Save and Review button")
    public void saveAndReviewButton(){
        frontendStepsReport.saveAndReviewButton();
    }
    @Then("I press the cancel request of deletion")
    public void iPressCancelRequestDeletion(){
        frontendStepsReport.iPressCancelRequestDeletion();
    }
    @Then("I press Submit")
    public void iPressSubmit(){
        frontendStepsReport.iPressSubmit();
    }
    @Then("I am able to press withdraw")
    public void iPressWithdraw(){
        frontendStepsReport.iPressWithdraw();
    }
    @Then("I am able to press withdraw for Registration")
    public void iPressWithdrawRegistration(){
        frontendStepsReport.iPressWithdrawRegistration();
    }
    @Then("I am able to press withdraw for deletion")
    public void iPressWithdrawDeletion(){
        frontendStepsReport.iPressWithdrawDeletion();
    }
    @Then("I click in delete")
    public void iClickInDelete() {
        frontendStepsReport.iClickInDelete();
    }
    @When("I press in remedy deletion deficiency button")
    public void iPressInRemedyDeletionDeficiencyButton() {
        frontendStepsReport.iPressInRemedyDeletionDeficiencyButton();
    }
    @When("I validate the payment is confirmed")
    public void iValidateThePaymentIsConfirmed() {
        frontendStepsReport.iValidateThePaymentIsConfirmed();
    }
}
