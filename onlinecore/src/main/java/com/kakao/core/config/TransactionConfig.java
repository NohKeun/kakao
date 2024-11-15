package com.kakao.core.config;
/*
 * Copyright WINDCOZEE (c) 2017.
 */

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;

import static org.springframework.transaction.TransactionDefinition.PROPAGATION_REQUIRED;

@Slf4j
@Aspect
@Configuration
public class TransactionConfig {

    @Autowired @Qualifier("transactionManager")
    //JpaConfig 주입한 Bean 설정 가져오기
    private TransactionManager transactionManager;

    private Integer DEFAULT_TIMEOUT = 60;

    @Bean
    public TransactionInterceptor txAdvice() {
        log.debug("txAdvice start.....");

        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
        transactionAttribute.setName("Kakao-Transaction");
        transactionAttribute.setPropagationBehavior(PROPAGATION_REQUIRED); //현재 트랜잭션이 있으면 그 트랜잭션을 사용하고, 없으면 새로 생성
        transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Throwable.class))); //모든 오류에 대해서 RollBack 함
        transactionAttribute.setTimeout(DEFAULT_TIMEOUT);

        // TransactionInterceptor 설정
        TransactionInterceptor txInterceptor = new TransactionInterceptor();
        txInterceptor.setTransactionAttributeSource((TransactionAttributeSource) transactionAttribute);
        txInterceptor.setTransactionManager(transactionManager);
        return txInterceptor;
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        log.info("txAdviceAdvisor start.....");

        AspectJExpressionPointcut requiredTx = new AspectJExpressionPointcut();

        requiredTx.setExpression("execution(public * com.kakao..service.*.*(..))"); //com.kakao 하위 service 패키지의 모든 public 함수

        return new DefaultPointcutAdvisor(requiredTx, txAdvice());
    }
}