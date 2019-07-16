package com.blog.base.controller;

import com.blog.base.entity.Link;
import com.blog.base.service.LinkService;
import com.blog.base.util.BootStrapTableList;
import com.blog.base.util.PageQueryUtil;
import com.blog.base.util.Result;
import com.blog.base.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/admin/")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @GetMapping("/link")
    public String linkPage() {
        return "admin/link";
    }
    @RequestMapping("link/list")
    @ResponseBody
    public BootStrapTableList toIndex(@RequestParam Map<String,Object> queryParams){
        PageQueryUtil pageUtil = new PageQueryUtil(queryParams);
        return linkService.getLinkPage(pageUtil);
    }
    @RequestMapping("link/save")
    @ResponseBody
    public Result saveLink(@RequestParam("linkTitle") String linkTitle,
                          @RequestParam("linkDescription") String linkDescription,
                          @RequestParam("linkAddress") String linkAddress,
                          @RequestParam("linkOrder") String linkOrder){
        if (StringUtils.isEmpty(linkTitle) || StringUtils.isEmpty(linkDescription) || StringUtils.isEmpty(linkAddress) || StringUtils.isEmpty(linkOrder)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Link link=new Link();
        link.setLinktitle(linkTitle);
        link.setLinkdescription(linkDescription);
        link.setLinkaddress(linkAddress);
        link.setLinkorder(linkOrder);
        link.setCreatedate(new Date());
        if(linkService.saveLink(link)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("友链添加失败！");
        }
    }
    @RequestMapping("link/del")
    @ResponseBody
    public Result delLink(@RequestParam("oid") Long oid){
        if(linkService.delLink(oid)){
            return ResultGenerator.genSuccessResult();
        }else {
            return ResultGenerator.genFailResult("友链删除失败！");
        }
    }
    @RequestMapping("link/detail")
    @ResponseBody
    public Result queryLinkDetail(@RequestParam("oid") Long oid){
        Link link=linkService.queryLinkDetail(oid);
        return ResultGenerator.genSuccessResult(link);
    }
    @RequestMapping("link/update")
    @ResponseBody
    public Result updateLink(@RequestParam("linkOid") Long linkOid,
                             @RequestParam("linkTitle") String linkTitle,
                             @RequestParam("linkDescription") String linkDescription,
                             @RequestParam("linkAddress") String linkAddress,
                             @RequestParam("linkOrder") String linkOrder){
        if (StringUtils.isEmpty(linkOid) ||StringUtils.isEmpty(linkTitle) || StringUtils.isEmpty(linkDescription) || StringUtils.isEmpty(linkAddress) || StringUtils.isEmpty(linkOrder)) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        Link link=new Link();
        link.setOid(linkOid);
        link.setLinktitle(linkTitle);
        link.setLinkdescription(linkDescription);
        link.setLinkaddress(linkAddress);
        link.setLinkorder(linkOrder);
        if(linkService.updateLink(link)){
            return ResultGenerator.genSuccessResult();
        }else{
            return ResultGenerator.genFailResult("友链修改失败！");
        }
    }
}
