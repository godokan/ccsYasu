package com.yasu.ccs.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class LoginController {

    @ResponseBody
    @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
    public String  loginPost(@RequestBody Map<String,Object> map) {
        System.out.println(map);
        return "redirect:/home";
    }
}
