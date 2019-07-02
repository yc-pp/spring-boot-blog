package com.blog.base.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 自定义页面
 */
public class CustomPage {
    //主键
    private Long oId;
    //页面展现顺序
    private String pageOrder;
    //页面访问路径
    private String pagePermalink;
    //页面标题
    private String pageTitle;
    //页面打开方式
    private String pageOpenTarget;
    //页面展示用小图标
    private String pageIcon;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    public Long getoId() {
        return oId;
    }

    public void setoId(Long oId) {
        this.oId = oId;
    }

    public String getPageOrder() {
        return pageOrder;
    }

    public void setPageOrder(String pageOrder) {
        this.pageOrder = pageOrder;
    }

    public String getPagePermalink() {
        return pagePermalink;
    }

    public void setPagePermalink(String pagePermalink) {
        this.pagePermalink = pagePermalink;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageOpenTarget() {
        return pageOpenTarget;
    }

    public void setPageOpenTarget(String pageOpenTarget) {
        this.pageOpenTarget = pageOpenTarget;
    }

    public String getPageIcon() {
        return pageIcon;
    }

    public void setPageIcon(String pageIcon) {
        this.pageIcon = pageIcon;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
