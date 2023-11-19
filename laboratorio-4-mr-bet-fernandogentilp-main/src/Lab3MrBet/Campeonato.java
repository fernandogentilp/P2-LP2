package Lab3MrBet;

import java.util.ArrayList;

public class Campeonato {
	private String nomeCampeonato;
	
	private final int numeroParticipantes;
	
	private ArrayList<Time> participantes;
	
	public Campeonato(String nomeCampeonato, int numeroParticipantes) {
		this.nomeCampeonato = nomeCampeonato;
		this.numeroParticipantes = numeroParticipantes;
		this.participantes = new ArrayList<Time>();
	}
	
	
	
	public String getNomeCampeonato() {
		return nomeCampeonato;
	}
	

	public int getNumeroParticipantes() {
		return numeroParticipantes;
	}


	/**
	 * Método auxiliar de incluir times em campeonato.
	 * @param time Objeto Time
	 * @return retorna se os times desse campeonatos foram incluidos, caso exceda o numero de participantes, e retorna o time incluido no
	 * campeonato caso não exceda.
	 */
	public String incluiTimeCampeonato(Time time)  {
		if(this.participantes.size() == this.numeroParticipantes) {
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		}
		
		this.participantes.add(time);
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	/**
	 * Método auxiliar de verificar times em campeonato
	 * @param time objeto Time
	 * @return retorna true caso o time esteja em campeonato, e falso caso o contrario.
	 */
	public boolean verificaTimeCampeonato(Time time) {
		if(this.participantes.contains(time)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public String toString() {
		return "* " + this.nomeCampeonato + " " + this.participantes.size() + "/" + this.numeroParticipantes;
	}
	
	
	
	
}
