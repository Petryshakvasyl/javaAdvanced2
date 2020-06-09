package ua.lviv.lgs.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ua.lviv.lgs.spring.dto.CategoryDTO;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @GetMapping("/category")
    public String createCategoryPage() {
        return "category";
    }

    @PostMapping("/category")
    public String createCategoryPage(@Valid @ModelAttribute("category") CategoryDTO category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "category";
        }
        return "success";
    }
}
