package com.poni.mapper;

import com.poni.pojo.SysUser;
import com.poni.utils.MyMapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface SysUserMapper extends MyMapper<SysUser> {
}