package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Headphone;

@Configuration
public class BeanConfiguration {
	@Bean
	public Headphone headphone() {
		Headphone bean = new Headphone("sundara", 300, "planar", 90);
		// bean.setName("sundara");
		// bean.setDriverType("planar");
		// bean.setPadMaterial("pleather");
		return bean;
	}
}
