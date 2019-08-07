package com.blog.base.vo;

public class TagHotVO {
    private Long tagOId;
    private Long tagCount;
    private String tagTitle;

    public Long getTagOId() {
        return tagOId;
    }

    public void setTagOId(Long tagOId) {
        this.tagOId = tagOId;
    }

    public Long getTagCount() {
        return tagCount;
    }

    public void setTagCount(Long tagCount) {
        this.tagCount = tagCount;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TagHotVO{");
        sb.append("tagOId=").append(tagOId);
        sb.append(", tagCount=").append(tagCount);
        sb.append(", tagTitle='").append(tagTitle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
