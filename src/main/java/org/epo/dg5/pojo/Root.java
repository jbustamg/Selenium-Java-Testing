package org.epo.dg5.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class Root {
        private String type;
        private int revision;
        private Request request;
        private DataObj data;
        private String productCode;

    @Data @AllArgsConstructor @NoArgsConstructor
    public static class DataObj{
        private String type;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class PhoneList{
        private String areaCode;
        private String countryCode;
        private String id;
        private String number;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class FaxList{
        private String areaCode;
        private String countryCode;
        private String id;
        private String number;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class Address{
        private String address1;
        private String address2;
        private String address3;
        private String address4;
        private String addressCountry;
        private String addressCity;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class Representative{
        private String clientId;
        private String representativeId;
        private List<PhoneList> phoneList;
        private List<FaxList> faxList;
        private String  firstName;
        private String  lastName;
        private String  nationality;
        private String  preferredLanguage;
        private Address address;
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class Request{
        private String operation;
        private boolean draftingStage;
        private String type;
        private Representative representative;
    }



}
