package com.heihei.project.model.vo;

import com.heihei.heiapicommon.model.entity.InterfaceInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InterfaceInfoVO extends InterfaceInfo {


    /**
     * 调用次数
     */
    private Integer totalNum;

    public static final long serialVersionUID = 1l;
}
