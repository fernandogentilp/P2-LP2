package Lab3MrBet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MrBet {
	private HashMap<String, Time> times;
	
	private HashMap<String, Campeonato> campeonato;
	
	private ArrayList<Aposta> apostas;
	
	public MrBet() {
		this.times = new HashMap<>();
		this.campeonato = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * Esse metodo auxiliar serve para adicionar times no hashmap
	 * @param codigo codigo do time
	 * @param nome nome do time
	 * @param mascote mascote do time
	 * @return retorna se o time existe ou se a inclusão foi realizada
	 */
	public String incluiTime(String codigo, String nome, String mascote) {
		Time time = new Time(codigo, nome, mascote);
		
		if(times.containsKey(codigo)) {
			return "TIME JÁ EXISTENTE";
		}
		
		else {
			times.put(codigo, time);
			return "INCLUSÃO REALIZADA!";
		}
	}
	/**
	 * Método auxiliar que serve para mostrar o time
	 * @param codigo
	 * @return retorna o time, caso o contrario retorna null
	 */
	public Time recuperaTime(String codigo) {
		if(times.containsKey(codigo)) {
			return times.get(codigo);
		}
		
		else {
			return null;
		}
	}
	/**
	 * Método auxiliar que adiciona campeonato
	 * @param nomeCampeonato parametro para o nome do campeonato
	 * @param numeroParticipante numero de partcipantes do campeonato
	 * @return retorna campeonato existente, caso a chave tenha no hashmap, caso contrario retorna campeonato adicionado
	 */
	public String adicionaCampeonato(String nomeCampeonato, int numeroParticipante) {
		Campeonato jogo = new Campeonato(nomeCampeonato, numeroParticipante);
		
		if(campeonato.containsKey(nomeCampeonato)) {
			return "CAMPEONATO JÁ EXISTE!";
		}
		
		else {
			campeonato.put(nomeCampeonato, jogo);
			return "CAMPEONATO ADICIONADO!";
		}
	}
	
	/**
	 * Método que inclui time em campeonato
	 * @param codigo parametro para codigo do campeonato
	 * @param nomeCampeonato parametro para nome do campeonato
	 * @return retorna erros, caso o time não exista ou campeonato não exista, e retorna o time e o campeonato
	 */
	
	public String incluirTimeCampeonato(String codigo, String nomeCampeonato) {
		if(!times.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO EXISTE!");
		}
		
		if(!campeonato.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("CAMPEONATO NÃO EXISTE!");
		}
		
		return this.campeonato.get(nomeCampeonato).incluiTimeCampeonato(times.get(codigo));
	}
	
	/**
	 * Método auxiliar que verifica se o time está em campeonato
	 * @param codigo parametro para o codigo do time
	 * @param nomeCampeonato parametro para o nome do campeonato
	 * @return retorna erros caso o time não exista ou o campeonato não exista, e retorna se o time está ou não no campeonato
	 */
	public String verificaTimeCampeonato(String codigo, String nomeCampeonato) {
		if(!times.containsKey(codigo)) {
			throw new IllegalArgumentException("O TIME NÃO EXISTE!");
		}
		
		if(!campeonato.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
		
		if(this.campeonato.get(nomeCampeonato).verificaTimeCampeonato(times.get(codigo))) {
			return "O TIME ESTÁ NO CAMPEONATO!";
		}
		
		else {
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		}
	}
	
	/**
	 * Método auxiliar que exibe o campeonato
	 * @param codigo codigo do time
	 * @return retorna um erro caso o time não esteja cadastrado, e retorna uma string formatada 
	 */
	public String exibirCampeonato(String codigo) {
		if(!this.times.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO CADASTRADO NO SISTEMA");
		}
		
		String s = "";
		for(String campeonatos: this.campeonato.keySet()) {
			Campeonato c = this.campeonato.get(campeonatos);
			
			if(c.verificaTimeCampeonato(this.times.get(codigo))) {
				s += c.toString() + "\n";
			}
		}
		return "Campeonato do " + this.times.get(codigo).getNomeTime() + ":" + "\n" + s;
	}
	
	/**
	 * Método auxiliar de apostas
	 * @param codigo parametro do time
	 * @param nomeCampeonato parametro do campeonato
	 * @param colocacao parametro da colocacao do time
	 * @param valor parametro do valor da aposta
	 * @return retorna erros caso a aposta não for registrada, o time não for cadastrado e o campeonato não exista e retorna aposta registrada
	 * caso a aposta for registrada.
	 */
	public String apostar(String codigo, String nomeCampeonato, int colocacao, double valor) {
		if(colocacao > campeonato.get(nomeCampeonato).getNumeroParticipantes()) {
			throw new IllegalArgumentException("APOSTA NÃO REGISTRADA!");
		}
		
		if(!this.times.containsKey(codigo)) {
			throw new IllegalArgumentException("TIME NÃO CADASTRADO NO SISTEMA");
		}
		
		if(!campeonato.containsKey(nomeCampeonato)) {
			throw new IllegalArgumentException("O CAMPEONATO NÃO EXISTE!");
		}
		
		apostas.add(new Aposta(times.get(codigo), campeonato.get(nomeCampeonato), colocacao, valor));
		return "APOSTA REGISTRADA!";
		
	}
	/**
	 * Método auxilar que verifica o status da aposta
	 * @return retorna uma string formatada
	 */
	public String verificaStatusAposta() {
		String a = "";
		for(int i = 0; i < this.apostas.size(); i++) {
			a += (i + 1) + ". " + apostas.get(i).toString();	
		}
		return a;
	}

	public HashMap<String, Time> getTimes() {
		return times;
	}

	public HashMap<String, Campeonato> getCampeonato() {
		return campeonato;
	}
	
	
}