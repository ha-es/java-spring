package com.example.firstproject.domain;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class HomeController {

    @RequestMapping(value = "/android", method = {RequestMethod.POST})
    public String androidPage(HttpServletRequest request, Model model){
        System.out.println("서버에서 안드로이드 접속 요청함");
        try{
            String androidID  = request.getParameter("id");
            String androidPW  = request.getParameter("pwd");
            System.out.println("안드로이드에서 받아온 id : " + androidID );
            System.out.println("안드로이드에서 받아온 pwd : " + androidPW );
            model.addAttribute("android",androidID);
            return "android";

        }catch (Exception e){
            e.printStackTrace();
            return "null";
        }
    }
}
