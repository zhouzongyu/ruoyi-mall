package com.ruoyi;

import com.cyl.wechat.WechatPayData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class},
        scanBasePackages = {"com.ruoyi", "com.cyl"}
)
@Slf4j
//@EnableConfigurationProperties(WechatPayData.class)
@EnableScheduling
public class RuoYiApplication {
    public static void main(String[] args) throws UnknownHostException {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        Environment env = new SpringApplication(RuoYiApplication.class).run(args).getEnvironment();
        String port = env.getProperty("server.port");
        String context = env.getProperty("server.servlet.context-path");
        String path = port + "" + context + "swagger-ui/index.html";
        String externalAPI = InetAddress.getLocalHost().getHostAddress();
        log.info(
                "Access URLs:\n----------------------------------------------------------\n\t"
                        + "Local-API: \t\thttp://127.0.0.1:{}\n\t"
                        + "External-API: \thttp://{}:{}\n\t"
                        + "web-URL: \t\thttp://127.0.0.1:{}/index.html\n\t----------------------------------------------------------",
                path, externalAPI, path, port);
    }
}
