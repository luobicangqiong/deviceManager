package com.soft.test;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.soft.dao.DeviceDAO;
import com.soft.daoimpl.DeviceDAOImpl;
import com.soft.model.Device;
import com.soft.service.KeFuGuanLiService;
import com.soft.serviceimpl.KeFuGuanLiServiceImpl;
import com.soft.serviceimpl.KuFangGuanLiServiceImpl;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:/applicationContext.xml"})
@Transactional
///@TransactionConfiguration(defaultRollback = false)
public class TestDeviceDao {

	@Test
	public void testGetAll() throws Exception {
		
		DeviceDAO deviceDAO = new DeviceDAOImpl();
		System.out.println(deviceDAO.findAll(Device.class));
	}
	
	@Test
	public void testBeijian() throws Exception {
		
		KeFuGuanLiService keFuGuanLiService = new KeFuGuanLiServiceImpl();
		System.out.println(keFuGuanLiService.queryAll(0, 10));
		
	}
	
	@Test
	public void TestUUID() throws Exception {
		String aString  = UUID.randomUUID().toString();
		System.out.println(aString);
		System.out.println(aString.length());
		
	}
}
