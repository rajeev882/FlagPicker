package com.flag.picker.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.flag.picker.config.FlagPickerContants.CONTINENTS;
import static com.flag.picker.config.FlagPickerContants.COUNTRIES;
import static com.flag.picker.config.FlagPickerContants.FLAG_PICKER;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h1>FlagPickerApplication !</h1> The FlagPickerSwaggerConfig is Swagger2 config implementation.
 *
 * @author Rajeev kumar
 * @version 1.0
 * @since 2020-03-19
 */

@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.flag.picker")
public class FlagPickerSwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setContextPath(FLAG_PICKER);
	}

	private Predicate<String> postPaths() {
		return or(regex(CONTINENTS), regex(COUNTRIES));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Flag Picker REST API")
				.description("Flag Picker REST API reference for developers").version("1.0").build();
	}
}