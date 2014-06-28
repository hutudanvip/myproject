
package com.deppon.foss.module.advance.server.service.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice.SynCarErrorRptRequest;
import com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice.SynCarErrorRptResponse;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.foss.module.advance.server.service.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SynCarErrorRptRequest_QNAME = new QName("http://www.deppon.com/foss/module/advance/server/service/webservice/", "synCarErrorRptRequest");
    private final static QName _SynCarErrorRptResponse_QNAME = new QName("http://www.deppon.com/foss/module/advance/server/service/webservice/", "synCarErrorRptResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.foss.module.advance.server.service.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SynCarErrorRptRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/foss/module/advance/server/service/webservice/", name = "synCarErrorRptRequest")
    public JAXBElement<SynCarErrorRptRequest> createSynCarErrorRptRequest(SynCarErrorRptRequest value) {
        return new JAXBElement<SynCarErrorRptRequest>(_SynCarErrorRptRequest_QNAME, SynCarErrorRptRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SynCarErrorRptResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/foss/module/advance/server/service/webservice/", name = "synCarErrorRptResponse")
    public JAXBElement<SynCarErrorRptResponse> createSynCarErrorRptResponse(SynCarErrorRptResponse value) {
        return new JAXBElement<SynCarErrorRptResponse>(_SynCarErrorRptResponse_QNAME, SynCarErrorRptResponse.class, null, value);
    }

}
