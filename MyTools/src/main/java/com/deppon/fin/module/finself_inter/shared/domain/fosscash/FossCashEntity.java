package com.deppon.fin.module.finself_inter.shared.domain.fosscash;

import java.math.BigDecimal;
import java.util.Date;

public class FossCashEntity {
    private String id;

    private Date cashdate;

    private String depthnum;

    private String deptname;

    private BigDecimal cashamt;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCashdate() {
        return cashdate;
    }

    public void setCashdate(Date cashdate) {
        this.cashdate = cashdate;
    }

    public String getDepthnum() {
        return depthnum;
    }

    public void setDepthnum(String depthnum) {
        this.depthnum = depthnum == null ? null : depthnum.trim();
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname == null ? null : deptname.trim();
    }

    public BigDecimal getCashamt() {
        return cashamt;
    }

    public void setCashamt(BigDecimal cashamt) {
        this.cashamt = cashamt;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}