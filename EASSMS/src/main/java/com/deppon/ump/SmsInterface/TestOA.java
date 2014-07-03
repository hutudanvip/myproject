package com.deppon.ump.SmsInterface;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TestOA {

	/**
	 * @param args
	 * @description
	 * @version 1.0
	 * @author cbb
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * @update 2012-11-19 下午7:30:24
	 */

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		TestOA oa = new TestOA();
		//oa.test("13916123460");
		oa.test("13524304344");
		//oa.test("13917380853");
	}

	public void test(String pho) throws JsonGenerationException, JsonMappingException, IOException{
		HttpClient httpClient = new HttpClient();//180.153.16.119:8180
		PostMethod postMethod = new PostMethod("http://192.168.17.65:8180/dpUMPInterface/ws/sms/batchSend");
		
		List<SmsInfo> list = new ArrayList<SmsInfo>();
		int i=0;
		for(;i<1 ; i++){
			SmsInfo smsInfo = new SmsInfo();
			smsInfo.setMobile(pho);
			smsInfo.setMsgContent("测试网关成功短信");
			smsInfo.setMsgSource("XTLY20121031135020");
			smsInfo.setMsgType("YWLX20121105094321");
			smsInfo.setSendTime(new Timestamp(new Date().getTime()));
			smsInfo.setSendDept("DP01334");
			smsInfo.setSender("078829");
			smsInfo.setServiceType("1");
			smsInfo.setUnionId("YWLX20121105094321"+new Date().getTime()+i);
			list.add(smsInfo);
		}	
		ObjectMapper mapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		mapper.writeValue(stringWriter, list);
		//GPSSMSKEY20121105 OASMSKEY20121031 GPSSMSKEY20121105 hCmUzo+H4Su+p9BJ9a7XSQ==
		String digest = MD5Encrypt.encrypt("OASMSKEY20121031");  
		
		postMethod.getParams().setContentCharset("UTF-8");
		postMethod.setRequestBody(new NameValuePair[]{new NameValuePair("data_digest", digest), new NameValuePair("smsInfo", stringWriter.getBuffer().toString())});
		int status = httpClient.executeMethod(postMethod);
		System.out.println(postMethod.getResponseBodyAsString());
		System.out.println(status);
	}
}
