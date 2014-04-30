
package com.common.util.ibatis.bean;

import java.math.BigDecimal;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import oracle.sql.TIMESTAMP;


/**
 * �������ʵ�����
 * 
 * <p>ClaimInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�����ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="ClaimInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="plateNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accidentTime" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="carType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="carTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="backCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dutyStyle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dutyStyleName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dutyType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dutyTypeName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isAssessed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isTakeAssessed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ourAssessedCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="otherAssessedCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="ourIndemnity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="otherIndemnity" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="insuranceCom" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="accidentCost" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="driverNum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="driverName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="driverDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reportTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="reportDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="operateName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dutyCareerDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="trackDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accidentDesc" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClaimInfo", propOrder = {
    "errorCode",
    "plateNum",
    "accidentTime",
    "carType",
    "carTypeName",
    "errorType",
    "errorTypeName",
    "backCode",
    "dutyStyle",
    "dutyStyleName",
    "dutyType",
    "dutyTypeName",
    "isAssessed",
    "isTakeAssessed",
    "ourAssessedCost",
    "otherAssessedCost",
    "ourIndemnity",
    "otherIndemnity",
    "insuranceCom",
    "accidentCost",
    "driverNum",
    "driverName",
    "driverDept",
    "reportTime",
    "reportDept",
    "operateName",
    "dutyCareerDept",
    "trackDept",
    "accidentDesc"
})
public class ClaimInfo {

    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String plateNum;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date accidentTime;
    @XmlElement(required = true)
    protected String carType;
    @XmlElement(required = true)
    protected String carTypeName;
    @XmlElement(required = true)
    protected String errorType;
    @XmlElement(required = true)
    protected String errorTypeName;
    @XmlElement(required = true)
    protected String backCode;
    @XmlElement(required = true)
    protected String dutyStyle;
    @XmlElement(required = true)
    protected String dutyStyleName;
    @XmlElement(required = true)
    protected String dutyType;
    @XmlElement(required = true)
    protected String dutyTypeName;
    protected boolean isAssessed;
    protected boolean isTakeAssessed;
    @XmlElement(required = true)
    protected BigDecimal ourAssessedCost;
    @XmlElement(required = true)
    protected BigDecimal otherAssessedCost;
    @XmlElement(required = true)
    protected BigDecimal ourIndemnity;
    @XmlElement(required = true)
    protected BigDecimal otherIndemnity;
    @XmlElement(required = true)
    protected BigDecimal insuranceCom;
    @XmlElement(required = true)
    protected BigDecimal accidentCost;
    @XmlElement(required = true)
    protected String driverNum;
    @XmlElement(required = true)
    protected String driverName;
    @XmlElement(required = true)
    protected String driverDept;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date reportTime;
    @XmlElement(required = true)
    protected String reportDept;
    @XmlElement(required = true)
    protected String operateName;
    @XmlElement(required = true)
    protected String dutyCareerDept;
    @XmlElement(required = true)
    protected String trackDept;
    @XmlElement(required = true)
    protected String accidentDesc;

    /**
     * ��ȡerrorCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * ����errorCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * ��ȡplateNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlateNum() {
        return plateNum;
    }

    /**
     * ����plateNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlateNum(String value) {
        this.plateNum = value;
    }

    /**
     * ��ȡaccidentTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getAccidentTime() {
        return accidentTime;
    }

    /**
     * ����accidentTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccidentTime(Date value) {
        this.accidentTime = value;
    }

    /**
     * ��ȡcarType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarType() {
        return carType;
    }

    /**
     * ����carType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarType(String value) {
        this.carType = value;
    }

    /**
     * ��ȡcarTypeName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarTypeName() {
        return carTypeName;
    }

    /**
     * ����carTypeName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarTypeName(String value) {
        this.carTypeName = value;
    }

    /**
     * ��ȡerrorType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * ����errorType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorType(String value) {
        this.errorType = value;
    }

    /**
     * ��ȡerrorTypeName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorTypeName() {
        return errorTypeName;
    }

    /**
     * ����errorTypeName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorTypeName(String value) {
        this.errorTypeName = value;
    }

    /**
     * ��ȡbackCode���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackCode() {
        return backCode;
    }

    /**
     * ����backCode���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackCode(String value) {
        this.backCode = value;
    }

    /**
     * ��ȡdutyStyle���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyStyle() {
        return dutyStyle;
    }

    /**
     * ����dutyStyle���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyStyle(String value) {
        this.dutyStyle = value;
    }

    /**
     * ��ȡdutyStyleName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyStyleName() {
        return dutyStyleName;
    }

    /**
     * ����dutyStyleName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyStyleName(String value) {
        this.dutyStyleName = value;
    }

    /**
     * ��ȡdutyType���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyType() {
        return dutyType;
    }

    /**
     * ����dutyType���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyType(String value) {
        this.dutyType = value;
    }

    /**
     * ��ȡdutyTypeName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyTypeName() {
        return dutyTypeName;
    }

    /**
     * ����dutyTypeName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyTypeName(String value) {
        this.dutyTypeName = value;
    }

    /**
     * ��ȡisAssessed���Ե�ֵ��
     * 
     */
    public boolean isIsAssessed() {
        return isAssessed;
    }

    /**
     * ����isAssessed���Ե�ֵ��
     * 
     */
    public void setIsAssessed(boolean value) {
        this.isAssessed = value;
    }

    /**
     * ��ȡisTakeAssessed���Ե�ֵ��
     * 
     */
    public boolean isIsTakeAssessed() {
        return isTakeAssessed;
    }

    /**
     * ����isTakeAssessed���Ե�ֵ��
     * 
     */
    public void setIsTakeAssessed(boolean value) {
        this.isTakeAssessed = value;
    }

    /**
     * ��ȡourAssessedCost���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOurAssessedCost() {
        return ourAssessedCost;
    }

    /**
     * ����ourAssessedCost���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOurAssessedCost(BigDecimal value) {
        this.ourAssessedCost = value;
    }

    /**
     * ��ȡotherAssessedCost���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherAssessedCost() {
        return otherAssessedCost;
    }

    /**
     * ����otherAssessedCost���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherAssessedCost(BigDecimal value) {
        this.otherAssessedCost = value;
    }

    /**
     * ��ȡourIndemnity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOurIndemnity() {
        return ourIndemnity;
    }

    /**
     * ����ourIndemnity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOurIndemnity(BigDecimal value) {
        this.ourIndemnity = value;
    }

    /**
     * ��ȡotherIndemnity���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOtherIndemnity() {
        return otherIndemnity;
    }

    /**
     * ����otherIndemnity���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOtherIndemnity(BigDecimal value) {
        this.otherIndemnity = value;
    }

    /**
     * ��ȡinsuranceCom���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInsuranceCom() {
        return insuranceCom;
    }

    /**
     * ����insuranceCom���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInsuranceCom(BigDecimal value) {
        this.insuranceCom = value;
    }

    /**
     * ��ȡaccidentCost���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAccidentCost() {
        return accidentCost;
    }

    /**
     * ����accidentCost���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAccidentCost(BigDecimal value) {
        this.accidentCost = value;
    }

    /**
     * ��ȡdriverNum���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverNum() {
        return driverNum;
    }

    /**
     * ����driverNum���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverNum(String value) {
        this.driverNum = value;
    }

    /**
     * ��ȡdriverName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     * ����driverName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverName(String value) {
        this.driverName = value;
    }

    /**
     * ��ȡdriverDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDriverDept() {
        return driverDept;
    }

    /**
     * ����driverDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDriverDept(String value) {
        this.driverDept = value;
    }

    /**
     * ��ȡreportTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getReportTime() {
        return reportTime;
    }

    /**
     * ����reportTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReportTime(Date value) {
        this.reportTime = value;
    }

    /**
     * ��ȡreportDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportDept() {
        return reportDept;
    }

    /**
     * ����reportDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportDept(String value) {
        this.reportDept = value;
    }

    /**
     * ��ȡoperateName���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperateName() {
        return operateName;
    }

    /**
     * ����operateName���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperateName(String value) {
        this.operateName = value;
    }

    /**
     * ��ȡdutyCareerDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyCareerDept() {
        return dutyCareerDept;
    }

    /**
     * ����dutyCareerDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyCareerDept(String value) {
        this.dutyCareerDept = value;
    }

    /**
     * ��ȡtrackDept���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrackDept() {
        return trackDept;
    }

    /**
     * ����trackDept���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrackDept(String value) {
        this.trackDept = value;
    }

    /**
     * ��ȡaccidentDesc���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccidentDesc() {
        return accidentDesc;
    }

    /**
     * ����accidentDesc���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccidentDesc(String value) {
        this.accidentDesc = value;
    }

}
