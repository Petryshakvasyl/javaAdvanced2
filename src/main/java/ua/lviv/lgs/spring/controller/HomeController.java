package ua.lviv.lgs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class HomeController {

//    @GetMapping("/hello")
//    public String hello(Model model) {
//        model.addAttribute("firstName", "Jon");
//        model.addAttribute("lastName", "Snow");
//        return "home";
//    }

    @GetMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        Map<String, Object> model = modelAndView.getModel();
        model.put("firstName", "Jon");

        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("lastName", "Snow");
        return modelAndView;
    }

    @GetMapping("/hello/user")
    public ModelAndView helloUser(@RequestParam(required = false, defaultValue = "Jon", name = "fName") String firstName,
                                  @RequestParam(required = false, defaultValue = "Snow") String lastName,
                                  ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        Map<String, Object> model = modelAndView.getModel();
        model.put("firstName", firstName);

        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("lastName", lastName);
        return modelAndView;
    }

}
