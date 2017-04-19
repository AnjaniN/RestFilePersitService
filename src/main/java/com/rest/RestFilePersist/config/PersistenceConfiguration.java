package com.rest.RestFilePersist.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

public class PersistenceConfiguration {
	
		
		@Bean
		@ConfigurationProperties(prefix="spring.datasource")
		public DataSource dataSource(){
			return DataSourceBuilder.create().build();
			
		}
			
		

}
