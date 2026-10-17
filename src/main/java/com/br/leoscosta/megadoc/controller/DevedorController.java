package com.br.leoscosta.megadoc.controller;

import com.br.leoscosta.megadoc.model.Devedor;
import com.br.leoscosta.megadoc.repository.DevedorRepository;
import com.br.leoscosta.megadoc.service.DevedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/devedor")
public class DevedorController {

    @Autowired
    private DevedorRepository devedorRepository;
    @Autowired
    private DevedorService devedorService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping
    public String buscarDevedores(){
        return devedorRepository.findAll().toString();
    }

    @PostMapping
    public String cadastrarDevedor(@RequestBody Devedor devedor){
        devedorRepository.save(devedor);
        return "Devedor " + devedor.getNome() + " cadastrado com sucesso!";
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDevedor(@PathVariable Long id) {
        devedorService.deletarDevedor(id);
        return ResponseEntity.noContent().build();

    }
}
