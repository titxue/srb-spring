package com.titxu.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.titxu.common.exception.Assert;
import com.titxu.common.result.ResponseEnum;
import com.titxu.core.convert.UserInfoConvert;
import com.titxu.core.pojo.dto.UserInfoDto;
import com.titxu.core.pojo.entity.UserInfo;
import com.titxu.core.mapper.UserInfoMapper;
import com.titxu.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户基本信息 服务实现类
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    private UserInfoMapper mapper;

    private UserInfoConvert convert;

    @Override
    public Boolean checkMobile(String mobile) {
        LambdaQueryWrapper<UserInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserInfo::getMobile,mobile);
        // 如果大于0，说明手机号已经被注册
        return mapper.selectCount(wrapper) > 0;
    }

    @Override
    public UserInfoDto register(UserInfoDto toDto) {
        UserInfo userInfo = convert.toEntity(toDto);
        int insert = mapper.insert(userInfo);
        Assert.isTrue(insert == 1, ResponseEnum.REGISTER_ERROR);
        return convert.toDto(userInfo);
    }

    @Autowired
    public void setMapper(UserInfoMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public void setConvert(UserInfoConvert convert) {
        this.convert = convert;
    }
}
