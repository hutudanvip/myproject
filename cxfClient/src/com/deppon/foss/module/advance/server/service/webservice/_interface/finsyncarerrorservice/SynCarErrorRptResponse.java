
package com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SynCarErrorRptResponse complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="SynCarErrorRptResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isSucess" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="failReason" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SynCarErrorRptResponse", propOrder = {
    "isSucess",
    "failReason"
})
public class SynCarErrorRptResponse {

    protected boolean isSucess;
    @XmlElement(required = true)
    protected String failReason;

    /**
     * 获取isSucess属性的值。
     * 
     */
    public boolean isIsSucess() {
        return isSucess;
    }

    /**
     * 设置isSucess属性的值。
     * 
     */
    public void setIsSucess(boolean value) {
        this.isSucess = value;
    }

    /**
     * 获取failReason属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFailReason() {
        return failReason;
    }

    /**
     * 设置failReason属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFailReason(String value) {
        this.failReason = value;
    }

}
