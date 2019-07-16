package com.blog.base.service.impl;

import com.blog.base.dao.TagArticleMapper;
import com.blog.base.dao.TagMapper;
import com.blog.base.entity.Tag;
import com.blog.base.entity.TagArticle;
import com.blog.base.service.TagService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private TagArticleMapper tagArticleMapper;
    @Override
    public BootStrapTableList getTagPage(PageQueryUtil pageUtil) {
        List<Tag> tags = tagMapper.findTagList(pageUtil);
        int total = tagMapper.getTotalTags(pageUtil);
        BootStrapTableList bst=new BootStrapTableList(tags,total);
        return bst;
    }

    @Override
    public Boolean saveTag(String tagTitle) {
        Tag temp=tagMapper.selectByTagTitle(tagTitle);
        if(temp==null){
            Tag tag=new Tag();
            tag.setTagtitle(tagTitle);
            tag.setCreatedate(new Date());
            return tagMapper.insertSelective(tag) > 0;
        }
        return false;
    }

    @Override
    public Boolean delTag(Long oid) {
        //查询标签是否关联文章
        List<TagArticle> tagArticleList=tagArticleMapper.selectByTagId(oid);
        if(tagArticleList != null && !tagArticleList.isEmpty()){
            return false;
        }
        return tagMapper.deleteByPrimaryKey(oid) > 0;
    }

    @Override
    public List<Tag> findAllTag() {
        return tagMapper.findTagList(null);
    }

}
