package com.example.project.domain.vo.exercise;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BikingVO {
    private Long num;
    private String status;
    private String registDate;
    private Long userNum;
    private String areaType;
    private String areaName;
}
