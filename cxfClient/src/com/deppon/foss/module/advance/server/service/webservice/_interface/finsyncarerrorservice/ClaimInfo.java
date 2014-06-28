
package com.deppon.foss.module.advance.server.service.webservice._interface.finsyncarerrorservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>ClaimInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
 *         &lt;element name="shouldCollect" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="manageDept" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dutyArea" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "accidentDesc",
    "shouldCollect",
    "manageDept",
    "dutyArea"
})
public class ClaimInfo {

    @XmlElement(required = true)
    protected String errorCode;
    @XmlElement(required = true)
    protected String plateNum;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar accidentTime;
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
    protected XMLGregorianCalendar reportTime;
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
    @XmlElement(required = true)
    protected BigDecimal shouldCollect;
    @XmlElement(required = true)
    protected String manageDept;
    @XmlElement(required = true)
    protected String dutyArea;

    /**
     * 获取errorCode属性的值。
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
     * 设置errorCode属性的值。
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
     * 获取plateNum属性的值。
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
     * 设置plateNum属性的值。
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
     * 获取accidentTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAccidentTime() {
        return accidentTime;
    }

    /**
     * 设置accidentTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAccidentTime(XMLGregorianCalendar value) {
        this.accidentTime = value;
    }

    /**
     * 获取carType属性的值。
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
     * 设置carType属性的值。
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
     * 获取carTypeName属性的值。
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
     * 设置carTypeName属性的值。
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
     * 获取errorType属性的值。
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
     * 设置errorType属性的值。
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
     * 获取errorTypeName属性的值。
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
     * 设置errorTypeName属性的值。
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
     * 获取backCode属性的值。
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
     * 设置backCode属性的值。
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
     * 获取dutyStyle属性的值。
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
     * 设置dutyStyle属性的值。
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
     * 获取dutyStyleName属性的值。
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
     * 设置dutyStyleName属性的值。
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
     * 获取dutyType属性的值。
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
     * 设置dutyType属性的值。
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
     * 获取dutyTypeName属性的值。
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
     * 设置dutyTypeName属性的值。
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
     * 获取isAssessed属性的值。
     * 
     */
    public boolean isIsAssessed() {
        return isAssessed;
    }

    /**
     * 设置isAssessed属性的值。
     * 
     */
    public void setIsAssessed(boolean value) {
        this.isAssessed = value;
    }

    /**
     * 获取isTakeAssessed属性的值。
     * 
     */
    public boolean isIsTakeAssessed() {
        return isTakeAssessed;
    }

    /**
     * 设置isTakeAssessed属性的值。
     * 
     */
    public void setIsTakeAssessed(boolean value) {
        this.isTakeAssessed = value;
    }

    /**
     * 获取ourAssessedCost属性的值。
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
     * 设置ourAssessedCost属性的值。
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
     * 获取otherAssessedCost属性的值。
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
     * 设置otherAssessedCost属性的值。
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
     * 获取ourIndemnity属性的值。
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
     * 设置ourIndemnity属性的值。
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
     * 获取otherIndemnity属性的值。
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
     * 设置otherIndemnity属性的值。
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
     * 获取insuranceCom属性的值。
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
     * 设置insuranceCom属性的值。
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
     * 获取accidentCost属性的值。
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
     * 设置accidentCost属性的值。
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
     * 获取driverNum属性的值。
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
     * 设置driverNum属性的值。
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
     * 获取driverName属性的值。
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
     * 设置driverName属性的值。
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
     * 获取driverDept属性的值。
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
     * 设置driverDept属性的值。
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
     * 获取reportTime属性的值。
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReportTime() {
        return reportTime;
    }

    /**
     * 设置reportTime属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReportTime(XMLGregorianCalendar value) {
        this.reportTime = value;
    }

    /**
     * 获取reportDept属性的值。
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
     * 设置reportDept属性的值。
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
     * 获取operateName属性的值。
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
     * 设置operateName属性的值。
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
     * 获取dutyCareerDept属性的值。
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
     * 设置dutyCareerDept属性的值。
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
     * 获取trackDept属性的值。
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
     * 设置trackDept属性的值。
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
     * 获取accidentDesc属性的值。
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
     * 设置accidentDesc属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccidentDesc(String value) {
        this.accidentDesc = value;
    }

    /**
     * 获取shouldCollect属性的值。
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getShouldCollect() {
        return shouldCollect;
    }

    /**
     * 设置shouldCollect属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setShouldCollect(BigDecimal value) {
        this.shouldCollect = value;
    }

    /**
     * 获取manageDept属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManageDept() {
        return manageDept;
    }

    /**
     * 设置manageDept属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManageDept(String value) {
        this.manageDept = value;
    }

    /**
     * 获取dutyArea属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDutyArea() {
        return dutyArea;
    }

    /**
     * 设置dutyArea属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDutyArea(String value) {
        this.dutyArea = value;
    }

}
