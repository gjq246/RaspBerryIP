package cn.edu.fjjxu.iot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.edu.fjjxu.iot.pojo.Device;
import cn.edu.fjjxu.iot.pojo.Global;

@Service
public class DeviceService {
	
	public synchronized void add(Device device){
		
		if(Global.DeviceList==null){
			Global.DeviceList=new ArrayList<Device>();
		}
				
		//查找是否有同名的进行更新
		for (int i=0;i<Global.DeviceList.size();i++) {
			if(Global.DeviceList.get(i).getDeviceName().equals(device.getDeviceName())){
				
				Global.DeviceList.get(i).setDeviceIp(device.getDeviceIp());

				Global.DeviceList.get(i).setLoginTime(device.getLoginTime());
				
				return;
				
			}
		}
		//否则添加
		Global.DeviceList.add(device);
		
	}
	
	public List<Map<String,Object>> getAll(){	
		
		
		List<Map<String,Object>> devices =new ArrayList<Map<String,Object>>(); 
		if(Global.DeviceList==null){
			return devices;
		}
		
		for(Device d:Global.DeviceList){
	       Map<String,Object> device = new HashMap<String,Object>(); 
	       device.put("DeviceName", d.getDeviceName());
	       device.put("DeviceIp", d.getDeviceIp());
	       device.put("LoginTime", d.getLoginTime());
	       devices.add(device); 
		}
	       
		return devices;
	}

}
