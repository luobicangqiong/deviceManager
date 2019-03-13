package com.soft.model;

public class DeviceLend {
	private String lendId;
	private EmpInfo empInfo;
	private Device device;
	private String status;
	private String deviceCount;
	
	
	
	public String getDeviceCount() {
		return deviceCount;
	}

	public void setDeviceCount(String deviceCount) {
		this.deviceCount = deviceCount;
	}

	
	
	public DeviceLend() {
		super();
	}

	public DeviceLend(String lendId, EmpInfo empInfo, Device device, String status, String deviceCount) {
		super();
		this.lendId = lendId;
		this.empInfo = empInfo;
		this.device = device;
		this.status = status;
		this.deviceCount = deviceCount;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getLendId() {
		return lendId;
	}
	public void setLendId(String lendId) {
		this.lendId = lendId;
	}
	public EmpInfo getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(EmpInfo empInfo) {
		this.empInfo = empInfo;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	@Override
	public String toString() {
		return "DeviceLend [lendId=" + lendId + ", empInfo=" + empInfo + ", device=" + device + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
}
