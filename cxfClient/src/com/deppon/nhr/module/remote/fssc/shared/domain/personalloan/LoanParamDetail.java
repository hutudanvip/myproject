
package com.deppon.nhr.module.remote.fssc.shared.domain.personalloan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoanParamDetail complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LoanParamDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cperiod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="psncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="psnstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanParamDetail", propOrder = {
    "cperiod",
    "psncode",
    "psnstate"
})
public class LoanParamDetail {

    @XmlElement(required = true)
    protected String cperiod;
    @XmlElement(required = true)
    protected String psncode;
    @XmlElement(required = true)
    protected String psnstate;

    /**
     * ��ȡcperiod���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCperiod() {
        return cperiod;
    }

    /**
     * ����cperiod���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCperiod(String value) {
        this.cperiod = value;
    }

    /**
     * ��ȡpsncode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsncode() {
        return psncode;
    }

    /**
     * ����psncode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsncode(String value) {
        this.psncode = value;
    }

    /**
     * ��ȡpsnstate���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPsnstate() {
        return psnstate;
    }

    /**
     * ����psnstate���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsnstate(String value) {
        this.psnstate = value;
    }

}
