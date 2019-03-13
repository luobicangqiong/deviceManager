package com.soft.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.soft.model.Device;
import com.soft.service.DeviceService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DeviceRepairAction extends ActionSupport implements ServletRequestAware, ServletResponseAware{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DeviceService deviceService;
	
	
	
	
	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	
	public String findAllDevice(){
		
		List<Device> list = deviceService.queryAllDevice(1, 7);
		Iterator<Device> iterator = list.iterator();
		JSONArray jsonArray = new JSONArray();
		JSONObject finalObj = new JSONObject();
		while (iterator.hasNext()) {

			JSONObject object = new JSONObject();
			/**
			 * <th data-options="field:'deviceId',width:110 ,align : 'center', ">ID</th>
									<th data-options="field:'deviceName',width:110 ,align : 'center', ">设备名</th>
									<th data-options="field:'deviceVersion',width:120,align : 'center', ">设备版本</th>
									<th data-options="field:'devicePrice',width:120,align:'center'">价格</th>
									<th data-options="field:'deviceState',width:110,align:'center'">状态</th>
									<th data-options="field:'devicePeople',width:110,align:'center'">管理人</th>
									<th data-options="field:'devicePhone',width:120,align:'center'">手机号</th>
			 */
			Device device = iterator.next();
			if("2".equals(device.getDeviceState())){
				object.put("deviceState", "损坏");
				object.put("deviceName",device.getDeviceName());
				object.put("deviceVersion", device.getDeviceVersion());
				object.put("devicePrice", device.getDevicePrice());
				object.put("devicePeople", device.getDevicePeople());
				object.put("deviceUse", device.getDeviceUse());
				object.put("devicePhone",device.getDevicePhone());
				object.put("deviceId",device.getDeviceId());
				jsonArray.add(object);
			}
		}
		System.out.println("device2222222222222222");
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
