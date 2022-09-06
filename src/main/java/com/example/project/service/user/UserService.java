package com.example.project.service.user;

import com.example.project.domain.dao.user.UserDAO;
import com.example.project.domain.vo.user.UserDTO;
import com.example.project.domain.vo.user.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserDAO userDAO;


    public void registerUser(UserVO userVO) {
        userDAO.register(userVO);
    }

    public UserVO loginUser(String email, String pw) {
        return userDAO.login(email,pw);
    }

    //  이메일 중복검사
    public int emailcheck(String email){
        return userDAO.emailCheck(email);
    };


}
