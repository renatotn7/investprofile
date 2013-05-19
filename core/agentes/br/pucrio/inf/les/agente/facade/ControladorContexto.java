package br.pucrio.inf.les.agente.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ControladorContexto � uma classe que implementa o padr�o <b>singleton</b> e
 * serve de fachada para o acesso a um contexto de aplica��o inicializado. O
 * contexto � inicializado quando � solicitada o primeiro objeto da classe.
 * Neste contexto s�o lidas as defini��es dos beans para as camadas de servi�o,
 * acesso a dados e persist�ncia. Abaixo segue um exemplo da cria��o de um
 * objeto de servi�o: mgr =
 * (AcaoManager)ControladorContexto.getInstance().getContexto().getBean("acaoManager");
 * 
 * @author Mauricio Costa Pinheiro
 * @version %I%, %G%
 */
public class ControladorContexto extends Throwable {
	private static final long serialVersionUID = 99L;

	private static ControladorContexto instance = null;

	// private GenericApplicationContext ctx = new GenericApplicationContext();
	private ApplicationContext ctx;

	/**
	 * Construtor da classe que l� as defini��es dos beans de todas as camadas.
	 * 
	 */
	public ControladorContexto() throws Exception {
		try {
			System.out
					.println("Iniciando Controlador de Contexto Singleton...");
			ctx = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext-dao.xml",
							"applicationAgentContext.xml" });
		} catch (Exception ex) {
			System.out.println("Erro ao iniciar beans do spring.");
			ex.printStackTrace();
			throw (ex);
		}
	}

	/**
	 * Cria uma inst�ncia da classe.
	 * 
	 */
	public static void inicia() throws Exception {
		try {
			if (instance == null) {
				instance = new ControladorContexto();
			}
		} catch (Exception ex) {
			throw (ex);
		}

	}

	/**
	 * Cria uma inst�ncia da classe ou retona a instanciada.
	 * 
	 * @return ControladorContexto inst�ncia �nica da classe.
	 */
	public static ControladorContexto instancia() throws Exception {
		try {
			if (instance == null) {
				instance = new ControladorContexto();
			}
			return instance;
		} catch (Exception ex) {
			throw (ex);
		}
	}

	/**
	 * Retorna o objeto de contexto da aplica��o associado ao controlador de
	 * contexto.
	 * 
	 * @return GenericApplicationContext contexto da aplica��o.
	 */
	public ApplicationContext contexto() {
		return ctx;
	}
}
