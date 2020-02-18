
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
    "VIN",
    "ID",
    "Source",
    "GPS",
    "EncryptedData",
    "Odometer",
    "Fuel",
    "ElectricCharge",
    "OilLife",
    "Transmission",
    "Battery12v",
    "DTC",
    "TirePressure",
    "Acceleration",
    "BrainImmobilizer",
    "DoorsAjar",
    "IgnitionSensor",
    "TrakaSensor",
    "EngineOff"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Telemetry {

    @JsonProperty("VIN")
    private String vIN;
    @JsonProperty("ID")
    private String iD;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("GPS")
    private GPS gPS;
    @JsonProperty("EncryptedData")
    private String encryptedData;
    @JsonProperty("Odometer")
    private Odometer odometer;
    @JsonProperty("Fuel")
    private Fuel fuel;
    @JsonProperty("ElectricCharge")
    private ElectricCharge electricCharge;
    @JsonProperty("OilLife")
    private OilLife oilLife;
    @JsonProperty("Transmission")
    private Transmission transmission;
    @JsonProperty("Battery12v")
    private Battery12v battery12v;
    @JsonProperty("DTC")
    private DTC dTC;
    @JsonProperty("TirePressure")
    private TirePressure tirePressure;
    @JsonProperty("Acceleration")
    private Acceleration acceleration;
    @JsonProperty("BrainImmobilizer")
    private BrainImmobilizer brainImmobilizer;
    @JsonProperty("DoorsAjar")
    private DoorsAjar doorsAjar;
    @JsonProperty("IgnitionSensor")
    private IgnitionSensor ignitionSensor;
    @JsonProperty("TrakaSensor")
    private TrakaSensor trakaSensor;
    @JsonProperty("EngineOff")
    private Boolean engineOff;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("VIN")
    public String getVIN() {
        return vIN;
    }

    @JsonProperty("VIN")
    public void setVIN(String vIN) {
        this.vIN = vIN;
    }

    @JsonProperty("ID")
    public String getID() {
        return iD;
    }

    @JsonProperty("ID")
    public void setID(String iD) {
        this.iD = iD;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("GPS")
    public GPS getGPS() {
        return gPS;
    }

    @JsonProperty("GPS")
    public void setGPS(GPS gPS) {
        this.gPS = gPS;
    }

    @JsonProperty("EncryptedData")
    public String getEncryptedData() {
        return encryptedData;
    }

    @JsonProperty("EncryptedData")
    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    @JsonProperty("Odometer")
    public Odometer getOdometer() {
        return odometer;
    }

    @JsonProperty("Odometer")
    public void setOdometer(Odometer odometer) {
        this.odometer = odometer;
    }

    @JsonProperty("Fuel")
    public Fuel getFuel() {
        return fuel;
    }

    @JsonProperty("Fuel")
    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    @JsonProperty("ElectricCharge")
    public ElectricCharge getElectricCharge() {
        return electricCharge;
    }

    @JsonProperty("ElectricCharge")
    public void setElectricCharge(ElectricCharge electricCharge) {
        this.electricCharge = electricCharge;
    }

    @JsonProperty("OilLife")
    public OilLife getOilLife() {
        return oilLife;
    }

    @JsonProperty("OilLife")
    public void setOilLife(OilLife oilLife) {
        this.oilLife = oilLife;
    }

    @JsonProperty("Transmission")
    public Transmission getTransmission() {
        return transmission;
    }

    @JsonProperty("Transmission")
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @JsonProperty("Battery12v")
    public Battery12v getBattery12v() {
        return battery12v;
    }

    @JsonProperty("Battery12v")
    public void setBattery12v(Battery12v battery12v) {
        this.battery12v = battery12v;
    }

    @JsonProperty("DTC")
    public DTC getDTC() {
        return dTC;
    }

    @JsonProperty("DTC")
    public void setDTC(DTC dTC) {
        this.dTC = dTC;
    }

    @JsonProperty("TirePressure")
    public TirePressure getTirePressure() {
        return tirePressure;
    }

    @JsonProperty("TirePressure")
    public void setTirePressure(TirePressure tirePressure) {
        this.tirePressure = tirePressure;
    }

    @JsonProperty("Acceleration")
    public Acceleration getAcceleration() {
        return acceleration;
    }

    @JsonProperty("Acceleration")
    public void setAcceleration(Acceleration acceleration) {
        this.acceleration = acceleration;
    }

    @JsonProperty("BrainImmobilizer")
    public BrainImmobilizer getBrainImmobilizer() {
        return brainImmobilizer;
    }

    @JsonProperty("BrainImmobilizer")
    public void setBrainImmobilizer(BrainImmobilizer brainImmobilizer) {
        this.brainImmobilizer = brainImmobilizer;
    }

    @JsonProperty("DoorsAjar")
    public DoorsAjar getDoorsAjar() {
        return doorsAjar;
    }

    @JsonProperty("DoorsAjar")
    public void setDoorsAjar(DoorsAjar doorsAjar) {
        this.doorsAjar = doorsAjar;
    }

    @JsonProperty("IgnitionSensor")
    public IgnitionSensor getIgnitionSensor() {
        return ignitionSensor;
    }

    @JsonProperty("IgnitionSensor")
    public void setIgnitionSensor(IgnitionSensor ignitionSensor) {
        this.ignitionSensor = ignitionSensor;
    }

    @JsonProperty("TrakaSensor")
    public TrakaSensor getTrakaSensor() {
        return trakaSensor;
    }

    @JsonProperty("TrakaSensor")
    public void setTrakaSensor(TrakaSensor trakaSensor) {
        this.trakaSensor = trakaSensor;
    }

    @JsonProperty("EngineOff")
    public Boolean getEngineOff() {
        return engineOff;
    }

    @JsonProperty("EngineOff")
    public void setEngineOff(Boolean engineOff) {
        this.engineOff = engineOff;
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
