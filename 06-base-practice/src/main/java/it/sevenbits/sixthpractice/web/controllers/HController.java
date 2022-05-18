package it.sevenbits.sixthpractice.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HController {
    /**
     * Returns response in the form of string
     *
     * @param name - request's parameter
     * @return string - response
     */
    @RequestMapping("/hello")
    @ResponseBody
    public String home(@RequestParam final String name) {
        return "Hello, " + name;
    }
}
