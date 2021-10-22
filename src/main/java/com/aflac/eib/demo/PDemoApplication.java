package com.aflac.eib.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.aflac.eib.lib.LibraryConfigurationReference;

@SuppressWarnings({"squid:S4823"})
@SpringBootApplication
@Import({ LibraryConfigurationReference.class })
public class PDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PDemoApplication.class, args);

	}
}
