package com.petshop.service;
import com.petshop.model.Servico;
import com.petshop.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ServicoService {
    private final ServicoRepository repo;
    public ServicoService(ServicoRepository repo){ this.repo = repo; }
    public List<Servico> listar(){ return repo.findAll(); }
    public Optional<Servico> buscar(Long id){ return repo.findById(id); }
    public Servico salvar(Servico obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}