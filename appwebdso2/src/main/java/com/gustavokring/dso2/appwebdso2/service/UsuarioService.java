package com.gustavokring.dso2.appwebdso2.service;

import com.gustavokring.dso2.appwebdso2.model.Usuario;
import com.gustavokring.dso2.appwebdso2.repository.UsuarioRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Mono<Usuario> getUserById(Long id) {
        return Mono.fromCallable(() -> repository.findById(id).orElseThrow(Exception::new));
    }

    public Mono<Void> insertNew(String nome, String email, String documentId, String senha, Long telefone) {
        return Mono.fromCallable(
                () -> repository.save(
                        Usuario.builder()
                            .nome(nome)
                            .email(email)
                            .senha(senha)
                            .telefone(telefone)
                            .dataCriacao(LocalDate.now())
                            .documentId(documentId)
                            .build()
                )
        ).then();
    }

    public Mono<Usuario> update(Long id, String nome, String email, String documentId, String senha, Long telefone) {

        return Mono.fromCallable(
                () -> repository.findById(id)
                        .orElseThrow(Exception::new))
                            .map(usuario -> repository.save(
                                    usuario.withId(id)
                                        .withNome(StringUtils.isBlank(nome) ? usuario.getNome() : nome )
                                        .withEmail(StringUtils.isBlank(email) ? usuario.getEmail() : email )
                                        .withSenha(StringUtils.isBlank(senha) ? usuario.getSenha() : senha )
                                        .withTelefone(telefone == null ? usuario.getTelefone() : telefone)
                                        .withDocumentId(StringUtils.isBlank(documentId) ? usuario.getDocumentId() : documentId)
                                        .withUltimaAtualizacao(
                                                LocalDateTime.parse(LocalDateTime.now().toString(),
                                                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")))
                                )
                            );
    }

    public void deleteById(Long id) { repository.deleteById(id); }


}
