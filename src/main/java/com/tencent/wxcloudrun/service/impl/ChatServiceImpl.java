package com.tencent.wxcloudrun.service.impl;

import com.alibaba.fastjson.JSON;
import com.tencent.wxcloudrun.service.ChatService;
import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.List;

/**
 * @author seanLau
 * @Description: 对话service实现
 * @date 2023/2/16 10:00
 */
@Service
@Slf4j
public class ChatServiceImpl implements ChatService {

    @Value("${open-api.token}")
    private String openApiToken;

    @Override
    public String talkWithBoot(String acceptStr) {

        if(!StringUtils.hasText(acceptStr)) {
            return  "小刘说，必须告诉他点什么，才能做出回答";
        }

        log.info("有人开始提问拉，问题是:{}",acceptStr);

        // 超时时间 暂定3分钟
        Duration duration = Duration.ofMinutes(5L);

        OpenAiService openAiService = new OpenAiService(openApiToken, duration);

        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("text-davinci-003")
                .temperature(0.6D)
                .prompt(acceptStr)
                .echo(false)
                .n(1)
                .topP(1D)
                .frequencyPenalty(0D)
                .presencePenalty(0D)
                .maxTokens(4000)
                .user("小民的百科全书")
                .build();

        List<CompletionChoice> result;

        try {
            result = openAiService.createCompletion(completionRequest).getChoices();
        }catch (Exception e) {
            // 一般都是超时
            String err = e.getMessage();
            return "哎呀，超时了，告诉小刘抓紧升级小水管，让它更流畅("+err+")";
        }

        if(CollectionUtils.isEmpty(result)) {
            return "百科全书也有不知道的事呢，告诉小刘赶紧训练它";
        }

        // 目前入参要求只返回一个预测完善 所以有结果只取第一个就行
        CompletionChoice completionChoice = result.get(0);

        log.debug("获取到的信息：{}", JSON.toJSONString(completionChoice));

        return completionChoice.getText();
    }
}
