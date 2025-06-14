package com.example.Kang.customer.as.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "inquire")
@Getter
@Setter
@NoArgsConstructor
public class Inquire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name; // 문의자 이름

    @Column(nullable = false, length = 50)
    private String contact; // 연락처(전화번호)

    @Column(nullable = false, length = 200)
    private String title; // 문의 제목

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description; // 문의 상세 내용


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private InquiryStatus status; // 문의 처리 상태

    @Column
    private String filePath; // 첨부 파일 경로 ( 사진이나 영상 )

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt; // 문의 등록일

    private LocalDateTime completedAt; // 문의 처리 완료일

    @PrePersist
    public void perPersist() {
        this.status = InquiryStatus.RECEIVED; // 엔티티가 저장되기 전, 상태를 '접수됨'으로 기본 설정
    }
}
