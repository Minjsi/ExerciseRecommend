package com.example.project.user;

import com.example.project.domain.dao.user.UserDAO;
import com.example.project.domain.vo.user.UserVO;
import com.example.project.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserDAOTests {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void insertTest(){
        UserVO userVO= new UserVO();
        userVO.setEmail("bbb@bbb.ddd");
        userVO.setPw("123456");
        userVO.setHeight("163");
        userVO.setCurrentWeight("55");
        userVO.setTargetWeight("50");
        userVO.setCurrentShape("상체 비만");
        userVO.setBodyArea("어깨");
        userDAO.register(userVO);
    }
}
