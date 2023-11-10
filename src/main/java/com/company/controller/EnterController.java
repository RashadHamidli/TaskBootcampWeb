package com.company.controller;

import com.company.entity.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EnterController {
    @GetMapping("a")
    public String enter(ModelMap modelMap) {
        Message message = new Message();
        message.setMessage("Hello RequestMappingHandlerMappin");
        modelMap.addAttribute("message", message.getMessage());
        return "index";
    }
}
