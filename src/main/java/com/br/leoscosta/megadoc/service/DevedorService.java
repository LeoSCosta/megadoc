package com.br.leoscosta.megadoc.service;

import com.br.leoscosta.megadoc.model.Devedor;
import com.br.leoscosta.megadoc.repository.DevedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DevedorService {

    @Autowired
    DevedorRepository devedorRepository;

    public void deletarDevedor(Long id){
        Devedor devedor = devedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Devedor não encontrado"));

        devedor.setExcluido(true);
        devedorRepository.save(devedor);
    }
}
