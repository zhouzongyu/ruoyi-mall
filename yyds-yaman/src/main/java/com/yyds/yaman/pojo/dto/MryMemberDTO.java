package com.yyds.yaman.pojo.dto;

import java.time.LocalDateTime;
import lombok.Data;
/**
 * 会员 DTO 对象
 *
 * @author zzy
 */
@Data
public class MryMemberDTO {
    private String id;
    private String userName;
    private String phone;
    private String vipNumber;
    private String birthDate;
    private Integer gender;
    private String address;
    private Integer skinType;
    private String remark;
    private String openId;
    private String miniProgramOpenId;
    private String unionId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
