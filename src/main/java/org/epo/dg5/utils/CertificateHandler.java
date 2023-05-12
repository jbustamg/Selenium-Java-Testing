package org.epo.dg5.utils;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.Serenity;
import okhttp3.*;
import org.epo.testautomation.selenium.By;
import org.epo.testautomation.selenium.SeleniumUtils;
import org.openqa.selenium.WebDriver;

import static org.epo.dg5.utils.Messages.*;
import java.io.IOException;

@Slf4j
public class CertificateHandler {
    public static void startNewSessionWithCertificate(String selenoidUrl, String host, String user) {
        Serenity.getWebdriverManager().closeCurrentDrivers();
        WebDriver webdriver = Serenity.getWebdriverManager().getWebdriver();

        webdriver.get("chrome://policy");
        String wdUrl = selenoidUrl.replace("/wd/hub", "");
        String url = wdUrl + "/download/" + Serenity.getCurrentSessionID()+ "/addpolicy";
        String payload = "{\"AutoSelectCertificateForUrls\": [\"{ \\\"pattern\\\": \\\"" + host + "\\\", \\\"filter\\\": {\\\"SUBJECT\\\": {\\\"CN\\\": \\\"" + user + "\\\"}}}\"]}";
        OkHttpClient client = new OkHttpClient();

        boolean isPolicyChanged;
        try {
            log.info(PREPARING_RESPONSE);
            Response response = client.newCall((new Request.Builder()).url(url).post(RequestBody.create(MediaType.parse("application/json"), payload)).build()).execute();
            isPolicyChanged = response.isSuccessful();
            log.info(SUCCESS_RESPONSE);

            if (!isPolicyChanged) {
                throw new SeleniumUtils.PolicyNotUpdatedException("/addpolicy request failed. Response code: " + response.code());
            }
        } catch (IOException var14) {
            throw new SeleniumUtils.PolicyNotUpdatedException(var14);
        }

        int attempts = 3;
        isPolicyChanged = false;

        for(int i = 0; i < attempts; ++i) {
            webdriver.findElement(By.id("reload-policies")).click();
            isPolicyChanged = true;
            /*
            String policy = webdriver.findElement(By.cssSelector(".policy-data .value")).getText();
            if (policy.contains(user)) {
                log.info(user + EXIST);
                isPolicyChanged = true;
                break;
            }
             */
            log.info(POLICY_CHANGED);
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException var13) {
                Thread.currentThread().interrupt();
            }
        }
        if (!isPolicyChanged) {
            throw new SeleniumUtils.PolicyNotUpdatedException("Policy was not updated");
        }
    }

}
