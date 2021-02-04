package com.dmg.aifood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dmg.aifood.api.assembler.RestauranteInputDisassembler;
import com.dmg.aifood.api.assembler.RestauranteModelAssemble;
import com.dmg.aifood.api.model.RestauranteModel;
import com.dmg.aifood.api.model.input.RestauranteInput;
import com.dmg.aifood.domain.exception.CozinhaNaoEncontradaException;
import com.dmg.aifood.domain.exception.NegocioException;
import com.dmg.aifood.domain.model.Restaurante;
import com.dmg.aifood.domain.repository.RestauranteRepository;
import com.dmg.aifood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroRestauranteService cadastroRestaurante;

//	@Autowired
//	private SmartValidator smartValidator;

	@Autowired
	private RestauranteModelAssemble restauranteModelAssemble;

	@Autowired
	private RestauranteInputDisassembler restauranteInputDisassembler;

	@GetMapping
	public List<RestauranteModel> listar() {
		return restauranteModelAssemble.toColletionModel(restauranteRepository.findAll());
	}

	@GetMapping("/{restauranteId}")
	public RestauranteModel buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = cadastroRestaurante.buscar(restauranteId);
		return restauranteModelAssemble.toModel(restaurante);
	}

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public RestauranteModel adicionar(@RequestBody @Valid RestauranteInput restauranteInput) {
		try {
			Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInput);
			return restauranteModelAssemble.toModel(cadastroRestaurante.salvar(restaurante));
		} catch (CozinhaNaoEncontradaException ex) {
			throw new NegocioException(ex.getMessage());
		}
	}

	@PutMapping("/{restauranteId}")
	public RestauranteModel atualizar(@PathVariable Long restauranteId,
			@RequestBody @Valid RestauranteInput restauranteInput) {

		try {
//			Restaurante restaurante = restauranteInputDisassembler.toDomainObject(restauranteInput);

			Restaurante restaurante = cadastroRestaurante.buscar(restauranteId);

			restauranteInputDisassembler.copyToDomainObject(restauranteInput, restaurante);

//			BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento", "endereco", "dataCadastro", "produtos");
			return restauranteModelAssemble.toModel(cadastroRestaurante.salvar(restaurante));
		} catch (CozinhaNaoEncontradaException ex) {
			throw new NegocioException(ex.getMessage(), ex);
		}
	}

//	@PatchMapping("/{restauranteId}")
//	public RestauranteModel atualizarParcial(@PathVariable Long restauranteId, @RequestBody Map<String, Object> campos,
//			HttpServletRequest request) {
//		Restaurante restauranteAtual = cadastroRestaurante.buscar(restauranteId);
//		merge(campos, restauranteAtual, request);
//
//		validate(restauranteAtual, "restaurante");
//		return atualizar(restauranteId, restauranteAtual);
//	}

//	private void validate(Restaurante restaurante, String objectName) {
//		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(restaurante, objectName);
//		smartValidator.validate(restaurante, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			throw new ValidacaoException(bindingResult);
//		}
//	}

//	private void merge(Map<String, Object> dadosOrigem, Restaurante restauranteDestino, HttpServletRequest request) {
//		ServletServerHttpRequest serverHttpRequest = new ServletServerHttpRequest(request);
//		try {
//			ObjectMapper objectMapper = new ObjectMapper();
//			objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
//			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
//			Restaurante restauranteOrigem = objectMapper.convertValue(dadosOrigem, Restaurante.class);
//
//			dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
//				Field field = ReflectionUtils.findField(Restaurante.class, nomePropriedade);
//				field.setAccessible(true);
//				Object novoValor = ReflectionUtils.getField(field, restauranteOrigem);
//				ReflectionUtils.setField(field, restauranteDestino, novoValor);
//			});
//		} catch (IllegalArgumentException ex) {
//			Throwable rootCause = ExceptionUtils.getRootCause(ex);
//			throw new HttpMessageNotReadableException(ex.getMessage(), rootCause, serverHttpRequest);
//		}
//	}

	@DeleteMapping("/{restauranteId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long restauranteId) {
		cadastroRestaurante.remover(restauranteId);
	}

}
