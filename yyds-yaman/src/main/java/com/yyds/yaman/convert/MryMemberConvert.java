package com.yyds.yaman.convert;
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.pojo.dto.MryMemberDTO;
import com.yyds.yaman.pojo.vo.MryMemberVO;
import org.mapstruct.Mapper;
import java.util.List;
/**
 * 会员  DO <=> DTO <=> VO / BO / Query
 *
 * @author zzy
 */
@Mapper(componentModel = "spring")
public interface MryMemberConvert  {

    /**
     * @param source DO
     * @return DTO
     */
    MryMemberDTO do2dto(MryMember source);

    /**
     * @param source DTO
     * @return DO
     */
    MryMember dto2do(MryMemberDTO source);

    List<MryMemberVO> dos2vos(List<MryMember> list);
}
