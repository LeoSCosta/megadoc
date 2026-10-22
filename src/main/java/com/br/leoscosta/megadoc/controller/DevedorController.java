package com.br.leoscosta.megadoc.controller;

import com.br.leoscosta.megadoc.dto.devedor.DevedorRequest;
import com.br.leoscosta.megadoc.dto.devedor.DevedorResponse;
import com.br.leoscosta.megadoc.entity.Devedor;
import com.br.leoscosta.megadoc.repository.DevedorRepository;
import com.br.leoscosta.megadoc.service.DevedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/devedor")
public class DevedorController {

    @Autowired
    private DevedorService devedorService;

    @GetMapping
    public List<DevedorResponse> buscarDevedores(){
        return devedorService.BuscarTodosDevedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DevedorResponse> buscarPorId(@PathVariable Long id) {
        return devedorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DevedorResponse> cadastrarDevedor(@Valid @RequestBody DevedorRequest devedorRequest){
        DevedorResponse devedor = devedorService.cadastrarDevedor(devedorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(devedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirDevedor(@PathVariable Long id) {
        devedorService.deletarDevedor(id);
        return ResponseEntity.ok("Devedor excluído com sucesso.");
    }
}
