package com.example.Kang.customer.as.controller;

import com.example.Kang.customer.as.dto.InquiryRequestDto;
import com.example.Kang.customer.as.dto.InquiryResponseDto;
import com.example.Kang.customer.as.dto.InquiryUpdateDto;
import com.example.Kang.customer.as.service.InquiryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/Inquiry")
public class InquireController {
    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<InquiryResponseDto> createInquire(@RequestBody InquiryRequestDto inquiryRequestDto) {
        InquiryResponseDto createdInquire = inquiryService.createInquiry(inquiryRequestDto);
        return new ResponseEntity<>(createdInquire, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InquiryResponseDto>> getAllInquire() {
        List<InquiryResponseDto> inquires = inquiryService.getAllInquiry();
        return new ResponseEntity<>(inquires, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InquiryResponseDto> updateInquire(@PathVariable Long id, @RequestBody InquiryUpdateDto inquiryUpdateDto) {
        return inquiryService.updateInquiry(id, inquiryUpdateDto)
                .map(updateInquire -> new ResponseEntity<>(updateInquire, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
