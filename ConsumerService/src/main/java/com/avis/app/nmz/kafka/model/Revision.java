
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
    "Year",
    "TankCapacity",
    "TankCapacityUnit",
    "EngineType",
    "FuelType"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Revision {

    @JsonProperty("Year")
    private Integer year;
    @JsonProperty("TankCapacity")
    private Double tankCapacity;
    @JsonProperty("TankCapacityUnit")
    private String tankCapacityUnit;
    @JsonProperty("EngineType")
    private String engineType;
    @JsonProperty("FuelType")
    private String fuelType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Year")
    public Integer getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @JsonProperty("TankCapacity")
    public Double getTankCapacity() {
        return tankCapacity;
    }

    @JsonProperty("TankCapacity")
    public void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    @JsonProperty("TankCapacityUnit")
    public String getTankCapacityUnit() {
        return tankCapacityUnit;
    }

    @JsonProperty("TankCapacityUnit")
    public void setTankCapacityUnit(String tankCapacityUnit) {
        this.tankCapacityUnit = tankCapacityUnit;
    }

    @JsonProperty("EngineType")
    public String getEngineType() {
        return engineType;
    }

    @JsonProperty("EngineType")
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @JsonProperty("FuelType")
    public String getFuelType() {
        return fuelType;
    }

    @JsonProperty("FuelType")
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
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
