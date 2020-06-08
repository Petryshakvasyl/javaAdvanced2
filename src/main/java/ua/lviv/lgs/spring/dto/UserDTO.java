package ua.lviv.lgs.spring.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String username;
    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Min(4)
    private String password;

    @NotEmpty
    private String passwordConfirm;
}
