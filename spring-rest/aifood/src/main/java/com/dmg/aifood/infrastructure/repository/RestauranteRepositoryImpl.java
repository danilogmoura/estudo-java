package com.dmg.aifood.infrastructure.repository;

import static com.dmg.aifood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.dmg.aifood.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.dmg.aifood.domain.model.Restaurante;
import com.dmg.aifood.domain.repository.RestauranteRepository;
import com.dmg.aifood.domain.repository.RestauranteRepositoryQueires;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueires {

	@PersistenceContext
	private EntityManager manager;

	@Lazy
	@Autowired
	private RestauranteRepository restauranteRepository;

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		var builder = manager.getCriteriaBuilder();

		var criteria = builder.createQuery(Restaurante.class);
		var root = criteria.from(Restaurante.class);

		var predicates = new ArrayList<Predicate>();

		if (StringUtils.hasText(nome)) {
			predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}

		if (taxaFreteInicial != null) {
			predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}

		if (taxaFreteFinal != null) {
			predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
		}

		criteria.where(predicates.toArray(new Predicate[0]));

		var query = manager.createQuery(criteria);
		return query.getResultList();
	}

	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
	}

//	@Override
//	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
//
//		var jpql = new StringBuilder();
//		jpql.append("from Restaurante where 0 = 0");
//
//		var parametros = new HashMap<String, Object>();
//
//		if (StringUtils.hasLength(nome)) {
//			jpql.append("and nome like :nome ");
//			parametros.put("nome", "%" + nome + "%");
//		}
//
//		if (taxaFreteInicial != null) {
//			jpql.append("and taxaFrete >= :taxaFreteInicial ");
//			parametros.put("taxaFreteInicial", taxaFreteInicial);
//		}
//
//		if (taxaFreteFinal != null) {
//			jpql.append("and taxaFrete <= :taxaFreteFinal ");
//			parametros.put("taxaFreteFinal", taxaFreteFinal);
//		}
//
//		TypedQuery<Restaurante> query = manager.createQuery(jpql.toString(), Restaurante.class);
//		parametros.forEach((key, value) -> query.setParameter(key, value));
//		
//		return query.getResultList();
//	}

}
