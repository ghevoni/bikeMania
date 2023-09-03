package com.project.store.controllers;


import com.project.store.repositories.BikeRepository;
import com.project.store.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeneralController {

    public GeneralController() {
        System.out.println(getClass().getSimpleName() + " created");

    }

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/aboutUs")
    public ModelAndView getAboutUs() {
        ModelAndView modelAndView = new ModelAndView("aboutUs");
        return modelAndView;
    }

    @GetMapping("/service")
    public ModelAndView getService() {
        ModelAndView modelAndView = new ModelAndView("service");
        return modelAndView;
    }

    @GetMapping("/contact")
    public ModelAndView getContact() {
        ModelAndView modelAndView = new ModelAndView("contact");
        return modelAndView;
    }

    @GetMapping("/termsConditions")
    public ModelAndView getTermsAndConditions() {
        ModelAndView modelAndView = new ModelAndView("termsConditions");
        return modelAndView;
    }

    @GetMapping("/return")
    public ModelAndView getReturn() {
        ModelAndView modelAndView = new ModelAndView("return");
        return modelAndView;
    }

    @GetMapping("/privacy")
    public ModelAndView getPrivacy() {
        ModelAndView modelAndView = new ModelAndView("privacy");
        return modelAndView;
    }

    @GetMapping("/cookie")
    public ModelAndView getCookie() {
        ModelAndView modelAndView = new ModelAndView("cookie");
        return modelAndView;
    }

    @GetMapping("/freeRevisions")
    public ModelAndView getFreeRevisions() {
        ModelAndView modelAndView = new ModelAndView("freeRevisions");
        return modelAndView;
    }

}
