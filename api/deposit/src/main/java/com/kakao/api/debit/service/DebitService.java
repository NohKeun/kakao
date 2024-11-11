package com.kakao.api.debit.service;

import com.kakao.api.inf.common.CommonFactory;
import com.kakao.api.inf.common.NotificationInf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DebitService {
    private final CommonFactory commonFactory;

    public void debit() {
        NotificationInf notificationInf = commonFactory.create("kakaoTalk");
        notificationInf.sendNotification();
    }
}
