package br.edu.ufcg.computacao.lp2.coisa;

/**
 * Essa classe representa o registro de resumos que o aluno fez.
 * @author fernando.gentil.pinheiro.pacheco
 */
public class RegistroResumos {
	private int contadorResumo;
	
	private int controlador;
	
	private String[] temaResumo;
	
	private String[] resumos;
	
	/**
	 * Esse é o construtor da classe. Ele pega o tema dos resumos e os resumos.
	 * @param numeroDeResumos é o número de resumos que o aluno fez.
	 */
	public RegistroResumos(int numeroDeResumos) {
		this.resumos = new String[numeroDeResumos];
		this.temaResumo = new String[numeroDeResumos];
	}
	/**
	 * Esse método adiciona os temas e os resumos. Ele irá checar se o tamanho do resumo é maior ou igual ao controlador, e se for, irá zerar ele.
	 * Também irá checar se o contador do resumo é menor que o tamanho dos resumos, e se for, ele irá contar. Tudo isso para controlar o tamanho do resumo em relação
	 * ao array.
	 * @param tema esse é o parâmetro que irá receber o tema.
	 * @param resumo esse é o parâmetro que irá receber o resumo
	 */
	public void adiciona(String tema, String resumo) {
		if(this.controlador >= this.resumos.length) {
			this.controlador = 0;
		}
		
		if(this.contadorResumo < this.resumos.length) {
			this.contadorResumo++;
		}
		this.temaResumo[controlador] = tema;
		this.resumos[controlador] = resumo;
		this.controlador++;
	}
	
	/**
	 * Esse método pega o resumo e retorna a string ajudanteResumo que irá imprimir o tema e o resumo formatados.
	 * @return e retorna a string formatada.
	 */
	public String[] pegaResumos() {
		String[] ajudanteResumo = new String[contadorResumo];
		
		for(int i=0; i < contadorResumo; i++) {
			ajudanteResumo[i] = this.temaResumo[i] + ": " + this.resumos[i];
		}
	return ajudanteResumo;
	} 

	/**
	 * Esse método pega o tema do resumo.
	 * @return e retorna o mesmo.
	 */
	public String[] getTemaResumo() {
		return this.temaResumo;
	}
	/**
	 * Esse método imprime basicamente quantos resumos foram cadastrados, e os temas deles.
	 * @return retorna a string formatada.
	 */
	public String imprimeResumos() {
		String[] temaLista = getTemaResumo();
		
		String temaString = "- " + contadorResumo + " " + "resumo(s) cadastrado(s)\n- ";

		for(int i=0; i < contadorResumo; i++) {
			temaString += (i < contadorResumo -1 ? temaLista[i] + " | " :temaLista[i]);
		}
		return temaString;
	}
	/**
	 * Esse método pega o número do contador de resumos
	 * @return e retorna o número inteiro de contador de resumos.
	 */
	public int conta() {
		return this.contadorResumo;
	}
	/**
	 * Esse método verifica se tem resumos.
	 * @param tema é o parâmetro método.
	 * @return e retorna se tem ou não resumos.
	 */
	public boolean temResumo(String tema) {
		for(int i= 0; i < this.contadorResumo; i++) {
			if(tema.equals(this.temaResumo[i])) {
				return true;
			}
		} return false;
	}

	
}

