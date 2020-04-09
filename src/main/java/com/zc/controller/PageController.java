package com.zc.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author 周超
 * @Date 2020/4/9 10:21
 * @Version 1.0
 **/
@Controller
//@RequestMapping("")
public class PageController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("deleteOrder")
    @RequiresPermissions("deleteOrder")
    public String deleteOrder(){
        return "deleteOrder";
    }

    @RequiresRoles(value = {"admin","productManager"},logical = Logical.OR)
    @RequestMapping("deleteProduct")
    public String deleteProduct(){
        return "deleteProduct";
    }

    @RequestMapping("listProduct")
    public String listProduct(){
        return "listProduct";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
            return "login";
    }

    @RequestMapping("unauthorized")
    public String noPerms(){
        return "unauthorized";
    }
}
