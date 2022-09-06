package com.example.project.domain.vo.user;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserVO {
    private Long num;
    private String email;
    private String pw;
    private String height;
    private String currentWeight;
    private String targetWeight;
    private String currentShape;
    private String bodyArea;
    private String registDate;

}
