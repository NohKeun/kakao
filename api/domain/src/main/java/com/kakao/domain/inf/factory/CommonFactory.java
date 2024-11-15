package com.kakao.domain.inf.factory;

import com.kakao.domain.inf.common.CustomerInf;
import com.kakao.domain.inf.common.NotificationInf;

public interface CommonFactory {

    NotificationInf injectionNotificationInf(String noti);

    CustomerInf injectionCustomerInf(String cust);

}
