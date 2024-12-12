package com.loan.loan.app.dto;


import lombok.Data;

@Data
public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
    private Integer score;
}
