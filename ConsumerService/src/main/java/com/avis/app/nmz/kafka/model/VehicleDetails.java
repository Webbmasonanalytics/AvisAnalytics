
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
    "Revision",
    "Model",
    "Make",
    "WizardMakeCode"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleDetails {

    @JsonProperty("Revision")
    private Revision revision;
    @JsonProperty("Model")
    private String model;
    @JsonProperty("Make")
    private String make;
    @JsonProperty("WizardMakeCode")
    private String wizardMakeCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Revision")
    public Revision getRevision() {
        return revision;
    }

    @JsonProperty("Revision")
    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    @JsonProperty("Model")
    public String getModel() {
        return model;
    }

    @JsonProperty("Model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("Make")
    public String getMake() {
        return make;
    }

    @JsonProperty("Make")
    public void setMake(String make) {
        this.make = make;
    }

    @JsonProperty("WizardMakeCode")
    public String getWizardMakeCode() {
        return wizardMakeCode;
    }

    @JsonProperty("WizardMakeCode")
    public void setWizardMakeCode(String wizardMakeCode) {
        this.wizardMakeCode = wizardMakeCode;
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
