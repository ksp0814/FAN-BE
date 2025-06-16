package com.example.Kang.customer.as.dto;

import com.example.Kang.customer.as.model.InquiryStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryResponseDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String title;
    private String description;
    private InquiryStatus status;
    private String filePath;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;
}
