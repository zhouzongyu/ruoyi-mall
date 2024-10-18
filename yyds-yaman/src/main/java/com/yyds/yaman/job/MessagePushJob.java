package com.yyds.yaman.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessagePushJob {
    @Async
    @Scheduled(cron = "00 0/1 * * * ?")
    public void pushMessage(){
  }
}
