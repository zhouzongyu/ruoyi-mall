package com.ruoyi.common.utils.ip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;

/**
 * 获取地址类
 * 
 * @author ruoyi
 */
public class AddressUtils
{
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    // IP地址查询
    public static final String IP_URL = "http://whois.pconline.com.cn/ipJson.jsp";

    // 未知地址
    public static final String UNKNOWN = "XX XX";

    public static String getRealAddressByIP(String ip)
    {
        String address = UNKNOWN;
        // 内网不查询
        if (IpUtils.internalIp(ip))
        {
            return "内网IP";
        }
        if (RuoYiConfig.isAddressEnabled() || true)
        {
            try
            {
                String rspStr = HttpUtils.sendGet(IP_URL, "ip=" + ip + "&json=true", Constants.GBK);
                if (StringUtils.isEmpty(rspStr))
                {
                    log.error("获取地理位置异常 {}", ip);
                    return getRealAddressByIPOther(ip);
                }

                //{"ip":"101.42.38.187","pro":"北京市","proCode":"110000","city":"北京市","cityCode":"110000","region":"","regionCode":"0","addr":"北京市 国创富盛通信技术有限公司","regionNames":"","err":""}

                JSONObject obj = JSONObject.parseObject(rspStr);
                String region = obj.getString("pro");
                String city = obj.getString("city");
                String operator = ((String)obj.get("addr")).split(" ")[1];
                return String.format("%s|%s|%s", region, city, operator);
            }
            catch (Exception e)
            {
                log.error("获取地理位置异常 {}", ip);
            }
        }
        return address;
    }

    public static String getRealAddressByIPOther(String ip){
        String rspStr = HttpUtils.sendGet("http://www.svlik.com/t/ipapi/ip.php", "ip=" + ip , Constants.UTF8);
        if (StringUtils.isEmpty(rspStr))
        {
            log.error("获取地理位置异常 {}", ip);
            return UNKNOWN;
        }else{
            JSONObject obj = JSONObject.parseObject(rspStr);
            String country = obj.getString("country");
            String area = obj.getString("area");
            return String.format("%s|%s", country, area);

        }
    }

    public static void main(String[] args) {
        System.out.println("地址：" + getRealAddressByIP("112.23.49.91"));
    }
}
