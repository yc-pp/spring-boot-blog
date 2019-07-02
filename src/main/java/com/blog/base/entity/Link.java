package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Link implements Serializable {
    private Long oid;

    private String linkaddress;

    private String linkdescription;

    private String linkorder;

    private String linktitle;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getLinkaddress() {
        return linkaddress;
    }

    public void setLinkaddress(String linkaddress) {
        this.linkaddress = linkaddress == null ? null : linkaddress.trim();
    }

    public String getLinkdescription() {
        return linkdescription;
    }

    public void setLinkdescription(String linkdescription) {
        this.linkdescription = linkdescription == null ? null : linkdescription.trim();
    }

    public String getLinkorder() {
        return linkorder;
    }

    public void setLinkorder(String linkorder) {
        this.linkorder = linkorder == null ? null : linkorder.trim();
    }

    public String getLinktitle() {
        return linktitle;
    }

    public void setLinktitle(String linktitle) {
        this.linktitle = linktitle == null ? null : linktitle.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", linkaddress=").append(linkaddress);
        sb.append(", linkdescription=").append(linkdescription);
        sb.append(", linkorder=").append(linkorder);
        sb.append(", linktitle=").append(linktitle);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}