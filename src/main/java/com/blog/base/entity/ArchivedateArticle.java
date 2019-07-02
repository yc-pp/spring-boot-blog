package com.blog.base.entity;

import java.io.Serializable;

public class ArchivedateArticle implements Serializable {
    private Long oid;

    private Long archivedateOid;

    private Long articleOid;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getArchivedateOid() {
        return archivedateOid;
    }

    public void setArchivedateOid(Long archivedateOid) {
        this.archivedateOid = archivedateOid;
    }

    public Long getArticleOid() {
        return articleOid;
    }

    public void setArticleOid(Long articleOid) {
        this.articleOid = articleOid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", archivedateOid=").append(archivedateOid);
        sb.append(", articleOid=").append(articleOid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}