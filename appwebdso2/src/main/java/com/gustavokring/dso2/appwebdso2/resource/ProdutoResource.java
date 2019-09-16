package com.gustavokring.dso2.appwebdso2.resource;

import com.gustavokring.dso2.appwebdso2.model.Produto;
import com.gustavokring.dso2.appwebdso2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/produto")
public class ProdutoResource {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Mono<Produto> get(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @GetMapping("/categoria/{categoria}")
    public Mono<List<Produto>> getAllByCategoria(@PathVariable String categoria) {
        return Mono.empty();
    }

    @PutMapping("/{id}")
    public Mono<Produto> editProduto(@PathVariable Long id,
                             @RequestParam(required = false) String nome,
                             @RequestParam(required = false) String categoria,
                             @RequestParam(required = false) String descricao,
                             @RequestParam(required = false) Long quantidade,
                             @RequestParam(required = false) Double valor) {

        return produtoService.update(id,nome,categoria,descricao,valor,quantidade);
    }

    @PostMapping
    public Mono<Void> newProduto(@RequestParam String nome,
                            @RequestParam String categoria,
                            @RequestParam String descricao,
                            @RequestParam Long quantidade,
                            @RequestParam Double valor) {

        return produtoService.insertNew(nome, categoria, descricao, quantidade, valor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.deleteById(id);
    }

    @PutMapping("/retirar/{id}")
    public Mono<Void> retiraProduto(@PathVariable Long id) {
        return Mono.empty();
    }

}
