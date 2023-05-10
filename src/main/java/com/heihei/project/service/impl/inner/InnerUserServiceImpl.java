package com.heihei.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heihei.heiapicommon.model.entity.User;
import com.heihei.heiapicommon.service.InnerUserService;
import com.heihei.project.common.ErrorCode;
import com.heihei.project.exception.BusinessException;
import com.heihei.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;


import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {

        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        QueryWrapper<User> query = new QueryWrapper<>();
        query.eq("accessKey", accessKey);

        return userMapper.selectOne(query);
    }
}
