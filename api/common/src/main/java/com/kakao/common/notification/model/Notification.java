package com.kakao.common.notification.model;

import com.kakao.domain.inf.common.NotificationInf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class Notification implements NotificationInf {

    @Override
    public void sendNotification() {
        log.debug("보내기 전");

        /**
         * 해당 템플릿이 정상적인 템플릿인가
         * */
    }

    public void verify() {
        log.debug("공통적으로 검증할 로직 추가");
    }
}
