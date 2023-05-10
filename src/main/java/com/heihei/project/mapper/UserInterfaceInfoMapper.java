package com.heihei.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heihei.heiapicommon.model.entity.UserInterfaceInfo;

import java.util.List;


/**
* @author HeiHei
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2023-03-05 17:09:15
* @Entity generator.domain.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




