package com.blog.base.service;

import com.blog.base.entity.Link;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;

import java.util.List;

public interface LinkService {
    BootStrapTableList getLinkPage(PageQueryUtil pageUtil);

    Boolean saveLink(Link link);

    Boolean delLink(Long oid);

    Link queryLinkDetail(Long oid);

    Boolean updateLink(Link link);

    List<Link> queryLinks();
}
