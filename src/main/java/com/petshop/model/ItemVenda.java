package com.petshop.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_venda")
public class ItemVenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne @JoinColumn(name = "id_venda")
    private Venda venda;
    @ManyToOne @JoinColumn(name = "id_produto")
    private Produto produto;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    private BigDecimal subtotal;
    public ItemVenda(){}
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
}
