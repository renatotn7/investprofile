package br.pucrio.inf.les.agente.model;

/**
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 * @version %I%, %G%
 */
public enum CanaisAnalistas {
	Risco("Risco"),
	Similaridade("Similaridade"),
	Confianca("Confianca"),
	Volatilidade("Volatilidade"),
	Rentabilidade("Rentabilidade"),
	PessoalInvestimento("PessoalInvestimento"),
	PessoalInvestimentoRetornoSimilaridades("PessoalInvestimento.Similaridades"),
	PessoalInvestimentoRetornoRentabilidade("PessoalInvestimento.Rentabilidade");

	private final Tag tag;

	CanaisAnalistas(String tag) {
		this.tag = new Tag(tag);
	}

	public Tag tag() {
		return this.tag;
	}

	public String toString() {
		return this.tag.toString();
	}
}
