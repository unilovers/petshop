package com.petshop.controller;
import com.petshop.model.Funcionario;
import com.petshop.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioApiController {
    private final FuncionarioService service;
    public FuncionarioApiController(FuncionarioService service){ this.service = service; }
    @GetMapping
    public List<Funcionario> list(){ return service.listar(); }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> get(@PathVariable Long id){ return service.buscar(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); }
    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario obj){ Funcionario saved = service.salvar(obj); return ResponseEntity.created(URI.create("/api/funcionario/" + saved.getId())).body(saved); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){ service.deletar(id); return ResponseEntity.noContent().build(); }
}