package com.soft.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.soft.dao.DeviceRecorderDAO;
import com.soft.model.Device;
import com.soft.model.DeviceRecorder;
import com.soft.model.EmpInfo;
import com.soft.service.DeviceRecorderService;

public class DeviceRecorderServiceImpl implements DeviceRecorderService {

	DeviceRecorderDAO deviceRecorderDAO;
	

	public DeviceRecorderDAO getDeviceRecorderDAO() {
		return deviceRecorderDAO;
	}



	public void setDeviceRecorderDAO(DeviceRecorderDAO deviceRecorderDAO) {
		this.deviceRecorderDAO = deviceRecorderDAO;
	}



	@Override
	public List<DeviceRecorder> queryAllDeviceRecorder() {
		
		try {
			String sql = "select * from device_recorder";
			//List<DeviceRecorder> recorders = deviceRecorderDAO.findSQL(sql);
 			List<DeviceRecorder> list = deviceRecorderDAO.findAll(DeviceRecorder.class);  // 原有查询到的实体类数组
 			DeviceRecorder deviceRecorder = (DeviceRecorder) deviceRecorderDAO.findById(DeviceRecorder.class, "1");
 			List<DeviceRecorder> list1 = new ArrayList<DeviceRecorder>();

			
			return list;
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}



	@Override
	public boolean addDeviceRecorder(DeviceRecorder deviceRecorder) {
		// TODO Auto-generated method stub
		try {
			deviceRecorderDAO.save(deviceRecorder);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public boolean deleteDeviceRecorder(DeviceRecorder deviceRecorder) {
		// TODO Auto-generated method stub
		try {
			deviceRecorderDAO.delete(deviceRecorder);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
