package com.br.leoscosta.megadoc.repository;

import com.br.leoscosta.megadoc.model.Devedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevedorRepository extends JpaRepository<Devedor, Long> {
}
