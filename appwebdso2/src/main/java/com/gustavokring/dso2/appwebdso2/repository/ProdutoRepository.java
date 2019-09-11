package com.gustavokring.dso2.appwebdso2.repository;

import com.gustavokring.dso2.appwebdso2.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
