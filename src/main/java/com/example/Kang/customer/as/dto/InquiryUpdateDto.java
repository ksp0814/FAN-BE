package com.example.Kang.customer.as.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryUpdateDto {

    private String name;
    private String phoneNumber;
    private String email;
    private String title;
    private String description;
    private String filePath;

}
