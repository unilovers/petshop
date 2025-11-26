package com.petshop.repository;
import com.petshop.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {}