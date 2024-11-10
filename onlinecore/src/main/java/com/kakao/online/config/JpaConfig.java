package com.kakao.online.config;

@Slf4j
@Configuration
@EnableJpaRepositories( basePackages = {"com.kakao.online"}
        , repositoryBaseClass = BaseRepositoryImpl.class
        , bootstrapMode = BootstrapMode.DEFAULT
)
@EnableJpaAuditing(dateTimeProviderRef = "hopesDateTimeProvider")
public class JpaConfig {
}
