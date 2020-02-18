
package com.avis.app.nmz.kafka.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "GPSCountry",
    "EngineOff",
    "LotState",
    "FleetFuelCapacityGals",
    "RentalData"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleState {

    @JsonProperty("GPSCountry")
    private String gPSCountry;
    @JsonProperty("EngineOff")
    private Boolean engineOff;
    @JsonProperty("LotState")
    private String lotState;
    @JsonProperty("FleetFuelCapacityGals")
    private Double fleetFuelCapacityGals;
    @JsonProperty("RentalData")
    private RentalData rentalData;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("GPSCountry")
    public String getGPSCountry() {
        return gPSCountry;
    }

    @JsonProperty("GPSCountry")
    public void setGPSCountry(String gPSCountry) {
        this.gPSCountry = gPSCountry;
    }

    @JsonProperty("EngineOff")
    public Boolean getEngineOff() {
        return engineOff;
    }

    @JsonProperty("EngineOff")
    public void setEngineOff(Boolean engineOff) {
        this.engineOff = engineOff;
    }

    @JsonProperty("LotState")
    public String getLotState() {
        return lotState;
    }

    @JsonProperty("LotState")
    public void setLotState(String lotState) {
        this.lotState = lotState;
    }

    @JsonProperty("FleetFuelCapacityGals")
    public Double getFleetFuelCapacityGals() {
        return fleetFuelCapacityGals;
    }

    @JsonProperty("FleetFuelCapacityGals")
    public void setFleetFuelCapacityGals(Double fleetFuelCapacityGals) {
        this.fleetFuelCapacityGals = fleetFuelCapacityGals;
    }

    @JsonProperty("RentalData")
    public RentalData getRentalData() {
        return rentalData;
    }

    @JsonProperty("RentalData")
    public void setRentalData(RentalData rentalData) {
        this.rentalData = rentalData;
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
