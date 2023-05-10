package com.heihei.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heihei.heiapicommon.model.entity.UserInterfaceInfo;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {


    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);

}
