package com.soft.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.soft.dao.DeviceLendDAO;
import com.soft.model.DeviceLend;
import com.soft.model.DeviceRecorder;
import com.soft.service.DeviceLendService;

public class DeviceLendServiceImpl implements DeviceLendService {

	DeviceLendDAO deviceLendDAO;
	
	public DeviceLendDAO getDeviceLendDAO() {
		return deviceLendDAO;
	}

	public void setDeviceLendDAO(DeviceLendDAO deviceLendDAO) {
		this.deviceLendDAO = deviceLendDAO;
	}

	
	
	@Override
	public boolean addDeviceLend(DeviceLend deviceLend) {
		try {
			deviceLendDAO.save(deviceLend);
			System.out.println("33333333333333");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<DeviceLend> queryAllDeviceLend() {
		try {
			String sql = "select * from device_lend";
			//List<DeviceRecorder> recorders = deviceRecorderDAO.findSQL(sql);
 			List<DeviceLend> list = deviceLendDAO.findAll(DeviceLend.class);  // 原有查询到的实体类数组	
 			
			return list;
		} catch (Exception e) {	
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateDeviceLend(DeviceLend deviceLend) {
		try {
			deviceLendDAO.update(deviceLend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public DeviceLend findDeviceLendById(String id) {
		try {
			DeviceLend deviceLend = (DeviceLend) deviceLendDAO.findById(DeviceLend.class, id);
			return deviceLend;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
