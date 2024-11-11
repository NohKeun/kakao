package com.kakao.api.notification.module;

import com.kakao.api.notification.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoTalkNotification extends Notification {

    @Override
    public void sendNotification() {
        System.out.println("Kakao Talk");
    }
}
