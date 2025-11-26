package com.petshop.repository;
import com.petshop.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {}