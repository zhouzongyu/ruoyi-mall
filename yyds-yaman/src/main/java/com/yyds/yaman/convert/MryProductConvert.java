package com.yyds.yaman.convert;

import com.yyds.yaman.domain.MryProduct;
import com.yyds.yaman.pojo.dto.MryProductDTO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 产品管理  DO <=> DTO <=> VO / BO / Query
 *
 * @author zzy
 */
@Mapper(componentModel = "spring")
public interface MryProductConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MryProductDTO do2dto(MryProduct source);

    /**
     * @param source DTO
     * @return DO
     */
    MryProduct dto2do(MryProductDTO source);

}
