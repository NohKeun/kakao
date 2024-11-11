//package com.kakao.online.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
//import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
//import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableJdbcAuditing
//@EnableJdbcRepositories( basePackages = "com.kakao.online.jpa.data"
//		               , jdbcOperationsRef = "namedParameterJdbcTemplate"
//					   , transactionManagerRef = "transactionManager"
//					   )
//public class DatabaseConfig extends AbstractJdbcConfiguration {
//
//	@Bean
//	@Primary
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource userDataSource) {
//		return new NamedParameterJdbcTemplate(userDataSource);
//	}
//
//
//	@Bean
//	@Primary
//	public TransactionManager transactionManager(DataSource userDataSource) {
//		return new TransactionManager(userDataSource);
//	}
//
//	@Bean
//	public OracleRowMapper RowMapper()
//	{
//		return new OracleRowMapper();
//	}
//}
