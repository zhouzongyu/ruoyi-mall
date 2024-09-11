package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import java.util.List;

import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 会员 数据视图对象
 *
 * @author zzy
 */
@Data
public class MryMemberVO {
    @ApiModelProperty("用户ID" )
    private String id;

    @ApiModelProperty("用户名" )
    @Excel(name = "用户名" )
    private String userName;

    @ApiModelProperty("手机号" )
    @Excel(name = "手机号" )
    private String phone;

    @ApiModelProperty("会员号" )
    @Excel(name = "会员号" )
    private String vipNumber;

    @ApiModelProperty("设备状态 1-已绑定 0-未绑定" )
    private Integer deviceStatus;

    @ApiModelProperty("备注" )
    private String remark;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间" )
    private LocalDateTime createTime;


    @ApiModelProperty("更新时间" )
    private LocalDateTime updateTime;

    @ApiModelProperty("绑定设备列表" )
    private List<MryMemberDeviceVo> devices;
}
