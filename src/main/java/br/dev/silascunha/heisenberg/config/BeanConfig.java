package br.dev.silascunha.heisenberg.config;

import br.dev.silascunha.heisenberg.dto.SinonimoInput;
import br.dev.silascunha.heisenberg.model.Sinonimo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.model.Orientacao;

@Configuration
public class BeanConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        //TODO - Adicionar mapeamentos mais assertivos aqui
        TypeMap<OrientacaoInput, Orientacao> inputToOrientacao = modelMapper.createTypeMap(OrientacaoInput.class, Orientacao.class);
        TypeMap<SinonimoInput, Sinonimo> inputToSinonimo = modelMapper.createTypeMap(SinonimoInput.class, Sinonimo.class);

        inputToOrientacao.addMappings(mapper -> {
           mapper.skip(Orientacao::setId);
        });

        return modelMapper;
    }

}
