
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
    "Recorded",
    "Voltage",
    "Source"
})
public class Battery12v {

    @JsonProperty("Recorded")
    private String recorded;
    @JsonProperty("Voltage")
    private Double voltage;
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

    @JsonProperty("Voltage")
    public Double getVoltage() {
        return voltage;
    }

    @JsonProperty("Voltage")
    public void setVoltage(Double voltage) {
        this.voltage = voltage;
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
