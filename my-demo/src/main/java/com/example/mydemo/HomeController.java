package com.example.mydemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("home")
    public String home(HttpServletRequest req) {
        String name = req.getParameter("name");

        HttpSession session = req.getSession();
        session.setAttribute("name", name);

        // System.out.println(name);
        // req.setAttribute("name", name);

        System.out.println("/home called");
        System.out.println(name);
        return "home";
    }
}
