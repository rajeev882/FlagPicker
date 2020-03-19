package com.flag.picker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.flag.picker.config.FlagPickerSwaggerConfig;

@SpringBootApplication
@Import(value = FlagPickerSwaggerConfig.class)
/**
* <h1>FlagPickerApplication ! </h1>
* The FlagPickerApplication is basic implementation of Continent and country look up.
*
* @author  Rajeev kumar
* @version 1.0
* @since   2020-03-19
*/
public class FlagPickerApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(FlagPickerApplication.class, args);
	}

}
