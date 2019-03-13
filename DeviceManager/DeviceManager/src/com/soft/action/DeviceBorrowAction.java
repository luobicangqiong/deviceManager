package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.soft.dao.DeviceDAO;
import com.soft.model.Device;
import com.soft.model.DeviceLend;
import com.soft.model.DeviceRecorder;
import com.soft.model.EmpInfo;
import com.soft.service.DeviceLendService;
import com.soft.service.DeviceRecorderService;
import com.soft.service.DeviceService;
import com.soft.service.EmpInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeviceBorrowAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DeviceService deviceService;
	private DeviceRecorderService deviceRecorderService;
	private DeviceLendService deviceLendService;
	private EmpInfoService empInfoService;
	HttpSession session = null;
	
	
	public DeviceLendService getDeviceLendService() {
		return deviceLendService;
	}

	public void setDeviceLendService(DeviceLendService deviceLendService) {
		this.deviceLendService = deviceLendService;
	}

	public EmpInfoService getEmpInfoService() {
		return empInfoService;
	}

	public void setEmpInfoService(EmpInfoService empInfoService) {
		this.empInfoService = empInfoService;
	}

	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public DeviceRecorderService getDeviceRecorderService() {
		return deviceRecorderService;
	}

	public void setDeviceRecorderService(DeviceRecorderService deviceRecorderService) {
		this.deviceRecorderService = deviceRecorderService;
	}
	
	public String queryAllDevice() {
		// TODO Auto-generated method stub
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
			object.put("deviceLeave", device.getDeviceLeave());
			jsonArray.add(object);
		}
		System.out.println("device111111111111111111111111111");
		System.out.println(jsonArray.toString());
		finalObj.put("rows", jsonArray);
		//System.out.println("-----"+finalObj.toString()+"-----");
		session = request.getSession();
		System.out.println(session.getAttribute("userName"));
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		System.out.println(System.getProperty("user.name"));
		
		   out.println(finalObj.toString());   
		   out.flush();   
		   out.close();   
		
		return null;
		
	}
	
	public String updateDevice(){
		String id = request.getParameter("deviceId");
		Device device  = deviceService.findById(id);
		String phone = request.getParameter("devicePhone");
		System.out.println(phone);
		EmpInfo empInfo = empInfoService.queryUserByPhone(phone);
		System.out.println(empInfo);
		System.out.println(device);
		JSONObject finalObj = new JSONObject();
		PrintWriter out = null;
		//System.out.println(deviceLendService.queryAllDeviceLend());
		if(empInfo != null)
		{
			finalObj.put("info", "申请已经提交，请等待答复");
			
			response.setContentType("text/html;charset=UTF-8");
			
			
			String id1 = UUID.randomUUID().toString();
			String status = "1";
			String count = request.getParameter("deviceNumber");
			DeviceLend deviceLend = new DeviceLend(id1,empInfo, device, status, count);
			deviceLendService.addDeviceLend(deviceLend);
			
			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}   
			   
			   out.println(finalObj.toString());   
			   out.flush();   
			   out.close(); 
		}else {
			
			System.out.println("请输入正确的手机号");
			finalObj.put("info", "您无权借出，请输入正确的手机号！");
			
			response.setContentType("text/html;charset=UTF-8");
			

			try {
				out = response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}   
			   
			   out.println(finalObj.toString());   
			   out.flush();   
			   out.close(); 
		}

		
		return null;
	}
	
	public String queryAllDeviceByName() {
		// TODO Auto-generated method stub
		//List<Device> list = deviceService.queryAllDevice(1, 7);
		List<DeviceRecorder> list = deviceRecorderService.queryAllDeviceRecorder();
		Iterator<DeviceRecorder> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		session = request.getSession();
		String empNameString = (String) session.getAttribute("userName");
		
		while (iterator.hasNext()) {

			JSONObject object = new JSONObject();
			
			DeviceRecorder deviceRecorder = iterator.next();
			if(deviceRecorder.getEmpInfo().getEmpName().equals(empNameString)){
				Device device = deviceRecorder.getDevice();
				object.put("deviceId", device.getDeviceId());
				object.put("deviceName",device.getDeviceName());
				object.put("deviceVersion", device.getDeviceVersion());
				object.put("devicePrice", device.getDevicePrice());
				object.put("deviceCount", deviceRecorder.getDeviceCount());
				
				jsonArray.add(object);
			}     
			
			
		}
		System.out.println("device111111111111111111111111111");
		System.out.println(jsonArray.toString());
		finalObj.put("rows", jsonArray);
		//System.out.println("-----"+finalObj.toString()+"-----");
		session = request.getSession();
		System.out.println(session.getAttribute("userName"));
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		System.out.println(System.getProperty("user.name"));
		
		   out.println(finalObj.toString());   
		   out.flush();   
		   out.close();   
		
		return null;
		
	}
	
	public String returnDevice(){
		
		String deviceNameString = request.getParameter("deviceName");
		String deviceIdString = request.getParameter("deviceId");
		String deviceCountString = request.getParameter("deviceCount");
		
		List<DeviceRecorder> list = deviceRecorderService.queryAllDeviceRecorder();
		Iterator<DeviceRecorder> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		session = request.getSession();
		String empNameString = (String) session.getAttribute("userName");
		PrintWriter out = null;
		
		while (iterator.hasNext()) {

			JSONObject object = new JSONObject();
			
			DeviceRecorder deviceRecorder = iterator.next();
			//System.out.println(deviceRecorder.getEmpInfo().getEmpName());
			if(deviceRecorder.getEmpInfo().getEmpName().equals(empNameString) &&deviceRecorder.getDevice().getDeviceId().equals(deviceIdString) && deviceRecorder.getDeviceCount().equals(deviceCountString)){
				
				System.out.println("进来归还设备！！！");
				Device device = deviceService.findById(deviceIdString);
				System.out.println(device);
				String deviceLeave = String.valueOf(Integer.parseInt(device.getDeviceLeave())+ Integer.parseInt(deviceCountString));
				device.setDeviceLeave(deviceLeave);
				
				deviceService.updateDevice(device);
				deviceRecorderService.deleteDeviceRecorder(deviceRecorder);
				System.out.println("归还成功！！！");
				
				finalObj.put("info", "归还成功！！！");
				response.setContentType("text/html;charset=UTF-8");
				
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}   
				   
				   out.println(finalObj.toString());   
				   out.flush();   
				   out.close(); 
			}     
			
			
		}
		
		
		
		return null;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}


}
