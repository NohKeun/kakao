package com.kakao.common.notification.module;

import com.kakao.common.notification.model.Notification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PushNotification extends Notification {

    @Override
    public void sendNotification() {
        System.out.println("push");

        super.verify();
    }
}
