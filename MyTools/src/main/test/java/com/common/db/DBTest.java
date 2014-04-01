package com.common.db;

import java.util.List;

import com.common.util.db.DbUtil;

public class DBTest {
	public static void main(String[] args) {
		try {
			List list = DbUtil.executeQuery("SELECT 2 FROM DUAL");
			System.out.println(list.get(0));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
