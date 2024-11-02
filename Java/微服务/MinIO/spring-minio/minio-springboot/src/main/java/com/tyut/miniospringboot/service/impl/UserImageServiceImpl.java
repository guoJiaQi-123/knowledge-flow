package com.tyut.miniospringboot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.miniospringboot.mapper.UserImageMapper;
import com.tyut.miniospringboot.model.UserImage;
import com.tyut.miniospringboot.service.UserImageService;
import org.springframework.stereotype.Service;

/**
* @author HX
* @description 针对表【t_user_image】的数据库操作Service实现
* @createDate 2024-11-02 19:17:54
*/
@Service
public class UserImageServiceImpl extends ServiceImpl<UserImageMapper, UserImage>
    implements UserImageService {

}




