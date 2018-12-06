package com.poni.service.impl;

import com.github.pagehelper.PageHelper;
import com.poni.mapper.SysUserMapper;
import com.poni.mapper.SysUserMapperPoni;
import com.poni.pojo.SysUser;
import com.poni.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/12/3 23:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperPoni sysUserMapperPoni;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addUser(SysUser user)throws Exception{
       return sysUserMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUser(SysUser user){
       return sysUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteUser(String userId){
       return sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserById(String userId){
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SysUser> queryUserList(SysUser user){
        return sysUserMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public  List<SysUser> queryUserListPaged(SysUser sysUser, Integer page,Integer pageSize){
        // 开始分页
        PageHelper.startPage(page, pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(sysUser.getNickname())) {
            criteria.andLike("nickname", "%" + sysUser.getNickname() + "%");
        }
        example.orderBy("registTime").desc();
        List<SysUser> userList = sysUserMapper.selectByExample(example);

        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public SysUser queryUserByAge(Integer age){
        List<SysUser> userList = sysUserMapperPoni.queryUserByAge(age);

        if (userList != null && !userList.isEmpty()) {
            return (SysUser)userList.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int saveUserTransactional(SysUser user){

        sysUserMapper.insert(user);

        int a = 1 / 0;

        user.setIsDelete(1);

        return  sysUserMapper.updateByPrimaryKeySelective(user);
    }
}
