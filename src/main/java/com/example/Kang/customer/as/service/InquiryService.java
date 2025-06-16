package com.example.Kang.customer.as.service;

import com.example.Kang.customer.as.dto.InquiryRequestDto;
import com.example.Kang.customer.as.dto.InquiryResponseDto;
import com.example.Kang.customer.as.dto.InquiryUpdateDto;
import com.example.Kang.customer.as.model.Inquire;
import com.example.Kang.customer.as.model.InquiryStatus;
import com.example.Kang.customer.as.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;

    @Transactional
    public InquiryResponseDto createInquiry(InquiryRequestDto requestDto) {
            Inquire inquiry = new Inquire();
            inquiry.setName(requestDto.getName());
            inquiry.setPhoneNumber(requestDto.getPhoneNumber());
            inquiry.setEmail(requestDto.getEmail());
            inquiry.setTitle(requestDto.getTitle());
            inquiry.setDescription(requestDto.getDescription());
            inquiry.setFilePath(requestDto.getFilePath());

            Inquire saved = inquiryRepository.save(inquiry);

            return convertToResponseDto(saved);
    }


    @Transactional
    public Optional<InquiryResponseDto> updateInquiryStatus(Long id, InquiryStatus newStatus) {
        return inquiryRepository.findById(id).map(inquire -> {
            inquire.setStatus(newStatus);
            if (newStatus == InquiryStatus.COMPLETED) {
                inquire.setCompletedAt(LocalDateTime.now());
            } else {
                inquire.setCompletedAt(null);
            }
            Inquire updateInquire = inquiryRepository.save(inquire);
            return convertToResponseDto(updateInquire);
        });
    }

    @Transactional(readOnly = true)
    public List<InquiryResponseDto> getAllInquiry() {
        return inquiryRepository.findAll().stream()
                .map(this::convertToResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<InquiryResponseDto> updateInquiry(Long id, InquiryUpdateDto updateDto) {
        return inquiryRepository.findById(id).map(inquire -> {
            if (updateDto.getName() != null) {
                inquire.setName(updateDto.getName());
            }
            if (updateDto.getPhoneNumber() != null) {
                inquire.setPhoneNumber(updateDto.getPhoneNumber());
            }
            if (updateDto.getEmail() != null) {
                inquire.setEmail(updateDto.getEmail());
            }
            if (updateDto.getTitle() != null) {
                inquire.setTitle(updateDto.getTitle());
            }
            if (updateDto.getDescription() != null) {
                inquire.setDescription(updateDto.getDescription());
            }
            if (updateDto.getFilePath() != null) {
                inquire.setFilePath(updateDto.getFilePath());
            }
            Inquire updatedInquire = inquiryRepository.save(inquire);
            return convertToResponseDto(updatedInquire);
        });
    }



    private InquiryResponseDto convertToResponseDto(Inquire inquire) {
        return new InquiryResponseDto(
                inquire.getId(),
                inquire.getName(),
                inquire.getPhoneNumber(),
                inquire.getEmail(),
                inquire.getTitle(),
                inquire.getDescription(),
                inquire.getStatus(),
                inquire.getFilePath(),
                inquire.getCreatedAt(),
                inquire.getCompletedAt()
        );

    }
}
