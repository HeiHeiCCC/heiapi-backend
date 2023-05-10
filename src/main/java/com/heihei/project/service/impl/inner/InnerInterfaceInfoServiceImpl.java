package com.heihei.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heihei.heiapicommon.model.entity.InterfaceInfo;
import com.heihei.heiapicommon.service.InnerInterfaceInfoService;
import com.heihei.project.common.ErrorCode;
import com.heihei.project.exception.BusinessException;
import com.heihei.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String path, String method) {
        if (StringUtils.isAnyBlank(path, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        QueryWrapper<InterfaceInfo> query = new QueryWrapper<>();
        query.eq("url", path).eq("method", method);

        return interfaceInfoMapper.selectOne(query);


    }
}
