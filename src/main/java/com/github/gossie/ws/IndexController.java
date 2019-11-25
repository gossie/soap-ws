package com.github.gossie.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(path = "/")
    public String root() {
        return index();
    }

    @GetMapping(path = "/index.html")
    public String index() {
        return "index";
    }

}
