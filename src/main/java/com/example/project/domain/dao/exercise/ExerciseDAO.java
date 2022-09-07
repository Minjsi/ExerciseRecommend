package com.example.project.domain.dao.exercise;


import com.example.project.domain.vo.exercise.*;
import com.example.project.mapper.exercise.ExerciseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ExerciseDAO {

    private final ExerciseMapper exerciseMapper;

//    숄더프레스생성
    public void shoulderPressRegister(Long userNum){
        exerciseMapper.shoulderPressInsert(userNum);
    }

//    숄더프레스 조회
    public ShoulderPressVO shoulderPressRead(Long userNum, String registDate){
        return exerciseMapper.shoulderPressSelect(userNum, registDate);
    }

//    사이드레터럴레이즈 생성
//
    public void sideLateralRaiseRegister(Long userNum){
        exerciseMapper.sideLateralRaiseInsert(userNum);
    }
//    사이드레터럴레이즈 조회
    public SideLateralRaiseVO sideLateralRaiseRead(Long userNum, String registDate){
        return exerciseMapper.sideLateralRaiseSelect(userNum, registDate);
    }

//    싯업 생성
public void sitUpRegister(Long userNum){
    exerciseMapper.sitUpInsert(userNum);
}

//    싯업 조회
    public SitUpVO sitUpRead(Long userNum, String registDate){
        return exerciseMapper.sitUpSelect(userNum, registDate);
    }

//    레그레이즈 생성
    public void legRaiseRegister(Long userNum){
        exerciseMapper.legRaiseInsert(userNum);
    }



//    레그레이즈 조회
    public LegRaiseVO legRaiseRead(Long userNum, String registDate){
        return exerciseMapper.legRaiseSelect(userNum, registDate);
    }

//    푸쉬업 생성

    public void pushUpRegister(Long userNum){
        exerciseMapper.pushUpInsert(userNum);
    }
//    푸쉬업 조회
    public PushUpVO pushUpRead(Long userNum, String registDate){
        return exerciseMapper.pushUpSelect(userNum, registDate);
    }

//    버피 생성
    public void burpeeRegister(Long userNum){
        exerciseMapper.burpeeInsert(userNum);
    }
//    버피 조회
    public BurpeeVO burpeeRead(Long userNum, String registDate){
        return exerciseMapper.burpeeSelect(userNum, registDate);
    }
//    슈퍼맨 생성
    public void supermanRegister(Long userNum){
        exerciseMapper.supermanInsert(userNum);
    }

//    슈퍼맨 조회
    public SupermanVO supermanRead(Long userNum, String registDate){
        return exerciseMapper.supermanSelect(userNum, registDate);
    }

//    턱걸이 생성
    public void chinningRegister(Long userNum){
        exerciseMapper.chinningInsert(userNum);
    }
//    턱걸이 조회
    public ChinningVO chinningRead(Long userNum, String registDate){
        return exerciseMapper.chinningSelect(userNum, registDate);
    }
//    스쿼트 생성
    public void squatRegister(Long userNum){
        exerciseMapper.squatInsert(userNum);
    }

//    스쿼트 조회
    public SquatVO squatRead(Long userNum, String registDate){
        return exerciseMapper.squatSelect(userNum, registDate);
    }
//    런지 생성
    public void lungeRegister(Long userNum){
        exerciseMapper.lungeInsert(userNum);
    }
//    런지 조회
    public LungeVO lungeRead(Long userNum, String registDate){
        return exerciseMapper.lungeSelect(userNum, registDate);
    }
//    달리기 생성
    public void runningRegister(Long userNum){
        exerciseMapper.runningInsert(userNum);
    }
//    달리기 조회
    public RunningVO runningRead(Long userNum, String registDate){
        return exerciseMapper.runningSelect(userNum, registDate);
    }

//    자전거 생성
    public void bikingRegister(Long userNum){
        exerciseMapper.bikingInsert(userNum);
    }
//    자전거 조회

    public BikingVO bikingRead(Long userNum, String registDate){
        return exerciseMapper.bikingSelect(userNum, registDate);
    }

}
