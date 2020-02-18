
package com.avis.app.redshift.model;

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
    "Status",
    "VehicleState_FleetFuelCapacityGals",
    "VehicleState_EngineOff",
    "VehicleState_LotState",
    "VehicleState_RentalData_Brand",
    "VehicleState_RentalData_Discount",
    "VehicleState_RentalData_WifiEnabled",
    "VehicleState_RentalData_CheckInDue",
    "VehicleState_RentalData_RentalType",
    "VehicleState_RentalData_MiniLease",
    "VehicleState_RentalData_RANumber",
    "VehicleState_RentalData_Timestamp",
    "VehicleState_GPSCountry",
    "LastUpdate",
    "VendorIds_PID",
    "LastCommDate",
    "MVA",
    "VIN",
    "Telemetry_DoorsAjar_Recorded",
    "Telemetry_DoorsAjar_Value",
    "Telemetry_DoorsAjar_Source",
    "Telemetry_OilLife_Recorded",
    "Telemetry_OilLife_Level",
    "Telemetry_OilLife_Units",
    "Telemetry_OilLife_Source",
    "Telemetry_IgnitionSensor_Recorded",
    "Telemetry_IgnitionSensor_Value",
    "Telemetry_IgnitionSensor_Source",
    "Telemetry_BrainImmobilizer_Recorded",
    "Telemetry_BrainImmobilizer_Value",
    "Telemetry_ElectricCharge_Recorded",
    "Telemetry_ElectricCharge_Level",
    "Telemetry_ElectricCharge_Units",
    "Telemetry_ElectricCharge_Source",
    "Telemetry_Transmission_State",
    "Telemetry_Transmission_Recorded",
    "Telemetry_Transmission_Source",
    "Telemetry_Odometer_Recorded",
    "Telemetry_Odometer_Value",
    "Telemetry_Odometer_Units",
    "Telemetry_Odometer_Source",
    "Telemetry_GPS_Speed_Value",
    "Telemetry_GPS_Speed_Units",
    "Telemetry_GPS_Speed_Source",
    "Telemetry_GPS_Accuracy",
    "Telemetry_GPS_Recorded",
    "Telemetry_GPS_Latitude",
    "Telemetry_GPS_Longitude",
    "Telemetry_GPS_Source",
    "Telemetry_GPS_Altitude",
    "Telemetry_GPS_Bearing",
    "Telemetry_Source",
    "Telemetry_DTC_Description",
    "Telemetry_DTC_Recorded",
    "Telemetry_DTC_Code",
    "Telemetry_DTC_Source",
    "Telemetry_EngineOff",
    "Telemetry_Fuel_Percentage",
    "Telemetry_Fuel_Recorded",
    "Telemetry_Fuel_Level",
    "Telemetry_Fuel_Units",
    "Telemetry_Fuel_Source",
    "Telemetry_Battery12v_Recorded",
    "Telemetry_Battery12v_Voltage",
    "Telemetry_Battery12v_Source",
    "Telemetry_TirePressure_RearRight",
    "Telemetry_TirePressure_FrontRight",
    "Telemetry_TirePressure_Recorded",
    "Telemetry_TirePressure_FrontLeft",
    "Telemetry_TirePressure_RearLeft",
    "Telemetry_TirePressure_Units",
    "Telemetry_TirePressure_Source",
    "Telemetry_VIN",
    "Telemetry_ID",
    "Telemetry_EncryptedData",
    "Telemetry_Acceleration_Recorded",
    "Telemetry_Acceleration_Level",
    "Telemetry_Acceleration_Magnitude",
    "Telemetry_Acceleration_Source",
    "Telemetry_TrakaSensor_Recorded",
    "Telemetry_TrakaSensor_Plugged",
    "Telemetry_TrakaSensor_IDCode",
    "Telemetry_TrakaSensor_Enabled",
    "RevisionNumber",
    "Source",
    "VehicleDetails_Revision_Year",
    "VehicleDetails_Revision_TankCapacityUnit",
    "VehicleDetails_Revision_EngineType",
    "VehicleDetails_Revision_TankCapacity",
    "VehicleDetails_Revision_FuelType",
    "VehicleDetails_Model",
    "VehicleDetails_Make",
    "VehicleDetails_WizardMakeCode"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class NormalizeTelematics {

	//Kafka Metadata
	
	@JsonProperty("TopicName")
	private String topicName;
	@JsonProperty("kafkaTimeStamp")
	private Long kafkaTimeStamp;
	@JsonProperty("offset")
	private Long offset;
	@JsonProperty("partition")
	private Integer partition;
	
    @JsonProperty("Status")
    private String status;
    @JsonProperty("VehicleState_FleetFuelCapacityGals")
    private Double vehicleStateFleetFuelCapacityGals;
    @JsonProperty("VehicleState_EngineOff")
    private Boolean vehicleStateEngineOff;
    @JsonProperty("VehicleState_LotState")
    private String vehicleStateLotState;
    @JsonProperty("VehicleState_RentalData_Brand")
    private String vehicleStateRentalDataBrand;
    @JsonProperty("VehicleState_RentalData_Discount")
    private String vehicleStateRentalDataDiscount;
    @JsonProperty("VehicleState_RentalData_WifiEnabled")
    private Boolean vehicleStateRentalDataWifiEnabled;
    @JsonProperty("VehicleState_RentalData_CheckInDue")
    private String vehicleStateRentalDataCheckInDue;
    @JsonProperty("VehicleState_RentalData_RentalType")
    private String vehicleStateRentalDataRentalType;
    @JsonProperty("VehicleState_RentalData_MiniLease")
    private Boolean vehicleStateRentalDataMiniLease;
    @JsonProperty("VehicleState_RentalData_RANumber")
    private String vehicleStateRentalDataRANumber;
    @JsonProperty("VehicleState_RentalData_Timestamp")
    private String vehicleStateRentalDataTimestamp;
    @JsonProperty("VehicleState_GPSCountry")
    private String vehicleStateGPSCountry;
    @JsonProperty("LastUpdate")
    private String lastUpdate;
    @JsonProperty("VendorIds_PID")
    private String vendorIdsPID;
    @JsonProperty("LastCommDate")
    private String lastCommDate;
    @JsonProperty("MVA")
    private String mVA;
    @JsonProperty("VIN")
    private String vIN;
    @JsonProperty("Telemetry_DoorsAjar_Recorded")
    private String telemetryDoorsAjarRecorded;
    @JsonProperty("Telemetry_DoorsAjar_Value")
    private Boolean telemetryDoorsAjarValue;
    @JsonProperty("Telemetry_DoorsAjar_Source")
    private String telemetryDoorsAjarSource;
    @JsonProperty("Telemetry_OilLife_Recorded")
    private String telemetryOilLifeRecorded;
    @JsonProperty("Telemetry_OilLife_Level")
    private Double telemetryOilLifeLevel;
    @JsonProperty("Telemetry_OilLife_Units")
    private String telemetryOilLifeUnits;
    @JsonProperty("Telemetry_OilLife_Source")
    private String telemetryOilLifeSource;
    @JsonProperty("Telemetry_IgnitionSensor_Recorded")
    private String telemetryIgnitionSensorRecorded;
    @JsonProperty("Telemetry_IgnitionSensor_Value")
    private Boolean telemetryIgnitionSensorValue;
    @JsonProperty("Telemetry_IgnitionSensor_Source")
    private String telemetryIgnitionSensorSource;
    @JsonProperty("Telemetry_BrainImmobilizer_Recorded")
    private String telemetryBrainImmobilizerRecorded;
    @JsonProperty("Telemetry_BrainImmobilizer_Value")
    private Double telemetryBrainImmobilizerValue;
    @JsonProperty("Telemetry_ElectricCharge_Recorded")
    private String telemetryElectricChargeRecorded;
    @JsonProperty("Telemetry_ElectricCharge_Level")
    private Double telemetryElectricChargeLevel;
    @JsonProperty("Telemetry_ElectricCharge_Units")
    private String telemetryElectricChargeUnits;
    @JsonProperty("Telemetry_ElectricCharge_Source")
    private String telemetryElectricChargeSource;
    @JsonProperty("Telemetry_Transmission_State")
    private String telemetryTransmissionState;
    @JsonProperty("Telemetry_Transmission_Recorded")
    private String telemetryTransmissionRecorded;
    @JsonProperty("Telemetry_Transmission_Source")
    private String telemetryTransmissionSource;
    @JsonProperty("Telemetry_Odometer_Recorded")
    private String telemetryOdometerRecorded;
    @JsonProperty("Telemetry_Odometer_Value")
    private Double telemetryOdometerValue;
    @JsonProperty("Telemetry_Odometer_Units")
    private String telemetryOdometerUnits;
    @JsonProperty("Telemetry_Odometer_Source")
    private String telemetryOdometerSource;
    @JsonProperty("Telemetry_GPS_Speed_Value")
    private Double telemetryGPSSpeedValue;
    @JsonProperty("Telemetry_GPS_Speed_Units")
    private String telemetryGPSSpeedUnits;
    @JsonProperty("Telemetry_GPS_Speed_Source")
    private String telemetryGPSSpeedSource;
    @JsonProperty("Telemetry_GPS_Accuracy")
    private Double telemetryGPSAccuracy;
    @JsonProperty("Telemetry_GPS_Recorded")
    private String telemetryGPSRecorded;
    @JsonProperty("Telemetry_GPS_Latitude")
    private Double telemetryGPSLatitude;
    @JsonProperty("Telemetry_GPS_Longitude")
    private Double telemetryGPSLongitude;
    @JsonProperty("Telemetry_GPS_Source")
    private String telemetryGPSSource;
    @JsonProperty("Telemetry_GPS_Altitude")
    private Double telemetryGPSAltitude;
    @JsonProperty("Telemetry_GPS_Bearing")
    private Double telemetryGPSBearing;
    @JsonProperty("Telemetry_Source")
    private String telemetrySource;
    @JsonProperty("Telemetry_DTC_Description")
    private String telemetryDTCDescription;
    @JsonProperty("Telemetry_DTC_Recorded")
    private String telemetryDTCRecorded;
    @JsonProperty("Telemetry_DTC_Code")
    private String telemetryDTCCode;
    @JsonProperty("Telemetry_DTC_Source")
    private String telemetryDTCSource;
    @JsonProperty("Telemetry_EngineOff")
    private Boolean telemetryEngineOff;
    @JsonProperty("Telemetry_Fuel_Percentage")
    private Integer telemetryFuelPercentage;
    @JsonProperty("Telemetry_Fuel_Recorded")
    private String telemetryFuelRecorded;
    @JsonProperty("Telemetry_Fuel_Level")
    private Double telemetryFuelLevel;
    @JsonProperty("Telemetry_Fuel_Units")
    private String telemetryFuelUnits;
    @JsonProperty("Telemetry_Fuel_Source")
    private String telemetryFuelSource;
    @JsonProperty("Telemetry_Battery12v_Recorded")
    private String telemetryBattery12vRecorded;
    @JsonProperty("Telemetry_Battery12v_Voltage")
    private Double telemetryBattery12vVoltage;
    @JsonProperty("Telemetry_Battery12v_Source")
    private String telemetryBattery12vSource;
    @JsonProperty("Telemetry_TirePressure_RearRight")
    private Double telemetryTirePressureRearRight;
    @JsonProperty("Telemetry_TirePressure_FrontRight")
    private Double telemetryTirePressureFrontRight;
    @JsonProperty("Telemetry_TirePressure_Recorded")
    private String telemetryTirePressureRecorded;
    @JsonProperty("Telemetry_TirePressure_FrontLeft")
    private Double telemetryTirePressureFrontLeft;
    @JsonProperty("Telemetry_TirePressure_RearLeft")
    private Double telemetryTirePressureRearLeft;
    @JsonProperty("Telemetry_TirePressure_Units")
    private String telemetryTirePressureUnits;
    @JsonProperty("Telemetry_TirePressure_Source")
    private String telemetryTirePressureSource;
    @JsonProperty("Telemetry_VIN")
    private String telemetryVIN;
    @JsonProperty("Telemetry_ID")
    private String telemetryID;
    @JsonProperty("Telemetry_EncryptedData")
    private String telemetryEncryptedData;
    @JsonProperty("Telemetry_Acceleration_Recorded")
    private String telemetryAccelerationRecorded;
    @JsonProperty("Telemetry_Acceleration_Level")
    private String telemetryAccelerationLevel;
    @JsonProperty("Telemetry_Acceleration_Magnitude")
    private Double telemetryAccelerationMagnitude;
    @JsonProperty("Telemetry_Acceleration_Source")
    private String telemetryAccelerationSource;
    @JsonProperty("Telemetry_TrakaSensor_Recorded")
    private String telemetryTrakaSensorRecorded;
    @JsonProperty("Telemetry_TrakaSensor_Plugged")
    private Boolean telemetryTrakaSensorPlugged;
    @JsonProperty("Telemetry_TrakaSensor_IDCode")
    private String telemetryTrakaSensorIDCode;
    @JsonProperty("Telemetry_TrakaSensor_Enabled")
    private Boolean telemetryTrakaSensorEnabled;
    @JsonProperty("RevisionNumber")
    private Integer revisionNumber;
    @JsonProperty("Source")
    private String source;
    @JsonProperty("VehicleDetails_Revision_Year")
    private Integer vehicleDetailsRevisionYear;
    @JsonProperty("VehicleDetails_Revision_TankCapacityUnit")
    private String vehicleDetailsRevisionTankCapacityUnit;
    @JsonProperty("VehicleDetails_Revision_EngineType")
    private String vehicleDetailsRevisionEngineType;
    @JsonProperty("VehicleDetails_Revision_TankCapacity")
    private Double vehicleDetailsRevisionTankCapacity;
    @JsonProperty("VehicleDetails_Revision_FuelType")
    private String vehicleDetailsRevisionFuelType;
    @JsonProperty("VehicleDetails_Model")
    private String vehicleDetailsModel;
    @JsonProperty("VehicleDetails_Make")
    private String vehicleDetailsMake;
    @JsonProperty("VehicleDetails_WizardMakeCode")
    private String vehicleDetailsWizardMakeCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("VehicleState_FleetFuelCapacityGals")
    public Double getVehicleStateFleetFuelCapacityGals() {
        return vehicleStateFleetFuelCapacityGals;
    }

    @JsonProperty("VehicleState_FleetFuelCapacityGals")
    public void setVehicleStateFleetFuelCapacityGals(Double vehicleStateFleetFuelCapacityGals) {
        this.vehicleStateFleetFuelCapacityGals = vehicleStateFleetFuelCapacityGals;
    }

    @JsonProperty("VehicleState_EngineOff")
    public Boolean getVehicleStateEngineOff() {
        return vehicleStateEngineOff;
    }

    @JsonProperty("VehicleState_EngineOff")
    public void setVehicleStateEngineOff(Boolean vehicleStateEngineOff) {
        this.vehicleStateEngineOff = vehicleStateEngineOff;
    }

    @JsonProperty("VehicleState_LotState")
    public String getVehicleStateLotState() {
        return vehicleStateLotState;
    }

    @JsonProperty("VehicleState_LotState")
    public void setVehicleStateLotState(String vehicleStateLotState) {
        this.vehicleStateLotState = vehicleStateLotState;
    }

    @JsonProperty("VehicleState_RentalData_Brand")
    public String getVehicleStateRentalDataBrand() {
        return vehicleStateRentalDataBrand;
    }

    @JsonProperty("VehicleState_RentalData_Brand")
    public void setVehicleStateRentalDataBrand(String vehicleStateRentalDataBrand) {
        this.vehicleStateRentalDataBrand = vehicleStateRentalDataBrand;
    }

    @JsonProperty("VehicleState_RentalData_Discount")
    public String getVehicleStateRentalDataDiscount() {
        return vehicleStateRentalDataDiscount;
    }

    @JsonProperty("VehicleState_RentalData_Discount")
    public void setVehicleStateRentalDataDiscount(String vehicleStateRentalDataDiscount) {
        this.vehicleStateRentalDataDiscount = vehicleStateRentalDataDiscount;
    }

    @JsonProperty("VehicleState_RentalData_WifiEnabled")
    public Boolean getVehicleStateRentalDataWifiEnabled() {
        return vehicleStateRentalDataWifiEnabled;
    }

    @JsonProperty("VehicleState_RentalData_WifiEnabled")
    public void setVehicleStateRentalDataWifiEnabled(Boolean vehicleStateRentalDataWifiEnabled) {
        this.vehicleStateRentalDataWifiEnabled = vehicleStateRentalDataWifiEnabled;
    }

    @JsonProperty("VehicleState_RentalData_CheckInDue")
    public String getVehicleStateRentalDataCheckInDue() {
        return vehicleStateRentalDataCheckInDue;
    }

    @JsonProperty("VehicleState_RentalData_CheckInDue")
    public void setVehicleStateRentalDataCheckInDue(String vehicleStateRentalDataCheckInDue) {
        this.vehicleStateRentalDataCheckInDue = vehicleStateRentalDataCheckInDue;
    }

    @JsonProperty("VehicleState_RentalData_RentalType")
    public String getVehicleStateRentalDataRentalType() {
        return vehicleStateRentalDataRentalType;
    }

    @JsonProperty("VehicleState_RentalData_RentalType")
    public void setVehicleStateRentalDataRentalType(String vehicleStateRentalDataRentalType) {
        this.vehicleStateRentalDataRentalType = vehicleStateRentalDataRentalType;
    }

    @JsonProperty("VehicleState_RentalData_MiniLease")
    public Boolean getVehicleStateRentalDataMiniLease() {
        return vehicleStateRentalDataMiniLease;
    }

    @JsonProperty("VehicleState_RentalData_MiniLease")
    public void setVehicleStateRentalDataMiniLease(Boolean vehicleStateRentalDataMiniLease) {
        this.vehicleStateRentalDataMiniLease = vehicleStateRentalDataMiniLease;
    }

    @JsonProperty("VehicleState_RentalData_RANumber")
    public String getVehicleStateRentalDataRANumber() {
        return vehicleStateRentalDataRANumber;
    }

    @JsonProperty("VehicleState_RentalData_RANumber")
    public void setVehicleStateRentalDataRANumber(String vehicleStateRentalDataRANumber) {
        this.vehicleStateRentalDataRANumber = vehicleStateRentalDataRANumber;
    }

    @JsonProperty("VehicleState_RentalData_Timestamp")
    public String getVehicleStateRentalDataTimestamp() {
        return vehicleStateRentalDataTimestamp;
    }

    @JsonProperty("VehicleState_RentalData_Timestamp")
    public void setVehicleStateRentalDataTimestamp(String vehicleStateRentalDataTimestamp) {
        this.vehicleStateRentalDataTimestamp = vehicleStateRentalDataTimestamp;
    }

    @JsonProperty("VehicleState_GPSCountry")
    public String getVehicleStateGPSCountry() {
        return vehicleStateGPSCountry;
    }

    @JsonProperty("VehicleState_GPSCountry")
    public void setVehicleStateGPSCountry(String vehicleStateGPSCountry) {
        this.vehicleStateGPSCountry = vehicleStateGPSCountry;
    }

    @JsonProperty("LastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("LastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonProperty("VendorIds_PID")
    public String getVendorIdsPID() {
        return vendorIdsPID;
    }

    @JsonProperty("VendorIds_PID")
    public void setVendorIdsPID(String vendorIdsPID) {
        this.vendorIdsPID = vendorIdsPID;
    }

    @JsonProperty("LastCommDate")
    public String getLastCommDate() {
        return lastCommDate;
    }

    @JsonProperty("LastCommDate")
    public void setLastCommDate(String lastCommDate) {
        this.lastCommDate = lastCommDate;
    }

    @JsonProperty("MVA")
    public String getMVA() {
        return mVA;
    }

    @JsonProperty("MVA")
    public void setMVA(String mVA) {
        this.mVA = mVA;
    }

    @JsonProperty("VIN")
    public String getVIN() {
        return vIN;
    }

    @JsonProperty("VIN")
    public void setVIN(String vIN) {
        this.vIN = vIN;
    }

    @JsonProperty("Telemetry_DoorsAjar_Recorded")
    public String getTelemetryDoorsAjarRecorded() {
        return telemetryDoorsAjarRecorded;
    }

    @JsonProperty("Telemetry_DoorsAjar_Recorded")
    public void setTelemetryDoorsAjarRecorded(String telemetryDoorsAjarRecorded) {
        this.telemetryDoorsAjarRecorded = telemetryDoorsAjarRecorded;
    }

    @JsonProperty("Telemetry_DoorsAjar_Value")
    public Boolean getTelemetryDoorsAjarValue() {
        return telemetryDoorsAjarValue;
    }

    @JsonProperty("Telemetry_DoorsAjar_Value")
    public void setTelemetryDoorsAjarValue(Boolean telemetryDoorsAjarValue) {
        this.telemetryDoorsAjarValue = telemetryDoorsAjarValue;
    }

    @JsonProperty("Telemetry_DoorsAjar_Source")
    public String getTelemetryDoorsAjarSource() {
        return telemetryDoorsAjarSource;
    }

    @JsonProperty("Telemetry_DoorsAjar_Source")
    public void setTelemetryDoorsAjarSource(String telemetryDoorsAjarSource) {
        this.telemetryDoorsAjarSource = telemetryDoorsAjarSource;
    }

    @JsonProperty("Telemetry_OilLife_Recorded")
    public String getTelemetryOilLifeRecorded() {
        return telemetryOilLifeRecorded;
    }

    @JsonProperty("Telemetry_OilLife_Recorded")
    public void setTelemetryOilLifeRecorded(String telemetryOilLifeRecorded) {
        this.telemetryOilLifeRecorded = telemetryOilLifeRecorded;
    }

    @JsonProperty("Telemetry_OilLife_Level")
    public Double getTelemetryOilLifeLevel() {
        return telemetryOilLifeLevel;
    }

    @JsonProperty("Telemetry_OilLife_Level")
    public void setTelemetryOilLifeLevel(Double telemetryOilLifeLevel) {
        this.telemetryOilLifeLevel = telemetryOilLifeLevel;
    }

    @JsonProperty("Telemetry_OilLife_Units")
    public String getTelemetryOilLifeUnits() {
        return telemetryOilLifeUnits;
    }

    @JsonProperty("Telemetry_OilLife_Units")
    public void setTelemetryOilLifeUnits(String telemetryOilLifeUnits) {
        this.telemetryOilLifeUnits = telemetryOilLifeUnits;
    }

    @JsonProperty("Telemetry_OilLife_Source")
    public String getTelemetryOilLifeSource() {
        return telemetryOilLifeSource;
    }

    @JsonProperty("Telemetry_OilLife_Source")
    public void setTelemetryOilLifeSource(String telemetryOilLifeSource) {
        this.telemetryOilLifeSource = telemetryOilLifeSource;
    }

    @JsonProperty("Telemetry_IgnitionSensor_Recorded")
    public String getTelemetryIgnitionSensorRecorded() {
        return telemetryIgnitionSensorRecorded;
    }

    @JsonProperty("Telemetry_IgnitionSensor_Recorded")
    public void setTelemetryIgnitionSensorRecorded(String telemetryIgnitionSensorRecorded) {
        this.telemetryIgnitionSensorRecorded = telemetryIgnitionSensorRecorded;
    }

    @JsonProperty("Telemetry_IgnitionSensor_Value")
    public Boolean getTelemetryIgnitionSensorValue() {
        return telemetryIgnitionSensorValue;
    }

    @JsonProperty("Telemetry_IgnitionSensor_Value")
    public void setTelemetryIgnitionSensorValue(Boolean telemetryIgnitionSensorValue) {
        this.telemetryIgnitionSensorValue = telemetryIgnitionSensorValue;
    }

    @JsonProperty("Telemetry_IgnitionSensor_Source")
    public String getTelemetryIgnitionSensorSource() {
        return telemetryIgnitionSensorSource;
    }

    @JsonProperty("Telemetry_IgnitionSensor_Source")
    public void setTelemetryIgnitionSensorSource(String telemetryIgnitionSensorSource) {
        this.telemetryIgnitionSensorSource = telemetryIgnitionSensorSource;
    }

    @JsonProperty("Telemetry_BrainImmobilizer_Recorded")
    public String getTelemetryBrainImmobilizerRecorded() {
        return telemetryBrainImmobilizerRecorded;
    }

    @JsonProperty("Telemetry_BrainImmobilizer_Recorded")
    public void setTelemetryBrainImmobilizerRecorded(String telemetryBrainImmobilizerRecorded) {
        this.telemetryBrainImmobilizerRecorded = telemetryBrainImmobilizerRecorded;
    }

    @JsonProperty("Telemetry_BrainImmobilizer_Value")
    public Double getTelemetryBrainImmobilizerValue() {
        return telemetryBrainImmobilizerValue;
    }

    @JsonProperty("Telemetry_BrainImmobilizer_Value")
    public void setTelemetryBrainImmobilizerValue(Double telemetryBrainImmobilizerValue) {
        this.telemetryBrainImmobilizerValue = telemetryBrainImmobilizerValue;
    }

    @JsonProperty("Telemetry_ElectricCharge_Recorded")
    public String getTelemetryElectricChargeRecorded() {
        return telemetryElectricChargeRecorded;
    }

    @JsonProperty("Telemetry_ElectricCharge_Recorded")
    public void setTelemetryElectricChargeRecorded(String telemetryElectricChargeRecorded) {
        this.telemetryElectricChargeRecorded = telemetryElectricChargeRecorded;
    }

    @JsonProperty("Telemetry_ElectricCharge_Level")
    public Double getTelemetryElectricChargeLevel() {
        return telemetryElectricChargeLevel;
    }

    @JsonProperty("Telemetry_ElectricCharge_Level")
    public void setTelemetryElectricChargeLevel(Double telemetryElectricChargeLevel) {
        this.telemetryElectricChargeLevel = telemetryElectricChargeLevel;
    }

    @JsonProperty("Telemetry_ElectricCharge_Units")
    public String getTelemetryElectricChargeUnits() {
        return telemetryElectricChargeUnits;
    }

    @JsonProperty("Telemetry_ElectricCharge_Units")
    public void setTelemetryElectricChargeUnits(String telemetryElectricChargeUnits) {
        this.telemetryElectricChargeUnits = telemetryElectricChargeUnits;
    }

    @JsonProperty("Telemetry_ElectricCharge_Source")
    public String getTelemetryElectricChargeSource() {
        return telemetryElectricChargeSource;
    }

    @JsonProperty("Telemetry_ElectricCharge_Source")
    public void setTelemetryElectricChargeSource(String telemetryElectricChargeSource) {
        this.telemetryElectricChargeSource = telemetryElectricChargeSource;
    }

    @JsonProperty("Telemetry_Transmission_State")
    public String getTelemetryTransmissionState() {
        return telemetryTransmissionState;
    }

    @JsonProperty("Telemetry_Transmission_State")
    public void setTelemetryTransmissionState(String telemetryTransmissionState) {
        this.telemetryTransmissionState = telemetryTransmissionState;
    }

    @JsonProperty("Telemetry_Transmission_Recorded")
    public String getTelemetryTransmissionRecorded() {
        return telemetryTransmissionRecorded;
    }

    @JsonProperty("Telemetry_Transmission_Recorded")
    public void setTelemetryTransmissionRecorded(String telemetryTransmissionRecorded) {
        this.telemetryTransmissionRecorded = telemetryTransmissionRecorded;
    }

    @JsonProperty("Telemetry_Transmission_Source")
    public String getTelemetryTransmissionSource() {
        return telemetryTransmissionSource;
    }

    @JsonProperty("Telemetry_Transmission_Source")
    public void setTelemetryTransmissionSource(String telemetryTransmissionSource) {
        this.telemetryTransmissionSource = telemetryTransmissionSource;
    }

    @JsonProperty("Telemetry_Odometer_Recorded")
    public String getTelemetryOdometerRecorded() {
        return telemetryOdometerRecorded;
    }

    @JsonProperty("Telemetry_Odometer_Recorded")
    public void setTelemetryOdometerRecorded(String telemetryOdometerRecorded) {
        this.telemetryOdometerRecorded = telemetryOdometerRecorded;
    }

    @JsonProperty("Telemetry_Odometer_Value")
    public Double getTelemetryOdometerValue() {
        return telemetryOdometerValue;
    }

    @JsonProperty("Telemetry_Odometer_Value")
    public void setTelemetryOdometerValue(Double telemetryOdometerValue) {
        this.telemetryOdometerValue = telemetryOdometerValue;
    }

    @JsonProperty("Telemetry_Odometer_Units")
    public String getTelemetryOdometerUnits() {
        return telemetryOdometerUnits;
    }

    @JsonProperty("Telemetry_Odometer_Units")
    public void setTelemetryOdometerUnits(String telemetryOdometerUnits) {
        this.telemetryOdometerUnits = telemetryOdometerUnits;
    }

    @JsonProperty("Telemetry_Odometer_Source")
    public String getTelemetryOdometerSource() {
        return telemetryOdometerSource;
    }

    @JsonProperty("Telemetry_Odometer_Source")
    public void setTelemetryOdometerSource(String telemetryOdometerSource) {
        this.telemetryOdometerSource = telemetryOdometerSource;
    }

    @JsonProperty("Telemetry_GPS_Speed_Value")
    public Double getTelemetryGPSSpeedValue() {
        return telemetryGPSSpeedValue;
    }

    @JsonProperty("Telemetry_GPS_Speed_Value")
    public void setTelemetryGPSSpeedValue(Double telemetryGPSSpeedValue) {
        this.telemetryGPSSpeedValue = telemetryGPSSpeedValue;
    }

    @JsonProperty("Telemetry_GPS_Speed_Units")
    public String getTelemetryGPSSpeedUnits() {
        return telemetryGPSSpeedUnits;
    }

    @JsonProperty("Telemetry_GPS_Speed_Units")
    public void setTelemetryGPSSpeedUnits(String telemetryGPSSpeedUnits) {
        this.telemetryGPSSpeedUnits = telemetryGPSSpeedUnits;
    }

    @JsonProperty("Telemetry_GPS_Speed_Source")
    public String getTelemetryGPSSpeedSource() {
        return telemetryGPSSpeedSource;
    }

    @JsonProperty("Telemetry_GPS_Speed_Source")
    public void setTelemetryGPSSpeedSource(String telemetryGPSSpeedSource) {
        this.telemetryGPSSpeedSource = telemetryGPSSpeedSource;
    }

    @JsonProperty("Telemetry_GPS_Accuracy")
    public Double getTelemetryGPSAccuracy() {
        return telemetryGPSAccuracy;
    }

    @JsonProperty("Telemetry_GPS_Accuracy")
    public void setTelemetryGPSAccuracy(Double telemetryGPSAccuracy) {
        this.telemetryGPSAccuracy = telemetryGPSAccuracy;
    }

    @JsonProperty("Telemetry_GPS_Recorded")
    public String getTelemetryGPSRecorded() {
        return telemetryGPSRecorded;
    }

    @JsonProperty("Telemetry_GPS_Recorded")
    public void setTelemetryGPSRecorded(String telemetryGPSRecorded) {
        this.telemetryGPSRecorded = telemetryGPSRecorded;
    }

    @JsonProperty("Telemetry_GPS_Latitude")
    public Double getTelemetryGPSLatitude() {
        return telemetryGPSLatitude;
    }

    @JsonProperty("Telemetry_GPS_Latitude")
    public void setTelemetryGPSLatitude(Double telemetryGPSLatitude) {
        this.telemetryGPSLatitude = telemetryGPSLatitude;
    }

    @JsonProperty("Telemetry_GPS_Longitude")
    public Double getTelemetryGPSLongitude() {
        return telemetryGPSLongitude;
    }

    @JsonProperty("Telemetry_GPS_Longitude")
    public void setTelemetryGPSLongitude(Double telemetryGPSLongitude) {
        this.telemetryGPSLongitude = telemetryGPSLongitude;
    }

    @JsonProperty("Telemetry_GPS_Source")
    public String getTelemetryGPSSource() {
        return telemetryGPSSource;
    }

    @JsonProperty("Telemetry_GPS_Source")
    public void setTelemetryGPSSource(String telemetryGPSSource) {
        this.telemetryGPSSource = telemetryGPSSource;
    }

    @JsonProperty("Telemetry_GPS_Altitude")
    public Double getTelemetryGPSAltitude() {
        return telemetryGPSAltitude;
    }

    @JsonProperty("Telemetry_GPS_Altitude")
    public void setTelemetryGPSAltitude(Double telemetryGPSAltitude) {
        this.telemetryGPSAltitude = telemetryGPSAltitude;
    }

    @JsonProperty("Telemetry_GPS_Bearing")
    public Double getTelemetryGPSBearing() {
        return telemetryGPSBearing;
    }

    @JsonProperty("Telemetry_GPS_Bearing")
    public void setTelemetryGPSBearing(Double telemetryGPSBearing) {
        this.telemetryGPSBearing = telemetryGPSBearing;
    }

    @JsonProperty("Telemetry_Source")
    public String getTelemetrySource() {
        return telemetrySource;
    }

    @JsonProperty("Telemetry_Source")
    public void setTelemetrySource(String telemetrySource) {
        this.telemetrySource = telemetrySource;
    }

    @JsonProperty("Telemetry_DTC_Description")
    public String getTelemetryDTCDescription() {
        return telemetryDTCDescription;
    }

    @JsonProperty("Telemetry_DTC_Description")
    public void setTelemetryDTCDescription(String telemetryDTCDescription) {
        this.telemetryDTCDescription = telemetryDTCDescription;
    }

    @JsonProperty("Telemetry_DTC_Recorded")
    public String getTelemetryDTCRecorded() {
        return telemetryDTCRecorded;
    }

    @JsonProperty("Telemetry_DTC_Recorded")
    public void setTelemetryDTCRecorded(String telemetryDTCRecorded) {
        this.telemetryDTCRecorded = telemetryDTCRecorded;
    }

    @JsonProperty("Telemetry_DTC_Code")
    public String getTelemetryDTCCode() {
        return telemetryDTCCode;
    }

    @JsonProperty("Telemetry_DTC_Code")
    public void setTelemetryDTCCode(String telemetryDTCCode) {
        this.telemetryDTCCode = telemetryDTCCode;
    }

    @JsonProperty("Telemetry_DTC_Source")
    public String getTelemetryDTCSource() {
        return telemetryDTCSource;
    }

    @JsonProperty("Telemetry_DTC_Source")
    public void setTelemetryDTCSource(String telemetryDTCSource) {
        this.telemetryDTCSource = telemetryDTCSource;
    }

    @JsonProperty("Telemetry_EngineOff")
    public Boolean getTelemetryEngineOff() {
        return telemetryEngineOff;
    }

    @JsonProperty("Telemetry_EngineOff")
    public void setTelemetryEngineOff(Boolean telemetryEngineOff) {
        this.telemetryEngineOff = telemetryEngineOff;
    }

    @JsonProperty("Telemetry_Fuel_Percentage")
    public Integer getTelemetryFuelPercentage() {
        return telemetryFuelPercentage;
    }

    @JsonProperty("Telemetry_Fuel_Percentage")
    public void setTelemetryFuelPercentage(Integer telemetryFuelPercentage) {
        this.telemetryFuelPercentage = telemetryFuelPercentage;
    }

    @JsonProperty("Telemetry_Fuel_Recorded")
    public String getTelemetryFuelRecorded() {
        return telemetryFuelRecorded;
    }

    @JsonProperty("Telemetry_Fuel_Recorded")
    public void setTelemetryFuelRecorded(String telemetryFuelRecorded) {
        this.telemetryFuelRecorded = telemetryFuelRecorded;
    }

    @JsonProperty("Telemetry_Fuel_Level")
    public Double getTelemetryFuelLevel() {
        return telemetryFuelLevel;
    }

    @JsonProperty("Telemetry_Fuel_Level")
    public void setTelemetryFuelLevel(Double telemetryFuelLevel) {
        this.telemetryFuelLevel = telemetryFuelLevel;
    }

    @JsonProperty("Telemetry_Fuel_Units")
    public String getTelemetryFuelUnits() {
        return telemetryFuelUnits;
    }

    @JsonProperty("Telemetry_Fuel_Units")
    public void setTelemetryFuelUnits(String telemetryFuelUnits) {
        this.telemetryFuelUnits = telemetryFuelUnits;
    }

    @JsonProperty("Telemetry_Fuel_Source")
    public String getTelemetryFuelSource() {
        return telemetryFuelSource;
    }

    @JsonProperty("Telemetry_Fuel_Source")
    public void setTelemetryFuelSource(String telemetryFuelSource) {
        this.telemetryFuelSource = telemetryFuelSource;
    }

    @JsonProperty("Telemetry_Battery12v_Recorded")
    public String getTelemetryBattery12vRecorded() {
        return telemetryBattery12vRecorded;
    }

    @JsonProperty("Telemetry_Battery12v_Recorded")
    public void setTelemetryBattery12vRecorded(String telemetryBattery12vRecorded) {
        this.telemetryBattery12vRecorded = telemetryBattery12vRecorded;
    }

    @JsonProperty("Telemetry_Battery12v_Voltage")
    public Double getTelemetryBattery12vVoltage() {
        return telemetryBattery12vVoltage;
    }

    @JsonProperty("Telemetry_Battery12v_Voltage")
    public void setTelemetryBattery12vVoltage(Double telemetryBattery12vVoltage) {
        this.telemetryBattery12vVoltage = telemetryBattery12vVoltage;
    }

    @JsonProperty("Telemetry_Battery12v_Source")
    public String getTelemetryBattery12vSource() {
        return telemetryBattery12vSource;
    }

    @JsonProperty("Telemetry_Battery12v_Source")
    public void setTelemetryBattery12vSource(String telemetryBattery12vSource) {
        this.telemetryBattery12vSource = telemetryBattery12vSource;
    }

    @JsonProperty("Telemetry_TirePressure_RearRight")
    public Double getTelemetryTirePressureRearRight() {
        return telemetryTirePressureRearRight;
    }

    @JsonProperty("Telemetry_TirePressure_RearRight")
    public void setTelemetryTirePressureRearRight(Double telemetryTirePressureRearRight) {
        this.telemetryTirePressureRearRight = telemetryTirePressureRearRight;
    }

    @JsonProperty("Telemetry_TirePressure_FrontRight")
    public Double getTelemetryTirePressureFrontRight() {
        return telemetryTirePressureFrontRight;
    }

    @JsonProperty("Telemetry_TirePressure_FrontRight")
    public void setTelemetryTirePressureFrontRight(Double telemetryTirePressureFrontRight) {
        this.telemetryTirePressureFrontRight = telemetryTirePressureFrontRight;
    }

    @JsonProperty("Telemetry_TirePressure_Recorded")
    public String getTelemetryTirePressureRecorded() {
        return telemetryTirePressureRecorded;
    }

    @JsonProperty("Telemetry_TirePressure_Recorded")
    public void setTelemetryTirePressureRecorded(String telemetryTirePressureRecorded) {
        this.telemetryTirePressureRecorded = telemetryTirePressureRecorded;
    }

    @JsonProperty("Telemetry_TirePressure_FrontLeft")
    public Double getTelemetryTirePressureFrontLeft() {
        return telemetryTirePressureFrontLeft;
    }

    @JsonProperty("Telemetry_TirePressure_FrontLeft")
    public void setTelemetryTirePressureFrontLeft(Double telemetryTirePressureFrontLeft) {
        this.telemetryTirePressureFrontLeft = telemetryTirePressureFrontLeft;
    }

    @JsonProperty("Telemetry_TirePressure_RearLeft")
    public Double getTelemetryTirePressureRearLeft() {
        return telemetryTirePressureRearLeft;
    }

    @JsonProperty("Telemetry_TirePressure_RearLeft")
    public void setTelemetryTirePressureRearLeft(Double telemetryTirePressureRearLeft) {
        this.telemetryTirePressureRearLeft = telemetryTirePressureRearLeft;
    }

    @JsonProperty("Telemetry_TirePressure_Units")
    public String getTelemetryTirePressureUnits() {
        return telemetryTirePressureUnits;
    }

    @JsonProperty("Telemetry_TirePressure_Units")
    public void setTelemetryTirePressureUnits(String telemetryTirePressureUnits) {
        this.telemetryTirePressureUnits = telemetryTirePressureUnits;
    }

    @JsonProperty("Telemetry_TirePressure_Source")
    public String getTelemetryTirePressureSource() {
        return telemetryTirePressureSource;
    }

    @JsonProperty("Telemetry_TirePressure_Source")
    public void setTelemetryTirePressureSource(String telemetryTirePressureSource) {
        this.telemetryTirePressureSource = telemetryTirePressureSource;
    }

    @JsonProperty("Telemetry_VIN")
    public String getTelemetryVIN() {
        return telemetryVIN;
    }

    @JsonProperty("Telemetry_VIN")
    public void setTelemetryVIN(String telemetryVIN) {
        this.telemetryVIN = telemetryVIN;
    }

    @JsonProperty("Telemetry_ID")
    public String getTelemetryID() {
        return telemetryID;
    }

    @JsonProperty("Telemetry_ID")
    public void setTelemetryID(String telemetryID) {
        this.telemetryID = telemetryID;
    }

    @JsonProperty("Telemetry_EncryptedData")
    public String getTelemetryEncryptedData() {
        return telemetryEncryptedData;
    }

    @JsonProperty("Telemetry_EncryptedData")
    public void setTelemetryEncryptedData(String telemetryEncryptedData) {
        this.telemetryEncryptedData = telemetryEncryptedData;
    }

    @JsonProperty("Telemetry_Acceleration_Recorded")
    public String getTelemetryAccelerationRecorded() {
        return telemetryAccelerationRecorded;
    }

    @JsonProperty("Telemetry_Acceleration_Recorded")
    public void setTelemetryAccelerationRecorded(String telemetryAccelerationRecorded) {
        this.telemetryAccelerationRecorded = telemetryAccelerationRecorded;
    }

    @JsonProperty("Telemetry_Acceleration_Level")
    public String getTelemetryAccelerationLevel() {
        return telemetryAccelerationLevel;
    }

    @JsonProperty("Telemetry_Acceleration_Level")
    public void setTelemetryAccelerationLevel(String telemetryAccelerationLevel) {
        this.telemetryAccelerationLevel = telemetryAccelerationLevel;
    }

    @JsonProperty("Telemetry_Acceleration_Magnitude")
    public Double getTelemetryAccelerationMagnitude() {
        return telemetryAccelerationMagnitude;
    }

    @JsonProperty("Telemetry_Acceleration_Magnitude")
    public void setTelemetryAccelerationMagnitude(Double telemetryAccelerationMagnitude) {
        this.telemetryAccelerationMagnitude = telemetryAccelerationMagnitude;
    }

    @JsonProperty("Telemetry_Acceleration_Source")
    public String getTelemetryAccelerationSource() {
        return telemetryAccelerationSource;
    }

    @JsonProperty("Telemetry_Acceleration_Source")
    public void setTelemetryAccelerationSource(String telemetryAccelerationSource) {
        this.telemetryAccelerationSource = telemetryAccelerationSource;
    }

    @JsonProperty("Telemetry_TrakaSensor_Recorded")
    public String getTelemetryTrakaSensorRecorded() {
        return telemetryTrakaSensorRecorded;
    }

    @JsonProperty("Telemetry_TrakaSensor_Recorded")
    public void setTelemetryTrakaSensorRecorded(String telemetryTrakaSensorRecorded) {
        this.telemetryTrakaSensorRecorded = telemetryTrakaSensorRecorded;
    }

    @JsonProperty("Telemetry_TrakaSensor_Plugged")
    public Boolean getTelemetryTrakaSensorPlugged() {
        return telemetryTrakaSensorPlugged;
    }

    @JsonProperty("Telemetry_TrakaSensor_Plugged")
    public void setTelemetryTrakaSensorPlugged(Boolean telemetryTrakaSensorPlugged) {
        this.telemetryTrakaSensorPlugged = telemetryTrakaSensorPlugged;
    }

    @JsonProperty("Telemetry_TrakaSensor_IDCode")
    public String getTelemetryTrakaSensorIDCode() {
        return telemetryTrakaSensorIDCode;
    }

    @JsonProperty("Telemetry_TrakaSensor_IDCode")
    public void setTelemetryTrakaSensorIDCode(String telemetryTrakaSensorIDCode) {
        this.telemetryTrakaSensorIDCode = telemetryTrakaSensorIDCode;
    }

    @JsonProperty("Telemetry_TrakaSensor_Enabled")
    public Boolean getTelemetryTrakaSensorEnabled() {
        return telemetryTrakaSensorEnabled;
    }

    @JsonProperty("Telemetry_TrakaSensor_Enabled")
    public void setTelemetryTrakaSensorEnabled(Boolean telemetryTrakaSensorEnabled) {
        this.telemetryTrakaSensorEnabled = telemetryTrakaSensorEnabled;
    }

    @JsonProperty("RevisionNumber")
    public Integer getRevisionNumber() {
        return revisionNumber;
    }

    @JsonProperty("RevisionNumber")
    public void setRevisionNumber(Integer revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    @JsonProperty("Source")
    public String getSource() {
        return source;
    }

    @JsonProperty("Source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("VehicleDetails_Revision_Year")
    public Integer getVehicleDetailsRevisionYear() {
        return vehicleDetailsRevisionYear;
    }

    @JsonProperty("VehicleDetails_Revision_Year")
    public void setVehicleDetailsRevisionYear(Integer vehicleDetailsRevisionYear) {
        this.vehicleDetailsRevisionYear = vehicleDetailsRevisionYear;
    }

    @JsonProperty("VehicleDetails_Revision_TankCapacityUnit")
    public String getVehicleDetailsRevisionTankCapacityUnit() {
        return vehicleDetailsRevisionTankCapacityUnit;
    }

    @JsonProperty("VehicleDetails_Revision_TankCapacityUnit")
    public void setVehicleDetailsRevisionTankCapacityUnit(String vehicleDetailsRevisionTankCapacityUnit) {
        this.vehicleDetailsRevisionTankCapacityUnit = vehicleDetailsRevisionTankCapacityUnit;
    }

    @JsonProperty("VehicleDetails_Revision_EngineType")
    public String getVehicleDetailsRevisionEngineType() {
        return vehicleDetailsRevisionEngineType;
    }

    @JsonProperty("VehicleDetails_Revision_EngineType")
    public void setVehicleDetailsRevisionEngineType(String vehicleDetailsRevisionEngineType) {
        this.vehicleDetailsRevisionEngineType = vehicleDetailsRevisionEngineType;
    }

    @JsonProperty("VehicleDetails_Revision_TankCapacity")
    public Double getVehicleDetailsRevisionTankCapacity() {
        return vehicleDetailsRevisionTankCapacity;
    }

    @JsonProperty("VehicleDetails_Revision_TankCapacity")
    public void setVehicleDetailsRevisionTankCapacity(Double vehicleDetailsRevisionTankCapacity) {
        this.vehicleDetailsRevisionTankCapacity = vehicleDetailsRevisionTankCapacity;
    }

    @JsonProperty("VehicleDetails_Revision_FuelType")
    public String getVehicleDetailsRevisionFuelType() {
        return vehicleDetailsRevisionFuelType;
    }

    @JsonProperty("VehicleDetails_Revision_FuelType")
    public void setVehicleDetailsRevisionFuelType(String vehicleDetailsRevisionFuelType) {
        this.vehicleDetailsRevisionFuelType = vehicleDetailsRevisionFuelType;
    }

    @JsonProperty("VehicleDetails_Model")
    public String getVehicleDetailsModel() {
        return vehicleDetailsModel;
    }

    @JsonProperty("VehicleDetails_Model")
    public void setVehicleDetailsModel(String vehicleDetailsModel) {
        this.vehicleDetailsModel = vehicleDetailsModel;
    }

    @JsonProperty("VehicleDetails_Make")
    public String getVehicleDetailsMake() {
        return vehicleDetailsMake;
    }

    @JsonProperty("VehicleDetails_Make")
    public void setVehicleDetailsMake(String vehicleDetailsMake) {
        this.vehicleDetailsMake = vehicleDetailsMake;
    }

    @JsonProperty("VehicleDetails_WizardMakeCode")
    public String getVehicleDetailsWizardMakeCode() {
        return vehicleDetailsWizardMakeCode;
    }

    @JsonProperty("VehicleDetails_WizardMakeCode")
    public void setVehicleDetailsWizardMakeCode(String vehicleDetailsWizardMakeCode) {
        this.vehicleDetailsWizardMakeCode = vehicleDetailsWizardMakeCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @JsonProperty("TopicName")
	public String getTopicName() {
		return topicName;
	}

    @JsonProperty("TopicName")
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

    @JsonProperty("KafkaTimeStamp")
	public Long getKafkaTimeStamp() {
		return kafkaTimeStamp;
	}

    @JsonProperty("KafkaTimeStamp")
	public void setKafkaTimeStamp(Long kafkaTimeStamp) {
		this.kafkaTimeStamp = kafkaTimeStamp;
	}
    
    @JsonProperty("Offset")
	public Long getOffset() {
		return offset;
	}

    @JsonProperty("Offset")
	public void setOffset(Long offset) {
		this.offset = offset;
	}

    @JsonProperty("Partition")
	public Integer getPartition() {
		return partition;
	}

    @JsonProperty("Partition")
	public void setPartition(Integer partition) {
		this.partition = partition;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kafkaTimeStamp == null) ? 0 : kafkaTimeStamp.hashCode());
		result = prime * result + ((lastCommDate == null) ? 0 : lastCommDate.hashCode());
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((mVA == null) ? 0 : mVA.hashCode());
		result = prime * result + ((offset == null) ? 0 : offset.hashCode());
		result = prime * result + ((partition == null) ? 0 : partition.hashCode());
		result = prime * result + ((revisionNumber == null) ? 0 : revisionNumber.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telemetryAccelerationLevel == null) ? 0 : telemetryAccelerationLevel.hashCode());
		result = prime * result
				+ ((telemetryAccelerationMagnitude == null) ? 0 : telemetryAccelerationMagnitude.hashCode());
		result = prime * result
				+ ((telemetryAccelerationRecorded == null) ? 0 : telemetryAccelerationRecorded.hashCode());
		result = prime * result + ((telemetryAccelerationSource == null) ? 0 : telemetryAccelerationSource.hashCode());
		result = prime * result + ((telemetryBattery12vRecorded == null) ? 0 : telemetryBattery12vRecorded.hashCode());
		result = prime * result + ((telemetryBattery12vSource == null) ? 0 : telemetryBattery12vSource.hashCode());
		result = prime * result + ((telemetryBattery12vVoltage == null) ? 0 : telemetryBattery12vVoltage.hashCode());
		result = prime * result
				+ ((telemetryBrainImmobilizerRecorded == null) ? 0 : telemetryBrainImmobilizerRecorded.hashCode());
		result = prime * result
				+ ((telemetryBrainImmobilizerValue == null) ? 0 : telemetryBrainImmobilizerValue.hashCode());
		result = prime * result + ((telemetryDTCCode == null) ? 0 : telemetryDTCCode.hashCode());
		result = prime * result + ((telemetryDTCDescription == null) ? 0 : telemetryDTCDescription.hashCode());
		result = prime * result + ((telemetryDTCRecorded == null) ? 0 : telemetryDTCRecorded.hashCode());
		result = prime * result + ((telemetryDTCSource == null) ? 0 : telemetryDTCSource.hashCode());
		result = prime * result + ((telemetryDoorsAjarRecorded == null) ? 0 : telemetryDoorsAjarRecorded.hashCode());
		result = prime * result + ((telemetryDoorsAjarSource == null) ? 0 : telemetryDoorsAjarSource.hashCode());
		result = prime * result + ((telemetryDoorsAjarValue == null) ? 0 : telemetryDoorsAjarValue.hashCode());
		result = prime * result
				+ ((telemetryElectricChargeLevel == null) ? 0 : telemetryElectricChargeLevel.hashCode());
		result = prime * result
				+ ((telemetryElectricChargeRecorded == null) ? 0 : telemetryElectricChargeRecorded.hashCode());
		result = prime * result
				+ ((telemetryElectricChargeSource == null) ? 0 : telemetryElectricChargeSource.hashCode());
		result = prime * result
				+ ((telemetryElectricChargeUnits == null) ? 0 : telemetryElectricChargeUnits.hashCode());
		result = prime * result + ((telemetryEncryptedData == null) ? 0 : telemetryEncryptedData.hashCode());
		result = prime * result + ((telemetryEngineOff == null) ? 0 : telemetryEngineOff.hashCode());
		result = prime * result + ((telemetryFuelLevel == null) ? 0 : telemetryFuelLevel.hashCode());
		result = prime * result + ((telemetryFuelPercentage == null) ? 0 : telemetryFuelPercentage.hashCode());
		result = prime * result + ((telemetryFuelRecorded == null) ? 0 : telemetryFuelRecorded.hashCode());
		result = prime * result + ((telemetryFuelSource == null) ? 0 : telemetryFuelSource.hashCode());
		result = prime * result + ((telemetryFuelUnits == null) ? 0 : telemetryFuelUnits.hashCode());
		result = prime * result + ((telemetryGPSAccuracy == null) ? 0 : telemetryGPSAccuracy.hashCode());
		result = prime * result + ((telemetryGPSAltitude == null) ? 0 : telemetryGPSAltitude.hashCode());
		result = prime * result + ((telemetryGPSBearing == null) ? 0 : telemetryGPSBearing.hashCode());
		result = prime * result + ((telemetryGPSLatitude == null) ? 0 : telemetryGPSLatitude.hashCode());
		result = prime * result + ((telemetryGPSLongitude == null) ? 0 : telemetryGPSLongitude.hashCode());
		result = prime * result + ((telemetryGPSRecorded == null) ? 0 : telemetryGPSRecorded.hashCode());
		result = prime * result + ((telemetryGPSSource == null) ? 0 : telemetryGPSSource.hashCode());
		result = prime * result + ((telemetryGPSSpeedSource == null) ? 0 : telemetryGPSSpeedSource.hashCode());
		result = prime * result + ((telemetryGPSSpeedUnits == null) ? 0 : telemetryGPSSpeedUnits.hashCode());
		result = prime * result + ((telemetryGPSSpeedValue == null) ? 0 : telemetryGPSSpeedValue.hashCode());
		result = prime * result + ((telemetryID == null) ? 0 : telemetryID.hashCode());
		result = prime * result
				+ ((telemetryIgnitionSensorRecorded == null) ? 0 : telemetryIgnitionSensorRecorded.hashCode());
		result = prime * result
				+ ((telemetryIgnitionSensorSource == null) ? 0 : telemetryIgnitionSensorSource.hashCode());
		result = prime * result
				+ ((telemetryIgnitionSensorValue == null) ? 0 : telemetryIgnitionSensorValue.hashCode());
		result = prime * result + ((telemetryOdometerRecorded == null) ? 0 : telemetryOdometerRecorded.hashCode());
		result = prime * result + ((telemetryOdometerSource == null) ? 0 : telemetryOdometerSource.hashCode());
		result = prime * result + ((telemetryOdometerUnits == null) ? 0 : telemetryOdometerUnits.hashCode());
		result = prime * result + ((telemetryOdometerValue == null) ? 0 : telemetryOdometerValue.hashCode());
		result = prime * result + ((telemetryOilLifeLevel == null) ? 0 : telemetryOilLifeLevel.hashCode());
		result = prime * result + ((telemetryOilLifeRecorded == null) ? 0 : telemetryOilLifeRecorded.hashCode());
		result = prime * result + ((telemetryOilLifeSource == null) ? 0 : telemetryOilLifeSource.hashCode());
		result = prime * result + ((telemetryOilLifeUnits == null) ? 0 : telemetryOilLifeUnits.hashCode());
		result = prime * result + ((telemetrySource == null) ? 0 : telemetrySource.hashCode());
		result = prime * result
				+ ((telemetryTirePressureFrontLeft == null) ? 0 : telemetryTirePressureFrontLeft.hashCode());
		result = prime * result
				+ ((telemetryTirePressureFrontRight == null) ? 0 : telemetryTirePressureFrontRight.hashCode());
		result = prime * result
				+ ((telemetryTirePressureRearLeft == null) ? 0 : telemetryTirePressureRearLeft.hashCode());
		result = prime * result
				+ ((telemetryTirePressureRearRight == null) ? 0 : telemetryTirePressureRearRight.hashCode());
		result = prime * result
				+ ((telemetryTirePressureRecorded == null) ? 0 : telemetryTirePressureRecorded.hashCode());
		result = prime * result + ((telemetryTirePressureSource == null) ? 0 : telemetryTirePressureSource.hashCode());
		result = prime * result + ((telemetryTirePressureUnits == null) ? 0 : telemetryTirePressureUnits.hashCode());
		result = prime * result + ((telemetryTrakaSensorEnabled == null) ? 0 : telemetryTrakaSensorEnabled.hashCode());
		result = prime * result + ((telemetryTrakaSensorIDCode == null) ? 0 : telemetryTrakaSensorIDCode.hashCode());
		result = prime * result + ((telemetryTrakaSensorPlugged == null) ? 0 : telemetryTrakaSensorPlugged.hashCode());
		result = prime * result
				+ ((telemetryTrakaSensorRecorded == null) ? 0 : telemetryTrakaSensorRecorded.hashCode());
		result = prime * result
				+ ((telemetryTransmissionRecorded == null) ? 0 : telemetryTransmissionRecorded.hashCode());
		result = prime * result + ((telemetryTransmissionSource == null) ? 0 : telemetryTransmissionSource.hashCode());
		result = prime * result + ((telemetryTransmissionState == null) ? 0 : telemetryTransmissionState.hashCode());
		result = prime * result + ((telemetryVIN == null) ? 0 : telemetryVIN.hashCode());
		result = prime * result + ((topicName == null) ? 0 : topicName.hashCode());
		result = prime * result + ((vIN == null) ? 0 : vIN.hashCode());
		result = prime * result + ((vehicleDetailsMake == null) ? 0 : vehicleDetailsMake.hashCode());
		result = prime * result + ((vehicleDetailsModel == null) ? 0 : vehicleDetailsModel.hashCode());
		result = prime * result
				+ ((vehicleDetailsRevisionEngineType == null) ? 0 : vehicleDetailsRevisionEngineType.hashCode());
		result = prime * result
				+ ((vehicleDetailsRevisionFuelType == null) ? 0 : vehicleDetailsRevisionFuelType.hashCode());
		result = prime * result
				+ ((vehicleDetailsRevisionTankCapacity == null) ? 0 : vehicleDetailsRevisionTankCapacity.hashCode());
		result = prime * result + ((vehicleDetailsRevisionTankCapacityUnit == null) ? 0
				: vehicleDetailsRevisionTankCapacityUnit.hashCode());
		result = prime * result + ((vehicleDetailsRevisionYear == null) ? 0 : vehicleDetailsRevisionYear.hashCode());
		result = prime * result
				+ ((vehicleDetailsWizardMakeCode == null) ? 0 : vehicleDetailsWizardMakeCode.hashCode());
		result = prime * result + ((vehicleStateEngineOff == null) ? 0 : vehicleStateEngineOff.hashCode());
		result = prime * result
				+ ((vehicleStateFleetFuelCapacityGals == null) ? 0 : vehicleStateFleetFuelCapacityGals.hashCode());
		result = prime * result + ((vehicleStateGPSCountry == null) ? 0 : vehicleStateGPSCountry.hashCode());
		result = prime * result + ((vehicleStateLotState == null) ? 0 : vehicleStateLotState.hashCode());
		result = prime * result + ((vehicleStateRentalDataBrand == null) ? 0 : vehicleStateRentalDataBrand.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataCheckInDue == null) ? 0 : vehicleStateRentalDataCheckInDue.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataDiscount == null) ? 0 : vehicleStateRentalDataDiscount.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataMiniLease == null) ? 0 : vehicleStateRentalDataMiniLease.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataRANumber == null) ? 0 : vehicleStateRentalDataRANumber.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataRentalType == null) ? 0 : vehicleStateRentalDataRentalType.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataTimestamp == null) ? 0 : vehicleStateRentalDataTimestamp.hashCode());
		result = prime * result
				+ ((vehicleStateRentalDataWifiEnabled == null) ? 0 : vehicleStateRentalDataWifiEnabled.hashCode());
		result = prime * result + ((vendorIdsPID == null) ? 0 : vendorIdsPID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NormalizeTelematics other = (NormalizeTelematics) obj;
		if (kafkaTimeStamp == null) {
			if (other.kafkaTimeStamp != null)
				return false;
		} else if (!kafkaTimeStamp.equals(other.kafkaTimeStamp))
			return false;
		if (lastCommDate == null) {
			if (other.lastCommDate != null)
				return false;
		} else if (!lastCommDate.equals(other.lastCommDate))
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (mVA == null) {
			if (other.mVA != null)
				return false;
		} else if (!mVA.equals(other.mVA))
			return false;
		if (offset == null) {
			if (other.offset != null)
				return false;
		} else if (!offset.equals(other.offset))
			return false;
		if (partition == null) {
			if (other.partition != null)
				return false;
		} else if (!partition.equals(other.partition))
			return false;
		if (revisionNumber == null) {
			if (other.revisionNumber != null)
				return false;
		} else if (!revisionNumber.equals(other.revisionNumber))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telemetryAccelerationLevel == null) {
			if (other.telemetryAccelerationLevel != null)
				return false;
		} else if (!telemetryAccelerationLevel.equals(other.telemetryAccelerationLevel))
			return false;
		if (telemetryAccelerationMagnitude == null) {
			if (other.telemetryAccelerationMagnitude != null)
				return false;
		} else if (!telemetryAccelerationMagnitude.equals(other.telemetryAccelerationMagnitude))
			return false;
		if (telemetryAccelerationRecorded == null) {
			if (other.telemetryAccelerationRecorded != null)
				return false;
		} else if (!telemetryAccelerationRecorded.equals(other.telemetryAccelerationRecorded))
			return false;
		if (telemetryAccelerationSource == null) {
			if (other.telemetryAccelerationSource != null)
				return false;
		} else if (!telemetryAccelerationSource.equals(other.telemetryAccelerationSource))
			return false;
		if (telemetryBattery12vRecorded == null) {
			if (other.telemetryBattery12vRecorded != null)
				return false;
		} else if (!telemetryBattery12vRecorded.equals(other.telemetryBattery12vRecorded))
			return false;
		if (telemetryBattery12vSource == null) {
			if (other.telemetryBattery12vSource != null)
				return false;
		} else if (!telemetryBattery12vSource.equals(other.telemetryBattery12vSource))
			return false;
		if (telemetryBattery12vVoltage == null) {
			if (other.telemetryBattery12vVoltage != null)
				return false;
		} else if (!telemetryBattery12vVoltage.equals(other.telemetryBattery12vVoltage))
			return false;
		if (telemetryBrainImmobilizerRecorded == null) {
			if (other.telemetryBrainImmobilizerRecorded != null)
				return false;
		} else if (!telemetryBrainImmobilizerRecorded.equals(other.telemetryBrainImmobilizerRecorded))
			return false;
		if (telemetryBrainImmobilizerValue == null) {
			if (other.telemetryBrainImmobilizerValue != null)
				return false;
		} else if (!telemetryBrainImmobilizerValue.equals(other.telemetryBrainImmobilizerValue))
			return false;
		if (telemetryDTCCode == null) {
			if (other.telemetryDTCCode != null)
				return false;
		} else if (!telemetryDTCCode.equals(other.telemetryDTCCode))
			return false;
		if (telemetryDTCDescription == null) {
			if (other.telemetryDTCDescription != null)
				return false;
		} else if (!telemetryDTCDescription.equals(other.telemetryDTCDescription))
			return false;
		if (telemetryDTCRecorded == null) {
			if (other.telemetryDTCRecorded != null)
				return false;
		} else if (!telemetryDTCRecorded.equals(other.telemetryDTCRecorded))
			return false;
		if (telemetryDTCSource == null) {
			if (other.telemetryDTCSource != null)
				return false;
		} else if (!telemetryDTCSource.equals(other.telemetryDTCSource))
			return false;
		if (telemetryDoorsAjarRecorded == null) {
			if (other.telemetryDoorsAjarRecorded != null)
				return false;
		} else if (!telemetryDoorsAjarRecorded.equals(other.telemetryDoorsAjarRecorded))
			return false;
		if (telemetryDoorsAjarSource == null) {
			if (other.telemetryDoorsAjarSource != null)
				return false;
		} else if (!telemetryDoorsAjarSource.equals(other.telemetryDoorsAjarSource))
			return false;
		if (telemetryDoorsAjarValue == null) {
			if (other.telemetryDoorsAjarValue != null)
				return false;
		} else if (!telemetryDoorsAjarValue.equals(other.telemetryDoorsAjarValue))
			return false;
		if (telemetryElectricChargeLevel == null) {
			if (other.telemetryElectricChargeLevel != null)
				return false;
		} else if (!telemetryElectricChargeLevel.equals(other.telemetryElectricChargeLevel))
			return false;
		if (telemetryElectricChargeRecorded == null) {
			if (other.telemetryElectricChargeRecorded != null)
				return false;
		} else if (!telemetryElectricChargeRecorded.equals(other.telemetryElectricChargeRecorded))
			return false;
		if (telemetryElectricChargeSource == null) {
			if (other.telemetryElectricChargeSource != null)
				return false;
		} else if (!telemetryElectricChargeSource.equals(other.telemetryElectricChargeSource))
			return false;
		if (telemetryElectricChargeUnits == null) {
			if (other.telemetryElectricChargeUnits != null)
				return false;
		} else if (!telemetryElectricChargeUnits.equals(other.telemetryElectricChargeUnits))
			return false;
		if (telemetryEncryptedData == null) {
			if (other.telemetryEncryptedData != null)
				return false;
		} else if (!telemetryEncryptedData.equals(other.telemetryEncryptedData))
			return false;
		if (telemetryEngineOff == null) {
			if (other.telemetryEngineOff != null)
				return false;
		} else if (!telemetryEngineOff.equals(other.telemetryEngineOff))
			return false;
		if (telemetryFuelLevel == null) {
			if (other.telemetryFuelLevel != null)
				return false;
		} else if (!telemetryFuelLevel.equals(other.telemetryFuelLevel))
			return false;
		if (telemetryFuelPercentage == null) {
			if (other.telemetryFuelPercentage != null)
				return false;
		} else if (!telemetryFuelPercentage.equals(other.telemetryFuelPercentage))
			return false;
		if (telemetryFuelRecorded == null) {
			if (other.telemetryFuelRecorded != null)
				return false;
		} else if (!telemetryFuelRecorded.equals(other.telemetryFuelRecorded))
			return false;
		if (telemetryFuelSource == null) {
			if (other.telemetryFuelSource != null)
				return false;
		} else if (!telemetryFuelSource.equals(other.telemetryFuelSource))
			return false;
		if (telemetryFuelUnits == null) {
			if (other.telemetryFuelUnits != null)
				return false;
		} else if (!telemetryFuelUnits.equals(other.telemetryFuelUnits))
			return false;
		if (telemetryGPSAccuracy == null) {
			if (other.telemetryGPSAccuracy != null)
				return false;
		} else if (!telemetryGPSAccuracy.equals(other.telemetryGPSAccuracy))
			return false;
		if (telemetryGPSAltitude == null) {
			if (other.telemetryGPSAltitude != null)
				return false;
		} else if (!telemetryGPSAltitude.equals(other.telemetryGPSAltitude))
			return false;
		if (telemetryGPSBearing == null) {
			if (other.telemetryGPSBearing != null)
				return false;
		} else if (!telemetryGPSBearing.equals(other.telemetryGPSBearing))
			return false;
		if (telemetryGPSLatitude == null) {
			if (other.telemetryGPSLatitude != null)
				return false;
		} else if (!telemetryGPSLatitude.equals(other.telemetryGPSLatitude))
			return false;
		if (telemetryGPSLongitude == null) {
			if (other.telemetryGPSLongitude != null)
				return false;
		} else if (!telemetryGPSLongitude.equals(other.telemetryGPSLongitude))
			return false;
		if (telemetryGPSRecorded == null) {
			if (other.telemetryGPSRecorded != null)
				return false;
		} else if (!telemetryGPSRecorded.equals(other.telemetryGPSRecorded))
			return false;
		if (telemetryGPSSource == null) {
			if (other.telemetryGPSSource != null)
				return false;
		} else if (!telemetryGPSSource.equals(other.telemetryGPSSource))
			return false;
		if (telemetryGPSSpeedSource == null) {
			if (other.telemetryGPSSpeedSource != null)
				return false;
		} else if (!telemetryGPSSpeedSource.equals(other.telemetryGPSSpeedSource))
			return false;
		if (telemetryGPSSpeedUnits == null) {
			if (other.telemetryGPSSpeedUnits != null)
				return false;
		} else if (!telemetryGPSSpeedUnits.equals(other.telemetryGPSSpeedUnits))
			return false;
		if (telemetryGPSSpeedValue == null) {
			if (other.telemetryGPSSpeedValue != null)
				return false;
		} else if (!telemetryGPSSpeedValue.equals(other.telemetryGPSSpeedValue))
			return false;
		if (telemetryID == null) {
			if (other.telemetryID != null)
				return false;
		} else if (!telemetryID.equals(other.telemetryID))
			return false;
		if (telemetryIgnitionSensorRecorded == null) {
			if (other.telemetryIgnitionSensorRecorded != null)
				return false;
		} else if (!telemetryIgnitionSensorRecorded.equals(other.telemetryIgnitionSensorRecorded))
			return false;
		if (telemetryIgnitionSensorSource == null) {
			if (other.telemetryIgnitionSensorSource != null)
				return false;
		} else if (!telemetryIgnitionSensorSource.equals(other.telemetryIgnitionSensorSource))
			return false;
		if (telemetryIgnitionSensorValue == null) {
			if (other.telemetryIgnitionSensorValue != null)
				return false;
		} else if (!telemetryIgnitionSensorValue.equals(other.telemetryIgnitionSensorValue))
			return false;
		if (telemetryOdometerRecorded == null) {
			if (other.telemetryOdometerRecorded != null)
				return false;
		} else if (!telemetryOdometerRecorded.equals(other.telemetryOdometerRecorded))
			return false;
		if (telemetryOdometerSource == null) {
			if (other.telemetryOdometerSource != null)
				return false;
		} else if (!telemetryOdometerSource.equals(other.telemetryOdometerSource))
			return false;
		if (telemetryOdometerUnits == null) {
			if (other.telemetryOdometerUnits != null)
				return false;
		} else if (!telemetryOdometerUnits.equals(other.telemetryOdometerUnits))
			return false;
		if (telemetryOdometerValue == null) {
			if (other.telemetryOdometerValue != null)
				return false;
		} else if (!telemetryOdometerValue.equals(other.telemetryOdometerValue))
			return false;
		if (telemetryOilLifeLevel == null) {
			if (other.telemetryOilLifeLevel != null)
				return false;
		} else if (!telemetryOilLifeLevel.equals(other.telemetryOilLifeLevel))
			return false;
		if (telemetryOilLifeRecorded == null) {
			if (other.telemetryOilLifeRecorded != null)
				return false;
		} else if (!telemetryOilLifeRecorded.equals(other.telemetryOilLifeRecorded))
			return false;
		if (telemetryOilLifeSource == null) {
			if (other.telemetryOilLifeSource != null)
				return false;
		} else if (!telemetryOilLifeSource.equals(other.telemetryOilLifeSource))
			return false;
		if (telemetryOilLifeUnits == null) {
			if (other.telemetryOilLifeUnits != null)
				return false;
		} else if (!telemetryOilLifeUnits.equals(other.telemetryOilLifeUnits))
			return false;
		if (telemetrySource == null) {
			if (other.telemetrySource != null)
				return false;
		} else if (!telemetrySource.equals(other.telemetrySource))
			return false;
		if (telemetryTirePressureFrontLeft == null) {
			if (other.telemetryTirePressureFrontLeft != null)
				return false;
		} else if (!telemetryTirePressureFrontLeft.equals(other.telemetryTirePressureFrontLeft))
			return false;
		if (telemetryTirePressureFrontRight == null) {
			if (other.telemetryTirePressureFrontRight != null)
				return false;
		} else if (!telemetryTirePressureFrontRight.equals(other.telemetryTirePressureFrontRight))
			return false;
		if (telemetryTirePressureRearLeft == null) {
			if (other.telemetryTirePressureRearLeft != null)
				return false;
		} else if (!telemetryTirePressureRearLeft.equals(other.telemetryTirePressureRearLeft))
			return false;
		if (telemetryTirePressureRearRight == null) {
			if (other.telemetryTirePressureRearRight != null)
				return false;
		} else if (!telemetryTirePressureRearRight.equals(other.telemetryTirePressureRearRight))
			return false;
		if (telemetryTirePressureRecorded == null) {
			if (other.telemetryTirePressureRecorded != null)
				return false;
		} else if (!telemetryTirePressureRecorded.equals(other.telemetryTirePressureRecorded))
			return false;
		if (telemetryTirePressureSource == null) {
			if (other.telemetryTirePressureSource != null)
				return false;
		} else if (!telemetryTirePressureSource.equals(other.telemetryTirePressureSource))
			return false;
		if (telemetryTirePressureUnits == null) {
			if (other.telemetryTirePressureUnits != null)
				return false;
		} else if (!telemetryTirePressureUnits.equals(other.telemetryTirePressureUnits))
			return false;
		if (telemetryTrakaSensorEnabled == null) {
			if (other.telemetryTrakaSensorEnabled != null)
				return false;
		} else if (!telemetryTrakaSensorEnabled.equals(other.telemetryTrakaSensorEnabled))
			return false;
		if (telemetryTrakaSensorIDCode == null) {
			if (other.telemetryTrakaSensorIDCode != null)
				return false;
		} else if (!telemetryTrakaSensorIDCode.equals(other.telemetryTrakaSensorIDCode))
			return false;
		if (telemetryTrakaSensorPlugged == null) {
			if (other.telemetryTrakaSensorPlugged != null)
				return false;
		} else if (!telemetryTrakaSensorPlugged.equals(other.telemetryTrakaSensorPlugged))
			return false;
		if (telemetryTrakaSensorRecorded == null) {
			if (other.telemetryTrakaSensorRecorded != null)
				return false;
		} else if (!telemetryTrakaSensorRecorded.equals(other.telemetryTrakaSensorRecorded))
			return false;
		if (telemetryTransmissionRecorded == null) {
			if (other.telemetryTransmissionRecorded != null)
				return false;
		} else if (!telemetryTransmissionRecorded.equals(other.telemetryTransmissionRecorded))
			return false;
		if (telemetryTransmissionSource == null) {
			if (other.telemetryTransmissionSource != null)
				return false;
		} else if (!telemetryTransmissionSource.equals(other.telemetryTransmissionSource))
			return false;
		if (telemetryTransmissionState == null) {
			if (other.telemetryTransmissionState != null)
				return false;
		} else if (!telemetryTransmissionState.equals(other.telemetryTransmissionState))
			return false;
		if (telemetryVIN == null) {
			if (other.telemetryVIN != null)
				return false;
		} else if (!telemetryVIN.equals(other.telemetryVIN))
			return false;
		if (topicName == null) {
			if (other.topicName != null)
				return false;
		} else if (!topicName.equals(other.topicName))
			return false;
		if (vIN == null) {
			if (other.vIN != null)
				return false;
		} else if (!vIN.equals(other.vIN))
			return false;
		if (vehicleDetailsMake == null) {
			if (other.vehicleDetailsMake != null)
				return false;
		} else if (!vehicleDetailsMake.equals(other.vehicleDetailsMake))
			return false;
		if (vehicleDetailsModel == null) {
			if (other.vehicleDetailsModel != null)
				return false;
		} else if (!vehicleDetailsModel.equals(other.vehicleDetailsModel))
			return false;
		if (vehicleDetailsRevisionEngineType == null) {
			if (other.vehicleDetailsRevisionEngineType != null)
				return false;
		} else if (!vehicleDetailsRevisionEngineType.equals(other.vehicleDetailsRevisionEngineType))
			return false;
		if (vehicleDetailsRevisionFuelType == null) {
			if (other.vehicleDetailsRevisionFuelType != null)
				return false;
		} else if (!vehicleDetailsRevisionFuelType.equals(other.vehicleDetailsRevisionFuelType))
			return false;
		if (vehicleDetailsRevisionTankCapacity == null) {
			if (other.vehicleDetailsRevisionTankCapacity != null)
				return false;
		} else if (!vehicleDetailsRevisionTankCapacity.equals(other.vehicleDetailsRevisionTankCapacity))
			return false;
		if (vehicleDetailsRevisionTankCapacityUnit == null) {
			if (other.vehicleDetailsRevisionTankCapacityUnit != null)
				return false;
		} else if (!vehicleDetailsRevisionTankCapacityUnit.equals(other.vehicleDetailsRevisionTankCapacityUnit))
			return false;
		if (vehicleDetailsRevisionYear == null) {
			if (other.vehicleDetailsRevisionYear != null)
				return false;
		} else if (!vehicleDetailsRevisionYear.equals(other.vehicleDetailsRevisionYear))
			return false;
		if (vehicleDetailsWizardMakeCode == null) {
			if (other.vehicleDetailsWizardMakeCode != null)
				return false;
		} else if (!vehicleDetailsWizardMakeCode.equals(other.vehicleDetailsWizardMakeCode))
			return false;
		if (vehicleStateEngineOff == null) {
			if (other.vehicleStateEngineOff != null)
				return false;
		} else if (!vehicleStateEngineOff.equals(other.vehicleStateEngineOff))
			return false;
		if (vehicleStateFleetFuelCapacityGals == null) {
			if (other.vehicleStateFleetFuelCapacityGals != null)
				return false;
		} else if (!vehicleStateFleetFuelCapacityGals.equals(other.vehicleStateFleetFuelCapacityGals))
			return false;
		if (vehicleStateGPSCountry == null) {
			if (other.vehicleStateGPSCountry != null)
				return false;
		} else if (!vehicleStateGPSCountry.equals(other.vehicleStateGPSCountry))
			return false;
		if (vehicleStateLotState == null) {
			if (other.vehicleStateLotState != null)
				return false;
		} else if (!vehicleStateLotState.equals(other.vehicleStateLotState))
			return false;
		if (vehicleStateRentalDataBrand == null) {
			if (other.vehicleStateRentalDataBrand != null)
				return false;
		} else if (!vehicleStateRentalDataBrand.equals(other.vehicleStateRentalDataBrand))
			return false;
		if (vehicleStateRentalDataCheckInDue == null) {
			if (other.vehicleStateRentalDataCheckInDue != null)
				return false;
		} else if (!vehicleStateRentalDataCheckInDue.equals(other.vehicleStateRentalDataCheckInDue))
			return false;
		if (vehicleStateRentalDataDiscount == null) {
			if (other.vehicleStateRentalDataDiscount != null)
				return false;
		} else if (!vehicleStateRentalDataDiscount.equals(other.vehicleStateRentalDataDiscount))
			return false;
		if (vehicleStateRentalDataMiniLease == null) {
			if (other.vehicleStateRentalDataMiniLease != null)
				return false;
		} else if (!vehicleStateRentalDataMiniLease.equals(other.vehicleStateRentalDataMiniLease))
			return false;
		if (vehicleStateRentalDataRANumber == null) {
			if (other.vehicleStateRentalDataRANumber != null)
				return false;
		} else if (!vehicleStateRentalDataRANumber.equals(other.vehicleStateRentalDataRANumber))
			return false;
		if (vehicleStateRentalDataRentalType == null) {
			if (other.vehicleStateRentalDataRentalType != null)
				return false;
		} else if (!vehicleStateRentalDataRentalType.equals(other.vehicleStateRentalDataRentalType))
			return false;
		if (vehicleStateRentalDataTimestamp == null) {
			if (other.vehicleStateRentalDataTimestamp != null)
				return false;
		} else if (!vehicleStateRentalDataTimestamp.equals(other.vehicleStateRentalDataTimestamp))
			return false;
		if (vehicleStateRentalDataWifiEnabled == null) {
			if (other.vehicleStateRentalDataWifiEnabled != null)
				return false;
		} else if (!vehicleStateRentalDataWifiEnabled.equals(other.vehicleStateRentalDataWifiEnabled))
			return false;
		if (vendorIdsPID == null) {
			if (other.vendorIdsPID != null)
				return false;
		} else if (!vendorIdsPID.equals(other.vendorIdsPID))
			return false;
		return true;
	}
}

