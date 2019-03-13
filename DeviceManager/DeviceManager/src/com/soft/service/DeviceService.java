package com.soft.service;

import java.util.List;

import com.soft.dao.DeviceDAO;
import com.soft.model.Device;

public interface DeviceService{

	/**
	 * add Device
	 * @return 
	 */
	public boolean addDevice(Device device);
	
	/**
	 * deleteDevice
	 */
	public void deleteDevice(Device device);
	
	/**
	 * update Device
	 */
	public void updateDevice(Device device);
	
	/**
	 * query all Device
	 */
	public List<Device> queryAllDevice(int page, int pageSize);
	
	/**
	 * get all count
	 */
	public int countAll();
	
	/**
	 * query by name
	 */
	public List<Device> queryDeviceByName(String name);
	
	/**
	 * 
	 */
	public Device findById(String id);
	
}
