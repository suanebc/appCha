package com.AppCha.appCha.models;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="produto")
@Entity
public class ProdutoLeitura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproduto;


    private String nome;

    @Lob
    private byte[] img;


    private String preco;


    @ManyToOne
    @JoinColumn(name = "idtipo")
    private Tipo tipo;


    private String descricao;

    public Tipo getTipo(){return tipo;}

    public long getIdproduto() {
        return idproduto;
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    //IMG
    public byte[] getImg() {return img;}


}
