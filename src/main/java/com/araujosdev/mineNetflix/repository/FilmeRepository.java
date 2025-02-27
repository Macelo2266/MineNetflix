package com.araujosdev.mineNetflix.repository;

import com.araujosdev.mineNetflix.model.Filme;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@NonNullApi
public interface FilmeRepository extends JpaRepository<Filme, Long> {
   Optional<Filme> findById(Long id);
}
