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
                    text: '我是你的专属百科，有什么都可以问我哦~'
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

});

bot.run();