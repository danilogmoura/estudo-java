package com.dmg.financeiroapi.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmg.financeiroapi.domain.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
