package com.heihei.project.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.heihei.heiapicommon.model.entity.InterfaceInfo;
import com.heihei.heiapicommon.model.entity.UserInterfaceInfo;
import com.heihei.project.annotation.AuthCheck;
import com.heihei.project.common.BaseResponse;
import com.heihei.project.common.ErrorCode;
import com.heihei.project.common.ResultUtils;
import com.heihei.project.exception.BusinessException;
import com.heihei.project.mapper.UserInterfaceInfoMapper;
import com.heihei.project.model.vo.InterfaceInfoVO;
import com.heihei.project.service.InterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 * @author HeiHei
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {
    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo(){
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdMap = userInterfaceInfoList.stream().collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtil.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> collect = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = BeanUtil.copyProperties(interfaceInfo, InterfaceInfoVO.class);
            Integer totalNum = interfaceInfoIdMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());

        return ResultUtils.success(collect);
    }
}
