package com.dmg.aifood.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmg.aifood.domain.model.Permissao;
import com.dmg.aifood.domain.repository.PermissaoRepository;

@Service
public class CadastroPermissaoService {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Transactional
	public Permissao salvar(Permissao permissao) {
		return permissaoRepository.save(permissao);
	}

	@Transactional
	public void remover(Long id) {
		permissaoRepository.deleteById(id);
	}
}
