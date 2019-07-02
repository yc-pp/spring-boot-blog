package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    private Long oid;

    private String articletitle;

    private String articleabstract;

    private String articleabstracttext;

    private String articletags;

    private Long articleauthorid;

    private String articlecommentcount;

    private String articleviewcount;

    private String articlepermalink;

    private String articleputtop;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date articlecreated;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date articleupdated;

    private Double articlerandomdouble;

    private String articlesignid;

    private String articlecommentable;

    private String articleviewpwd;

    private String articleimg1url;

    private String articlestatus;

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

    public String getArticleabstract() {
        return articleabstract;
    }

    public void setArticleabstract(String articleabstract) {
        this.articleabstract = articleabstract == null ? null : articleabstract.trim();
    }

    public String getArticleabstracttext() {
        return articleabstracttext;
    }

    public void setArticleabstracttext(String articleabstracttext) {
        this.articleabstracttext = articleabstracttext == null ? null : articleabstracttext.trim();
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

    public String getArticlecommentcount() {
        return articlecommentcount;
    }

    public void setArticlecommentcount(String articlecommentcount) {
        this.articlecommentcount = articlecommentcount == null ? null : articlecommentcount.trim();
    }

    public String getArticleviewcount() {
        return articleviewcount;
    }

    public void setArticleviewcount(String articleviewcount) {
        this.articleviewcount = articleviewcount == null ? null : articleviewcount.trim();
    }

    public String getArticlepermalink() {
        return articlepermalink;
    }

    public void setArticlepermalink(String articlepermalink) {
        this.articlepermalink = articlepermalink == null ? null : articlepermalink.trim();
    }

    public String getArticleputtop() {
        return articleputtop;
    }

    public void setArticleputtop(String articleputtop) {
        this.articleputtop = articleputtop == null ? null : articleputtop.trim();
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

    public Double getArticlerandomdouble() {
        return articlerandomdouble;
    }

    public void setArticlerandomdouble(Double articlerandomdouble) {
        this.articlerandomdouble = articlerandomdouble;
    }

    public String getArticlesignid() {
        return articlesignid;
    }

    public void setArticlesignid(String articlesignid) {
        this.articlesignid = articlesignid == null ? null : articlesignid.trim();
    }

    public String getArticlecommentable() {
        return articlecommentable;
    }

    public void setArticlecommentable(String articlecommentable) {
        this.articlecommentable = articlecommentable == null ? null : articlecommentable.trim();
    }

    public String getArticleviewpwd() {
        return articleviewpwd;
    }

    public void setArticleviewpwd(String articleviewpwd) {
        this.articleviewpwd = articleviewpwd == null ? null : articleviewpwd.trim();
    }

    public String getArticleimg1url() {
        return articleimg1url;
    }

    public void setArticleimg1url(String articleimg1url) {
        this.articleimg1url = articleimg1url == null ? null : articleimg1url.trim();
    }

    public String getArticlestatus() {
        return articlestatus;
    }

    public void setArticlestatus(String articlestatus) {
        this.articlestatus = articlestatus == null ? null : articlestatus.trim();
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
        sb.append(", articleabstract=").append(articleabstract);
        sb.append(", articleabstracttext=").append(articleabstracttext);
        sb.append(", articletags=").append(articletags);
        sb.append(", articleauthorid=").append(articleauthorid);
        sb.append(", articlecommentcount=").append(articlecommentcount);
        sb.append(", articleviewcount=").append(articleviewcount);
        sb.append(", articlepermalink=").append(articlepermalink);
        sb.append(", articleputtop=").append(articleputtop);
        sb.append(", articlecreated=").append(articlecreated);
        sb.append(", articleupdated=").append(articleupdated);
        sb.append(", articlerandomdouble=").append(articlerandomdouble);
        sb.append(", articlesignid=").append(articlesignid);
        sb.append(", articlecommentable=").append(articlecommentable);
        sb.append(", articleviewpwd=").append(articleviewpwd);
        sb.append(", articleimg1url=").append(articleimg1url);
        sb.append(", articlestatus=").append(articlestatus);
        sb.append(", articlecontent=").append(articlecontent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}