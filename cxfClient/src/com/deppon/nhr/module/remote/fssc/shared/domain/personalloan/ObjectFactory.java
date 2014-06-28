
package com.deppon.nhr.module.remote.fssc.shared.domain.personalloan;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.deppon.nhr.module.remote.fssc.shared.domain.personalloan package. 
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

    private final static QName _LoanStatusRequest_QNAME = new QName("http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", "loanStatusRequest");
    private final static QName _LoanAmountRequest_QNAME = new QName("http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", "loanAmountRequest");
    private final static QName _LoanStatusResponse_QNAME = new QName("http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", "loanStatusResponse");
    private final static QName _LoanAmountResponse_QNAME = new QName("http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", "loanAmountResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.deppon.nhr.module.remote.fssc.shared.domain.personalloan
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoanStatusRequest }
     * 
     */
    public LoanStatusRequest createLoanStatusRequest() {
        return new LoanStatusRequest();
    }

    /**
     * Create an instance of {@link LoanAmountRequest }
     * 
     */
    public LoanAmountRequest createLoanAmountRequest() {
        return new LoanAmountRequest();
    }

    /**
     * Create an instance of {@link LoanStatusResponse }
     * 
     */
    public LoanStatusResponse createLoanStatusResponse() {
        return new LoanStatusResponse();
    }

    /**
     * Create an instance of {@link LoanAmountResponse }
     * 
     */
    public LoanAmountResponse createLoanAmountResponse() {
        return new LoanAmountResponse();
    }

    /**
     * Create an instance of {@link LoanStatusDetail }
     * 
     */
    public LoanStatusDetail createLoanStatusDetail() {
        return new LoanStatusDetail();
    }

    /**
     * Create an instance of {@link LoanParamDetail }
     * 
     */
    public LoanParamDetail createLoanParamDetail() {
        return new LoanParamDetail();
    }

    /**
     * Create an instance of {@link LoanAmountDetail }
     * 
     */
    public LoanAmountDetail createLoanAmountDetail() {
        return new LoanAmountDetail();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoanStatusRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", name = "loanStatusRequest")
    public JAXBElement<LoanStatusRequest> createLoanStatusRequest(LoanStatusRequest value) {
        return new JAXBElement<LoanStatusRequest>(_LoanStatusRequest_QNAME, LoanStatusRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoanAmountRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", name = "loanAmountRequest")
    public JAXBElement<LoanAmountRequest> createLoanAmountRequest(LoanAmountRequest value) {
        return new JAXBElement<LoanAmountRequest>(_LoanAmountRequest_QNAME, LoanAmountRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoanStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", name = "loanStatusResponse")
    public JAXBElement<LoanStatusResponse> createLoanStatusResponse(LoanStatusResponse value) {
        return new JAXBElement<LoanStatusResponse>(_LoanStatusResponse_QNAME, LoanStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoanAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan", name = "loanAmountResponse")
    public JAXBElement<LoanAmountResponse> createLoanAmountResponse(LoanAmountResponse value) {
        return new JAXBElement<LoanAmountResponse>(_LoanAmountResponse_QNAME, LoanAmountResponse.class, null, value);
    }

}
