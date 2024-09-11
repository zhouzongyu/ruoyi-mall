package com.yyds.yaman.pojo.vo;

import java.time.LocalDateTime;
import com.ruoyi.common.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/**
 * 会员 数据视图对象
 * 
 * @author zzy
 */
@Data
public class MryMemberVO  {
   /** ID */
    private Integer id;
   /** 用户名 */
    @Excel(name = "用户名")
    private String userName;
   /** 手机号 */
    @Excel(name = "手机号")
    private String phone;
   /** 会员号 */
    @Excel(name = "会员号")
    private String vipNumber;
   /** 出生日期 */
    @Excel(name = "出生日期")
    private String birthDate;
   /** 性别 */
    @Excel(name = "性别")
    private Integer gender;
   /** 居住地区 */
    @Excel(name = "居住地区")
    private String address;
   /** 用户肤质 */
    @Excel(name = "用户肤质")
    private Integer skinType;
   /** 备注 */
    @Excel(name = "备注")
    private String remark;
   /** 公众号openId */
    @Excel(name = "公众号openId")
    private String openId;
   /** 小程序openId */
    @Excel(name = "小程序openId")
    private String miniProgramOpenId;
   /** unionid */
    @Excel(name = "unionid")
    private String unionId;
   /** 创建时间 */
    private LocalDateTime createTime;
   /** 更新时间 */
    private LocalDateTime updateTime;
}
