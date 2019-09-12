package com.gustavokring.dso2.appwebdso2.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonDeserialize(builder = Produto.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)
@Wither
@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String categoria;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String descricao;
    private Long quantidade;
    private Double valor;
    private LocalDate dataCriacao;
    private LocalDateTime ultimaAtualizacao;


    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {}

}
