package com.heihei.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heihei.heiapicommon.model.entity.InterfaceInfo;
import com.heihei.project.common.ErrorCode;
import com.heihei.project.exception.BusinessException;
import com.heihei.project.mapper.InterfaceInfoMapper;
import com.heihei.project.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author HeiHei
* @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
* @createDate 2023-02-24 15:09:12
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }


        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestParams = interfaceInfo.getRequestParams();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        String userId = interfaceInfo.getUserId();
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        Date createTime = interfaceInfo.getCreateTime();
        Date updateTime = interfaceInfo.getUpdateTime();
        Integer isDelete = interfaceInfo.getIsDelete();

        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name, url, method)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }

    }
}




