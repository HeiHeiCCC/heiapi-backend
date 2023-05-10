package com.heihei.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heihei.heiapicommon.model.entity.UserInterfaceInfo;
import com.heihei.project.common.ErrorCode;
import com.heihei.project.exception.BusinessException;
import com.heihei.project.mapper.UserInterfaceInfoMapper;
import com.heihei.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
* @author HeiHei
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Service实现
* @createDate 2023-03-05 17:09:15
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = userInterfaceInfo.getId();
        Long userId = userInterfaceInfo.getUserId();
        Long interfaceInfoId = userInterfaceInfo.getInterfaceInfoId();
        Integer totalNum = userInterfaceInfo.getTotalNum();
        Integer leftNum = userInterfaceInfo.getLeftNum();
        Integer status = userInterfaceInfo.getStatus();
        Date createTime = userInterfaceInfo.getCreateTime();
        Date updateTime = userInterfaceInfo.getUpdateTime();
        Integer isDelete = userInterfaceInfo.getIsDelete();



        // 创建时，所有参数必须非空
        if (add) {
            if (id <= 0 || userId <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (leftNum < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于0");
        }
    }


    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        boolean update = update().eq("interfaceInfoId", interfaceInfoId)
                .eq("userId", userId)
                .gt("leftNum", 0)
                .setSql("leftNum = leftNum - 1, totalNum = totalNum + 1").update();


        return update;
    }

}




