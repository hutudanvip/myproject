package com.deppon;

import java.math.BigDecimal;
import java.util.UUID;
import javax.xml.ws.Holder;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import com.deppon.esb.header.ESBHeader;
import com.deppon.nhr.module.remote.fssc.service.CommonException;
import com.deppon.nhr.module.remote.fssc.service.PersonalLoanService;
import com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanAmountDetail;
import com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanAmountRequest;
import com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanStatusRequest;

public class TestEhr {
	public static void main(String[] args) throws CommonException {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(PersonalLoanService.class);
		factory.setAddress("http://10.224.72.141:8081/nhr/ws/personalLoanService");
		PersonalLoanService loanService = (PersonalLoanService)factory.create();
		
		LoanAmountRequest request = new LoanAmountRequest();
		
		Holder<ESBHeader> esbHeader = new Holder<ESBHeader>();
		ESBHeader header = new ESBHeader();
		header.setVersion("1.0");
		header.setEsbServiceCode("ESB_FSSC2ESB_VALIDATE_ERROR");
//		header.setBusinessId(request + DateUtil.getFormatDateString("yyyyMMddhhmmssSSS"));
		header.setRequestId(UUID.randomUUID().toString());
		header.setSourceSystem("FSSC");
		header.setExchangePattern(1); 
		header.setMessageFormat("SOAP");
		esbHeader.value= header;
		
		//私人借款数据
		LoanAmountDetail detail = new LoanAmountDetail();
		detail.setCperiod("2014-01");
		detail.setLoanmony(new BigDecimal(3000));
		detail.setPsncode("116628");
		detail.setPsnstate("1");
		
		//私人借款数据集合
//		List<LoanAmountDetail> list_detail = request.getLoanAmountDetail();
//		list_detail.add(detail);
//		request.setList(list);
		
		request.getLoanAmountDetail().add(detail);
		
		loanService.addLoanAmount(request, esbHeader);
		
		LoanStatusRequest loanStatusRequest = new LoanStatusRequest();
		loanStatusRequest.getLoanParamDetail();
		loanService.queryLoanStatus(loanStatusRequest, esbHeader);
//		loanService.
	}
}
