package com.petshop.controller;
import com.petshop.service.FuncionarioService;
import com.petshop.model.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/funcionarios")
public class FuncionarioMvcController {
    private final FuncionarioService service;
    public FuncionarioMvcController(FuncionarioService service){ this.service = service; }
    @GetMapping
    public String list(Model model){ model.addAttribute("items", service.listar()); return "funcionarios/lista"; }
    @GetMapping("/novo")
    public String novo(Model model){ model.addAttribute("item", new Funcionario()); return "funcionarios/form"; }
    @PostMapping("/salvar")
    public String salvar(Funcionario item){ service.salvar(item); return "redirect:/funcionarios"; }
}