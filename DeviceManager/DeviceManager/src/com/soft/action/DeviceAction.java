package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.soft.model.Device;
import com.soft.model.Emp;
import com.soft.service.DeviceService;
import com.soft.serviceimpl.DeviceServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeviceAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private DeviceService deviceService;
	
	public DeviceService getDeviceService(){
		
		return deviceService;
	}
	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}
	
	private Device device;
	
	public Device getDevice(){
		
		return device;
	}
	
	public void setDevice(Device device) {
		this.device = device;
	}
	
	/**
	 * 
	 * �õ����е��豸��Ϣ
	 * 
	 */
	public String queryAllDevice(){
		
		List<Device> list = deviceService.queryAllDevice(1, 7);
		Iterator<Device> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		while (iterator.hasNext()) {

			JSONObject object = new JSONObject();
			
			Device device = iterator.next();
			object.put("deviceId", device.getDeviceId());
			object.put("deviceName",device.getDeviceName());
			object.put("deviceVersion", device.getDeviceVersion());
			object.put("devicePrice", device.getDevicePrice());
			object.put("deviceNumber", device.getDeviceNumber());
			object.put("warnNumber", device.getWarnNumber());
			object.put("deviceState", device.getDeviceState());
			object.put("devicePeople", device.getDevicePeople());
			object.put("deviceUse", device.getDeviceUse());
			object.put("devicePhone",device.getDevicePhone());
			object.put("deviceLeave", device.getDeviceLeave());
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
		
		return null;
		
	}
	
	/**
	 * add Device
	 */
	public void addDevice() {
		
		System.out.println(device);
		JSONObject finalObj = new JSONObject();
		if(deviceService.addDevice(device)){
			finalObj.put("info", "添加成功");
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}   
			   
			   out.println(finalObj.toString());   
			   out.flush();   
			   out.close();   
		}else{
			
			 finalObj.put("info", "添加失败，请重新添加！！！");
			
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
	/**
	 * 
	 * edit device
	 */
	
	public void editDevice() {
		System.out.println("update。。。。。。。。。");
		System.out.println(device);
		JSONObject finalObj = new JSONObject();
		PrintWriter out = null;
		try {
			deviceService.updateDevice(device);
			finalObj.put("info", "修改成功");
			
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			finalObj.put("info", "修改失败，请重新修改");
			
			response.setContentType("text/html;charset=UTF-8");
			e.printStackTrace();
		} finally {
			out.println(finalObj.toString());   
			out.flush();   
			out.close(); 
		}
		
		
	}
	
	/**
	 * 
	 * 
	 * delete device
	 */
	public void deleteDevice() {
		System.out.println(device);
		JSONObject finalObj = new JSONObject();
		PrintWriter out = null;
		try {
			deviceService.deleteDevice(device);
			finalObj.put("info", "删除成功");
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			finalObj.put("info", "删除失败，请重新删除！！！");
			response.setContentType("text/html;charset=UTF-8");
			
			e.printStackTrace();
		} finally {
			out.println(finalObj.toString());   
			out.flush();   
			out.close(); 
		}
		
	}
	
	/***
	 * 
	 * find device by name
	 */
	public void findDeviceByName() {
		
		String name = request.getParameter("name");
		List<Device> list = deviceService.queryAllDevice(1, 7);
		Iterator<Device> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		
		while (iterator.hasNext()) {

			JSONObject object = new JSONObject();
			
			Device device = iterator.next();
			if (device.getDeviceName().equals(name))
			{
				object.put("deviceId", device.getDeviceId());
				object.put("deviceName",device.getDeviceName());
				object.put("deviceVersion", device.getDeviceVersion());
				object.put("devicePrice", device.getDevicePrice());
				object.put("deviceNumber", device.getDeviceNumber());
				object.put("warnNumber", device.getWarnNumber());
				object.put("deviceState", device.getDeviceState());
				object.put("devicePeople", device.getDevicePeople());
				object.put("deviceUse", device.getDeviceUse());
				object.put("devicePhone",device.getDevicePhone());
				
				jsonArray.add(object);
			}

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
	@Override
	public void setServletResponse(HttpServletResponse response) {
		
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	
	

}
