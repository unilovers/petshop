package com.petshop.controller;
import com.petshop.model.ItemVenda;
import com.petshop.service.ItemVendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/itemvenda")
public class ItemVendaApiController {
    private final ItemVendaService service;
    public ItemVendaApiController(ItemVendaService service){ this.service = service; }
    @GetMapping
    public List<ItemVenda> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<ItemVenda> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<ItemVenda> create(@RequestBody ItemVenda obj){ ItemVenda saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/itemvenda/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}