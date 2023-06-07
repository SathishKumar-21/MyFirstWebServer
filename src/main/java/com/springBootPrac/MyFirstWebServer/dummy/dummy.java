package com.springBootPrac.MyFirstWebServer.dummy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class dummy {
    @RequestMapping("dummy")
    public String showDummy(){
        return "dummy";
    }
}
