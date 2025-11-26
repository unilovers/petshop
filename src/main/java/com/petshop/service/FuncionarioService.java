package com.petshop.service;
import com.petshop.model.Funcionario;
import com.petshop.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class FuncionarioService {
    private final FuncionarioRepository repo;
    public FuncionarioService(FuncionarioRepository repo){ this.repo = repo; }
    public List<Funcionario> listar(){ return repo.findAll(); }
    public Optional<Funcionario> buscar(Long id){ return repo.findById(id); }
    public Funcionario salvar(Funcionario obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}