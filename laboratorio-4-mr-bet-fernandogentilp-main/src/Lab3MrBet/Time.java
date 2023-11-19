package Lab3MrBet;

import java.util.Objects;

public class Time {
	private String codigo;
	private String nomeTime;
	private String mascote;
	
	public Time(String codigo, String nomeTime, String mascote) {
		this.codigo = codigo;
		this.nomeTime = nomeTime;
		this.mascote = mascote;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public String getMascote() {
		return mascote;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, mascote, nomeTime);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(mascote, other.mascote)
				&& Objects.equals(nomeTime, other.nomeTime);
	}
	
	public String toString() {
		return "[" + this.codigo + "]" + " " + this.nomeTime + "/" + " " + this.mascote;
	}
}
