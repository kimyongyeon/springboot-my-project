package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public String index(Model model, HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
        logger.info("index(/) 화면 입니다. ");
        model.addAttribute("name", "한글사랑");
        return "contentLayout";
    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        logger.info("hello(/hello) 화면 입니다.");
        System.out.println("sout 한글사랑");
        model.addAttribute("name", "springtest template");
        return "hello";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(Model model) {
        logger.info("login(/login) 화면 입니다.");
        model.addAttribute("name", "환영 합니다.");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(Model model, HttpServletResponse res) throws IOException {
        logger.info("loginout(/loginout) 화면 입니다.");
        res.sendRedirect("/login");
    }

    @RequestMapping(value = "/loginAction", method = {RequestMethod.POST})
    public String loginAction(Model model
            , HttpServletResponse res
            , HttpServletRequest req
            , @RequestParam("userid") String userid
            , @RequestParam("userpw") String userpw) throws IOException {

        logger.info("loginAction(/loginAction) 화면 입니다.");
        logger.info("userid : {} ", userid);
        logger.info("userpw : {} ", userpw);
        logger.info("userid : {} ", userid.length());
        logger.info("userpw : {} ", userpw.length());

        if(userid.length() == 0 || userpw.length() == 0) {
            res.sendRedirect("/login");
        }
        return "/hello";
    }

}
