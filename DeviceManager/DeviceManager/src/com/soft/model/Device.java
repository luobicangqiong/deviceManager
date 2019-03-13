package com.soft.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Entity;

/**
 * BeiJian entity. @author MyEclipse Persistence Tools
 */

public class Device implements java.io.Serializable {
	
	
	private String deviceId;
	private String deviceName;
	private String deviceVersion;
	private String devicePrice;
	private String deviceNumber;
	private String warnNumber;
	private String deviceState;
	private String devicePeople;
	private String deviceUse;
	private String devicePhone;
	private String deviceLeave;
	private Set<DeviceRecorder> deviceRecorders = new HashSet<DeviceRecorder>(); 
	
    
	
	
	public Set<DeviceRecorder> getDeviceRecorders() {
		return deviceRecorders;
	}


	public void setDeviceRecorders(Set<DeviceRecorder> deviceRecorders) {
		this.deviceRecorders = deviceRecorders;
	}


	public Device() {
		super();
	}


	
	public String getDeviceLeave() {
		return deviceLeave;
	}


	public void setDeviceLeave(String deviceLeave) {
		this.deviceLeave = deviceLeave;
	}




	public String getDeviceId() {
		return deviceId;
	}



	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}



	public String getDeviceName() {
		return deviceName;
	}



	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}



	public String getDeviceVersion() {
		return deviceVersion;
	}



	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}



	public String getDevicePrice() {
		return devicePrice;
	}



	public void setDevicePrice(String devicePrice) {
		this.devicePrice = devicePrice;
	}



	public String getDeviceNumber() {
		return deviceNumber;
	}



	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}



	public String getWarnNumber() {
		return warnNumber;
	}



	public void setWarnNumber(String warnNumber) {
		this.warnNumber = warnNumber;
	}



	public String getDeviceState() {
		return deviceState;
	}



	public void setDeviceState(String deviceState) {
		this.deviceState = deviceState;
	}



	public String getDevicePeople() {
		return devicePeople;
	}



	public void setDevicePeople(String devicePeople) {
		this.devicePeople = devicePeople;
	}



	public String getDeviceUse() {
		return deviceUse;
	}



	public void setDeviceUse(String deviceUse) {
		this.deviceUse = deviceUse;
	}



	public String getDevicePhone() {
		return devicePhone;
	}



	public void setDevicePhone(String devicePhone) {
		this.devicePhone = devicePhone;
	}


	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceName=" + deviceName + ", deviceVersion=" + deviceVersion
				+ ", devicePrice=" + devicePrice + ", deviceNumber=" + deviceNumber + ", warnNumber=" + warnNumber
				+ ", deviceState=" + deviceState + ", devicePeople=" + devicePeople + ", deviceUse=" + deviceUse
				+ ", devicePhone=" + devicePhone + ", deviceLeave=" + deviceLeave + ", deviceRecorders="
				+ deviceRecorders + "]";
	}


	public Device(String deviceId, String deviceName, String deviceVersion, String devicePrice, String deviceNumber,
			String warnNumber, String deviceState, String devicePeople, String deviceUse, String devicePhone,
			String deviceLeave, Set<DeviceRecorder> deviceRecorders) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.deviceVersion = deviceVersion;
		this.devicePrice = devicePrice;
		this.deviceNumber = deviceNumber;
		this.warnNumber = warnNumber;
		this.deviceState = deviceState;
		this.devicePeople = devicePeople;
		this.deviceUse = deviceUse;
		this.devicePhone = devicePhone;
		this.deviceLeave = deviceLeave;
		this.deviceRecorders = deviceRecorders;
	}


	
	
	
    

}