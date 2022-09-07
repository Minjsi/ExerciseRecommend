package com.example.project.exercise;

import com.example.project.service.exercise.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ExerciseServiceTests {
    @Autowired
    private ExerciseService exerciseService;

    @Test
    public void findArea(){
        exerciseService.findExercise(2L);
        log.info("테스트 하는 중");
    }
}
