
package com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SynCarErrorRptRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡclaimInfo���Ե�ֵ��
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
     * ����claimInfo���Ե�ֵ��
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
