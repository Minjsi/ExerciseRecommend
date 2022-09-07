package com.example.project.mapper.exercise;


import com.example.project.domain.vo.exercise.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExerciseMapper {


    //    숄더프레스생성
    public void shoulderPressInsert(Long num);
//    숄더프레스 조회
    public ShoulderPressVO shoulderPressSelect(Long userNum, String registDate);


    //사이드레터럴레이즈 생성
    public void sideLateralRaiseInsert(Long num);

//    사이드레터럴레이즈 조회
    public SideLateralRaiseVO sideLateralRaiseSelect(Long userNum, String registDate);

//    싯업 생성
    public void sitUpInsert(Long num);

    //    싯업 조회
    public SitUpVO sitUpSelect(Long userNum, String registDate);

//    레그레이즈 생성
    public void legRaiseInsert(Long num);

    //    레그레이즈 조회
    public LegRaiseVO legRaiseSelect(Long userNum, String registDate);


//    푸쉬업 생성
    public void pushUpInsert(Long num);

    //    푸쉬업 조회
    public PushUpVO pushUpSelect(Long userNum, String registDate);

//    버피 생성
    public void burpeeInsert(Long num);

    //    버피 조회
    public BurpeeVO burpeeSelect(Long userNum, String registDate);

//    슈퍼맨 생성
    public void supermanInsert(Long num);

    //    슈퍼맨 조회
    public SupermanVO supermanSelect(Long userNum, String registDate);


    //    턱걸이 생성
    public void chinningInsert(Long num);

    //    턱걸이 조회
    public ChinningVO chinningSelect(Long userNum, String registDate);

//    스쿼트 생성
    public void squatInsert(Long num);

    //    스쿼트 조회
    public SquatVO squatSelect(Long userNum, String registDate);

//    런지 생성
    public void lungeInsert(Long num);

    //    런지 조회
    public LungeVO lungeSelect(Long userNum, String registDate);


//    달리기 생성
    public void runningInsert(Long num);

    //    달리기 조회
    public RunningVO runningSelect(Long userNum, String registDate);


//    자전거 생성
    public void bikingInsert(Long num);

    //    자전거 조회
    public BikingVO bikingSelect(Long userNum, String registDate);

}
