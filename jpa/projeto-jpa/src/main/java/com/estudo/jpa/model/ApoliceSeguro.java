package com.estudo.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "apolice_seguro")
public class ApoliceSeguro extends EntidadeBaseInteger {

    @Column(name = "valor_franquia")
    private BigDecimal valorFranquia;

    @Column(name = "protecao_terceiro")
    private Boolean protecaoTerceiro;

    @Column(name = "protecao_causas_naturais")
    private Boolean protecaoCausasNaturais;

    @Column(name = "protecao_roubo")
    private Boolean protecaoRoubo;
}
