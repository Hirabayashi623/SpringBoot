package com.tuyano.springboot.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public SampleBean get() {
		return new SampleBean();
	}
}
