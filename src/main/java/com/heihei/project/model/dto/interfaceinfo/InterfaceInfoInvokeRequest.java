package com.heihei.project.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @TableName product
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * 主键
     */
    private long id;

    /**
     * 请求参数
     */
    private String userRequestParams;

    public static final long serialVersionUID = 1L;


}