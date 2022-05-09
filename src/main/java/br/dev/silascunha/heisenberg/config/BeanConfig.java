package br.dev.silascunha.heisenberg.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.model.Orientacao;

@Configuration
public class BeanConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //TODO - Adicionar mapeamentos mais assertivos aqui
//        TypeMap<Orientacao, OrientacaoInput> orientacaoToOrientacaoDto = modelMapper.createTypeMap(Orientacao.class, OrientacaoInput.class);
//
//        orientacaoToOrientacaoDto.addMappings(mapper -> {
//            mapper.map(src -> src.getExame().getId(), OrientacaoInput::setIdExame);
//        });

        return modelMapper;
    }

}
