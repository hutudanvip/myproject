
package com.deppon.nhr.module.remote.fssc.shared.domain.personalloan;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoanAmountRequest complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="LoanAmountRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loanAmountDetail" type="{http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan}LoanAmountDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanAmountRequest", propOrder = {
    "loanAmountDetail"
})
public class LoanAmountRequest {

    @XmlElement(required = true, nillable = true)
    protected List<LoanAmountDetail> loanAmountDetail;

    /**
     * Gets the value of the loanAmountDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loanAmountDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoanAmountDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoanAmountDetail }
     * 
     * 
     */
    public List<LoanAmountDetail> getLoanAmountDetail() {
        if (loanAmountDetail == null) {
            loanAmountDetail = new ArrayList<LoanAmountDetail>();
        }
        return this.loanAmountDetail;
    }

}
