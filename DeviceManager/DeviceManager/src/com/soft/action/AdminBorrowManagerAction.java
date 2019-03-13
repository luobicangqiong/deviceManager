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
import org.apache.struts2.views.xslt.StringAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.soft.model.Device;
import com.soft.model.DeviceLend;
import com.soft.model.DeviceRecorder;
import com.soft.model.EmpInfo;
import com.soft.service.DeviceLendService;
import com.soft.service.DeviceRecorderService;
import com.soft.service.DeviceService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdminBorrowManagerAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceRecorderService deviceRecorderService;
	@Autowired
	private DeviceLendService deviceLendService;
	
	
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

	public DeviceLendService getDeviceLendService() {
		return deviceLendService;
	}

	public void setDeviceLendService(DeviceLendService deviceLendService) {
		this.deviceLendService = deviceLendService;
	}

	
	public String agreeDevice(){
		
		String lenIdString = request.getParameter("lenId");
		String deviceIdString = request.getParameter("deviceId");
		String phone = request.getParameter("devicePhone");
		System.out.println(lenIdString);
		System.out.println(deviceIdString);
		System.out.println(phone);
		
		JSONObject finalObj = new JSONObject();
		
		DeviceLend deviceLend = deviceLendService.findDeviceLendById(lenIdString);
		deviceLend.setStatus("0");
		String deviceBorrowCount = deviceLend.getDeviceCount();
		deviceLendService.updateDeviceLend(deviceLend);
		Device device = deviceService.findById(deviceIdString);
		String new_leaveString = Integer.toString(Integer.valueOf(device.getDeviceLeave()) - Integer.valueOf(deviceBorrowCount));
		device.setDeviceLeave(new_leaveString);
		deviceService.updateDevice(device);
		EmpInfo empInfo = deviceLend.getEmpInfo();
		String id = UUID.randomUUID().toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String reStr = null;
        try {
			Date dt = df.parse(df.format(new Date()));  
			Calendar rightNow = Calendar.getInstance();  
			rightNow.setTime(dt);  
			rightNow.add(Calendar.MONTH, 3);  
			Date dt1 = rightNow.getTime();  
			reStr = df.format(dt1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		DeviceRecorder deviceRecorder = new DeviceRecorder(id, device, deviceBorrowCount,df.format(new Date()),reStr,empInfo);
		deviceRecorderService.addDeviceRecorder(deviceRecorder);
		System.out.println("成功");
		finalObj.put("info", "对方成功借出");
		
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
		return null;
	}
	
	public String queryAllDevice()
	{
		System.out.println("进入device.................");
		System.out.println(deviceService.queryAllDevice(1,10));
		List<DeviceLend> list = deviceLendService.queryAllDeviceLend();

		
		
		Iterator<DeviceLend> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		
		while (iterator.hasNext()) {

			JSONObject object = new JSONObject();
			
			DeviceLend deviceLend = iterator.next();
			System.out.println(deviceLend.getStatus());
			if("1".equals(deviceLend.getStatus()))
			{
				object.put("lenId", deviceLend.getLendId());
				object.put("deviceId", deviceLend.getDevice().getDeviceId());
				object.put("devicName", deviceLend.getDevice().getDeviceName());
				object.put("devicePeople", deviceLend.getEmpInfo().getEmpMobile());
				object.put("devicePhone",deviceLend.getEmpInfo().getEmpMobile());
				object.put("deviceNumber",deviceLend.getDeviceCount());
				jsonArray.add(object);
			}
			
		}
		
		System.out.println(jsonArray.toString());
		finalObj.put("rows", jsonArray);
		
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
	
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		
		this.response = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	
}
