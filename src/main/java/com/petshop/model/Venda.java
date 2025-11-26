package com.petshop.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private LocalDateTime dataVenda = LocalDateTime.now();
    private BigDecimal valorTotal = BigDecimal.ZERO;
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens = new ArrayList<>();
    public Venda(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Cliente getCliente(){return cliente;}
    public void setCliente(Cliente cliente){this.cliente=cliente;}
    public LocalDateTime getDataVenda(){return dataVenda;}
    public BigDecimal getValorTotal(){return valorTotal;}
    public List<ItemVenda> getItens(){return itens;}
}
