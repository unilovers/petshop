package com.petshop.controller;
import com.petshop.service.VendaService;
import com.petshop.model.Venda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/vendas")
public class VendaMvcController {
    private final VendaService service;
    public VendaMvcController(VendaService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "vendas/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Venda()); return "vendas/form"; }
    @PostMapping("/salvar")
    public String salvar(Venda item){ service.salvar(item); return "redirect:/vendas"; }
}