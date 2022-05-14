package br.dev.silascunha.heisenberg.service.impl;

import java.util.List;

import br.dev.silascunha.heisenberg.dto.ExameInput;
import br.dev.silascunha.heisenberg.service.OrientacaoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.silascunha.heisenberg.model.Exame;
import br.dev.silascunha.heisenberg.repository.ExameRepository;
import br.dev.silascunha.heisenberg.service.ExameService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExameServiceImpl implements ExameService {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private OrientacaoService orientacaoService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Exame getExameById(Integer id) {
        Exame exame = exameRepository.findById(id).get();

        return exame;
    }

    @Override
    public List<Exame> getAllExames() {
        List<Exame> exames = exameRepository.findAll();

        return exames;
    }

    @Override
    @Transactional
    public Exame saveExame(ExameInput exameInput) {
        Exame exame = modelMapper.map(exameInput, Exame.class);

        System.out.println(exame);
        exameRepository.save(exame);

        exameInput.getOrientacoes().forEach(orientacaoInput -> {
            orientacaoInput.setIdExame(exame.getId());

            orientacaoService.saveOrientacao(orientacaoInput);
        });

        return exame;
    }

    @Override
    @Transactional
    public Exame updateExame(ExameInput exameInput, Integer id) {
        Exame exameInDB = exameRepository.getById(id);

        modelMapper.map(exameInput, exameInDB);

        return exameRepository.save(exameInDB);
    }

    @Override
    public void deleteExame(Integer id) {
        exameRepository.deleteById(id);
    }

    @Override
    public List<Exame> pesquisarExame(String pesquisa) {
        List<Exame> exames = exameRepository.searchExame(pesquisa);

        return exames;
    }

}
