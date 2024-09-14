package com.yyds.yaman.pojo.query;

import java.time.LocalDateTime;
import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设备使用记录 查询 对象
 *
 * @author zzy
 */
@ApiModel(description="设备使用记录")
@Data
public class MryDeviceUsageRecordQuery {

    @ApiModelProperty("设备ID 精确匹配")
    private String deviceId;
}
