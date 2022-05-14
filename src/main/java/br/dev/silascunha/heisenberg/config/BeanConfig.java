package br.dev.silascunha.heisenberg.config;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.dto.SinonimoInput;
import br.dev.silascunha.heisenberg.model.Orientacao;
import br.dev.silascunha.heisenberg.model.Sinonimo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.config.Configuration.AccessLevel;
@Configuration
public class BeanConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PRIVATE)
                .setAmbiguityIgnored(true);

        //TODO - Adicionar mapeamentos mais assertivos aqui
        TypeMap<OrientacaoInput, Orientacao> inputToOrientacao = modelMapper.createTypeMap(OrientacaoInput.class, Orientacao.class);

        inputToOrientacao.addMappings(mapper -> {
           mapper.skip(Orientacao::setId);
        });

        return modelMapper;
    }

}
