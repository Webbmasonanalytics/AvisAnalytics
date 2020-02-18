
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
    "Recorded",
    "Latitude",
    "Longitude",
    "Altitude",
    "Accuracy",
    "Speed",
    "Bearing",
    "Source"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class GPS {

    @JsonProperty("Recorded")
    private String recorded;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("Altitude")
    private Double altitude;
    @JsonProperty("Accuracy")
    private Double accuracy;
    @JsonProperty("Speed")
    private Speed speed;
    @JsonProperty("Bearing")
    private Double bearing;
    @JsonProperty("Source")
    private String source;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Recorded")
    public String getRecorded() {
        return recorded;
    }

    @JsonProperty("Recorded")
    public void setRecorded(String recorded) {
        this.recorded = recorded;
    }

    @JsonProperty("Latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("Altitude")
    public Double getAltitude() {
        return altitude;
    }

    @JsonProperty("Altitude")
    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    @JsonProperty("Accuracy")
    public Double getAccuracy() {
        return accuracy;
    }

    @JsonProperty("Accuracy")
    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @JsonProperty("Speed")
    public Speed getSpeed() {
        return speed;
    }

    @JsonProperty("Speed")
    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    @JsonProperty("Bearing")
    public Double getBearing() {
        return bearing;
    }

    @JsonProperty("Bearing")
    public void setBearing(Double bearing) {
        this.bearing = bearing;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
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
