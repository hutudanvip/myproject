
/**   
 * @title TestSmsSend.java
 * @package com.deppon.ump.module.test
 * @description 
 * @author cbb   
 * @update 2012-10-23 下午3:11:32
 * @version V1.0   
 */
 
package com.deppon.ump.SmsInterface;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;


/**
 * @description 
 * @version 1.0
 * @author cbb
 * @update 2012-10-23 下午3:11:32 
 */

public class TestSmsSend {

	/**
	 * @param args
	 * @description
	 * @version 1.0
	 * @author cbb
	 * @throws IOException 
	 * @throws HttpException 
	 * @update 2012-10-23 下午3:11:32
	 */

	public static void main(String[] args) throws HttpException, IOException {
		// TODO Auto-generated method stub

		HttpClient httpClient = new HttpClient();
		PostMethod postMethod = new PostMethod("http://192.168.17.65:9920/dpUMPInterface/ws/sms/batchSend");
		SmsInfo info = new SmsInfo();
		info.setMobile("1352430434"); 
		info.setMsgContent("");
		info.setSendDept("发送部门");
		info.setSender("发送人");
		info.setMsgType("YWLX20121023153958");
		info.setMsgSource("1");	
		info.setUnionId("YWLX"+new Timestamp(new Date().getTime())+"");
		info.setSendTime(new Timestamp(new Date().getTime()));
		//info.setLatestSendTime(new Timestamp(new Date().getTime()+60*60*24));
		info.setWaybillNo("12345678");
		info.setServiceType("1");
		//重发
		//info.setRepeatState(1);
		SmsInfo info1 = new SmsInfo();
		info1.setMobile("12021007881"); 
		info1.setMsgContent("");
		info1.setSendDept("发送部门1");
		info1.setSender("发送人1");
		info1.setMsgType("YWLX20121023175159");
		info1.setMsgSource("2");	
		info1.setUnionId(new Timestamp(new Date().getTime())+"1");
		info1.setSendTime(new Timestamp(new Date().getTime()));
		info1.setLatestSendTime(new Timestamp(new Date().getTime()+60*60*24));
		info1.setWaybillNo("12345678");
		info1.setServiceType("3");
		List<SmsInfo> list = new ArrayList<SmsInfo>();
		list.add(info);
		//list.add(info1);
		ObjectMapper mapper = new ObjectMapper();
		StringWriter stringWriter = new StringWriter();
		mapper.writeValue(stringWriter, list);
		String digest = MD5Encrypt.encrypt("smscbb" + "20120102");
		postMethod.getParams().setContentCharset("UTF-8");
		postMethod.setRequestBody(new NameValuePair[]{new NameValuePair("data_digest", digest), new NameValuePair("smsInfo", stringWriter.getBuffer().toString())});
		int status = httpClient.executeMethod(postMethod);
		SmsReturn smsReturn= mapper.readValue(postMethod.getResponseBody(), SmsReturn.class);
		System.out.println(postMethod.getResponseBodyAsString());
		ObjectReader or = mapper.reader(SmsReturn.class);
		SmsReturn sr = or.readValue(postMethod.getResponseBodyAsStream());
		System.out.println(status);
	}

}
