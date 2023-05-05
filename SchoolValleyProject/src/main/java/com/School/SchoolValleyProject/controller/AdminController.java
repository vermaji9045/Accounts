package com.School.SchoolValleyProject.controller;

import com.School.SchoolValleyProject.Model.ValleyClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @RequestMapping("/displayClasses")
    public ModelAndView displayclasses(Model model)
    {
        ModelAndView modelAndView=new ModelAndView("classes.html");
        modelAndView.addObject("valleyClass",new ValleyClass());
        return modelAndView;
    }
}
