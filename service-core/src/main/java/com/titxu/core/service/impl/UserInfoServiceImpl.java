package com.titxu.core.service.impl;

import com.titxu.core.pojo.entity.UserInfo;
import com.titxu.core.mapper.UserInfoMapper;
import com.titxu.core.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
