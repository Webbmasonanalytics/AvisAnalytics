
package com.avis.app.nmz.kafka.model;

import java.util.HashMap;
import java.util.Map;

import com.avis.app.fw.kafka.model.DataObject;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "VIN",
    "MVA",
    "Status",
    "Source",
    "VehicleDetails",
    "VehicleState",
    "Telemetry",
    "VendorIds",
    "LastUpdate",
    "LastCommDate",
    "RevisionNumber"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelemetryNormalizedMsg implements DataObject{

    @JsonProperty("VIN")
    private String vIN;
    @JsonProperty("MVA")
    private String mVA;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("VehicleDetails")
    private VehicleDetails vehicleDetails;
    @JsonProperty("VehicleState")
    private VehicleState vehicleState;
    @JsonProperty("Telemetry")
    private Telemetry telemetry;
    @JsonProperty("VendorIds")
    private VendorIds vendorIds;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    @JsonProperty("LastCommDate")
    private String lastCommDate;
    @JsonProperty("RevisionNumber")
    private Integer revisionNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("VIN")
    public String getVIN() {
        return vIN;
    }

    @JsonProperty("VIN")
    public void setVIN(String vIN) {
        this.vIN = vIN;
    }

    @JsonProperty("MVA")
    public String getMVA() {
        return mVA;
    }

    @JsonProperty("MVA")
    public void setMVA(String mVA) {
        this.mVA = mVA;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("VehicleDetails")
    public VehicleDetails getVehicleDetails() {
        return vehicleDetails;
    }

    @JsonProperty("VehicleDetails")
    public void setVehicleDetails(VehicleDetails vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }

    @JsonProperty("VehicleState")
    public VehicleState getVehicleState() {
        return vehicleState;
    }

    @JsonProperty("VehicleState")
    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    @JsonProperty("Telemetry")
    public Telemetry getTelemetry() {
        return telemetry;
    }

    @JsonProperty("Telemetry")
    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    @JsonProperty("VendorIds")
    public VendorIds getVendorIds() {
        return vendorIds;
    }

    @JsonProperty("VendorIds")
    public void setVendorIds(VendorIds vendorIds) {
        this.vendorIds = vendorIds;
    }

    @JsonProperty("LastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("LastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonProperty("LastCommDate")
    public String getLastCommDate() {
        return lastCommDate;
    }

    @JsonProperty("LastCommDate")
    public void setLastCommDate(String lastCommDate) {
        this.lastCommDate = lastCommDate;
    }

    @JsonProperty("RevisionNumber")
    public Integer getRevisionNumber() {
        return revisionNumber;
    }

    @JsonProperty("RevisionNumber")
    public void setRevisionNumber(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
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
