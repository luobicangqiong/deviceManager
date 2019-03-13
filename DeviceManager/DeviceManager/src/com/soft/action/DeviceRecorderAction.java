package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.soft.model.DeviceRecorder;
import com.soft.service.DeviceRecorderService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeviceRecorderAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DeviceRecorderService deviceRecorderService;
	
	public DeviceRecorderService getDeviceRecorderService() {
		return deviceRecorderService;
	}

	public void setDeviceRecorderService(DeviceRecorderService deviceRecorderService) {
		this.deviceRecorderService = deviceRecorderService;
	}

	public DeviceRecorder deviceRecorder;
	
	public DeviceRecorder getDeviceRecorder() {
		return deviceRecorder;
	}

	public void setDeviceRecorder(DeviceRecorder deviceRecorder) {
		this.deviceRecorder = deviceRecorder;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * query all deviceRecorder
	 */
	public void queryAllDeviceRecorder()
	{
		
		System.out.println("all borrow device......");
		List<DeviceRecorder> list = deviceRecorderService.queryAllDeviceRecorder();
//		System.out.println("查询出的实体类是1:" + list);
		Iterator<DeviceRecorder> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		List<String> deviceNameList = new ArrayList<String>();
		List<String> deviceNumberList = new ArrayList<String>();
		List<String> empNameList = new ArrayList<String>();
		List<String> empPhoneList = new ArrayList<String>();
		while(iterator.hasNext())
		{
			JSONObject object = new JSONObject();
			
			DeviceRecorder deviceRecorder = iterator.next();
			System.out.println(deviceRecorder);
			object.put("deviceRecorderId", deviceRecorder.getDeviceRecorderId());
			object.put("deviceCount", deviceRecorder.getDeviceCount());
			object.put("deviceBorrowTime", deviceRecorder.getDeviceBorrowTime());
			object.put("deviceBackTime", deviceRecorder.getDeviceBackTime());
			
			object.put("device.deviceName", deviceRecorder.getDevice().getDeviceName());
			object.put("empInfo.empName", deviceRecorder.getEmpInfo().getEmpName());
			object.put("empInfo.empMobile", deviceRecorder.getEmpInfo().getEmpMobile());
			
			jsonArray.add(object);
		}

		System.out.println("device111111111111111111111111111");
		System.out.println(jsonArray.toString());
		finalObj.put("rows", jsonArray);
		//System.out.println("-----"+finalObj.toString()+"-----");
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		   
		   out.println(finalObj.toString());   
		   out.flush();   
		   out.close();   
		
		
	}
}
