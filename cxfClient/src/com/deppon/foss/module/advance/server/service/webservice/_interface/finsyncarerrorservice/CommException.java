
package com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.13
 * 2014-05-09T09:28:08.251+08:00
 * Generated source version: 2.6.13
 */

@WebFault(name = "commonExceptionInfo", targetNamespace = "http://www.deppon.com/esb/exception")
public class CommException extends Exception {
    
    private com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo;

    public CommException() {
        super();
    }
    
    public CommException(String message) {
        super(message);
    }
    
    public CommException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommException(String message, com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo) {
        super(message);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public CommException(String message, com.deppon.esb.exception.CommonExceptionInfo commonExceptionInfo, Throwable cause) {
        super(message, cause);
        this.commonExceptionInfo = commonExceptionInfo;
    }

    public com.deppon.esb.exception.CommonExceptionInfo getFaultInfo() {
        return this.commonExceptionInfo;
    }
}