package com.poni.mapper;

import com.poni.pojo.SysUser;

import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/12/5 1:10
 */
public interface SysUserMapperPoni {

    List<SysUser> queryUserByAge(Integer age);

}
