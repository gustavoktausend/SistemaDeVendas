package com.gustavokring.dso2.appwebdso2.repository;

import com.gustavokring.dso2.appwebdso2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
