package ua.lviv.lgs.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.lgs.spring.controller.validators.UserValidator;
import ua.lviv.lgs.spring.dto.UserDTO;
import ua.lviv.lgs.spring.service.UserService;

import javax.validation.Valid;

@Controller
@Slf4j
public class UserController {

    private final UserValidator userValidator;

    private final UserService userService;

    public UserController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(userValidator);
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model) {
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@Valid @ModelAttribute("user") UserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        log.info("register user");
        userService.createUser(user);
//        eventPublisher.publishEvent(new RegisterUserEvent(this, user, request.getContextPath()));
        return "success";
    }
}
