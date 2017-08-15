package com.mango.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Aaron on 2017-07-31.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(HttpServletRequest request, Map<String, Object> map){
        map.put("port", request.getLocalPort());
        return  "index";
    }
}
