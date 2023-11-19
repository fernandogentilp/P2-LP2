package MrBetTests;

import Lab3MrBet.Campeonato;
import Lab3MrBet.Time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CampeonatoTest {
	Campeonato campeonato;
	Time time;
	
	@BeforeEach
	public void setUp() {
		campeonato = new Campeonato("Bra", 10);
		time = new Time("123", "Seila", "J");
		campeonato.incluiTimeCampeonato(time);
	}
	
	@Test
	void incluiTimeCampeonatoSucedido() {
		assertEquals(campeonato.incluiTimeCampeonato(time), "TIME INCLUÍDO NO CAMPEONATO!");
	}
}
