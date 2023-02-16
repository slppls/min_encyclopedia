var bot = new ChatSDK({
    config: {
        navbar: {
            title: '小民的百科全书'
        },
        robot: {
            avatar: '/img/zhima.JPG'
        },
        // 用户头像
        user: {
            avatar: '/img/dog.JPG',
        },
        messages: [
            {
                type: 'text',
                content: {
                    text: '我是芝麻～你要跟我聊聊什么吗？'
                }
            }
        ]
    },
    requests: {
        send: function (msg) {
            if (msg.type === 'text') {
                return {
                    url: '//localhost/chat/talk',
                    data: {
                        acceptStr: msg.content.text
                    }
                };
            }
        }
    },
    handled: {
        /**
         *
         * 解析请求返回的数据
         * @param {object} res - 请求返回的数据
         * @param {object} requestType - 请求类型
         * @return {array}
         */
        parseResponse: function (res, requestType) {
            // 根据 requestType 处理数据
            debugger
            if (requestType === 'send' && res.data) {
                // 用 isv 消息解析器处理数据
                return isvParser({ data: res.data });
            }

            // 不需要处理的数据直接返回
            return res;
        },
    },
});

bot.run();