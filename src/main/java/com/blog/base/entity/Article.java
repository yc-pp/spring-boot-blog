package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Long oid;

    private String articletitle;

    private String articleimgurl;

    private Integer articlecategoryid;

    private String articlecategoryname;

    private String articletags;

    private Long articleauthorid;

    private Byte articlestatus;

    private Long articleviewcount;

    private Byte articlecommentable;

    private String articlepermalink;

    private Long articlecommentcount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date articlecreated;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date articleupdated;

    private String articlecontent;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getArticletitle() {
        return articletitle;
    }

    public void setArticletitle(String articletitle) {
        this.articletitle = articletitle == null ? null : articletitle.trim();
    }

    public String getArticleimgurl() {
        return articleimgurl;
    }

    public void setArticleimgurl(String articleimgurl) {
        this.articleimgurl = articleimgurl == null ? null : articleimgurl.trim();
    }

    public Integer getArticlecategoryid() {
        return articlecategoryid;
    }

    public void setArticlecategoryid(Integer articlecategoryid) {
        this.articlecategoryid = articlecategoryid;
    }

    public String getArticlecategoryname() {
        return articlecategoryname;
    }

    public void setArticlecategoryname(String articlecategoryname) {
        this.articlecategoryname = articlecategoryname == null ? null : articlecategoryname.trim();
    }

    public String getArticletags() {
        return articletags;
    }

    public void setArticletags(String articletags) {
        this.articletags = articletags == null ? null : articletags.trim();
    }

    public Long getArticleauthorid() {
        return articleauthorid;
    }

    public void setArticleauthorid(Long articleauthorid) {
        this.articleauthorid = articleauthorid;
    }

    public Byte getArticlestatus() {
        return articlestatus;
    }

    public void setArticlestatus(Byte articlestatus) {
        this.articlestatus = articlestatus;
    }

    public Long getArticleviewcount() {
        return articleviewcount;
    }

    public void setArticleviewcount(Long articleviewcount) {
        this.articleviewcount = articleviewcount;
    }

    public Byte getArticlecommentable() {
        return articlecommentable;
    }

    public void setArticlecommentable(Byte articlecommentable) {
        this.articlecommentable = articlecommentable;
    }

    public String getArticlepermalink() {
        return articlepermalink;
    }

    public void setArticlepermalink(String articlepermalink) {
        this.articlepermalink = articlepermalink == null ? null : articlepermalink.trim();
    }

    public Long getArticlecommentcount() {
        return articlecommentcount;
    }

    public void setArticlecommentcount(Long articlecommentcount) {
        this.articlecommentcount = articlecommentcount;
    }

    public Date getArticlecreated() {
        return articlecreated;
    }

    public void setArticlecreated(Date articlecreated) {
        this.articlecreated = articlecreated;
    }

    public Date getArticleupdated() {
        return articleupdated;
    }

    public void setArticleupdated(Date articleupdated) {
        this.articleupdated = articleupdated;
    }

    public String getArticlecontent() {
        return articlecontent;
    }

    public void setArticlecontent(String articlecontent) {
        this.articlecontent = articlecontent == null ? null : articlecontent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", articletitle=").append(articletitle);
        sb.append(", articleimgurl=").append(articleimgurl);
        sb.append(", articlecategoryid=").append(articlecategoryid);
        sb.append(", articlecategoryname=").append(articlecategoryname);
        sb.append(", articletags=").append(articletags);
        sb.append(", articleauthorid=").append(articleauthorid);
        sb.append(", articlestatus=").append(articlestatus);
        sb.append(", articleviewcount=").append(articleviewcount);
        sb.append(", articlecommentable=").append(articlecommentable);
        sb.append(", articlepermalink=").append(articlepermalink);
        sb.append(", articlecommentcount=").append(articlecommentcount);
        sb.append(", articlecreated=").append(articlecreated);
        sb.append(", articleupdated=").append(articleupdated);
        sb.append(", articlecontent=").append(articlecontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}