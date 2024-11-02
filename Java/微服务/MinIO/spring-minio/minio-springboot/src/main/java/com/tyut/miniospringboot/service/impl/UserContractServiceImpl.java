package com.tyut.miniospringboot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tyut.miniospringboot.mapper.UserContractMapper;
import com.tyut.miniospringboot.model.UserContract;
import com.tyut.miniospringboot.service.UserContractService;
import org.springframework.stereotype.Service;

/**
* @author HX
* @description 针对表【t_user_contract】的数据库操作Service实现
* @createDate 2024-11-02 19:17:54
*/
@Service
public class UserContractServiceImpl extends ServiceImpl<UserContractMapper, UserContract>
    implements UserContractService {

}




