package com.blog.base.entity;

import java.io.Serializable;

public class Category implements Serializable {
    private Long oid;

    private String categorytitle;

    private String categoryuri;

    private String categorydescription;

    private String categoryorder;

    private String categorytagcnt;

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
        this.categorytitle = categorytitle == null ? null : categorytitle.trim();
    }

    public String getCategoryuri() {
        return categoryuri;
    }

    public void setCategoryuri(String categoryuri) {
        this.categoryuri = categoryuri == null ? null : categoryuri.trim();
    }

    public String getCategorydescription() {
        return categorydescription;
    }

    public void setCategorydescription(String categorydescription) {
        this.categorydescription = categorydescription == null ? null : categorydescription.trim();
    }

    public String getCategoryorder() {
        return categoryorder;
    }

    public void setCategoryorder(String categoryorder) {
        this.categoryorder = categoryorder == null ? null : categoryorder.trim();
    }

    public String getCategorytagcnt() {
        return categorytagcnt;
    }

    public void setCategorytagcnt(String categorytagcnt) {
        this.categorytagcnt = categorytagcnt == null ? null : categorytagcnt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", categorytitle=").append(categorytitle);
        sb.append(", categoryuri=").append(categoryuri);
        sb.append(", categorydescription=").append(categorydescription);
        sb.append(", categoryorder=").append(categoryorder);
        sb.append(", categorytagcnt=").append(categorytagcnt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}