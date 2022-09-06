package com.example.project.mapper.user;

import com.example.project.domain.vo.user.UserDTO;
import com.example.project.domain.vo.user.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    //회원가입
    public void insert(UserVO userVO);

    //로그인
    public UserVO login(@Param("email")String email, @Param("pw") String pw);

    //  이메일 중복검사
    public int emailMatching(@Param("email") String email);


}
