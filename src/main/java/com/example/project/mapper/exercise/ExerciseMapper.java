package com.example.project.mapper.exercise;


import com.example.project.domain.vo.exercise.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExerciseMapper {


    //    숄더프레스생성
    public void shoulderPressInsert(Long num);
//    숄더프레스 조회
    public ExerciseDTO shoulderPressSelect(Long userNum, String registDate);

//   숄더프레스 수정
    public void shoulderPressCheck(Long userNum, String registDate, String areaName);

    //사이드레터럴레이즈 생성
    public void sideLateralRaiseInsert(Long num);

//    사이드레터럴레이즈 조회
    public ExerciseDTO sideLateralRaiseSelect(Long userNum, String registDate);

    //   사이드레터럴레이즈 수정
    public void sideLateralRaiseCheck(Long userNum, String registDate, String areaName);

//    싯업 생성
    public void sitUpInsert(Long num);

    //    싯업 조회
    public ExerciseDTO sitUpSelect(Long userNum, String registDate);

    //   싯업 수정
    public void sitUpCheck(Long userNum, String registDate, String areaName);

//    레그레이즈 생성
    public void legRaiseInsert(Long num);

    //    레그레이즈 조회
    public ExerciseDTO legRaiseSelect(Long userNum, String registDate);

    //   레그레이즈 수정
    public void legRaiseCheck(Long userNum, String registDate, String areaName);

//    푸쉬업 생성
    public void pushUpInsert(Long num);

    //    푸쉬업 조회
    public ExerciseDTO pushUpSelect(Long userNum, String registDate);

    //   푸쉬업 수정
    public void pushUpCheck(Long userNum, String registDate, String areaName);

//    버피 생성
    public void burpeeInsert(Long num);

    //    버피 조회
    public ExerciseDTO burpeeSelect(Long userNum, String registDate);

    //   버피 수정
    public void burpeeCheck(Long userNum, String registDate, String areaName);


    //    슈퍼맨 생성
    public void supermanInsert(Long num);

    //    슈퍼맨 조회
    public ExerciseDTO supermanSelect(Long userNum, String registDate);

    //   슈퍼맨 수정
    public void supermanCheck(Long userNum, String registDate, String areaName);

    //    턱걸이 생성
    public void chinningInsert(Long num);

    //    턱걸이 조회
    public ExerciseDTO chinningSelect(Long userNum, String registDate);

    //   턱걸이 수정
    public void chinningCheck(Long userNum, String registDate, String areaName);

//    스쿼트 생성
    public void squatInsert(Long num);

    //    스쿼트 조회
    public ExerciseDTO squatSelect(Long userNum, String registDate);

    //   스쿼트 수정
    public void squatCheck(Long userNum, String registDate, String areaName);

//    런지 생성
    public void lungeInsert(Long num);

    //    런지 조회
    public ExerciseDTO lungeSelect(Long userNum, String registDate);

    //   런지 수정
    public void lungeCheck(Long userNum, String registDate, String areaName);


//    달리기 생성
    public void runningInsert(Long num);

    //    달리기 조회
    public ExerciseDTO runningSelect(Long userNum, String registDate);

    //   달리기 수정
    public void runningCheck(Long userNum, String registDate, String areaName);

//    자전거 생성
    public void bikingInsert(Long num);

    //    자전거 조회
    public ExerciseDTO bikingSelect(Long userNum, String registDate);

    //   자전거 수정
    public void bikingCheck(Long userNum, String registDate, String areaName);

}
