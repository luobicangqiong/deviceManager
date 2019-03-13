package com.soft.model;

import org.hibernate.annotations.Entity;

/**
 * BeiJian entity. @author MyEclipse Persistence Tools
 */

public class DeviceRecorder implements java.io.Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deviceRecorderId;
	private Device device;
	private String deviceCount = "0";
	private String deviceBorrowTime;
	private String deviceBackTime;
	private EmpInfo empInfo;
	public String getDeviceRecorderId() {
		return deviceRecorderId;
	}
	public void setDeviceRecorderId(String deviceRecorderId) {
		this.deviceRecorderId = deviceRecorderId;
	}
	
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	public String getDeviceCount() {
		return deviceCount;
	}
	public void setDeviceCount(String deviceCount) {
		this.deviceCount = deviceCount;
	}
	public String getDeviceBorrowTime() {
		return deviceBorrowTime;
	}
	public void setDeviceBorrowTime(String deviceBorrowTime) {
		this.deviceBorrowTime = deviceBorrowTime;
	}
	public String getDeviceBackTime() {
		return deviceBackTime;
	}
	public void setDeviceBackTime(String deviceBackTime) {
		this.deviceBackTime = deviceBackTime;
	}
	
	public EmpInfo getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}
	
	
	@Override
	public String toString() {
		return "DeviceRecorder [deviceRecorderId=" + deviceRecorderId + ", device=" + device + ", deviceCount="
				+ deviceCount + ", deviceBorrowTime=" + deviceBorrowTime + ", deviceBackTime=" + deviceBackTime
				+ ", empInfo=" + empInfo + "]";
	}
	public DeviceRecorder(String deviceRecorderId, Device device, String deviceCount, String deviceBorrowTime,
			String deviceBackTime, EmpInfo empInfo) {
		super();
		this.deviceRecorderId = deviceRecorderId;
		this.device = device;
		this.deviceCount = deviceCount;
		this.deviceBorrowTime = deviceBorrowTime;
		this.deviceBackTime = deviceBackTime;
		this.empInfo = empInfo;
	}
	public DeviceRecorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
    

}