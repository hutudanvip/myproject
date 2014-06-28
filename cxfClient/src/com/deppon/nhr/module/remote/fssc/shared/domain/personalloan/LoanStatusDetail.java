
package com.deppon.nhr.module.remote.fssc.shared.domain.personalloan;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoanStatusDetail complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LoanStatusDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cperiod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="psncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanmony" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="settlestatus" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanStatusDetail", propOrder = {
    "cperiod",
    "psncode",
    "loanmony",
    "settlestatus"
})
public class LoanStatusDetail {

    @XmlElement(required = true)
    protected String cperiod;
    @XmlElement(required = true)
    protected String psncode;
    @XmlElement(required = true)
    protected BigDecimal loanmony;
    @XmlElement(required = true)
    protected BigInteger settlestatus;

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
     * ��ȡloanmony���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLoanmony() {
        return loanmony;
    }

    /**
     * ����loanmony���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLoanmony(BigDecimal value) {
        this.loanmony = value;
    }

    /**
     * ��ȡsettlestatus���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSettlestatus() {
        return settlestatus;
    }

    /**
     * ����settlestatus���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSettlestatus(BigInteger value) {
        this.settlestatus = value;
    }

}
