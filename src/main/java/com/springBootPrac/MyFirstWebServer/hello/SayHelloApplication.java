package com.springBootPrac.MyFirstWebServer.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloApplication {
    @RequestMapping("hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Sathish, How is your day going?";
    }
    @RequestMapping("hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My First Html Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("Hello Sathish, How is your day going?");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }
    @RequestMapping("hello-jsp")
    public String sayHelloJsp(){
        return "helloJsp";
    }
}
