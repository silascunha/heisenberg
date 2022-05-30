package br.dev.silascunha.heisenberg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import br.dev.silascunha.heisenberg.dto.ExameInput;
import br.dev.silascunha.heisenberg.dto.OrientacaoInput;
import br.dev.silascunha.heisenberg.dto.SinonimoInput;
import br.dev.silascunha.heisenberg.model.Orientacao;
import br.dev.silascunha.heisenberg.model.Sinonimo;
import br.dev.silascunha.heisenberg.service.OrientacaoService;
import br.dev.silascunha.heisenberg.service.exception.ResourceNotFoundException;
import br.dev.silascunha.heisenberg.service.exception.ValidacaoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        validarExameInput(exameInput, null);

        Exame exame = modelMapper.map(exameInput, Exame.class);
        exame.setSinonimos(
                exameInput.getSinonimos().stream()
                        .map(sinInput -> modelMapper.map(sinInput, Sinonimo.class)).collect(Collectors.toSet())
        );

        exame.setOrientacoes(
                exameInput.getOrientacoes().stream()
                        .map(oriInput -> modelMapper.map(oriInput, Orientacao.class)).collect(Collectors.toList())
        );

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
        validarExameInput(exameInput, id);

        Exame exameInDB = exameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exame não encontrado para o id {" + id + "}"));

        modelMapper.map(exameInput, exameInDB);

        Set<Sinonimo> sinonimos = exameInput.getSinonimos().stream()
                .map(sinInput -> modelMapper.map(sinInput, Sinonimo.class)).collect(Collectors.toSet());


        exameInDB.getSinonimos().retainAll(sinonimos);
        exameInDB.getSinonimos().addAll(sinonimos);

        exameRepository.save(exameInDB);

        if (exameInput.getOrientacoes() != null && !exameInput.getOrientacoes().isEmpty()) {
            List<Orientacao> orientacoes = new ArrayList<>(exameInDB.getOrientacoes());

            Map<Integer, OrientacaoInput> orientacaoInputMap = exameInput.getOrientacoes().stream()
                    .collect(Collectors.toMap(OrientacaoInput::getIdTipo, orientacaoInput -> orientacaoInput));


            orientacoes.forEach(orientacao -> {
                OrientacaoInput orientacaoInput = orientacaoInputMap.get(orientacao.getTipo().getId());

                if (orientacaoInput != null) {
                    orientacaoInput.setIdExame(id);
                    orientacaoService.updateOrientacao(orientacaoInput, orientacao.getId());
                    orientacaoInputMap.remove(orientacao.getTipo().getId());
                }
            });

            if (!orientacaoInputMap.isEmpty()) {
                orientacaoInputMap.values().forEach(orientacaoInput -> {
                    orientacaoInput.setIdExame(id);
                    orientacaoService.saveOrientacao(orientacaoInput);
                });
            }
        }

        return exameInDB;
    }

    @Override
    @Transactional
    public void deleteExame(Integer id) {
        Exame exame = exameRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exame não encontrado"));

        exame.getOrientacoes().forEach(orientacao -> {
            orientacaoService.deleteOrientacao(orientacao.getId());
        });

        exameRepository.delete(exame);
    }

    @Override
    public List<Exame> pesquisarExame(String pesquisa) {
        List<Exame> exames = exameRepository.searchExame(pesquisa);

        return exames;
    }

    private void validarExameInput(ExameInput exameInput, Integer exameId) {
        if (exameInput.getNome() == null || exameInput.getNome().isBlank()) {
            throw new ValidacaoException("O nome do exame é obrigatório");
        }

        Exame exameDB = exameRepository.findByNomeIgnoreCase(exameInput.getNome());

        boolean nomeExameJaExiste = exameDB != null && !exameDB.getId().equals(exameId);

        if (nomeExameJaExiste) {
            throw new ValidacaoException("Já existe um exame com o mesmo nome");
        }
    }
}
