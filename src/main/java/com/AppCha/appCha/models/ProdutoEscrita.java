package com.AppCha.appCha.models;

import java.io.Serializable;// transforma os objetos em binarios para manipular
import javax.persistence.*;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Table(name="produto")
@Entity
public class ProdutoEscrita<produto> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idproduto;

    @NotEmpty
    private String nome;

    @Lob
    private byte[] img;

    @NotEmpty
    private String preco;

    @NotNull
    private Long idtipo;

    @NotNull
    private String descricao;


    public long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Long geIdtipo() {return idtipo;}

    public void setIdtipo(Long idtipo) {
        this.idtipo = idtipo;
    }

    public String getDescricao() {return descricao;}

    public void setDescricao(String descricao) {this.descricao = descricao;}

    //IMG
    public byte[] getImg() {return img;}

    public void setImg(byte[] img) {this.img = img;}
}
