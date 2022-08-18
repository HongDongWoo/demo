package com.example.demo.controller;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/common")
public class Hello {



    @RequestMapping(value = "/CommonMultiAction.do")
    public String test(@RequestParam Map<String, String> params, RedirectAttributes redirectAttributes ) {
        System.out.println("test:"+params.toString());
        String method = params.getOrDefault("_method","");
        if( "11".equals(method)){
            redirectAttributes.addAttribute("mid", params.getOrDefault("mid",""));
            redirectAttributes.addAttribute("ordNo", params.getOrDefault("ordNo",""));
            redirectAttributes.addAttribute("svcCd", params.getOrDefault("svcCd",""));

        }else if("RcptView2".equals(method)){

        }else{
            redirectAttributes.addAllAttributes(params);
        }

        return "redirect:/common/test2";
    }


    @RequestMapping (value = "/test2")
    public ModelAndView test2(@RequestParam Map<String, String> params, ModelAndView modelAndView) {
        System.out.println("test2:"+params.toString());

        modelAndView.setViewName("index");
        modelAndView.addObject("name", params.get("mid"));
        modelAndView.addObject("ordNo", params.get("ordNo"));
        modelAndView.addObject("svcCd", params.get("svcCd"));

        return modelAndView;
    }
}









