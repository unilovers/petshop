package com.petshop.controller;
import com.petshop.service.ProdutoService;
import com.petshop.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/produtos")
public class ProdutoMvcController {
    private final ProdutoService service;
    public ProdutoMvcController(ProdutoService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "produtos/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Produto()); return "produtos/form"; }
    @PostMapping("/salvar")
    public String salvar(Produto item){ service.salvar(item); return "redirect:/produtos"; }
}