package com.deppon.ump.SmsInterface;

import java.io.Serializable;
import java.util.List;

public class SmsSendDailReturn implements Serializable{

	
	/** 
	 * @fields serialVersionUID 
	 */ 
	
	private static final long serialVersionUID = 2747438916992528325L;
	
	private List<SmsSendDail> smsSendDail;
	
	private long count;

	public List<SmsSendDail> getSmsSendDail() {
		return smsSendDail;
	}

	public void setSmsSendDail(List<SmsSendDail> smsSendDail) {
		this.smsSendDail = smsSendDail;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	

}
