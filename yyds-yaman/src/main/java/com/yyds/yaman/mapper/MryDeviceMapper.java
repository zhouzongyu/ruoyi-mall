package com.yyds.yaman.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyds.yaman.domain.MryDevice;
import com.yyds.yaman.pojo.dto.MryDeviceDTO;
import com.yyds.yaman.pojo.vo.MryMemberDeviceDetailVo;
import com.yyds.yaman.pojo.vo.MryMemberDeviceVo;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author zzy
 */
public interface MryDeviceMapper extends BaseMapper<MryDevice> {

    List<MryMemberDeviceVo> selectDeviceListByUserId(@Param("userId") String userId);
    List<MryMemberDeviceDetailVo> selectDeviceDetailListByUserId(@Param("userId") String userId);
    List<MryDeviceDTO> selectDeviceListByUserIds(@Param("userIds") List<String> userId);

    List<MryDevice> selectByEntity(MryDevice mryDevice);

    int updateDelFlagByIds(@Param("ids") String[] ids);
}
