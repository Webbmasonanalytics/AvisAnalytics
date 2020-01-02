
package com.avis.app.nmz.kafka.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Brand",
    "RANumber",
    "Discount",
    "Timestamp",
    "CheckInDue",
    "MiniLease",
    "WifiEnabled",
    "RentalType"
})
public class RentalData {

    @JsonProperty("Brand")
    private String brand;
    @JsonProperty("RANumber")
    private String rANumber;
    @JsonProperty("Discount")
    private String discount;
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("CheckInDue")
    private String checkInDue;
    @JsonProperty("MiniLease")
    private Boolean miniLease;
    @JsonProperty("WifiEnabled")
    private Boolean wifiEnabled;
    @JsonProperty("RentalType")
    private String rentalType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Brand")
    public String getBrand() {
        return brand;
    }

    @JsonProperty("Brand")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @JsonProperty("RANumber")
    public String getRANumber() {
        return rANumber;
    }

    @JsonProperty("RANumber")
    public void setRANumber(String rANumber) {
        this.rANumber = rANumber;
    }

    @JsonProperty("Discount")
    public String getDiscount() {
        return discount;
    }

    @JsonProperty("Discount")
    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("Timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("CheckInDue")
    public String getCheckInDue() {
        return checkInDue;
    }

    @JsonProperty("CheckInDue")
    public void setCheckInDue(String checkInDue) {
        this.checkInDue = checkInDue;
    }

    @JsonProperty("MiniLease")
    public Boolean getMiniLease() {
        return miniLease;
    }

    @JsonProperty("MiniLease")
    public void setMiniLease(Boolean miniLease) {
        this.miniLease = miniLease;
    }

    @JsonProperty("WifiEnabled")
    public Boolean getWifiEnabled() {
        return wifiEnabled;
    }

    @JsonProperty("WifiEnabled")
    public void setWifiEnabled(Boolean wifiEnabled) {
        this.wifiEnabled = wifiEnabled;
    }

    @JsonProperty("RentalType")
    public String getRentalType() {
        return rentalType;
    }

    @JsonProperty("RentalType")
    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
