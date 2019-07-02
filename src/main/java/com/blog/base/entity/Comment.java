package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable {
    private Long oid;

    private String commentcontent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentcreated;

    private String commentname;

    private Long commentonid;

    private String commentsharpurl;

    private String commentthumbnailurl;

    private String commenturl;

    private String commentoriginalcommentid;

    private String commentoriginalcommentname;

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

    public String getCommenturl() {
        return commenturl;
    }

    public void setCommenturl(String commenturl) {
        this.commenturl = commenturl == null ? null : commenturl.trim();
    }

    public String getCommentoriginalcommentid() {
        return commentoriginalcommentid;
    }

    public void setCommentoriginalcommentid(String commentoriginalcommentid) {
        this.commentoriginalcommentid = commentoriginalcommentid == null ? null : commentoriginalcommentid.trim();
    }

    public String getCommentoriginalcommentname() {
        return commentoriginalcommentname;
    }

    public void setCommentoriginalcommentname(String commentoriginalcommentname) {
        this.commentoriginalcommentname = commentoriginalcommentname == null ? null : commentoriginalcommentname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", commentcontent=").append(commentcontent);
        sb.append(", commentcreated=").append(commentcreated);
        sb.append(", commentname=").append(commentname);
        sb.append(", commentonid=").append(commentonid);
        sb.append(", commentsharpurl=").append(commentsharpurl);
        sb.append(", commentthumbnailurl=").append(commentthumbnailurl);
        sb.append(", commenturl=").append(commenturl);
        sb.append(", commentoriginalcommentid=").append(commentoriginalcommentid);
        sb.append(", commentoriginalcommentname=").append(commentoriginalcommentname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}