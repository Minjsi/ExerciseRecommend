package com.example.project.domain.dao.exercise;


import com.example.project.domain.vo.exercise.ShoulderPressVO;
import com.example.project.mapper.exercise.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExerciseDAO {

    private final ExerciseMapper exerciseMapper;

    public void shoulderPressRegister(Long userNum){
        exerciseMapper.shoulderPressInsert(userNum);
    }

//    public ShoulderPressVO shoulderPressRead(String date,Long userNum){
//
//    }

}
