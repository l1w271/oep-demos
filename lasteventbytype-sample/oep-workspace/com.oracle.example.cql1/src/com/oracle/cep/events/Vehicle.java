package com.oracle.cep.events;

public class Vehicle {

	private String vehicleID ;
	private String vehicleAssetName ;
	private long eventTime ;
	
	public String getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getVehicleAssetName() {
		return vehicleAssetName;
	}
	public void setVehicleAssetName(String vehicleAssetName) {
		this.vehicleAssetName = vehicleAssetName;
	}

	public long getEventTime() {
		return eventTime;
	}
	public void setEventTime(long eventTime) {
		this.eventTime = eventTime;
	}
	@Override
	public String toString() {
		return "Vehicle [eventTime=" + eventTime + ", vehicleAssetName="
				+ vehicleAssetName + ", vehicleID=" + vehicleID + "]";
	}
	
	
	
	
}
