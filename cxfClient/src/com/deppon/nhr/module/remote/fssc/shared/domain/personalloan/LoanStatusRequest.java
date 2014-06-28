
package com.deppon.nhr.module.remote.fssc.shared.domain.personalloan;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LoanStatusRequest complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LoanStatusRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="loanParamDetail" type="{http://www.deppon.com/nhr/module/remote/fssc/shared/domain/personalloan}LoanParamDetail" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanStatusRequest", propOrder = {
    "loanParamDetail"
})
public class LoanStatusRequest {

    @XmlElement(required = true, nillable = true)
    protected List<LoanParamDetail> loanParamDetail;

    /**
     * Gets the value of the loanParamDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loanParamDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoanParamDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoanParamDetail }
     * 
     * 
     */
    public List<LoanParamDetail> getLoanParamDetail() {
        if (loanParamDetail == null) {
            loanParamDetail = new ArrayList<LoanParamDetail>();
        }
        return this.loanParamDetail;
    }

}
