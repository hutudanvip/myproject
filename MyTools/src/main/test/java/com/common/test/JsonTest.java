package com.common.test;

import java.util.ArrayList;
import java.util.List;

import com.common.util.json.JsonUtils;

import net.sf.json.JSONArray;

public class JsonTest {
	public static void main(String[] args) {
		String clazz = Thread.currentThread().getStackTrace()[1].getClassName();
		System.out.println(clazz);
		List<TaskResultInfo> list = new ArrayList<TaskResultInfo>();
		for(int i=0; i<=3; i++) {
			TaskResultInfo info = new TaskResultInfo();
			info.setFlag(i);
			info.setMsg("test" + i);
			
			list.add(info);
		}
		
		TaskResultInfo info2 = new TaskResultInfo();
		info2.setFlag(5);
		info2.setMsg("test");
		

		JSONArray jsonArray = JSONArray.fromObject(info2);
		System.out.println(jsonArray.toString());
		
		JSONArray jsonarr = JSONArray.fromObject(jsonArray.toString());
		System.out.println("JSON大小" + jsonarr.size());
		List<StudentBean> list2 = JsonUtils.json2List(jsonarr.toString(), StudentBean.class);
		for(int i=0; i<list2.size(); i++) {
			StudentBean task = list2.get(i);
			System.out.println(task.getName());
//			String flag = jsonarr.getJSONObject(i);
		}
	}
	
	public String getName() {
		return Thread.currentThread().getStackTrace()[1].getClassName();
	}

}
