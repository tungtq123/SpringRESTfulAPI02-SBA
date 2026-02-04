package com.tqt.sba301_se1943_springrestapi02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserDTO {
    private String email;
    private String fullName;
    private String password;
}
