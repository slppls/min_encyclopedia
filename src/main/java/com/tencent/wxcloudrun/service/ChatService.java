package com.tencent.wxcloudrun.service;

/**
 * @author seanLau
 * @Description: 对话service
 * @date 2023/2/16 9:58
 */
public interface ChatService {


    /**
     * 与机器人对话
     * @param acceptStr 接收内容
     * @return
     */
    String talkWithBoot(String acceptStr);

}
