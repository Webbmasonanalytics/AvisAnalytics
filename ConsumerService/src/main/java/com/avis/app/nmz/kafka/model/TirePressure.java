
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
    "Units",
    "FrontLeft",
    "FrontRight",
    "RearLeft",
    "RearRight",
    "Source"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TirePressure {

    @JsonProperty("Recorded")
    private String recorded;
    @JsonProperty("Units")
    private String units;
    @JsonProperty("FrontLeft")
    private Double frontLeft;
    @JsonProperty("FrontRight")
    private Double frontRight;
    @JsonProperty("RearLeft")
    private Double rearLeft;
    @JsonProperty("RearRight")
    private Double rearRight;
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

    @JsonProperty("Units")
    public String getUnits() {
        return units;
    }

    @JsonProperty("Units")
    public void setUnits(String units) {
        this.units = units;
    }

    @JsonProperty("FrontLeft")
    public Double getFrontLeft() {
        return frontLeft;
    }

    @JsonProperty("FrontLeft")
    public void setFrontLeft(Double frontLeft) {
        this.frontLeft = frontLeft;
    }

    @JsonProperty("FrontRight")
    public Double getFrontRight() {
        return frontRight;
    }

    @JsonProperty("FrontRight")
    public void setFrontRight(Double frontRight) {
        this.frontRight = frontRight;
    }

    @JsonProperty("RearLeft")
    public Double getRearLeft() {
        return rearLeft;
    }

    @JsonProperty("RearLeft")
    public void setRearLeft(Double rearLeft) {
        this.rearLeft = rearLeft;
    }

    @JsonProperty("RearRight")
    public Double getRearRight() {
        return rearRight;
    }

    @JsonProperty("RearRight")
    public void setRearRight(Double rearRight) {
        this.rearRight = rearRight;
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
