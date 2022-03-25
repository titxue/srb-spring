package com.titxu.core.service.impl;

import com.titxu.core.pojo.entity.UserLoginRecord;
import com.titxu.core.mapper.UserLoginRecordMapper;
import com.titxu.core.service.UserLoginRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录记录表 服务实现类
 * </p>
 *
 * @author Lxue
 * @since 2022-03-22
 */
@Service
public class UserLoginRecordServiceImpl extends ServiceImpl<UserLoginRecordMapper, UserLoginRecord> implements UserLoginRecordService {

}
