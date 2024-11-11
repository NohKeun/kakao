package com.kakao.online.transfer.service;

import com.kakao.online.inf.common.CommonFactory;
import com.kakao.online.inf.common.NotificationInf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class Transfer {
    private final CommonFactory commonFactory;

    public void send() {
        NotificationInf notificationInf = commonFactory.create("kakaoTalk");
        notificationInf.sendNotification();
    }
}
