package br.pucrio.inf.les.investprofile.model;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 */
public enum EspecificacaoPapel {

	/**
	 * Definição das especialidades básicas
	 */
	INDEFINIDO(0,"Indefinido"),

	/**
	 * 
	 */
	ON(100,"Ação ordinária nominativa"),

	/**
	 * 
	 */
	PN(200,"Ação preferencial nominativa"),

	/**
	 * 
	 */
	CI(300,"Fundo de Investimento"),

	/**
	 * Definição das subespecialidades
	 */
	OR(101,"Ação ordinária nominativa resgatável"),

	/**
	 * 
	 */
	PR(201,"Ação preferencial nominativa resgatável");

	private int especificacaoBovespa;
	private String descricao;
	
	private EspecificacaoPapel(int especificacaoBovespa, String descricao) {
		this.especificacaoBovespa = especificacaoBovespa;
		this.descricao = descricao;
	}
	
	/**
	 * @return
	 */
	int codigoBovespa() {
		return this.especificacaoBovespa;
	}
	
	/**
	 * @return
	 */
	String descricao() {
		return this.descricao;
	}
}
