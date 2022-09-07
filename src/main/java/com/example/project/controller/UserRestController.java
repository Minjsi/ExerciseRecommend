package com.example.project.controller;

import com.example.project.service.exercise.ExerciseService;
import com.example.project.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@Slf4j
@RequestMapping("/userR/*")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final ExerciseService exerciseService;

    //이메일 중복확인
    @PostMapping("/emailMatching")
    public int emailMatch(@RequestParam String email){
        log.info("email test 띄워짐? : "+email);
        log.info("email test 갯수 : "+ userService.emailcheck(email));
        return userService.emailcheck(email);
    }


}
