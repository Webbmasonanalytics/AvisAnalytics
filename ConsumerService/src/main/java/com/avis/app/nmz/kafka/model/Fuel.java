
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
    "Level",
    "Percentage",
    "Units",
    "Source"
})
public class Fuel {

    @JsonProperty("Recorded")
    private String recorded;
    @JsonProperty("Level")
    private Double level;
    @JsonProperty("Percentage")
    private Integer percentage;
    @JsonProperty("Units")
    private String units;
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

    @JsonProperty("Level")
    public Double getLevel() {
        return level;
    }

    @JsonProperty("Level")
    public void setLevel(Double level) {
        this.level = level;
    }

    @JsonProperty("Percentage")
    public Integer getPercentage() {
        return percentage;
    }

    @JsonProperty("Percentage")
    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @JsonProperty("Units")
    public String getUnits() {
        return units;
    }

    @JsonProperty("Units")
    public void setUnits(String units) {
        this.units = units;
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
