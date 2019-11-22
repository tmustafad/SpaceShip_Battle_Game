package com.turkmen.xebialabs.xlspaceship.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by turkmenmustafademirci on 11/10/19.
 * For Creating mapper bean
 */

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
