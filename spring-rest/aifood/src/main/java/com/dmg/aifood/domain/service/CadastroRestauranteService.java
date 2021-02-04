package com.dmg.aifood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dmg.aifood.domain.exception.EntidadeEmUsoException;
import com.dmg.aifood.domain.exception.RestauranteNaoEncontradoException;
import com.dmg.aifood.domain.model.Cozinha;
import com.dmg.aifood.domain.model.Restaurante;
import com.dmg.aifood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	private static final String MSG_RASTAURANTE_EM_USO = "Restaurante de código %d não pode ser removido, pois está em uso";

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	public Restaurante buscar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId)
				.orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
	}

	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cadastroCozinha.buscar(cozinhaId);
		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}

	@Transactional
	public void remover(Long restauranteId) {
		try {
			restauranteRepository.deleteById(restauranteId);
		} catch (EmptyResultDataAccessException ex) {
			throw new RestauranteNaoEncontradoException(restauranteId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(String.format(MSG_RASTAURANTE_EM_USO, restauranteId));
		}
	}
}
