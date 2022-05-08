package br.dev.silascunha.heisenberg.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.silascunha.heisenberg.dto.OrientacaoDTO;
import br.dev.silascunha.heisenberg.model.Orientacao;
import br.dev.silascunha.heisenberg.repository.OrientacaoRepository;
import br.dev.silascunha.heisenberg.service.OrientacaoService;
import br.dev.silascunha.heisenberg.service.exception.ResourceNotFoundException;

@Service
public class OrientacaoServiceImpl implements OrientacaoService {

    @Autowired
    private OrientacaoRepository orientacaoRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public OrientacaoDTO getOrientacaoById(Integer id) {
        Orientacao orientacao = orientacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orientacao não encontrada com o id {" + id + "}"));

        return modelMapper.map(orientacao, OrientacaoDTO.class);
    }

    @Override
    public List<OrientacaoDTO> getAllOrientacoes() {
        List<Orientacao> orientacoes = orientacaoRepository.findAll();

        List<OrientacaoDTO> orientacoesDto = orientacoes.stream()
            .map(orientacao -> modelMapper.map(orientacao, OrientacaoDTO.class))
            .collect(Collectors.toList());

        return orientacoesDto;
    }

    @Override
    public Orientacao saveOrientacao(OrientacaoDTO orientacaoDto) {
        Orientacao orientacao = modelMapper.map(orientacaoDto, Orientacao.class);

        System.out.println(orientacaoDto);
        System.out.println(orientacao);

        
        return orientacaoRepository.save(orientacao);
    }

    @Override
    public Orientacao updateOrientacao(OrientacaoDTO orientacaoDto, Integer id) {
        Orientacao orientacao = orientacaoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Orientacao não encontrada com o id {" + id + "}"));

        modelMapper.map(orientacaoDto, orientacao);

        return orientacaoRepository.save(orientacao);
    }

    @Override
    public void deleteOrientacao(Integer id) {
        try {
            orientacaoRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceNotFoundException("Orientacao não encontrada com o id {" + id + "}");
        }
    }
    
}
