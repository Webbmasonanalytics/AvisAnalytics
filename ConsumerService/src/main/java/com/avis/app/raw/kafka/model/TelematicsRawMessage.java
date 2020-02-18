
package com.avis.app.raw.kafka.model;

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
    "correlationId",
    "fuelLevel",
    "lastTimestamp",
    "location",
    "telemetry",
    "vehicleName",
    "vin"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelematicsRawMessage implements DataObject{

    @JsonProperty("correlationId")
    private String correlationId;
    @JsonProperty("fuelLevel")
    private FuelLevel fuelLevel;
    @JsonProperty("lastTimestamp")
    private String lastTimestamp;
    @JsonProperty("location")
    private Location location;
    @JsonProperty("telemetry")
    private Telemetry telemetry;
    @JsonProperty("vehicleName")
    private String vehicleName;
    @JsonProperty("vin")
    private String vin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("correlationId")
    public String getCorrelationId() {
        return correlationId;
    }

    @JsonProperty("correlationId")
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    @JsonProperty("fuelLevel")
    public FuelLevel getFuelLevel() {
        return fuelLevel;
    }

    @JsonProperty("fuelLevel")
    public void setFuelLevel(FuelLevel fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @JsonProperty("lastTimestamp")
    public String getLastTimestamp() {
        return lastTimestamp;
    }

    @JsonProperty("lastTimestamp")
    public void setLastTimestamp(String lastTimestamp) {
        this.lastTimestamp = lastTimestamp;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("telemetry")
    public Telemetry getTelemetry() {
        return telemetry;
    }

    @JsonProperty("telemetry")
    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    @JsonProperty("vehicleName")
    public String getVehicleName() {
        return vehicleName;
    }

    @JsonProperty("vehicleName")
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @JsonProperty("vin")
    public String getVin() {
        return vin;
    }

    @JsonProperty("vin")
    public void setVin(String vin) {
        this.vin = vin;
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
