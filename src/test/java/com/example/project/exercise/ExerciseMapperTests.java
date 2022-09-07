package com.example.project.exercise;

import com.example.project.domain.vo.exercise.ExerciseDTO;
import com.example.project.domain.vo.exercise.ShoulderPressVO;
import com.example.project.mapper.exercise.ExerciseMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ExerciseMapperTests {

    @Autowired
    private ExerciseMapper exerciseMapper;

    @Test
    public void shoulderPressInsertTest(){
        exerciseMapper.shoulderPressInsert(2L);
    }
    @Test
    public void shoulderPressSelectTest(){
        ExerciseDTO exerciseDTO =exerciseMapper.shoulderPressSelect(2L,"2022-09-06");
        log.info("숄더프레스 조회 " + exerciseDTO.getRegistDate());
    }

}
