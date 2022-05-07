package br.dev.silascunha.heisenberg.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //TODO - Adicionar mapeamentos mais assertivos aqui

        return modelMapper;
    }

}
