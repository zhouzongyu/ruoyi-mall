package com.cyl.manager.act.domain.query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户领券记录 查询 对象
 *
 * @author zcc
 */
@ApiModel(description="用户领券记录 查询 对象")
@Data
public class MemberCouponQuery {
    @ApiModelProperty("活动id 精确匹配")
    private Long couponActivityId;

    @ApiModelProperty("用户id 精确匹配")
    private Long memberId;

    @ApiModelProperty("0未使用  1已使用 精确匹配")
    private Integer useStatus;


}