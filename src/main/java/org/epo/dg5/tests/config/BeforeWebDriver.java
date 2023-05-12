package org.epo.dg5.tests.config;

import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.HashMap;

public class BeforeWebDriver implements BeforeAWebdriverScenario {
    @Override
    public DesiredCapabilities apply(EnvironmentVariables environmentVariables, SupportedWebDriver supportedWebDriver, TestOutcome testOutcome, DesiredCapabilities desiredCapabilities) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", new HashMap<String, Object>() {
            {
                put("profile.default_content_settings.popups", 0);
                put("download.default_directory", "/home/selenium/Downloads");
                put("download.prompt_for_download", false);
                put("download.directory_upgrade", true);
                put("safebrowsing.enabled", false);
                put("plugins.always_open_pdf_externally", true);
                put("plugins.plugins_disabled", new ArrayList<String>() {
                    {
                        add("Chrome PDF Viewer");
                    }
                });
            }
        });

        desiredCapabilities.setCapability("name", testOutcome.getTitle());
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("browserVersion", "latest");

        return desiredCapabilities;
    }}