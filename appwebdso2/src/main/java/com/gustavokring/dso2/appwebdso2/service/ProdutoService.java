package com.gustavokring.dso2.appwebdso2.service;

import com.gustavokring.dso2.appwebdso2.model.Produto;
import com.gustavokring.dso2.appwebdso2.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Mono<Produto> getProdutoById(Long id) {
        return Mono.fromCallable(() -> repository.findById(id).orElseThrow(Exception::new));
    }

    public Mono<Void> insertNewProduto(String nome, String descricao, Long quantidade, Double valor) {

        return Mono.fromCallable(
                () -> repository.save(
                        Produto.builder()
                            .nome(nome)
                            .descricao(descricao)
                            .quantidade(quantidade)
                            .valor(valor)
                            .dataCriacao(LocalDate.now())
                            .build())
        ).then();
    }
}
