package com.ecommerce.service.auth;


import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.ecommerce.dto.ChangePasswordDto;
import com.ecommerce.dto.SignupRequest;
import com.ecommerce.dto.UserDto;

public interface AuthService {

     UserDto createUser(SignupRequest signupRequest) throws Exception;

     Boolean hasUserWithEmail(String email);

     UserDto getUserById(Long userId);

     UserDto updateUser(UserDto userDto) throws IOException;

    ResponseEntity<?> updatePasswordById(ChangePasswordDto changePasswordDto);
}
