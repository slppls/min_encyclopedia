package com.tencent.wxcloudrun.dto;

import lombok.Data;

/**
 * @author seanLau
 * @Description: 对话响应
 * @date 2023/2/16 14:04
 */
@Data
public class TalkResponse {

    private String _id;

    private String type;

    private Content content;



    @Data
    public static class Content {
        private String text;
    }

}
