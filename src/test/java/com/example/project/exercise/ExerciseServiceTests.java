package com.example.project.exercise;

import com.example.project.domain.vo.exercise.ExerciseDTO;
import com.example.project.service.exercise.ExerciseService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class ExerciseServiceTests {
    @Autowired
    private ExerciseService exerciseService;

    @Test
    public void findExercise(){
        List<ExerciseDTO> exerciseDTOList= exerciseService.findExercise(8L,"2022-09-07");
        log.info("이번엔 하체");
//        log.info("운동이름 : "+ exerciseDTOList.get(0).getAreaName());
        for(ExerciseDTO exerciseDTO : exerciseDTOList){
            log.info("운동이름 : " + exerciseDTO.getAreaName());
        }

    }
}
