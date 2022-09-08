package com.example.project.domain.dao.exercise;


import com.example.project.domain.vo.exercise.*;
import com.example.project.mapper.exercise.ExerciseMapper;
import com.example.project.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ExerciseDAO {

    private final ExerciseMapper exerciseMapper;
    private final UserMapper userMapper;

//    숄더프레스생성
    public void shoulderPressRegister(Long userNum){
        exerciseMapper.shoulderPressInsert(userNum);
    }

//    숄더프레스 조회
    public ExerciseDTO shoulderPressRead(Long userNum, String registDate){
        return exerciseMapper.shoulderPressSelect(userNum, registDate);
    }

//    사이드레터럴레이즈 생성
//
    public void sideLateralRaiseRegister(Long userNum){
        exerciseMapper.sideLateralRaiseInsert(userNum);
    }
//    사이드레터럴레이즈 조회
    public ExerciseDTO sideLateralRaiseRead(Long userNum, String registDate){
        return exerciseMapper.sideLateralRaiseSelect(userNum, registDate);
    }

//    싯업 생성
public void sitUpRegister(Long userNum){
    exerciseMapper.sitUpInsert(userNum);
}

//    싯업 조회
    public ExerciseDTO sitUpRead(Long userNum, String registDate){
        return exerciseMapper.sitUpSelect(userNum, registDate);
    }

//    레그레이즈 생성
    public void legRaiseRegister(Long userNum){
        exerciseMapper.legRaiseInsert(userNum);
    }



//    레그레이즈 조회
    public ExerciseDTO legRaiseRead(Long userNum, String registDate){
        return exerciseMapper.legRaiseSelect(userNum, registDate);
    }

//    푸쉬업 생성

    public void pushUpRegister(Long userNum){
        exerciseMapper.pushUpInsert(userNum);
    }
//    푸쉬업 조회
    public ExerciseDTO pushUpRead(Long userNum, String registDate){
        return exerciseMapper.pushUpSelect(userNum, registDate);
    }

//    버피 생성
    public void burpeeRegister(Long userNum){
        exerciseMapper.burpeeInsert(userNum);
    }
//    버피 조회
    public ExerciseDTO burpeeRead(Long userNum, String registDate){
        return exerciseMapper.burpeeSelect(userNum, registDate);
    }
//    슈퍼맨 생성
    public void supermanRegister(Long userNum){
        exerciseMapper.supermanInsert(userNum);
    }

//    슈퍼맨 조회
    public ExerciseDTO supermanRead(Long userNum, String registDate){
        return exerciseMapper.supermanSelect(userNum, registDate);
    }

//    턱걸이 생성
    public void chinningRegister(Long userNum){
        exerciseMapper.chinningInsert(userNum);
    }
//    턱걸이 조회
    public ExerciseDTO chinningRead(Long userNum, String registDate){
        return exerciseMapper.chinningSelect(userNum, registDate);
    }
//    스쿼트 생성
    public void squatRegister(Long userNum){
        exerciseMapper.squatInsert(userNum);
    }

//    스쿼트 조회
    public ExerciseDTO squatRead(Long userNum, String registDate){
        return exerciseMapper.squatSelect(userNum, registDate);
    }
//    런지 생성
    public void lungeRegister(Long userNum){
        exerciseMapper.lungeInsert(userNum);
    }
//    런지 조회
    public ExerciseDTO lungeRead(Long userNum, String registDate){
        return exerciseMapper.lungeSelect(userNum, registDate);
    }
//    달리기 생성
    public void runningRegister(Long userNum){
        exerciseMapper.runningInsert(userNum);
    }
//    달리기 조회
    public ExerciseDTO runningRead(Long userNum, String registDate){
        return exerciseMapper.runningSelect(userNum, registDate);
    }

//    자전거 생성
    public void bikingRegister(Long userNum){
        exerciseMapper.bikingInsert(userNum);
    }
//    자전거 조회

    public ExerciseDTO bikingRead(Long userNum, String registDate){
        return exerciseMapper.bikingSelect(userNum, registDate);
    }

    public void exerciseCheck(Long num, String registDate, String areaName){
        String bodyArea=userMapper.findArea(num);

        log.info("관심 부위 : " + bodyArea);

        switch(bodyArea){
            case "어깨":
                log.info("case 어깨 : " + bodyArea);
                shoulderCheck(num,registDate,areaName);
                break;

            case "등" :
                log.info("case 등 : " + bodyArea);
                backCheck(num,registDate,areaName);
                break;

            case  "복부":
                log.info("case 복부 : " + bodyArea);
                stomachCheck(num,registDate,areaName);
                break;
            case "하체":
                log.info("case 하체 : " + bodyArea);
                lowerBodyCheck(num,registDate,areaName);
                break;
        }

    }

    public void shoulderCheck(Long userNum, String registDate, String areaName){
        log.info("숄더 함수");
        log.info("운동이름"+areaName);

        switch(areaName){
            case "숄더프레스":
                log.info("case 숄더프레스 : " + areaName);
                    exerciseMapper.shoulderPressCheck(userNum, registDate, areaName);
                break;

            case "사이드레터럴레이즈" :
                log.info("case 사이드레터럴레이즈 : " + areaName);
                exerciseMapper.sideLateralRaiseCheck(userNum, registDate, areaName);
                break;

            case  "달리기":
                exerciseMapper.runningCheck(userNum, registDate, areaName);
                break;
            case "자전거":
                exerciseMapper.bikingCheck(userNum, registDate, areaName);
                break;
        }
    }

    public void backCheck(Long userNum, String registDate, String areaName){
        switch(areaName){
            case "턱걸이":
                exerciseMapper.chinningCheck(userNum, registDate, areaName);
                break;

            case "푸쉬업" :
                exerciseMapper.pushUpCheck(userNum, registDate, areaName);
                break;

            case  "슈퍼맨":
                exerciseMapper.supermanCheck(userNum, registDate, areaName);
                break;
            case "달리기":
                exerciseMapper.runningCheck(userNum, registDate, areaName);
                break;
        }
    }

    public void stomachCheck(Long userNum, String registDate, String areaName){
        switch(areaName){
            case "싯업":
                exerciseMapper.sitUpCheck(userNum, registDate, areaName);
                break;

            case "레그레이즈" :
                exerciseMapper.legRaiseCheck(userNum, registDate, areaName);
                break;

            case  "달리기":
                exerciseMapper.runningCheck(userNum, registDate, areaName);
                break;
            case "버피":
                exerciseMapper.burpeeCheck(userNum, registDate, areaName);
                break;
        }
    }

    public void lowerBodyCheck(Long userNum, String registDate, String areaName){
        switch(areaName){
            case "스쿼트":
                exerciseMapper.squatCheck(userNum, registDate, areaName);
                break;

            case "런지" :
                exerciseMapper.lungeCheck(userNum, registDate, areaName);
                break;

            case  "달리기":
                exerciseMapper.runningCheck(userNum, registDate, areaName);
                break;
            case "자전거":
                exerciseMapper.bikingCheck(userNum, registDate, areaName);
                break;
        }
    }

}
