package com.yyds.yaman.convert;
import com.yyds.yaman.domain.MryNews;
import com.yyds.yaman.pojo.dto.MryNewsDTO;
import com.yyds.yaman.pojo.vo.MryNewsVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 资讯文章  DO <=> DTO <=> VO / BO / Query
 *
 * @author zzy
 */
@Mapper(componentModel = "spring")
public interface MryNewsConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MryNewsDTO do2dto(MryNews source);

    /**
     * @param source DTO
     * @return DO
     */
    MryNews dto2do(MryNewsDTO source);

    List<MryNewsVO> dos2vos(List<MryNews> list);
}
