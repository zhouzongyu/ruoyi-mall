package com.yyds.yaman.convert;
import com.yyds.yaman.pojo.dto.MryDeviceDTO;
import com.yyds.yaman.pojo.vo.MryMemberDeviceVo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 【请填写功能名称】  DO <=> DTO <=> VO / BO / Query
 *
 * @author zzy
 */
@Mapper(componentModel = "spring")
public interface MryDeviceConvert  {



    List<MryMemberDeviceVo> dos2vos(List<MryDeviceDTO> list);
}
