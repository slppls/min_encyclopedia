package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.TalkRequest;
import com.tencent.wxcloudrun.dto.TalkResponse;
import com.tencent.wxcloudrun.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author seanLau
 * @Description: 对话控制器
 * @date 2023/2/16 9:57
 */
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;


    @GetMapping("/talk")
    TalkResponse talk(String acceptStr) {

        TalkResponse.Content content = new TalkResponse.Content();
        content.setText(chatService.talkWithBoot(acceptStr));

        TalkResponse response = new TalkResponse();
        response.set_id(UUID.randomUUID().toString());
        response.setType("text");
        response.setContent(content);

        return response;

    }




}
