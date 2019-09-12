package com.gustavokring.dso2.appwebdso2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(builder = Usuario.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Wither
@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String email;
    private String documentId;
    private String senha;
    private LocalDate dataCriacao;
    private LocalDateTime ultimaAtualizacao;
    private Long telefone;




    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}
}
