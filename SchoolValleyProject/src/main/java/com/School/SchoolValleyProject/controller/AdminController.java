package com.School.SchoolValleyProject.controller;

import com.School.SchoolValleyProject.Model.Person;
import com.School.SchoolValleyProject.Model.ValleyClass;
import com.School.SchoolValleyProject.repository.PersonRepository;
import com.School.SchoolValleyProject.repository.ValleyClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    ValleyClassRepository valleyClassRepository;
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayclasses(Model model)
    {
        List<ValleyClass>ValleyClasses=valleyClassRepository.findAll();
        ModelAndView modelAndView=new ModelAndView("classes.html");
        modelAndView.addObject("ValleyClasses",ValleyClasses);
        modelAndView.addObject("valleyClass",new ValleyClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("valleyClass") ValleyClass valleyClass)
    {
        valleyClassRepository.save(valleyClass);
        ModelAndView modelAndView=new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }
    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id)
    {
        Optional<ValleyClass>valleyClass=valleyClassRepository.findById(id);
        for(Person person:valleyClass.get().getPersons())
        {
            person.setValleyClass(null);
            personRepository.save(person);
        }
        valleyClassRepository.deleteById(id);
        ModelAndView modelAndView=new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }
}
