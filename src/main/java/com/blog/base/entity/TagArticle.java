package com.blog.base.entity;

import java.io.Serializable;

public class TagArticle implements Serializable {
    private Long oid;

    private Long articleOid;

    private Long tagOid;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getArticleOid() {
        return articleOid;
    }

    public void setArticleOid(Long articleOid) {
        this.articleOid = articleOid;
    }

    public Long getTagOid() {
        return tagOid;
    }

    public void setTagOid(Long tagOid) {
        this.tagOid = tagOid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", articleOid=").append(articleOid);
        sb.append(", tagOid=").append(tagOid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}