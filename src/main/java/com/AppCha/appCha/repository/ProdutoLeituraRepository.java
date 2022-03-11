package com.AppCha.appCha.repository;

import com.AppCha.appCha.models.ProdutoLeitura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProdutoLeituraRepository extends CrudRepository <ProdutoLeitura, Long>{


    List<ProdutoLeitura> findByNome(String nome);

    @Query(value = "select u from ProdutoLeitura u where  u.nome like %?1%")
    List<ProdutoLeitura>findByNomeProduto(String nomeProduto);

    @Query(value = "select u from ProdutoLeitura u where  u.tipo.nome like %?1%")
    List<ProdutoLeitura>findByNomeTipo(String nomeTipo);

    @Query(value = "select u from ProdutoLeitura u where u.tipo.nome like %?1% or u.nome like %?1%")
    List<ProdutoLeitura>findByNomeTipoOuNomeProduto(String nome);
}
