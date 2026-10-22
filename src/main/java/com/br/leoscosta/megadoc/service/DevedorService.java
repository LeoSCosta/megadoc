package com.br.leoscosta.megadoc.service;

import com.br.leoscosta.megadoc.dto.devedor.DevedorRequest;
import com.br.leoscosta.megadoc.dto.devedor.DevedorResponse;
import com.br.leoscosta.megadoc.entity.Devedor;
import com.br.leoscosta.megadoc.repository.DevedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevedorService {

    @Autowired
    DevedorRepository devedorRepository;

    public List<DevedorResponse> BuscarTodosDevedores(){
        return devedorRepository.findAll().stream().map(this::paraResponse).toList();
    }

    public void deletarDevedor(Long id){
        Devedor devedor = devedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Devedor não encontrado"));

        devedor.setExcluido(true);
        devedorRepository.save(devedor);
    }

    public Optional<DevedorResponse> buscarPorId(Long id) {
        return devedorRepository.findById(id).map(this::paraResponse);
    }

    public DevedorResponse cadastrarDevedor(DevedorRequest devedorRequest) {
        Devedor devedor = paraRequest(devedorRequest);
        devedorRepository.save(devedor);
        return paraResponse(devedor);
    }

    private Devedor paraRequest(DevedorRequest devedorRequest) {
        return new Devedor(devedorRequest.nome(), devedorRequest.documento());
    }

    private DevedorResponse paraResponse(Devedor devedor) {
        return new DevedorResponse(
                devedor.getId(),
                devedor.isExcluido(),
                devedor.getDataCadastro(),
                devedor.getDataAtualizacao(),
                devedor.getNome(),
                devedor.getDocumento()
        );
    }

}
