package com.gustavokring.dso2.appwebdso2.repository;

import com.gustavokring.dso2.appwebdso2.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
