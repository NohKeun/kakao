package com.kakao.common.notification.module;

import com.kakao.common.notification.model.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailNotification extends Notification {

    @Override
    public void sendNotification() {
        super.sendNotification();
        System.out.println("email");

    }
}
