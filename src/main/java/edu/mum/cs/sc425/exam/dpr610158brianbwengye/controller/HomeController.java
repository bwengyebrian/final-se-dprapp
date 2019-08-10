package edu.mum.cs.sc425.exam.dpr610158brianbwengye.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class HomeController {

    @GetMapping(value = {"/dprapp", "/dprapp/home"})
    public String home(Model model) {
        model.addAttribute("now", LocalDate.now());
        return "public/home/index";
    }
}
