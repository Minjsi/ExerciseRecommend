package com.example.project.domain.dao.user;


import com.example.project.domain.vo.user.UserDTO;
import com.example.project.domain.vo.user.UserVO;
import com.example.project.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {

    private final UserMapper userMapper;

    // 일반 유저 가입
    public void register(UserVO userVO){
        userMapper.insert(userVO);
    }

    public UserVO login(String email, String pw){
        return userMapper.login(email,pw);
    }

    //  이메일 중복검사
    public int emailCheck(String email){
        return userMapper.emailMatching(email);
    };


}
