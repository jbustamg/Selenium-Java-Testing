package org.epo.dg5.tests;

import io.cucumber.junit.CucumberOptions;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features/frontend"
                ,"src/test/resources/features/backend"},
        glue = "org.epo.dg5.tests.scenarios.steps.common"

)

@Slf4j
public class CucumberTest {

}