package com.gustavokring.dso2.appwebdso2.service;

import com.gustavokring.dso2.appwebdso2.model.Produto;
import com.gustavokring.dso2.appwebdso2.repository.ProdutoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Mono<Produto> getProdutoById(Long id) {
        return Mono.fromCallable(() -> repository.findById(id).orElseThrow(Exception::new));
    }

    public Mono<Void> insertNew(String nome, String descricao, Long quantidade, Double valor) {

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

    public Mono<Produto> update(Long id, String nome, String descricao, Double valor, Long quantidade) {

        return Mono.fromCallable(
                () -> repository.findById(id)
                        .orElseThrow(Exception::new))
                                .map(produto -> repository.save(
                                        produto.withId(id)
                                            .withNome(StringUtils.isBlank(nome) ? produto.getNome() : nome)
                                            .withDescricao(StringUtils.isBlank(descricao) ? produto.getDescricao() : descricao)
                                            .withQuantidade(quantidade == null ? produto.getQuantidade() : quantidade)
                                            .withValor(valor == null ? produto.getValor() : valor)
                                            .withUltimaAtualizacao(
                                                    LocalDateTime.parse(LocalDateTime.now().toString(),
                                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                                    )
                                );
    }

    public void deleteById(Long id) { repository.deleteById(id);}



}
