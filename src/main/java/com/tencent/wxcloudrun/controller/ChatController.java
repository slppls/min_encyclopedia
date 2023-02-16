package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.TalkRequest;
import com.tencent.wxcloudrun.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PostMapping("/talk")
    ApiResponse talk(@RequestBody TalkRequest talkRequest) {

        return ApiResponse.ok(chatService.talkWithBoot(talkRequest.getAcceptStr()));

    }




}
