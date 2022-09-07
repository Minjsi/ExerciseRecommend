package com.example.project.service.exercise;

import com.example.project.domain.dao.exercise.ExerciseDAO;
import com.example.project.domain.dao.user.UserDAO;
import com.example.project.domain.vo.exercise.ExerciseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExerciseService {

    private final ExerciseDAO exerciseDAO;
    private final UserDAO userDAO;

    @Transactional(rollbackFor = Exception.class)
    public List<ExerciseDTO> findExercise(Long num, String insertDate){
        log.info("findExercise service");

//        관심부위
        String bodyArea=userDAO.findArea(num);

        log.info("관심부위 : "+bodyArea);

        List<ExerciseDTO> exerciseDTOList=new ArrayList<ExerciseDTO>();

        switch(bodyArea){
            case "어깨":
//                해당 날짜에 운동이 있으면 조회만 하기
                if(exerciseDAO.shoulderPressRead(num,insertDate)!=null){
                    exerciseDTOList.add(0,exerciseDAO.shoulderPressRead(num,insertDate));

                    log.info("숄더프레스 서비스 if 부분  : "+exerciseDAO.shoulderPressRead(num,insertDate).getNum());
                    log.info("숄더프레스 서비스 if 부분 : "+exerciseDAO.shoulderPressRead(num,insertDate).getAreaName());
                    log.info("숄더프레스 서비스 if 부분 : "+exerciseDTOList.get(0).getStatus());
                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.sideLateralRaiseRead(num,insertDate));
                    exerciseDTOList.add(2,exerciseDAO.runningRead(num,insertDate));
                    exerciseDTOList.add(3,exerciseDAO.bikingRead(num,insertDate));


                }else{
//                    없으면 운동 생성 후 조회
                    exerciseDAO.shoulderPressRegister(num);
                    exerciseDAO.sideLateralRaiseRegister(num);
                    exerciseDAO.runningRegister(num);
                    exerciseDAO.bikingRegister(num);

                    exerciseDTOList.add(0,exerciseDAO.shoulderPressRead(num,insertDate));

                    log.info("숄더프레스 서비스 부분 : "+exerciseDAO.shoulderPressRead(num,insertDate).getNum());
                    log.info("숄더프레스 서비스 부분 : "+exerciseDAO.shoulderPressRead(num,insertDate).getAreaName());
                    log.info("숄더프레스 서비스 부분 : "+exerciseDTOList.get(0).getAreaName());
                    log.info("===========================================================");
                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.sideLateralRaiseRead(num,insertDate));
                    log.info("사이드레터럴레이즈 서비스 부분 : "+exerciseDAO.sideLateralRaiseRead(num,insertDate).getAreaName());
                    log.info("사이드레터럴레이즈 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(2,exerciseDAO.runningRead(num,insertDate));
                    exerciseDTOList.add(3,exerciseDAO.bikingRead(num,insertDate));


                }
                break;

            case "등" :
                log.info("switch 들어오는가");
                log.info("num"+num);
//                해당 날짜에 운동이 있으면 조회만 하기
                if(exerciseDAO.chinningRead(num,insertDate)!=null){
                    log.info("등 if 들어오는가");
                    exerciseDTOList.add(0,exerciseDAO.chinningRead(num,insertDate));

                    log.info("턱걸이 서비스 부분 : "+exerciseDAO.chinningRead(num,insertDate).getAreaName());
                    log.info("===========================================================");
                    exerciseDTOList.add(1,exerciseDAO.pushUpRead(num,insertDate));
                    exerciseDTOList.add(2,exerciseDAO.supermanRead(num,insertDate));

                    log.info("턱걸이 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(3,exerciseDAO.runningRead(num,insertDate));

                }else{
                    log.info("등 else 부분");
//                    없으면 운동 생성 후 조회
                    exerciseDAO.pushUpRegister(num);
                    exerciseDAO.chinningRegister(num);
                    exerciseDAO.supermanRegister(num);
                    exerciseDAO.runningRegister(num);
                    exerciseDAO.bikingRegister(num);

                    exerciseDTOList.add(0,exerciseDAO.pushUpRead(num,insertDate));

                    log.info("푸쉬업 서비스 부분 : "+exerciseDAO.pushUpRead(num,insertDate).getAreaName());
                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.chinningRead(num,insertDate));
                    exerciseDTOList.add(2,exerciseDAO.supermanRead(num,insertDate));

                    log.info("등 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(3,exerciseDAO.runningRead(num,insertDate));

                }
                break;

            case  "복부":

//                해당 날짜에 운동이 있으면 조회만 하기
                if(exerciseDAO.sitUpRead(num,insertDate)!=null){
                    exerciseDTOList.add(0,exerciseDAO.sitUpRead(num,insertDate));

                    log.info("싯업 서비스 부분 : "+exerciseDAO.sitUpRead(num,insertDate).getAreaName());
                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.legRaiseRead(num,insertDate));

                    log.info("복부 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(2,exerciseDAO.runningRead(num,insertDate));
                    exerciseDTOList.add(3,exerciseDAO.burpeeRead(num,insertDate));

                }else{
//                    없으면 운동 생성 후 조회
                    exerciseDAO.sitUpRegister(num);
                    exerciseDAO.legRaiseRegister(num);
                    exerciseDAO.runningRegister(num);
                    exerciseDAO.burpeeRegister(num);

                    exerciseDTOList.add(0,exerciseDAO.sitUpRead(num,insertDate));

                    log.info("푸쉬업 서비스 부분 : "+exerciseDAO.sitUpRead(num,insertDate).getAreaName());

                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.legRaiseRead(num,insertDate));

                    log.info("복부 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(2,exerciseDAO.runningRead(num,insertDate));
                    exerciseDTOList.add(3,exerciseDAO.burpeeRead(num,insertDate));
                }
                break;
            case "하체":

                //                해당 날짜에 운동이 있으면 조회만 하기
                if(exerciseDAO.squatRead(num,insertDate)!=null){

                    exerciseDTOList.add(0,exerciseDAO.squatRead(num,insertDate));

                    log.info("squat 서비스 부분 : "+exerciseDAO.squatRead(num,insertDate).getAreaName());
                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.lungeRead(num,insertDate));

                    log.info("lunge 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(2,exerciseDAO.runningRead(num,insertDate));
                    exerciseDTOList.add(3,exerciseDAO.bikingRead(num,insertDate));
                }else{
                    log.info("하체 기존 있는 경우");
//                    없으면 운동 생성 후 조회
                    exerciseDAO.squatRegister(num);
                    exerciseDAO.lungeRegister(num);
                    exerciseDAO.runningRegister(num);
                    exerciseDAO.bikingRegister(num);

                    exerciseDTOList.add(0,exerciseDAO.squatRead(num,insertDate));

                    log.info("squat 서비스 부분 : "+exerciseDAO.squatRead(num,insertDate).getAreaName());
                    log.info("===========================================================");

                    exerciseDTOList.add(1,exerciseDAO.lungeRead(num,insertDate));

                    log.info("lunge 서비스 부분: "+exerciseDTOList.get(1).getAreaName());

                    exerciseDTOList.add(2,exerciseDAO.runningRead(num,insertDate));
                    exerciseDTOList.add(3,exerciseDAO.bikingRead(num,insertDate));
                }
                break;
        }
        return exerciseDTOList;
    }

    public int exerciseCheck(Long num, String registDate, String areaName){
        log.info("운동 서비스 들어오는지 확인 할 것");
        exerciseDAO.exerciseCheck(num, registDate,areaName);
        return 0;
    }


//
//    //    숄더프레스생성
//    public void shoulderPressRegister(Long userNum){
//        exerciseDAO.shoulderPressRegister(userNum);
//    }
//
//
//    //    사이드레터럴레이즈 생성
//    public void sideLateralRaiseRegister(Long userNum){
//        exerciseDAO.sideLateralRaiseRegister(userNum);
//    }
////    사이드레터럴레이즈 조회
//
//
//    //    싯업 생성
//    public void sitUpRegister(Long userNum){
//        exerciseDAO.sitUpRegister(userNum);
//    }
//
////    레그레이즈 생성
//    public void legRaiseRegister(Long userNum){
//        exerciseDAO.legRaiseRegister(userNum);
//    }
//
////    푸쉬업 생성
//
//    public void pushUpRegister(Long userNum){
//        exerciseDAO.pushUpRegister(userNum);
//    }
////    버피 생성
//    public void burpeeRegister(Long userNum){
//        exerciseDAO.burpeeRegister(userNum);
//    }
//
//    //    슈퍼맨 생성
//    public void supermanRegister(Long userNum){
//        exerciseDAO.supermanRegister(userNum);
//    }
//
//
//    //    턱걸이 생성
//    public void chinningRegister(Long userNum){
//        exerciseDAO.chinningRegister(userNum);
//    }
//
//    //    스쿼트 생성
//    public void squatRegister(Long userNum){
//        exerciseDAO.squatRegister(userNum);
//    }
//
//
//    //    런지 생성
//    public void lungeRegister(Long userNum){
//        exerciseDAO.lungeRegister(userNum);
//    }
//
//    //    달리기 생성
//    public void runningRegister(Long userNum){
//        exerciseDAO.runningRegister(userNum);
//    }
////    자전거 생성
//    public void bikingRegister(Long userNum){
//        exerciseDAO.bikingRegister(userNum);
//    }


}
