package ua.lviv.lgs.spring.controller.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static ua.lviv.lgs.spring.Constants.DATE_FORMAT;

public class DateFormtValidator implements ConstraintValidator<DateConstrain, String> {

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext ctx) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(inputValue);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
