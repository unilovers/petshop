package com.petshop.service;
import com.petshop.model.Agendamento;
import com.petshop.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AgendamentoService {
    private final AgendamentoRepository repo;
    public AgendamentoService(AgendamentoRepository repo){ this.repo = repo; }
    public List<Agendamento> listar(){ return repo.findAll(); }
    public Optional<Agendamento> buscar(Long id){ return repo.findById(id); }
    public Agendamento salvar(Agendamento obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}