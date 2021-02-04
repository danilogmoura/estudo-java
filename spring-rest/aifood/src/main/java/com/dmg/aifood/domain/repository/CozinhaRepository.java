package com.dmg.aifood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dmg.aifood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends CustomJpaRepository<Cozinha, Long> {

	List<Cozinha> findAllByNomeContaining(String nome);

	Optional<Cozinha> findByNome(String nome);

	boolean existsByNome(String nome);

}
