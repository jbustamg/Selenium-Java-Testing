package org.epo.dg5.tests.scenarios.steps.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.*;
import org.epo.dg5.utils.BackendStepsReport;



public class BackEndStepsDefinition {

    BackendStepsReport backendStepsReport = new BackendStepsReport();
    @Given("An epo user and password")
    public void anEpoToken() {
        backendStepsReport.anEpoToken();
    }

    @When("^I get the token from NUA \\\"([^\\\"]*)\\\"$")
    public void iGetTheTokenFromNUA(String representiveId) {
        backendStepsReport.iGetTheTokenFromNUA(representiveId);
    }
    @Then("^I check I am able to change the \\\"([^\\\"]*)\\\"$")
    public void iCheckIAmAbleToChangeField(String field){
        backendStepsReport.iCheckIAmAbleToChangeField(field);
    }
    @Then("^I check I am able to check the elements don't change the \\\"([^\\\"]*)\\\"$")
    public void iCheckIAmAbleToCheckDontChangeField(String field) throws JsonProcessingException {
        backendStepsReport.iCheckIAmAbleToCheckDontChangeField(field);
    }
    @Then("I get the response of the legal representative")
    public void iGetTheResponseOfTheLegalRepresentative() {
        backendStepsReport.iGetTheResponseOfTheLegalRepresentative();
    }
}
