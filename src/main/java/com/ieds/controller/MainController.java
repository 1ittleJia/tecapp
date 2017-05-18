package com.ieds.controller;

import com.ieds.model.bo.LoginBo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jia on 2017/5/2.
 */
@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }


    /**
     * 登陆
     * @param login
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("login") LoginBo login) {
        if("admin".equals(login.getLoginNm())&&"password".equals(login.getPassword())){
            // 重定向到项目管理页面，方法为 redirect:url
            //return "redirect:/item/itemList";
            return "redirect:/main/main";
        }else{
            return "index";
        }
    }

    @RequestMapping(value = "/main/main", method = RequestMethod.GET)
    public String toMainPage() {
        return "main/main";
    }

}

