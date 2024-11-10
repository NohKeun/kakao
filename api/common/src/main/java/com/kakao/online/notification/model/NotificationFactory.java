package com.kakao.online.notification.model;

import com.kakao.online.inf.common.CommonFactory;
import com.kakao.online.inf.common.NotificationInf;
import com.kakao.online.notification.module.EmailNotification;
import com.kakao.online.notification.module.KakaoTalkNotification;
import com.kakao.online.notification.module.PushNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NotificationFactory implements CommonFactory {

    private final EmailNotification emailNotification;
    private final KakaoTalkNotification kakaoTalkNotification;
    private final PushNotification pushNotification;

    @Override
    public NotificationInf create(String kakao) {
        if (StringUtils.compare(kakao, "email") == 0 ) {
            return emailNotification;
        }
        else if (StringUtils.compare(kakao, "kakaoTalk") == 0 ) {
            return kakaoTalkNotification;
        }
        else {
            return pushNotification;
        }
    }
}
