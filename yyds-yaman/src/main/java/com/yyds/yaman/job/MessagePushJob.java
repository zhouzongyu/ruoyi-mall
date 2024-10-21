package com.yyds.yaman.job;

import com.ruoyi.common.utils.StringUtils;
import com.yyds.yaman.domain.MryMember;
import com.yyds.yaman.domain.MryMemberMessage;
import com.yyds.yaman.domain.MryMessage;
import com.yyds.yaman.mapper.MryMemberMessageMapper;
import com.yyds.yaman.service.MryMemberService;
import com.yyds.yaman.service.MryMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component("messageTask")
@Slf4j
public class MessagePushJob {

    @Autowired
    private MryMessageService mryMessageService;

    @Autowired
    private MryMemberService memberService;

    @Autowired
    private MryMemberMessageMapper memberMessageMapper;



    @Scheduled(cron = "0/30 * * * * ?")
    public void pushMessage(){
        log.info("开始推送消息");
        List<MryMessage> messageList = mryMessageService.queryPaddingMessageList();
        for(MryMessage mryMessage : messageList) {
            handleSendMessage(mryMessage);
        }
    }

    private void handleSendMessage(MryMessage mryMessage) {
        try{
            List<MryMember> members = null;
            if(StringUtils.isEmpty(mryMessage.getAreaCodes())) {
                 members =   memberService.getMemberList();

            } else {
                String[] areaIds =  mryMessage.getAreaNames().split(",");
                members = memberService.getMemberListByAreaIds(Arrays.asList(areaIds));
            }

            if(members != null && members.size() > 0) {
                members.stream().forEach(item-> sendMessageToUser(mryMessage, item));
            }

        }catch (Exception e){
            log.error("msg_id:{} 发送消息失败" , mryMessage.getId());

        }finally {
            mryMessage.setPushStatus(1);
            mryMessageService.update(mryMessage);
        }
    }

    private void sendMessageToUser(MryMessage mryMessage , MryMember mryMember) {
        MryMemberMessage mryMemberMessage = new MryMemberMessage();
        mryMemberMessage.setUserId(mryMember.getId());
        mryMemberMessage.setMsgTitle(mryMessage.getMsgTitle());
        mryMemberMessage.setMsgContent(mryMessage.getMsgContent());
        mryMemberMessage.setSendStatus("1");
        mryMemberMessage.setMsgStatus("0");
        mryMemberMessage.setDeleteFlag(0);
        mryMemberMessage.setIsTop("0");
        mryMemberMessage.setSendTime(new Date());
        int rows = memberMessageMapper.insert(mryMemberMessage);
        log.info("msg_id:{}, user_ID:{} , rows :{}" , mryMessage.getId(), mryMember.getId(), rows);
    }
}
