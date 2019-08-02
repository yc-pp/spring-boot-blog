package com.blog.base.vo;

import com.blog.base.entity.Tag;

public class TagVO {
    private Tag tag;
    private String choose;

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TagVO{");
        sb.append("tag=").append(tag);
        sb.append(", choose='").append(choose).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
