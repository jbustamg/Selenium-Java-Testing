package org.epo.dg5.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.epo.dg5.pojo.Root;
import org.junit.Assert;
import org.springframework.boot.configurationprocessor.json.JSONException;


import java.io.File;
import java.io.IOException;
import java.util.*;

import static io.restassured.RestAssured.*;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.epo.dg5.utils.Operations.*;


@Slf4j
public class BackendStepsReport {

    private final Map<String,String> executionContext = new HashMap<>();
    public void anEpoToken() {
        Map<String, String> paramCollection = new IdentityHashMap<>();
        paramCollection.put("grant_type",GRANT_TYPE);
        paramCollection.put("scope",SCOPE);
        paramCollection.put("client_id",CLIENT_ID);
        paramCollection.put("client_secret",CLIENT_SECRET);
        paramCollection.put("username",USER_MAIL);
        paramCollection.put("password",USER_PASS);
        String response = given().with().
                header("Cookie", COOKIE_ONE).
                params(paramCollection).
                config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT))).
                post(URL_TOKEN_USER).asString();
        JsonPath jsonPath = new JsonPath(response);
        String token = jsonPath.getString("access_token");
        this.executionContext.put("access_token",token);
    }
    public void iGetTheTokenFromNUA(String representiveId) {
        given().contentType(ContentType.JSON);
        String response = when().get(String.format(URL_NUA_USER, representiveId)).asString();
        JsonPath jsonPath = new JsonPath(response);
        String token = jsonPath.getString("token");
        this.executionContext.put("nua_token",token);

    }
    public void iCheckIAmAbleToChangeField(String field){
        File jsonData = new File(String.format("src/test/resources/Payloads/%s.json",field));
        String access_token= this.executionContext.get("access_token");
        String nua_token= this.executionContext.get("nua_token");

        String response = given().contentType(ContentType.JSON).
                header("Authorization", "Bearer " + access_token).
                header("Cookie", COOKIE_TWO).
                header("External-UserArea-Id-Token", nua_token).
                body(jsonData).
                when().post(String.format(ENDPOINT_CHANGE,ENVIRONMENT)).asString();
        JsonPath jsonPath = new JsonPath(response);
        Assert.assertNull(jsonPath.getString("error"));
        Assert.assertNull(jsonPath.getString("validations.codeList"));
    }
    public void iCheckIAmAbleToCheckDontChangeField(String field) throws JsonProcessingException {
        String access_token= this.executionContext.get("access_token");
        String nua_token= this.executionContext.get("nua_token");
        String response = given().contentType(ContentType.JSON).
                header("Authorization", "Bearer " + access_token).
                header("Cookie", COOKIE_TWO).
                header("External-UserArea-Id-Token", nua_token).
                body(this.setInvalidRequest(field)).
                when().post(String.format(ENDPOINT_CHANGE,ENVIRONMENT)).asString();
        JsonPath jsonPath = new JsonPath(response);
        System.out.print(response);
        Assert.assertNotNull("The error code not appears on the response",jsonPath.getString("validations.codeList"));

    }
    public void iGetTheResponseOfTheLegalRepresentative(){
        String access_token= this.executionContext.get("access_token");
        String nua_token= this.executionContext.get("nua_token");

        String response = given().contentType(ContentType.JSON).
                header("Authorization", "Bearer " + access_token).
                header("Cookie", COOKIE_TWO).
                header("External-UserArea-Id-Token", nua_token).
                when().
                get(String.format(ENDPOINT_INFO,ENVIRONMENT)).asString();
        log.info(response);
    }
    public Root setInvalidRequest(String field){
        Root root = new Root();
        Root.Request request = new Root.Request();
        Root.Representative representative = new Root.Representative();
        Root.DataObj dataObj = new Root.DataObj();
        Root.PhoneList num_1 = new Root.PhoneList();
        Root.PhoneList num_2 = new Root.PhoneList();
        Root.PhoneList num_3 = new Root.PhoneList();
        Root.PhoneList num_4 = new Root.PhoneList();
        Root.FaxList numFax_1 = new Root.FaxList();
        Root.FaxList numFax_2 = new Root.FaxList();
        Root.FaxList numFax_3 = new Root.FaxList();
        Root.FaxList numFax_4 = new Root.FaxList();
        Root.Address addressList1 = new Root.Address();
        Root.Address addressList2 = new Root.Address();
        Root.Address addressList3 = new Root.Address();
        root.setType("InformationRepProduct");
        root.setRevision(1);
        dataObj.setType("InformationRepData");
        root.setData(dataObj);
        root.setRequest(request);
        dataObj.setType("InformationRepData");
        root.setProductCode("REPRESENTATIVE_DATA");
        switch (field){
            case "telephone":
                num_1.setCountryCode("90");
                num_1.setAreaCode("90");
                num_1.setNumber("");
                num_1.setId("1");
                num_2.setCountryCode("");
                num_2.setAreaCode("");
                num_2.setNumber("5325320001");
                num_2.setId("2");
                num_3.setCountryCode("");
                num_3.setAreaCode("90");
                num_3.setNumber("5325320001");
                num_3.setId("2");
                num_4.setCountryCode("");
                num_4.setAreaCode("");
                num_4.setNumber("");
                num_4.setId("");
                ArrayList<Root.PhoneList> num = new ArrayList<>();
                num.add(num_1);
                num.add(num_2);
                num.add(num_3);
                num.add(num_4);
                representative.setPhoneList(num);
            break;
            case "fax":
                numFax_1.setCountryCode("90");
                numFax_1.setAreaCode("90");
                numFax_1.setNumber("");
                numFax_1.setId("1");
                numFax_2.setCountryCode("");
                numFax_2.setAreaCode("");
                numFax_2.setNumber("5325320001");
                numFax_2.setId("2");
                numFax_3.setCountryCode("");
                numFax_3.setAreaCode("90");
                numFax_3.setNumber("5325320001");
                numFax_3.setId("2");
                numFax_4.setCountryCode("");
                numFax_4.setAreaCode("");
                numFax_4.setNumber("");
                numFax_4.setId("");
                ArrayList<Root.FaxList> numFax = new ArrayList<>();
                numFax.add(numFax_1);
                numFax.add(numFax_2);
                numFax.add(numFax_3);
                numFax.add(numFax_4);
                representative.setFaxList(numFax);
            break;
            case "firstname":
                representative.setFirstName("Test");
            break;
            case "lastname":
                representative.setLastName("Test");
            break;
            case "name":
                representative.setFirstName("");
                representative.setLastName("");
            break;
            case "nationality":
                representative.setNationality("-");
            break;
            case "preferredLanguage":
                representative.setPreferredLanguage("-");
            break;
            case "addressOne":
                addressList1.setAddress1("");
                representative.setAddress(addressList1);
            break;
            case "addressTwo":
                addressList2.setAddress1("Address 1");
                addressList2.setAddress2("");
                addressList2.setAddress3("");
                addressList2.setAddress4("");
                addressList2.setAddressCity("");
                addressList2.setAddressCountry("");
                representative.setAddress(addressList2);
            break;
            case "addressThree":
                addressList3.setAddress1("");
                addressList3.setAddress2("");
                addressList3.setAddress3("");
                addressList3.setAddress4("");
                addressList3.setAddressCity("");
                addressList3.setAddressCountry("TR");
                representative.setAddress(addressList3);
            break;
        }
        representative.setClientId("100011356");
        representative.setRepresentativeId("99791");
        request.setRepresentative(representative);
        request.setOperation("CHANGE");
        request.setDraftingStage(false);
        request.setType("InformationRepRequest");
        return root;
    }
}

