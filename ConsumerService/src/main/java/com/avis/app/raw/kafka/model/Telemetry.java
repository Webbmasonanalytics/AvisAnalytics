
package com.avis.app.raw.kafka.model;

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
    "driverWindow",
    "estimatedFuelLevel",
    "flTirePressure",
    "frTirePressure",
    "odometer",
    "passengerWindow",
    "rlTirePressure",
    "rlWindow",
    "rrTirePressure",
    "rrWindow",
    "spareTirePressure",
    "sunRoof"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Telemetry {

    @JsonProperty("driverWindow")
    private DriverWindow driverWindow;
    @JsonProperty("estimatedFuelLevel")
    private EstimatedFuelLevel estimatedFuelLevel;
    @JsonProperty("flTirePressure")
    private FlTirePressure flTirePressure;
    @JsonProperty("frTirePressure")
    private FrTirePressure frTirePressure;
    @JsonProperty("odometer")
    private Odometer odometer;
    @JsonProperty("passengerWindow")
    private PassengerWindow passengerWindow;
    @JsonProperty("rlTirePressure")
    private RlTirePressure rlTirePressure;
    @JsonProperty("rlWindow")
    private RlWindow rlWindow;
    @JsonProperty("rrTirePressure")
    private RrTirePressure rrTirePressure;
    @JsonProperty("rrWindow")
    private RrWindow rrWindow;
    @JsonProperty("spareTirePressure")
    private SpareTirePressure spareTirePressure;
    @JsonProperty("sunRoof")
    private SunRoof sunRoof;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("driverWindow")
    public DriverWindow getDriverWindow() {
        return driverWindow;
    }

    @JsonProperty("driverWindow")
    public void setDriverWindow(DriverWindow driverWindow) {
        this.driverWindow = driverWindow;
    }

    @JsonProperty("estimatedFuelLevel")
    public EstimatedFuelLevel getEstimatedFuelLevel() {
        return estimatedFuelLevel;
    }

    @JsonProperty("estimatedFuelLevel")
    public void setEstimatedFuelLevel(EstimatedFuelLevel estimatedFuelLevel) {
        this.estimatedFuelLevel = estimatedFuelLevel;
    }

    @JsonProperty("flTirePressure")
    public FlTirePressure getFlTirePressure() {
        return flTirePressure;
    }

    @JsonProperty("flTirePressure")
    public void setFlTirePressure(FlTirePressure flTirePressure) {
        this.flTirePressure = flTirePressure;
    }

    @JsonProperty("frTirePressure")
    public FrTirePressure getFrTirePressure() {
        return frTirePressure;
    }

    @JsonProperty("frTirePressure")
    public void setFrTirePressure(FrTirePressure frTirePressure) {
        this.frTirePressure = frTirePressure;
    }

    @JsonProperty("odometer")
    public Odometer getOdometer() {
        return odometer;
    }

    @JsonProperty("odometer")
    public void setOdometer(Odometer odometer) {
        this.odometer = odometer;
    }

    @JsonProperty("passengerWindow")
    public PassengerWindow getPassengerWindow() {
        return passengerWindow;
    }

    @JsonProperty("passengerWindow")
    public void setPassengerWindow(PassengerWindow passengerWindow) {
        this.passengerWindow = passengerWindow;
    }

    @JsonProperty("rlTirePressure")
    public RlTirePressure getRlTirePressure() {
        return rlTirePressure;
    }

    @JsonProperty("rlTirePressure")
    public void setRlTirePressure(RlTirePressure rlTirePressure) {
        this.rlTirePressure = rlTirePressure;
    }

    @JsonProperty("rlWindow")
    public RlWindow getRlWindow() {
        return rlWindow;
    }

    @JsonProperty("rlWindow")
    public void setRlWindow(RlWindow rlWindow) {
        this.rlWindow = rlWindow;
    }

    @JsonProperty("rrTirePressure")
    public RrTirePressure getRrTirePressure() {
        return rrTirePressure;
    }

    @JsonProperty("rrTirePressure")
    public void setRrTirePressure(RrTirePressure rrTirePressure) {
        this.rrTirePressure = rrTirePressure;
    }

    @JsonProperty("rrWindow")
    public RrWindow getRrWindow() {
        return rrWindow;
    }

    @JsonProperty("rrWindow")
    public void setRrWindow(RrWindow rrWindow) {
        this.rrWindow = rrWindow;
    }

    @JsonProperty("spareTirePressure")
    public SpareTirePressure getSpareTirePressure() {
        return spareTirePressure;
    }

    @JsonProperty("spareTirePressure")
    public void setSpareTirePressure(SpareTirePressure spareTirePressure) {
        this.spareTirePressure = spareTirePressure;
    }

    @JsonProperty("sunRoof")
    public SunRoof getSunRoof() {
        return sunRoof;
    }

    @JsonProperty("sunRoof")
    public void setSunRoof(SunRoof sunRoof) {
        this.sunRoof = sunRoof;
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
