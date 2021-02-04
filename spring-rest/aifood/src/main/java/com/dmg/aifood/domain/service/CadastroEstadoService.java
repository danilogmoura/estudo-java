package com.dmg.aifood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dmg.aifood.domain.exception.EntidadeEmUsoException;
import com.dmg.aifood.domain.exception.EstadoNaoEncontradoException;
import com.dmg.aifood.domain.model.Estado;
import com.dmg.aifood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO = "Estado de código %d não pode ser removido, pois está em uso";

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado buscar(Long estadoId) {
		return estadoRepository.findById(estadoId).orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
	}

	@Transactional
	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Transactional
	public void remover(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);
		} catch (DataIntegrityViolationException ex) {
			throw new EntidadeEmUsoException(String.format(MSG_ESTADO_EM_USO, estadoId));
		} catch (EmptyResultDataAccessException ex) {
			throw new EstadoNaoEncontradoException(estadoId);
		}
	}

}
