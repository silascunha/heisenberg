package br.dev.silascunha.heisenberg.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
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
    public OrientacaoInput getOrientacaoById(Integer id) {
        Orientacao orientacao = orientacaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orientacao não encontrada com o id {" + id + "}"));

        return modelMapper.map(orientacao, OrientacaoInput.class);
    }

    @Override
    public List<OrientacaoInput> getAllOrientacoes() {
        List<Orientacao> orientacoes = orientacaoRepository.findAll();

        List<OrientacaoInput> orientacoesDto = orientacoes.stream()
            .map(orientacao -> modelMapper.map(orientacao, OrientacaoInput.class))
            .collect(Collectors.toList());

        return orientacoesDto;
    }

    @Override
    public Orientacao saveOrientacao(OrientacaoInput orientacaoInput) {
        Orientacao orientacao = modelMapper.map(orientacaoInput, Orientacao.class);

        System.out.println(orientacao.getExame().getId());

        return orientacaoRepository.save(orientacao);
    }

    @Override
    public Orientacao updateOrientacao(OrientacaoInput orientacaoInput, Integer id) {
        Orientacao orientacao = orientacaoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Orientacao não encontrada com o id {" + id + "}"));

        modelMapper.map(orientacaoInput, orientacao);

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
