package com.tyut.miniospringboot.controller;

import com.tyut.miniospringboot.model.UserInfo;
import com.tyut.miniospringboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version v1.0
 * @author OldGj 2024/11/2
 * @apiNote 用户信息控制层
 */
@RestController
@RequestMapping("/api/userInfo")
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;


    @GetMapping("/all")
    public List<UserInfo> getAllUserInfo() {
        List<UserInfo> list = userInfoService.list();
        System.out.println(list);
        return list;
    }
}
