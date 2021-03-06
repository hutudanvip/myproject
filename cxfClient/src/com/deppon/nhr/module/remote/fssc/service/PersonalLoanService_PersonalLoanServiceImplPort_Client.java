
package com.deppon.nhr.module.remote.fssc.service;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import com.deppon.nhr.module.remote.fssc.service.impl.PersonalLoanServiceImplService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.13
 * 2014-03-19T13:59:57.062+08:00
 * Generated source version: 2.6.13
 * 
 */
public final class PersonalLoanService_PersonalLoanServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.service.fssc.remote.module.nhr.deppon.com/", "PersonalLoanServiceImplService");

    private PersonalLoanService_PersonalLoanServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = PersonalLoanServiceImplService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        PersonalLoanServiceImplService ss = new PersonalLoanServiceImplService(wsdlURL, SERVICE_NAME);
        PersonalLoanService port = ss.getPersonalLoanServiceImplPort();  
        
        {
        System.out.println("Invoking addLoanAmount...");
        com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanAmountRequest _addLoanAmount_loanAmountRequest = new com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanAmountRequest();
        com.deppon.esb.header.ESBHeader _addLoanAmount_esbHeaderVal = new com.deppon.esb.header.ESBHeader();
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> _addLoanAmount_esbHeader = new javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader>(_addLoanAmount_esbHeaderVal);
        try {
            com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanAmountResponse _addLoanAmount__return = port.addLoanAmount(_addLoanAmount_loanAmountRequest, _addLoanAmount_esbHeader);
            System.out.println("addLoanAmount.result=" + _addLoanAmount__return);

            System.out.println("addLoanAmount._addLoanAmount_esbHeader=" + _addLoanAmount_esbHeader.value);
        } catch (CommonException e) { 
            System.out.println("Expected exception: CommonException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking queryLoanStatus...");
        com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanStatusRequest _queryLoanStatus_loanStatusRequest = new com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanStatusRequest();
        com.deppon.esb.header.ESBHeader _queryLoanStatus_esbHeaderVal = new com.deppon.esb.header.ESBHeader();
        javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader> _queryLoanStatus_esbHeader = new javax.xml.ws.Holder<com.deppon.esb.header.ESBHeader>(_queryLoanStatus_esbHeaderVal);
        try {
            com.deppon.nhr.module.remote.fssc.shared.domain.personalloan.LoanStatusResponse _queryLoanStatus__return = port.queryLoanStatus(_queryLoanStatus_loanStatusRequest, _queryLoanStatus_esbHeader);
            System.out.println("queryLoanStatus.result=" + _queryLoanStatus__return);

            System.out.println("queryLoanStatus._queryLoanStatus_esbHeader=" + _queryLoanStatus_esbHeader.value);
        } catch (CommonException e) { 
            System.out.println("Expected exception: CommonException has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
