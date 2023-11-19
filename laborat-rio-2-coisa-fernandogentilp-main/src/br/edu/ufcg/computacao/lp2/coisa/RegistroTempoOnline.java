package br.edu.ufcg.computacao.lp2.coisa;

/**
 * Essa classe representa o tempo online do aluno e o tempo requerido do mesmo.
 * @author fernando.gentil.pinheiro.pacheco
 */
/**
 * 
 */
public class RegistroTempoOnline {
	private int tempoOnline;
	
	private int tempoEsperado;

	private String nomeDisciplina;
	
	
	/**
	 * Esse construtor além de receber o nome da disciplina do aluno, ela delimita o limite de horas de tempo do aluno.
	 * 
	 * @param nomeDisciplina
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoEsperado = 120;
	}

	/**
	 * Esse construtor atribui o valor tempo esperado para o tempo online esperado do aluno.
	 * 
	 * @param nomeDisciplina
	 * @param tempoOnlineEsperado
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoEsperado = tempoOnlineEsperado;
	}

	/**
	 * Esse método basicamente adiciona o tempo online do aluno.
	 * 
	 * @param tempo
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnline += tempo;
	}
	
	/**
	 * Esse método verifica se o aluno atingiu ou não o tempo esperado. 
	 * 
	 * @return
	 */
	public boolean atingiuMetaTempoOnline() {
		return this.tempoOnline >= this.tempoEsperado;
	}
	
	
	/**
	 * Essee método retorna uma string contendo os dados formatados do tempo do aluno.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoOnline + "/" + this.tempoEsperado;
	}

}
