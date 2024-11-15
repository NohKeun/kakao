package com.kakao.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableJpaRepositories( basePackages = {"com.kakao"}
        , bootstrapMode = BootstrapMode.DEFAULT
)
@EnableJpaAuditing
public class JpaConfig {

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource userDataSource) {
        return new DataSourceTransactionManager(userDataSource);
    }
}
