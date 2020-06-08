package ua.lviv.lgs.spring.controller.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.lviv.lgs.spring.dto.UserDTO;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "password.notmatch");
        }
    }
}
