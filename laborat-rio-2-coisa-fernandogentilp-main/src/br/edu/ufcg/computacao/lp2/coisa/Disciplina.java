package br.edu.ufcg.computacao.lp2.coisa;

import java.util.Arrays;
/**
 * Essa classe representa as disciplinas no geral, as notas e as horas estudadas das diciplinas
 * @author fernando.gentil.pinheiro.pacheco
 */
public class Disciplina {
	private String nomeDisciplina;
	
	private double[] valorNota;
	
	private int horasAluno;
	
	/** 
	 * Esse é o construtor da classe Disciplina, com o mesmo nome da classe. Ele pega o nome da disciplina e o valor da nota no formato de array.
	*/
	public Disciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.valorNota = new double[4];
	}
	
	/**
	 * Esse método basicamente pega as horas dos alunos e registra na classe.
	 * @param horas ele pega as horas.
	 */
	public void cadastraHoras(int horas) {
		this.horasAluno = horas;
	}
	/**
	 * Esse método pega a nota do aluno.
	 * @param nota ele pega a nota do aluno.
	 * @param valorNota ele pega o valor da nota do aluno.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.valorNota[nota - 1] = valorNota;
	}
	
	/**
	 * Esse método calcula a média.
	 * @return e ele retorna a média calculada.
	 */
	private double media() {
		double resultado = 0;
		for(int i=0; i < valorNota.length; i++) {
			resultado += this.valorNota[i];
		}
		return resultado / valorNota.length;
	}
	
	/**
	 * Esse método avalia se o aluno foi aprovado ou reprovado com base na média dele.
	 * @return e ele retorna se o aluno foi, ou não aprovado.
	 */
	public boolean aprovado() {
		if (media() >= 7.0) {
			return 	true;
		}
		return false;
	}
	
	/**
	 * Esse método retorna uma string formatada como saída.
	 */
	public String toString() {
		return this.nomeDisciplina + " " + this.horasAluno + " " + media() + " " + Arrays.toString(valorNota);
	}
}
