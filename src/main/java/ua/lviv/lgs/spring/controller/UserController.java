package ua.lviv.lgs.spring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.service.UserService;

import java.util.Map;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public User getUsers(@RequestParam String email) {
        return userService.findByEmail(email).get();
    }

    @GetMapping("/users/{id}")
    public ModelAndView helloUserById(@PathVariable/*(name = "id") */ Long id, ModelAndView modelAndView) {
        modelAndView.setViewName("user");
        Map<String, Object> model = modelAndView.getModel();
        model.put("user", userService.findById(id));
        return modelAndView;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
