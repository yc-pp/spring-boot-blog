package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Long oid;

    private String categorytitle;

    private String categoryuri;

    private String categorydescription;

    private String categoryorder;

    private String categorytagcnt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createdate;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getCategorytitle() {
        return categorytitle;
    }

    public void setCategorytitle(String categorytitle) {
        this.categorytitle = categorytitle;
    }

    public String getCategoryuri() {
        return categoryuri;
    }

    public void setCategoryuri(String categoryuri) {
        this.categoryuri = categoryuri;
    }

    public String getCategorydescription() {
        return categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        this.categorydescription = categorydescription;
    }

    public String getCategoryorder() {
        return categoryorder;
    }

    public void setCategoryorder(String categoryorder) {
        this.categoryorder = categoryorder;
    }

    public String getCategorytagcnt() {
        return categorytagcnt;
    }

    public void setCategorytagcnt(String categorytagcnt) {
        this.categorytagcnt = categorytagcnt;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Category{");
        sb.append("oid=").append(oid);
        sb.append(", categorytitle='").append(categorytitle).append('\'');
        sb.append(", categoryuri='").append(categoryuri).append('\'');
        sb.append(", categorydescription='").append(categorydescription).append('\'');
        sb.append(", categoryorder='").append(categoryorder).append('\'');
        sb.append(", categorytagcnt='").append(categorytagcnt).append('\'');
        sb.append(", createdate=").append(createdate);
        sb.append('}');
        return sb.toString();
    }
}