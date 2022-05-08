package br.dev.silascunha.heisenberg.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.dev.silascunha.heisenberg.dto.OrientacaoDTO;
import br.dev.silascunha.heisenberg.model.Orientacao;

@Configuration
public class BeanConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //TODO - Adicionar mapeamentos mais assertivos aqui
        TypeMap<Orientacao, OrientacaoDTO> orientacaoToOrientacaoDto = modelMapper.createTypeMap(Orientacao.class, OrientacaoDTO.class);

        orientacaoToOrientacaoDto.addMappings(mapper -> {
            mapper.skip(OrientacaoDTO::setId);
            mapper.skip(OrientacaoDTO::setIdTipo);
            mapper.skip(OrientacaoDTO::setNomeTipo);
            mapper.map(src -> src.getExame().getId(), OrientacaoDTO::setIdExame);
        });

        return modelMapper;
    }

}
