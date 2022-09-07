package com.example.project.controller;

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
    public void login() {
    }

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
        }else{
        rttr.addFlashAttribute("msg","입력된 정보가 틀립니다. 회원가입해주세요.");
        return new RedirectView("/user/login");
        }
    }

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

           model.addAttribute("exerciseDTOList",exerciseService.findExercise(num,formatedNow));

           log.info("모델 받고 돌아 오는가");

           return "user/workout";

    }

    @GetMapping("/exerciseCheck")
    public String exerciseCheck(HttpSession session, String areaName){

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

        return "user/workout";
    }



}
