package com.kakao.online.notification.model;

import com.kakao.online.notification.module.EmailNotification;
import com.kakao.online.notification.module.KakaoTalkNotification;
import com.kakao.online.notification.module.PushNotification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Comment;
import org.springframework.cglib.proxy.Factory;

@Slf4j
@RequiredArgsConstructor
@Comment
public class NotificationFactory implements CommonFactory {

    private final EmailNotification emailNotification;
    private final KakaoTalkNotification kakaoTalkNotification;
    private final PushNotification pushNotification;

    @Override
}
