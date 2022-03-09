package com.crs.lt.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author user206
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class CrsEurekaServerApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrsEurekaServerApplication.class, args);
	}

}
