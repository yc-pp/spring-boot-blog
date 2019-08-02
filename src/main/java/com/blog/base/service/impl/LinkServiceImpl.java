package com.blog.base.service.impl;

import com.blog.base.dao.LinkMapper;
import com.blog.base.entity.Link;
import com.blog.base.service.LinkService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkServiceImpl implements LinkService {
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public BootStrapTableList getLinkPage(PageQueryUtil pageUtil) {
        List<Link> links = linkMapper.findLinkList(pageUtil);
        int total = linkMapper.getTotalLinks(pageUtil);
        BootStrapTableList bst=new BootStrapTableList(links,total);
        return bst;
    }

    @Override
    public Boolean saveLink(Link link) {
        return linkMapper.insertSelective(link) > 0;
    }

    @Override
    public Boolean delLink(Long oid) {
        return linkMapper.deleteByPrimaryKey(oid) > 0;
    }

    @Override
    public Link queryLinkDetail(Long oid) {
        return linkMapper.selectByPrimaryKey(oid);
    }

    @Override
    public Boolean updateLink(Link link) {
        return linkMapper.updateByPrimaryKeySelective(link) > 0;
    }
}
