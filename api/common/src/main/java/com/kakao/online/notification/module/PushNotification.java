package com.kakao.online.notification.module;

import com.kakao.online.notification.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PushNotification extends Notification {

    @Override
    public void sendNotification() {
        System.out.println("push");
    }
}
