package com.poni.service;

import com.poni.pojo.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/12/3 22:58
 */
@Service("userService")
public interface UserService {

    int addUser(SysUser user) throws Exception;

    int updateUser(SysUser user);

    int  deleteUser(String userId);

    SysUser queryUserById(String userId);

    List<SysUser> queryUserList(SysUser user);

    List<SysUser> queryUserListPaged(SysUser sysUser,Integer page,Integer pageSize);

    SysUser queryUserByAge(Integer age);

    int saveUserTransactional(SysUser user);
}
