package com.dmg.aifood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.dmg.aifood.domain.exception.CidadeNaoEncontradaException;
import com.dmg.aifood.domain.exception.EntidadeEmUsoException;
import com.dmg.aifood.domain.model.Cidade;
import com.dmg.aifood.domain.model.Estado;
import com.dmg.aifood.domain.repository.CidadeRepository;

@Service
public class CadastroCidadeService {

	private static final String MSG_CIDADE_EM_USO = "Cidade de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroEstadoService cadastroEstado;

	public Cidade buscar(Long cidadeId) {
		return cidadeRepository.findById(cidadeId).orElseThrow(() -> new CidadeNaoEncontradaException(cidadeId));
	}

	@Transactional
	public Cidade salvar(Cidade cidade) {
		Long estadoId = cidade.getEstado().getId();
		Estado estado = cadastroEstado.buscar(estadoId);
		cidade.setEstado(estado);
		return cidadeRepository.save(cidade);
	}

	@Transactional
	public void remover(Long cidadeId) {
		try {
			cidadeRepository.deleteById(cidadeId);
		} catch (EmptyResultDataAccessException ex) {
			throw new CidadeNaoEncontradaException(cidadeId);
		} catch (DataAccessException ex) {
			throw new EntidadeEmUsoException(String.format(MSG_CIDADE_EM_USO, cidadeId));
		}
	}
}
