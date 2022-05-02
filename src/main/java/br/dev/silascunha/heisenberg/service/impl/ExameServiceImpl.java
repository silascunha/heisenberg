package br.dev.silascunha.heisenberg.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.silascunha.heisenberg.model.Exame;
import br.dev.silascunha.heisenberg.repository.ExameRepository;
import br.dev.silascunha.heisenberg.service.ExameService;

@Service
public class ExameServiceImpl implements ExameService {

    @Autowired
    private ExameRepository exameRepository;

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
    public Exame saveExame(Exame exame) {
        exameRepository.save(exame);

        return exame;
    }

    @Override
    public Exame updateExame(Exame exame, Integer id) {
        Exame exameInDB = exameRepository.getById(id);

        BeanUtils.copyProperties(exame, exameInDB, "id");

        return exameRepository.save(exameInDB);
    }

    @Override
    public void deleteExame(Integer id) {
        exameRepository.deleteById(id);
    }

}
