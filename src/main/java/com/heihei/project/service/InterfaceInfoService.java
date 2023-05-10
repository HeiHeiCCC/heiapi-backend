package com.heihei.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heihei.heiapicommon.model.entity.InterfaceInfo;

/**
* @author HeiHei
* @description 针对表【interface_info(接口信息表)】的数据库操作Service
* @createDate 2023-02-24 15:09:12
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

   void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
