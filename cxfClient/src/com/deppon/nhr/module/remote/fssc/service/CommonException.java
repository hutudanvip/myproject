
package com.deppon.nhr.module.remote.fssc.service;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.13
 * 2014-03-19T13:59:57.125+08:00
 * Generated source version: 2.6.13
 */

@WebFault(name = "commonExceptionInfo", targetNamespace = "http://www.deppon.com/esb/exception")
public class CommonException extends Exception {
    
    private com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo;

    public CommonException() {
        super();
    }
    
    public CommonException(String message) {
        super(message);
    }
    
    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(String message, com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo) {
        super(message);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public CommonException(String message, com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo, Throwable cause) {
        super(message, cause);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public com.deppon.esb.exception.CommonExceptionInfo getFaultInfo() {
        return this.commonExceptionInfo;
    }
}
