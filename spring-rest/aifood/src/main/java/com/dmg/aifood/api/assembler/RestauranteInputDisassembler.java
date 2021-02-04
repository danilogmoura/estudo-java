package com.dmg.aifood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dmg.aifood.api.model.input.RestauranteInput;
import com.dmg.aifood.domain.model.Cozinha;
import com.dmg.aifood.domain.model.Restaurante;

@Component
public class RestauranteInputDisassembler {

	@Autowired
	private ModelMapper mapper;

	public Restaurante toDomainObject(RestauranteInput restauranteInput) {
		return mapper.map(restauranteInput, Restaurante.class);
	}

	public void copyToDomainObject(RestauranteInput input, Restaurante output) {
		/**
		 * Para evitar org.hibernate.HibernateException: identifier of an instance of
		 * com.dmg.aifood.domain.model.Cozinha was altered from 1 to 2
		 */
		output.setCozinha(new Cozinha());
		mapper.map(input, output);
	}
}
