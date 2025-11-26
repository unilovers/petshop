package com.petshop.service;
import com.petshop.model.ItemVenda;
import com.petshop.repository.ItemVendaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ItemVendaService {
    private final ItemVendaRepository repo;
    public ItemVendaService(ItemVendaRepository repo){ this.repo = repo; }
    public List<ItemVenda> listar(){ return repo.findAll(); }
    public Optional<ItemVenda> buscar(Long id){ return repo.findById(id); }
    public ItemVenda salvar(ItemVenda obj){ return repo.save(obj); }
    public void deletar(Long id){ repo.deleteById(id); }
}