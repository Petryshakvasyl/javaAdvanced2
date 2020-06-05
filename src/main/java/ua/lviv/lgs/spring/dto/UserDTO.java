package ua.lviv.lgs.spring.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {

    private Long id;
    @NotNull(message = "required filed")
    private String firstName;
    @NotNull(message = "required filed")
    private String lastName;
    @NotNull(message = "required filed")
    private String username;
    @NotNull(message = "required filed")
    @Email(message = "please enter valid email")
    private String email;

    @NotNull(message = "required filed")
    private String password;

    @NotNull(message = "required filed")
    private String passwordConfirm;
}
