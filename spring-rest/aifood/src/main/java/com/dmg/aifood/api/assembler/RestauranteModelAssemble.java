package com.dmg.aifood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dmg.aifood.api.model.RestauranteModel;
import com.dmg.aifood.domain.model.Restaurante;

@Component
public class RestauranteModelAssemble {

	@Autowired
	private ModelMapper mapper;

	public RestauranteModel toModel(Restaurante restaurante) {
		return mapper.map(restaurante, RestauranteModel.class);
	}

	public List<RestauranteModel> toColletionModel(List<Restaurante> restaurantes) {
		return restaurantes.stream()
				.map(restaurante -> toModel(restaurante))
				.collect(Collectors.toList());
	}
}
