
package com.deppon.esb.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StatusInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="StatusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeStamp" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusInfo", propOrder = {
    "statusId",
    "timeStamp"
})
public class StatusInfo {

    protected int statusId;
    protected long timeStamp;

    /**
     * 获取statusId属性的值。
     * 
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * 设置statusId属性的值。
     * 
     */
    public void setStatusId(int value) {
        this.statusId = value;
    }

    /**
     * 获取timeStamp属性的值。
     * 
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * 设置timeStamp属性的值。
     * 
     */
    public void setTimeStamp(long value) {
        this.timeStamp = value;
    }

}
