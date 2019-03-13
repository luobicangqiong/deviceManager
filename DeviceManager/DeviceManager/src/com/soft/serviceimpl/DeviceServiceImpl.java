package com.soft.serviceimpl;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.soft.dao.DeviceDAO;
import com.soft.daoimpl.DeviceDAOImpl;
import com.soft.model.Device;
import com.soft.service.DeviceService;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

public class DeviceServiceImpl implements DeviceService {
	
	DeviceDAO deviceDAO;;

	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	@Override
	public boolean addDevice(Device device) {
		// TODO Auto-generated method stub
		try {
			deviceDAO.save(device);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteDevice(Device device) {
		// TODO Auto-generated method stub
		try {
			deviceDAO.delete(device);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateDevice(Device device) {
		// TODO Auto-generated method stub
		try {
			deviceDAO.update(device);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Device> queryAllDevice(int page, int pageSize) {
		// TODO Auto-generated method stub
		try {
			List<Device> list = deviceDAO.findAll(Device.class);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		try {
			int count = deviceDAO.countAll(Device.class);
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Device> queryDeviceByName(String name) {
		// TODO Auto-generated method stub
		
		
		List<Device> list = deviceDAO.findByProperty(Device.class, "device_name", name);
		System.out.println(list);
		return list;
	}

	@Override
	public Device findById(String id) {
		// TODO Auto-generated method stub
		Device device = (Device) deviceDAO.findById(Device.class, id);
		return device;
	}

}
