package com.soft.service;

import java.util.List;

import com.soft.model.DeviceRecorder;

public interface DeviceRecorderService {
	/**
	 * query
	 */
	public List<DeviceRecorder> queryAllDeviceRecorder();
	
	/**
	 * add recorder
	 */
	public boolean addDeviceRecorder(DeviceRecorder deviceRecorder);
	
	/**
	 * delete recorder
	 */
	public boolean deleteDeviceRecorder(DeviceRecorder deviceRecorder);
}
