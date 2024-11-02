package com.tyut.miniospringboot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.miniospringboot.mapper.UserInfoMapper;
import com.tyut.miniospringboot.model.UserInfo;
import com.tyut.miniospringboot.service.UserInfoService;
import org.springframework.stereotype.Service;

/**
* @author HX
* @description 针对表【t_user_info】的数据库操作Service实现
* @createDate 2024-11-02 19:17:54
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService {

}




