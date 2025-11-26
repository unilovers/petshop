package com.petshop.controller;
import com.petshop.model.Produto;
import com.petshop.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/produto")
public class ProdutoApiController {
    private final ProdutoService service;
    public ProdutoApiController(ProdutoService service){ this.service = service; }
    @GetMapping
    public List<Produto> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto obj){ Produto saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/produto/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}