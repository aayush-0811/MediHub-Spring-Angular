package com.ecommerce.dto;


import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String name;

    private UserRole role;

    private MultipartFile img;

    private byte[] returnedImg;

}
