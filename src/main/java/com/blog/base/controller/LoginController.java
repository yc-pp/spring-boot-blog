package com.blog.base.controller;

import com.blog.base.dao.*;
import com.blog.base.entity.User;
import com.blog.base.service.impl.LoginServiceImpl;
import com.blog.base.util.Result;
import com.blog.base.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/")
public class LoginController {
    @Resource
    private LoginServiceImpl loginServiceImpl;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private LinkMapper linkMapper;

    @RequestMapping("index")
    public String toIndex(HttpServletRequest request){
        request.setAttribute("articles",articleMapper.getTotalArticles(null));
        request.setAttribute("comments",commentMapper.getTotalComments(null));
        request.setAttribute("categorys",categoryMapper.getTotalCategorys(null));
        request.setAttribute("tags",tagMapper.getTotalTags(null));
        request.setAttribute("links",linkMapper.getTotalLinks(null));
        return "admin/index";
    }

    @GetMapping("login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("login")
    @ResponseBody
    public Result login(@RequestParam("userName") String userName,
                        @RequestParam("passWord") String passWord,
                        HttpSession session){
        // if (StringUtils.isEmpty(verifyCode)) {
        //    session.setAttribute("errorMsg", "验证码不能为空");
        //    return "admin/login";
        // }
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)) {
        ///    session.setAttribute("errorMsg", "用户名或密码不能为空");
            return ResultGenerator.genFailResult("用户名或密码不能为空！");
        }
        // String kaptchaCode = session.getAttribute("rightCode") + "";
        // if (StringUtils.isEmpty(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
        //    session.setAttribute("errorMsg", "验证码错误");
        //    return "admin/login";
        //}
        User user=loginServiceImpl.login(userName,passWord);
        if (user != null) {
            session.setAttribute("loginNickName", user.getNickname());
            session.setAttribute("loginId", user.getOid());
//            request.setAttribute("articles",articleMapper.getTotalArticles(null));
//            request.setAttribute("comments",commentMapper.getTotalComments(null));
//            request.setAttribute("categorys",categoryMapper.getTotalCategorys(null));
//            request.setAttribute("tags",tagMapper.getTotalTags(null));
//            request.setAttribute("links",linkMapper.getTotalLinks(null));
            return ResultGenerator.genSuccessResult();
        } else {
 //           session.setAttribute("errorMsg", "登陆失败");
            return ResultGenerator.genFailResult("登陆失败！");
        }
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("loginNickName");
        request.getSession().removeAttribute("loginId");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}

