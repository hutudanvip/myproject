
package com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SynCarErrorRptRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SynCarErrorRptRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="claimInfo" type="{http://www.deppon.com/foss/module/advance/server/service/webservice/interface/FinSynCarErrorService}ClaimInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SynCarErrorRptRequest", propOrder = {
    "claimInfo"
})
public class SynCarErrorRptRequest {

    @XmlElement(required = true)
    protected ClaimInfo claimInfo;

    /**
     * 获取claimInfo属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ClaimInfo }
     *     
     */
    public ClaimInfo getClaimInfo() {
        return claimInfo;
    }

    /**
     * 设置claimInfo属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ClaimInfo }
     *     
     */
    public void setClaimInfo(ClaimInfo value) {
        this.claimInfo = value;
    }

}
