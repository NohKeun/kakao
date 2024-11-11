package com.kakao.api.notification.model;

import com.kakao.api.inf.factory.CommonFactory;
import com.kakao.api.inf.common.NotificationInf;
import com.kakao.api.notification.module.EmailNotification;
import com.kakao.api.notification.module.KakaoTalkNotification;
import com.kakao.api.notification.module.PushNotification;
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
    public NotificationInf injectionNotificationInf(String noti) {
        if (StringUtils.compare(noti, "email") == 0 ) {
            return emailNotification;
        }
        else if (StringUtils.compare(noti, "kakaoTalk") == 0 ) {
            return kakaoTalkNotification;
        }
        else {
            return pushNotification;
        }
    }
}
