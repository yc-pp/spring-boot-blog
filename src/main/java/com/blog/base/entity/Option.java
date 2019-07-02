package com.blog.base.entity;

import java.io.Serializable;

public class Option implements Serializable {
    private Long oid;

    private String optionvalue;

    private String optioncategory;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getOptionvalue() {
        return optionvalue;
    }

    public void setOptionvalue(String optionvalue) {
        this.optionvalue = optionvalue == null ? null : optionvalue.trim();
    }

    public String getOptioncategory() {
        return optioncategory;
    }

    public void setOptioncategory(String optioncategory) {
        this.optioncategory = optioncategory == null ? null : optioncategory.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", optionvalue=").append(optionvalue);
        sb.append(", optioncategory=").append(optioncategory);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}