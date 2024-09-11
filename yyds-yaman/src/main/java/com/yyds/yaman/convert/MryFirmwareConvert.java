package com.yyds.yaman.convert;
import com.yyds.yaman.domain.MryFirmware;
import com.yyds.yaman.pojo.dto.MryFirmwareDTO;
import com.yyds.yaman.pojo.vo.MryFirmwareVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 *  固件版本  DO <=> DTO <=> VO / BO / Query
 *
 * @author zzy
 */
@Mapper(componentModel = "spring")
public interface MryFirmwareConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MryFirmwareDTO do2dto(MryFirmware source);

    /**
     * @param source DTO
     * @return DO
     */
    MryFirmware dto2do(MryFirmwareDTO source);

    List<MryFirmwareVO> dos2vos(List<MryFirmware> list);
}
