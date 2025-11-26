package com.petshop.controller;
import com.petshop.model.Venda;
import com.petshop.service.VendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/venda")
public class VendaApiController {
    private final VendaService service;
    public VendaApiController(VendaService service){ this.service = service; }
    @GetMapping
    public List<Venda> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Venda> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Venda> create(@RequestBody Venda obj){ Venda saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/venda/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}