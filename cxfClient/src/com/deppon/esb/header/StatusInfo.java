
package com.deppon.esb.header;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>StatusInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡstatusId���Ե�ֵ��
     * 
     */
    public int getStatusId() {
        return statusId;
    }

    /**
     * ����statusId���Ե�ֵ��
     * 
     */
    public void setStatusId(int value) {
        this.statusId = value;
    }

    /**
     * ��ȡtimeStamp���Ե�ֵ��
     * 
     */
    public long getTimeStamp() {
        return timeStamp;
    }

    /**
     * ����timeStamp���Ե�ֵ��
     * 
     */
    public void setTimeStamp(long value) {
        this.timeStamp = value;
    }

}
