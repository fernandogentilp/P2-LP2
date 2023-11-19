package MrBetTests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Lab3MrBet.MrBet;
import Lab3MrBet.Time;

class MrBetTests {
	MrBet mrbet;
	
	
	@BeforeEach
	public void setUp() {
		mrbet = new MrBet();
		mrbet.incluiTime("123", "Seila", "Seila2");
		mrbet.incluiTime("667", "Jurubeba", "Oila");
		mrbet.adicionaCampeonato("Bra", 10);
		mrbet.apostar("123", "Bra", 2, 12.0);
		mrbet.incluirTimeCampeonato("123", "Bra");
	}
	
	@Test
	void incluirTimeBemSucedido() {
		Time time = new Time("123", "Seila", "Seila2");
		assertEquals(mrbet.getTimes().get("123"), time);
	}
	
	@Test
	void quantosTimesEmTimes() {
		assertEquals(mrbet.getTimes().size(), 2);
	}
	
	@Test
	void verificaCampeonatoExiste() {
		assertEquals(mrbet.getCampeonato().size(), 1);
	}
	
	@Test
	void incluiTimeCampeonato() {
		assertEquals(mrbet.incluirTimeCampeonato("123", "Bra"), "TIME INCLUÍDO NO CAMPEONATO!");
	}
	
	@Test
	void incluiTimeCampeonatoCodigoErrado() {
		assertThrows(IllegalArgumentException.class, () -> mrbet.incluirTimeCampeonato("789", "Bra"));
	}
	
	@Test
	void incluiTimeCampeonatoCampeonatoErrado() {
		assertThrows(IllegalArgumentException.class, () -> mrbet.incluirTimeCampeonato("123", "Cra"));
	}
	
	
	@Test
	void verificaTimeCampeonatoBemSucedido() {
		assertEquals(mrbet.verificaTimeCampeonato("123", "Bra"), "O TIME ESTÁ NO CAMPEONATO!");
	}
	
	@Test
	void verificaTimeCampeonatoMalSucedido() {
		assertEquals(mrbet.verificaTimeCampeonato("667", "Bra"), "O TIME NÃO ESTÁ NO CAMPEONATO!");
	}
	
	@Test
	void verificaTimeCampeonatoTimeErrado() {
		assertThrows(IllegalArgumentException.class, () -> mrbet.verificaTimeCampeonato("890", "Bra"));
	}
	
	@Test
	void verificaTimeCampeonatoCampeonatoErrado() {
		assertThrows(IllegalArgumentException.class, () -> mrbet.verificaTimeCampeonato("123", "Russia"));
	}
	
	
	@Test
	void exibirCampeonatoBemSucedido() {
		assertEquals(mrbet.exibirCampeonato("123"), "Campeonato do Seila:\n" + "* Bra 1/10\n");
	}
	
	@Test
	void exibirCampeonatoMalSucedido() {
		assertThrows(IllegalArgumentException.class, () -> mrbet.exibirCampeonato("789"));
	}
	
	@Test
	void verificaAposta() {
		assertEquals(mrbet.apostar("123", "Bra", 2, 10.0), "APOSTA REGISTRADA!");
	}
	
	@Test
	void verificaApostaMalSucedidaCodigo() {
		assertThrows(IllegalArgumentException.class, () -> mrbet.apostar("674", "Bra", 2, 12.0));
	}
	
	@Test
	void verificarStatusAposta() {
		
		assertEquals(mrbet.verificaStatusAposta(), "1. [123] Seila/ Seila2\n"
				+ "Bra\n"
				+ "2/10\n"
				+ "R$ 12.0" );
	}

}
