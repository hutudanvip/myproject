package com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.6.13
 * 2014-05-09T09:28:08.280+08:00
 * Generated source version: 2.6.13
 * 
 */
@WebServiceClient(name = "ISynCarErrorServiceService", 
                  wsdlLocation = "http://localhost:9090/financManager/webservice/claimsInterService?wsdl",
                  targetNamespace = "http://www.deppon.com/foss/module/advance/server/service/webservice/interface/FinSynCarErrorService") 
public class ISynCarErrorServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.deppon.com/foss/module/advance/server/service/webservice/interface/FinSynCarErrorService", "ISynCarErrorServiceService");
    public final static QName ISynCarErrorServicePort = new QName("http://www.deppon.com/foss/module/advance/server/service/webservice/interface/FinSynCarErrorService", "ISynCarErrorServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9090/financManager/webservice/claimsInterService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ISynCarErrorServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:9090/financManager/webservice/claimsInterService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ISynCarErrorServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ISynCarErrorServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ISynCarErrorServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns ISynCarErrorService
     */
    @WebEndpoint(name = "ISynCarErrorServicePort")
    public ISynCarErrorService getISynCarErrorServicePort() {
        return super.getPort(ISynCarErrorServicePort, ISynCarErrorService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ISynCarErrorService
     */
    @WebEndpoint(name = "ISynCarErrorServicePort")
    public ISynCarErrorService getISynCarErrorServicePort(WebServiceFeature... features) {
        return super.getPort(ISynCarErrorServicePort, ISynCarErrorService.class, features);
    }

}
