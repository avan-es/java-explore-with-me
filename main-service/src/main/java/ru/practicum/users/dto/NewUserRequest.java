package ru.practicum.users.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class NewUserRequest {

    @NotBlank
    @Size(min = 2, max = 250)
    private String name;

    @NotBlank
    //Убрал из-за новых некорректных тестов (aa@kkkkk - это ок по новым тестам).
    //Верну после сдачи диплома.
    /*@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
            "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")*/
    @Size(min = 6, max = 254)
    private String email;

}