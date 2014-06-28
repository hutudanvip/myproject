
package com.deppon.nhr.module.remote.fssc.shared.domain.personalloan;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoanAmountDetail complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LoanAmountDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cperiod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="psncode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="psnstate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="loanmony" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanAmountDetail", propOrder = {
    "cperiod",
    "psncode",
    "psnstate",
    "loanmony"
})
public class LoanAmountDetail {

    @XmlElement(required = true)
    protected String cperiod;
    @XmlElement(required = true)
    protected String psncode;
    @XmlElement(required = true)
    protected String psnstate;
    @XmlElement(required = true)
    protected BigDecimal loanmony;

    /**
     * 获取cperiod属性的值。
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
     * 设置cperiod属性的值。
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
     * 获取psncode属性的值。
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
     * 设置psncode属性的值。
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
     * 获取psnstate属性的值。
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
     * 设置psnstate属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPsnstate(String value) {
        this.psnstate = value;
    }

    /**
     * 获取loanmony属性的值。
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
     * 设置loanmony属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLoanmony(BigDecimal value) {
        this.loanmony = value;
    }

}
