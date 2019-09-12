package com.gustavokring.dso2.appwebdso2.repository;

import com.gustavokring.dso2.appwebdso2.model.Produto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findAllByCategoria(String categoria, Pageable pageable);
}
