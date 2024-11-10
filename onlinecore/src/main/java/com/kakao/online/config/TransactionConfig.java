package com.kakao.online.config;

import com.oneqoncore.core.transaction.OneQTransactionAttributeSource;
import com.oneqoncore.core.transaction.OneQTransactionInterceptor;
import com.oneqoncore.core.transaction.OneQTransactionManager;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Slf4j
@Aspect
@Configuration
public class TransactionConfig {

    @Autowired @Qualifier("transactionManager")
    private OneQTransactionManager transactionManager;

    @Value("#{new Integer('${oneqoncore.transaction.defaultTimeoutSec:60}')}")
    private Integer DEFAULT_TIMEOUT;

//    @Bean
//    public TransactionInterceptor txAdvice() {
//        log.info("txAdvice start.....");
//
//        MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
//        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
//        transactionAttribute.setName("1QServiceTransaction");
//        transactionAttribute.setPropagationBehavior(0);//PROPAGATION_REQUIRED
//        //transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
//        transactionAttribute.setTimeout(60);
//        transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Throwable.class)));
//        source.setTransactionAttribute(transactionAttribute);
//
//        TransactionInterceptor txadvice = new TransactionInterceptor();
//        txadvice.setTransactionAttributeSource(source);
//        txadvice.setTransactionManager(transactionManager);
//
//        return txadvice;
//    }


    @Bean
    public TransactionInterceptor txAdvice() {
        log.debug("txAdvice start.....");
        OneQTransactionAttributeSource source        = new OneQTransactionAttributeSource(DEFAULT_TIMEOUT);
        OneQTransactionInterceptor     txInterceptor = new OneQTransactionInterceptor();
        txInterceptor.setTransactionAttributeSource(source);
        txInterceptor.setTransactionManager(transactionManager);
        return txInterceptor;
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        log.info("txAdviceAdvisor start.....");

        AspectJExpressionPointcut requiredTx = new AspectJExpressionPointcut();
        //requiredTx.setExpression("execution(* inoan..*SVC.*(..))");
        //requiredTx.setExpression("execution(* com.tifscore..*SVC.*(..))");
//        requiredTx.setExpression("execution(* com.inobis..service.*.*(..))");
        requiredTx.setExpression("execution(public * com.oneqoncore..*..*..*SVC.execute(..)) || execution(public * com.inobis..*..*SVC.execute(..))");

        return new DefaultPointcutAdvisor(requiredTx, txAdvice());
    }
}