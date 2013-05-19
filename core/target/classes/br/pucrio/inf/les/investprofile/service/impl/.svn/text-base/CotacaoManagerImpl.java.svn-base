package br.pucrio.inf.les.investprofile.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.sun.net.ssl.internal.ssl.Debug;

import br.pucrio.inf.les.investprofile.dao.CotacaoDao;
import br.pucrio.inf.les.investprofile.model.Cotacao;
import br.pucrio.inf.les.investprofile.service.CotacaoManager;

/**
 * Implementation of CotacaoManager interface.
 * </p>
 * <p>
 * <a href="CotacaoManagerImpl.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:mauricio.pinheiro@gmail.com">Mauricio Costa Pinheiro</a>
 */
public class CotacaoManagerImpl extends GenericManagerImpl<Cotacao, Long>
		implements CotacaoManager {
	private CotacaoDao dao;

	/**
	 * @param dao
	 */
	public CotacaoManagerImpl(CotacaoDao dao) {
		super(dao);
		this.dao = dao;
	}

	/**
	 * Set the Dao for communication with the data layer.
	 * 
	 * @param dao
	 */
	public void setCotacaoDao(CotacaoDao dao) {
		this.dao = dao;
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#getCotacao(java.lang.String)
	 */
	public Cotacao getCotacao(String id) {
		return dao.getCotacao(new Long(id));
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#getUltimaCotacaoAcao(java.lang.String)
	 */
	public Cotacao getUltimaCotacaoAcao(String codigoBovespa) {
		return dao.getUltimaCotacaoAcao(codigoBovespa);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#getCotacoesPorCodigoBovespa(java.lang.String)
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespa(String codigoBovespa)
			throws Exception {
		try {
			return dao.getCotacoesPorCodigoBovespa(codigoBovespa);
		} catch (NullPointerException e) {
			throw new Exception("Não existem cotações para a ação '"
					+ codigoBovespa + "'.");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#getCotacoesPorCodigoBovespaDesde(java.lang.String,
	 *      java.util.Date)
	 */
	public List<Cotacao> getCotacoesPorCodigoBovespaDesde(String codigoBovespa,
			Date dataInicio) throws Exception {
		try {
			return dao.getCotacoesPorCodigoBovespaDesde(codigoBovespa,
					dataInicio);
		} catch (NullPointerException e) {
			throw new Exception("Não existem cotações a partir de '"
					+ new SimpleDateFormat("dd/MM/yyyy").format(dataInicio)
					+ "' para a ação '" + codigoBovespa + "'.");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#getAcoes(br.pucrio.inf.les.investprofile.model.Cotacao)
	 */
	public List<Cotacao> getCotacoes(Cotacao acao) {
		return dao.getCotacoes(acao);
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#saveCotacao(br.pucrio.inf.les.investprofile.model.Cotacao)
	 */
	public void saveCotacao(Cotacao cotacao) throws Exception {
		try {
			dao.saveCotacao(cotacao);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Cotacao '" + cotacao.getId() + "' ja existe!");
		}
	}

	/**
	 * @see br.pucrio.inf.les.investprofile.service.CotacaoManager#removeCotacao(java.lang.String)
	 */
	public void removeCotacao(String id) {
		if (log.isDebugEnabled()) {
			log.debug("removendo acao: " + id);
		}

		dao.removeCotacao(new Long(id));
	}
}
