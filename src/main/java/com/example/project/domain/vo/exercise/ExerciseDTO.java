package com.example.project.domain.vo.exercise;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ExerciseDTO {
    
    private String name;
    private String status;
}
