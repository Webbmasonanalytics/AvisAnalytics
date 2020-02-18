
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
    "Enabled",
    "Plugged",
    "IDCode"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrakaSensor {

    @JsonProperty("Recorded")
    private String recorded;
    @JsonProperty("Enabled")
    private Boolean enabled;
    @JsonProperty("Plugged")
    private Boolean plugged;
    @JsonProperty("IDCode")
    private String iDCode;
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

    @JsonProperty("Enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("Enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("Plugged")
    public Boolean getPlugged() {
        return plugged;
    }

    @JsonProperty("Plugged")
    public void setPlugged(Boolean plugged) {
        this.plugged = plugged;
    }

    @JsonProperty("IDCode")
    public String getIDCode() {
        return iDCode;
    }

    @JsonProperty("IDCode")
    public void setIDCode(String iDCode) {
        this.iDCode = iDCode;
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
