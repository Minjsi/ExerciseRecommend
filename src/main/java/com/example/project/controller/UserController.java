package com.example.project.controller;

import com.example.project.domain.vo.user.UserVO;
import com.example.project.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

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
    public void workoutList(HttpSession session, Model model){
//
//        Long num=session.getAttribute("num");
//        String bodyArea=session.getAttribute("bodyArea");


    }

}
