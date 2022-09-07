package com.example.project.service.exercise;

import com.example.project.domain.dao.exercise.ExerciseDAO;
import com.example.project.domain.dao.user.UserDAO;
import com.example.project.domain.vo.exercise.ExerciseDTO;
import com.example.project.domain.vo.exercise.ShoulderPressVO;
import com.example.project.domain.vo.exercise.SideLateralRaiseVO;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExerciseService {

    private final ExerciseDAO exerciseDAO;
    private final UserDAO userDAO;

    @Transactional(rollbackFor = Exception.class)
//    List<ExerciseDTO>
    public void findExercise(Long num){
        String bodyArea=userDAO.findArea(num);

        // 현재 날짜 구하기 자바 8버전 이상
        LocalDate now = LocalDate.now();
        // 포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 포맷 적용
        String formatedNow = now.format(formatter);
        ArrayList list=new ArrayList();

        switch(bodyArea){
            case "어깨":
                exerciseDAO.shoulderPressRegister(num);
                exerciseDAO.sideLateralRaiseRegister(num);
                ShoulderPressVO shoulderPressVO=exerciseDAO.shoulderPressRead(num,formatedNow);


                log.info("숄더프레스 서비스 부분 : "+shoulderPressVO.getAreaName());
                log.info("===========================================================");
                log.info("===========================================================");

                SideLateralRaiseVO sideLateralRaiseVO=exerciseDAO.sideLateralRaiseRead(num,formatedNow);
                log.info("사이드레터럴레이즈 서비스 부분 : "+sideLateralRaiseVO.getAreaName());




                break;
            case "등" :
                break;
            case  "복부":
                break;
            case "하체":
                break;
        }

    }



    //    숄더프레스생성
    public void shoulderPressRegister(Long userNum){
        exerciseDAO.shoulderPressRegister(userNum);
    }

//    숄더프레스 조회
//    public ShoulderPressVO shoulderPressRead(String date,Long userNum){
//
//    }

    //    사이드레터럴레이즈 생성
//
    public void sideLateralRaiseRegister(Long userNum){
        exerciseDAO.sideLateralRaiseRegister(userNum);
    }
//    사이드레터럴레이즈 조회


    //    싯업 생성
    public void sitUpRegister(Long userNum){
        exerciseDAO.sitUpRegister(userNum);
    }

    //    싯업 조회
//    레그레이즈 생성
    public void legRaiseRegister(Long userNum){
        exerciseDAO.legRaiseRegister(userNum);
    }

//    레그레이즈 조회
//    푸쉬업 생성

    public void pushUpRegister(Long userNum){
        exerciseDAO.pushUpRegister(userNum);
    }
    //    푸쉬업 조회
//    버피 생성
    public void burpeeRegister(Long userNum){
        exerciseDAO.burpeeRegister(userNum);
    }
//    버피 조회

    //    슈퍼맨 생성
    public void supermanRegister(Long userNum){
        exerciseDAO.supermanRegister(userNum);
    }

//    슈퍼맨 조회

    //    턱걸이 생성
    public void chinningRegister(Long userNum){
        exerciseDAO.chinningRegister(userNum);
    }
//    턱걸이 조회

    //    스쿼트 생성
    public void squatRegister(Long userNum){
        exerciseDAO.squatRegister(userNum);
    }

//    스쿼트 조회

    //    런지 생성
    public void lungeRegister(Long userNum){
        exerciseDAO.lungeRegister(userNum);
    }
//    런지 조회

    //    달리기 생성
    public void runningRegister(Long userNum){
        exerciseDAO.runningRegister(userNum);
    }
    //    달리기 조회
//    자전거 생성
    public void bikingRegister(Long userNum){
        exerciseDAO.bikingRegister(userNum);
    }
//    자전거 조회


}
