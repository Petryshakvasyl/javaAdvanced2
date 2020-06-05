//package ua.lviv.lgs.spring.controller.validators;
//
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import ua.lviv.lgs.spring.dto.UserDTO;
//
//@Component
//public class UserValidator implements Validator {
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return UserDTO.class.equals(aClass);
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        UserDTO user = (UserDTO) o;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Not empty");
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Not empty");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "Not empty");
//        if (user.getPassword().length() < 8) {
//            errors.rejectValue("password", "passwort size must be more than 8");
//        }
//
//        if (!user.getPassword().equals(user.getPasswordConfirm())) {
//            errors.rejectValue("passwordConfirm", "passworts do not match");
//        }
//    }
//}
