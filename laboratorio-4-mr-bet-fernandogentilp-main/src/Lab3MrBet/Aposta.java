package Lab3MrBet;

public class Aposta {
	private Time time;
	
	private Campeonato campeonato;
	
	private int colocacao;
	
	private double valor;
	
	public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
		this.time = time;
		this.campeonato = campeonato;
		this.colocacao = colocacao;
		this.valor = valor;
	}
	


	@Override
	public String toString() {
		return this.time.toString() + "\n"
				+ this.campeonato.getNomeCampeonato() + "\n"
				+ this.colocacao + "/" + this.campeonato.getNumeroParticipantes() + "\n"
				+ "R$ " + this.valor;
	}
	
	
}
