package com.soft.service;

import java.util.List;

import com.soft.model.DeviceLend;

public interface DeviceLendService {
	public boolean addDeviceLend(DeviceLend deviceLend);
	public List<DeviceLend> queryAllDeviceLend();
	public void updateDeviceLend(DeviceLend deviceLend);
	public DeviceLend findDeviceLendById(String id);
}
