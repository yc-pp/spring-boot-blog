package com.blog.base.vo;

import com.blog.base.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class BlogVO {
    private Long oid;

    private String articletitle;

    private String articleimgurl;

    private Long articlecategoryid;

    private String articlecategoryname;

    private List<String> articletags;

    private List<Comment> comments;

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
        this.articletitle = articletitle;
    }

    public String getArticleimgurl() {
        return articleimgurl;
    }

    public void setArticleimgurl(String articleimgurl) {
        this.articleimgurl = articleimgurl;
    }

    public Long getArticlecategoryid() {
        return articlecategoryid;
    }

    public void setArticlecategoryid(Long articlecategoryid) {
        this.articlecategoryid = articlecategoryid;
    }

    public String getArticlecategoryname() {
        return articlecategoryname;
    }

    public void setArticlecategoryname(String articlecategoryname) {
        this.articlecategoryname = articlecategoryname;
    }

    public List<String> getArticletags() {
        return articletags;
    }

    public void setArticletags(List<String> articletags) {
        this.articletags = articletags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
        this.articlepermalink = articlepermalink;
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
        this.articlecontent = articlecontent;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BlogVO{");
        sb.append("oid=").append(oid);
        sb.append(", articletitle='").append(articletitle).append('\'');
        sb.append(", articleimgurl='").append(articleimgurl).append('\'');
        sb.append(", articlecategoryid=").append(articlecategoryid);
        sb.append(", articlecategoryname='").append(articlecategoryname).append('\'');
        sb.append(", articletags=").append(articletags);
        sb.append(", comments=").append(comments);
        sb.append(", articleauthorid=").append(articleauthorid);
        sb.append(", articlestatus=").append(articlestatus);
        sb.append(", articleviewcount=").append(articleviewcount);
        sb.append(", articlecommentable=").append(articlecommentable);
        sb.append(", articlepermalink='").append(articlepermalink).append('\'');
        sb.append(", articlecommentcount=").append(articlecommentcount);
        sb.append(", articlecreated=").append(articlecreated);
        sb.append(", articleupdated=").append(articleupdated);
        sb.append(", articlecontent='").append(articlecontent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
