package com.deppon.ump.SmsInterface;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.map.ObjectMapper;

public class TestSendDail {
	public static void main(String[] args) throws HttpException, IOException {
		// TODO Auto-generated method stub

		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod("http://192.168.14.126:8480/dpUMPInterface/ws/sms/sendDail");
		SmsSendDailInfo smsSendDailInfo = new SmsSendDailInfo();
		//smsSendDailInfo.setStartTime(new Timestamp(new Date().getTime()));
		smsSendDailInfo.setEndTime(new Timestamp(new Date().getTime()));
		smsSendDailInfo.setStartDigit(0);
		smsSendDailInfo.setEndDigit(50);
		smsSendDailInfo.setServiceType("1");
		ObjectMapper mapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		mapper.writeValue(stringWriter, smsSendDailInfo);
		String digest = MD5Encrypt.encrypt("OASMSKEY" + "20121031");
		//String digest = MD5Encrypt.encrypt("ERPSMSKEY" + "20121105");
		System.out.println(digest);
		postMethod.getParams().setContentCharset("UTF-8");
		postMethod.setRequestBody(new NameValuePair[]{new NameValuePair("data_digest", digest), new NameValuePair("smsSendDailInfo", stringWriter.getBuffer().toString())});
		int status = httpClient.executeMethod(postMethod);
		//SmsReturn smsReturn= mapper.readValue(postMethod.getResponseBody(), SmsReturn.class);
		//System.out.println(smsReturn.getResultCode());
		SmsSendDailReturn smsSendDailReturn= mapper.readValue(postMethod.getResponseBody(), SmsSendDailReturn.class);
		System.out.println("总条数："+smsSendDailReturn.getCount());
		System.out.println("实际返回条数："+smsSendDailReturn.getSmsSendDail().size());
		System.out.println(postMethod.getResponseBodyAsString());
		//System.out.println(status);
	}
}
