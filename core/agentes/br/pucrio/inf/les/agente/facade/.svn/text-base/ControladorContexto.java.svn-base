package br.pucrio.inf.les.agente.facade;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ControladorContexto é uma classe que implementa o padrão <b>singleton</b> e
 * serve de fachada para o acesso a um contexto de aplicação inicializado. O
 * contexto é inicializado quando é solicitada o primeiro objeto da classe.
 * Neste contexto são lidas as definições dos beans para as camadas de serviço,
 * acesso a dados e persistência. Abaixo segue um exemplo da criação de um
 * objeto de serviço: mgr =
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
	 * Construtor da classe que lê as definições dos beans de todas as camadas.
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
	 * Cria uma instância da classe.
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
	 * Cria uma instância da classe ou retona a instanciada.
	 * 
	 * @return ControladorContexto instância única da classe.
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
	 * Retorna o objeto de contexto da aplicação associado ao controlador de
	 * contexto.
	 * 
	 * @return GenericApplicationContext contexto da aplicação.
	 */
	public ApplicationContext contexto() {
		return ctx;
	}
}
