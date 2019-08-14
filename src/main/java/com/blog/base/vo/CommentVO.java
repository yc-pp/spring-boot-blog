package com.blog.base.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CommentVO {
    private Long oid;

    private String commentcontent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentcreated;

    private String commentname;

    private Long commentonid;

    private String blogTitle;

    private String commentsharpurl;

    private String commentthumbnailurl;

    private Byte commentstatus;

    private String commenturl;

    private String replycontent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date replycreated;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent == null ? null : commentcontent.trim();
    }

    public Date getCommentcreated() {
        return commentcreated;
    }

    public void setCommentcreated(Date commentcreated) {
        this.commentcreated = commentcreated;
    }

    public String getCommentname() {
        return commentname;
    }

    public void setCommentname(String commentname) {
        this.commentname = commentname == null ? null : commentname.trim();
    }

    public Long getCommentonid() {
        return commentonid;
    }

    public void setCommentonid(Long commentonid) {
        this.commentonid = commentonid;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getCommentsharpurl() {
        return commentsharpurl;
    }

    public void setCommentsharpurl(String commentsharpurl) {
        this.commentsharpurl = commentsharpurl == null ? null : commentsharpurl.trim();
    }

    public String getCommentthumbnailurl() {
        return commentthumbnailurl;
    }

    public void setCommentthumbnailurl(String commentthumbnailurl) {
        this.commentthumbnailurl = commentthumbnailurl == null ? null : commentthumbnailurl.trim();
    }

    public Byte getCommentstatus() {
        return commentstatus;
    }

    public void setCommentstatus(Byte commentstatus) {
        this.commentstatus = commentstatus;
    }

    public String getCommenturl() {
        return commenturl;
    }

    public void setCommenturl(String commenturl) {
        this.commenturl = commenturl == null ? null : commenturl.trim();
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent == null ? null : replycontent.trim();
    }

    public Date getReplycreated() {
        return replycreated;
    }

    public void setReplycreated(Date replycreated) {
        this.replycreated = replycreated;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CommentVO{");
        sb.append("oid=").append(oid);
        sb.append(", commentcontent='").append(commentcontent).append('\'');
        sb.append(", commentcreated=").append(commentcreated);
        sb.append(", commentname='").append(commentname).append('\'');
        sb.append(", commentonid=").append(commentonid);
        sb.append(", blogTitle='").append(blogTitle).append('\'');
        sb.append(", commentsharpurl='").append(commentsharpurl).append('\'');
        sb.append(", commentthumbnailurl='").append(commentthumbnailurl).append('\'');
        sb.append(", commentstatus=").append(commentstatus);
        sb.append(", commenturl='").append(commenturl).append('\'');
        sb.append(", replycontent='").append(replycontent).append('\'');
        sb.append(", replycreated=").append(replycreated);
        sb.append('}');
        return sb.toString();
    }
}
