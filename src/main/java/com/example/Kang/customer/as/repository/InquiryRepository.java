package com.example.Kang.customer.as.repository;

import com.example.Kang.customer.as.model.Inquire;
import com.example.Kang.customer.as.model.InquiryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquire,Long> {

    List<Inquire> findByStatus(InquiryStatus status);
}
