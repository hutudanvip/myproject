package com.deppon;

import java.util.Arrays;

import com.itrus.cert.X509Certificate;
import com.itrus.kingdee.ISecurityConsts;
import com.itrus.pki.rsa.iTrusRSAAPI;
import com.itrus.pki.rsa.iTrusUsbKey;
import com.itrus.util.Base64;

public class CATest {
	public static void main(String[] args) {
//		clientSign();
		byte[] b1 = str2byte();
		String str = Base64.encode(b1);
		System.out.println(str);
	}
	
	public static void clientSign() {
		iTrusUsbKey it = new iTrusUsbKey("CA\\EAS\\client\\properties");
		System.out.println("-------------------------" + it);
		
		if(it.isUsbKeyExistent()) {
			String logonPassword = "111111";
			if(it.checkPasswd(logonPassword.getBytes())) {
				//签名原文
				byte[] p = "德邦".getBytes();
				//使用UKey做数字签名
				byte[] u = it.sign(p);
				
//				System.out.println("加密后的密文：" + Base64.encode(u));
//				//客户端验证 自签自验
//				int mm = it.verify(p, u);
//				if(mm == ISecurityConsts.SIGNATURE_VALID){
//					System.out.println(" 成功");
//				}
				
				String str1 = Base64.encode(u);
				byte[] u2 = Base64.decode(str1);
				String str2 = Base64.encode(u);
				
				if(str1.equals(str2)) {
					System.out.println("相等！--------------------------");
				} else {
					System.out.println("不相等-----------------------------");
				}
				
				if(Arrays.equals(u, u2)) {
					System.out.println("相等！--------------------------");
				} else {
					System.out.println("不相等-----------------------------");
				}
				
			} else {
				System.out.println("密码错误");
			}
		} else {
			System.out.println("请插入UKey");
		}
		
	}
	
	
	public static byte[] str2byte() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<10000; i++) {
			sb.append("a");
		}
		
		return Base64.decode(sb.toString());
		
	}
		
}

