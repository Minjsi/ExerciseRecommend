package com.example.project.controller;

import com.example.project.domain.vo.exercise.ExerciseDTO;
import com.example.project.domain.vo.user.UserVO;
import com.example.project.service.exercise.ExerciseService;
import com.example.project.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ExerciseService exerciseService;

    @GetMapping("/join")
    public void join() {
    }

    @PostMapping("/join")
    public String joinForm(UserVO userVO) {
        userService.registerUser(userVO);
        return "/user/login";
    }


    @GetMapping("/login")
    public String login(HttpSession session) {
        if(session.getAttribute("email")!=null) {
            log.info("세션 확인 : " + session.getAttribute("email"));
            session.invalidate();
        }

        log.info("로그인 화면");
        return "/user/login";
    }

//로그인
    @PostMapping("/login")
    public RedirectView loginForm(String email, String pw,
                                  RedirectAttributes rttr,
                                  HttpServletRequest request) {
        HttpSession session = request.getSession();

        UserVO userVO = userService.loginUser(email, pw);
        log.info("로그인 되었는가 : "+userVO.getNum());
        if(userVO!=null){
            session.setAttribute("num", userVO.getNum());
            session.setAttribute("email", userVO.getEmail());
            session.setAttribute("bodyArea", userVO.getBodyArea());

//          사용미정
            rttr.addFlashAttribute("num", userVO.getNum());

            return new RedirectView("/user/workout");
        }
        log.info("정보 일치 않음 : "+userVO.getEmail());
        rttr.addFlashAttribute("msg","입력된 정보가 틀립니다. 회원가입해주세요.");
        return new RedirectView("/user/login");

    }

//    로그인 후 운동목록 보기
    @GetMapping("/workout")
    public String workoutList(HttpSession session, Model model){
        log.info("session 확인"+session.getAttribute("num"));
        log.info("session 확인"+session.getAttribute("email"));

        Long num=(Long) session.getAttribute("num");
        String bodyArea=(String) session.getAttribute("bodyArea");

//         현재 날짜 구하기 자바 8버전 이상
            LocalDate now = LocalDate.now();
//         포맷 정의
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//         포맷 적용
            String formatedNow = now.format(formatter);

            session.setAttribute("todayDate",formatedNow);

            List<ExerciseDTO> exerciseDTOList=exerciseService.findExercise(num,formatedNow);
            model.addAttribute("exerciseDTOList",exerciseDTOList);

            int count=0;

            for(ExerciseDTO exerciseDTO: exerciseDTOList){
                log.info("for문");
                log.info("참 거짓"+exerciseDTO.getStatus().equals("1"));


                if (exerciseDTO.getStatus().equals("1")) {
                    log.info("참 거짓"+exerciseDTO.getStatus().equals("1"));
                    count+=1;
                    log.info("count 개수"+count);
                }
                else if(exerciseDTO.getStatus().equals("0")){
                    count+=0;
                }else {
                    log.info("bad");
                }

            }
            if (count==0){
                model.addAttribute("msg","운동을 완료 했습니다");
                log.info("count==0");
            }


           log.info("모델 받고 돌아 오는가");

           return "user/workout";
    }

    @GetMapping("/exerciseCheck")
    public RedirectView exerciseCheck(HttpSession session, String areaName){

        Long userNum=(Long)session.getAttribute("num");
        log.info("exercise test 띄워짐? : "+userNum);
        log.info("areaName : "+areaName);
        //         현재 날짜 구하기 자바 8버전 이상
        LocalDate now = LocalDate.now();
//         포맷 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//         포맷 적용
        String formatedNow = now.format(formatter);

        log.info("exercise test : ");
        exerciseService.exerciseCheck(userNum,formatedNow,areaName);

        return new RedirectView("/user/workout");
    }



}
