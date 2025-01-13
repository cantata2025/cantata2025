package com.cantata.tradetalent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class routeControllerTest {
    @GetMapping("/newlesson")
    public String test() {
        return "pages/newLesson";
    }
}
