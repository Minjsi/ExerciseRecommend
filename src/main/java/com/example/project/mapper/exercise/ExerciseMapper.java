package com.example.project.mapper.exercise;


import com.example.project.domain.vo.exercise.ShoulderPressVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExerciseMapper {

    public void shoulderPressInsert(Long num);
    public ShoulderPressVO shoulderPressSelect(Long userNum, String registDate);

    public void sideLateralRaiseInsert(Long num);
    public void sitUpInsert(Long num);
    public void legRaiseInsert(Long num);
    public void pushUpInsert(Long num);
    public void burpeeInsert(Long num);
    public void supermanInsert(Long num);
    public void chinningInsert(Long num);
    public void lungeInsert(Long num);
    public void runningInsert(Long num);
    public void bikingInsert(Long num);

}
