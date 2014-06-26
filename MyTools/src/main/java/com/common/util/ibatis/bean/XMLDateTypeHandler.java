package com.common.util.ibatis.bean;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class XMLDateTypeHandler implements TypeHandler{

	@Override
	public Object getResult(ResultSet arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParameter(PreparedStatement arg0, int arg1, Object arg2,
			JdbcType arg3) throws SQLException {
		XMLGregorianCalendar xgc = (XMLGregorianCalendar) arg2;
		GregorianCalendar gc = xgc.toGregorianCalendar();
		Date date = new Date(gc.getTime().getTime());
		arg0.setDate(arg1, date);
		arg0.setTimestamp(arg1, new Timestamp(date.getTime()));
	}

}
