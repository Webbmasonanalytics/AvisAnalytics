package com.avis.app.redshift.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author Sainagaraju Vaduka
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RawTelemtryToyota implements Serializable {
	
	private static final long serialVersionUID = 90067605705809281L;
	private int partition;
	private long offset;
	private long timestamp;
	private String topicName;
	private double location_coordinates_1;
	private String vehicleName;
	private double telemetry_driverWindow_value;
	private double telemetry_rrWindow_value;
	private String telemetry_rlTirePressure_unit;
	private String telemetry_odometer_unit;
	private String telemetry_frTirePressure_unit;
	private double telemetry_rrTirePressure_value;
	private String telemetry_spareTirePressure_unit;
	private String telemetry_flTirePressure_unit;
	private String telemetry_rrTirePressure_unit;
	private String correlationId;
	private String vin;
	private double location_coordinates_0;
	private double telemetry_estimatedFuelLevel_value;
	private double telemetry_frTirePressure_value;
	private double telemetry_odometer_value;
	private String location_type;
	private double telemetry_passengerWindow_value;
	private double telemetry_spareTirePressure_value;
	private double telemetry_rlTirePressure_value;
	private String lastTimestamp;
	private double fuelLevel_value;
	private double telemetry_rlWindow_value;
	private double telemetry_flTirePressure_value;
	private double telemetry_sunRoof_value;
	public double getLocation_coordinates_1() {
		return location_coordinates_1;
	}
	public void setLocation_coordinates_1(double location_coordinates_1) {
		this.location_coordinates_1 = location_coordinates_1;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public double getTelemetry_driverWindow_value() {
		return telemetry_driverWindow_value;
	}
	public void setTelemetry_driverWindow_value(double telemetry_driverWindow_value) {
		this.telemetry_driverWindow_value = telemetry_driverWindow_value;
	}
	public double getTelemetry_rrWindow_value() {
		return telemetry_rrWindow_value;
	}
	public void setTelemetry_rrWindow_value(double telemetry_rrWindow_value) {
		this.telemetry_rrWindow_value = telemetry_rrWindow_value;
	}
	public String getTelemetry_rlTirePressure_unit() {
		return telemetry_rlTirePressure_unit;
	}
	public void setTelemetry_rlTirePressure_unit(String telemetry_rlTirePressure_unit) {
		this.telemetry_rlTirePressure_unit = telemetry_rlTirePressure_unit;
	}
	public String getTelemetry_odometer_unit() {
		return telemetry_odometer_unit;
	}
	public void setTelemetry_odometer_unit(String telemetry_odometer_unit) {
		this.telemetry_odometer_unit = telemetry_odometer_unit;
	}
	public String getTelemetry_frTirePressure_unit() {
		return telemetry_frTirePressure_unit;
	}
	public void setTelemetry_frTirePressure_unit(String telemetry_frTirePressure_unit) {
		this.telemetry_frTirePressure_unit = telemetry_frTirePressure_unit;
	}
	public double getTelemetry_rrTirePressure_value() {
		return telemetry_rrTirePressure_value;
	}
	public void setTelemetry_rrTirePressure_value(double telemetry_rrTirePressure_value) {
		this.telemetry_rrTirePressure_value = telemetry_rrTirePressure_value;
	}
	public String getTelemetry_spareTirePressure_unit() {
		return telemetry_spareTirePressure_unit;
	}
	public void setTelemetry_spareTirePressure_unit(String telemetry_spareTirePressure_unit) {
		this.telemetry_spareTirePressure_unit = telemetry_spareTirePressure_unit;
	}
	public String getTelemetry_flTirePressure_unit() {
		return telemetry_flTirePressure_unit;
	}
	public void setTelemetry_flTirePressure_unit(String telemetry_flTirePressure_unit) {
		this.telemetry_flTirePressure_unit = telemetry_flTirePressure_unit;
	}
	public String getTelemetry_rrTirePressure_unit() {
		return telemetry_rrTirePressure_unit;
	}
	public void setTelemetry_rrTirePressure_unit(String telemetry_rrTirePressure_unit) {
		this.telemetry_rrTirePressure_unit = telemetry_rrTirePressure_unit;
	}
	public String getCorrelationId() {
		return correlationId;
	}
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public double getLocation_coordinates_0() {
		return location_coordinates_0;
	}
	public void setLocation_coordinates_0(double location_coordinates_0) {
		this.location_coordinates_0 = location_coordinates_0;
	}
	public double getTelemetry_estimatedFuelLevel_value() {
		return telemetry_estimatedFuelLevel_value;
	}
	public void setTelemetry_estimatedFuelLevel_value(double telemetry_estimatedFuelLevel_value) {
		this.telemetry_estimatedFuelLevel_value = telemetry_estimatedFuelLevel_value;
	}
	public double getTelemetry_frTirePressure_value() {
		return telemetry_frTirePressure_value;
	}
	public void setTelemetry_frTirePressure_value(double telemetry_frTirePressure_value) {
		this.telemetry_frTirePressure_value = telemetry_frTirePressure_value;
	}
	public double getTelemetry_odometer_value() {
		return telemetry_odometer_value;
	}
	public void setTelemetry_odometer_value(double telemetry_odometer_value) {
		this.telemetry_odometer_value = telemetry_odometer_value;
	}
	public String getLocation_type() {
		return location_type;
	}
	public void setLocation_type(String location_type) {
		this.location_type = location_type;
	}
	public double getTelemetry_passengerWindow_value() {
		return telemetry_passengerWindow_value;
	}
	public void setTelemetry_passengerWindow_value(double telemetry_passengerWindow_value) {
		this.telemetry_passengerWindow_value = telemetry_passengerWindow_value;
	}
	public double getTelemetry_spareTirePressure_value() {
		return telemetry_spareTirePressure_value;
	}
	public void setTelemetry_spareTirePressure_value(double telemetry_spareTirePressure_value) {
		this.telemetry_spareTirePressure_value = telemetry_spareTirePressure_value;
	}
	public double getTelemetry_rlTirePressure_value() {
		return telemetry_rlTirePressure_value;
	}
	public void setTelemetry_rlTirePressure_value(double telemetry_rlTirePressure_value) {
		this.telemetry_rlTirePressure_value = telemetry_rlTirePressure_value;
	}
	public String getLastTimestamp() {
		return lastTimestamp;
	}
	public void setLastTimestamp(String lastTimestamp) {
		this.lastTimestamp = lastTimestamp;
	}
	public double getFuelLevel_value() {
		return fuelLevel_value;
	}
	public void setFuelLevel_value(double fuelLevel_value) {
		this.fuelLevel_value = fuelLevel_value;
	}
	public double getTelemetry_rlWindow_value() {
		return telemetry_rlWindow_value;
	}
	public void setTelemetry_rlWindow_value(double telemetry_rlWindow_value) {
		this.telemetry_rlWindow_value = telemetry_rlWindow_value;
	}
	public double getTelemetry_flTirePressure_value() {
		return telemetry_flTirePressure_value;
	}
	public void setTelemetry_flTirePressure_value(double telemetry_flTirePressure_value) {
		this.telemetry_flTirePressure_value = telemetry_flTirePressure_value;
	}
	public double getTelemetry_sunRoof_value() {
		return telemetry_sunRoof_value;
	}
	public void setTelemetry_sunRoof_value(double telemetry_sunRoof_value) {
		this.telemetry_sunRoof_value = telemetry_sunRoof_value;
	}
	
	public int getPartition() {
		return partition;
	}
	public void setPartition(int partition) {
		this.partition = partition;
	}
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
}
