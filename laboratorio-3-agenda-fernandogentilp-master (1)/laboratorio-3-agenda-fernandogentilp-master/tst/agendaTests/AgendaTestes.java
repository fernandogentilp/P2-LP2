package agendaTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;
import agenda.Contato;

class AgendaTestes {
	
	Agenda agenda;
	
	@BeforeEach
	private void setUp() {
		this.agenda = new Agenda();
		agenda.cadastraContato(1, "Fernando", "Gentil", "(33)1234567");
		agenda.cadastraContato(2, "Fernand", "Genti", "(33)123456");
		agenda.cadastraFavorito(1, 1);

	}
	
	@Test
	void verificaTamanhoContatosTest() {
		assertEquals(agenda.getContatos().length, 100);
	}
	
	//Esse teste verifica se estamos criando um array corretamente
	@Test
	void cadastraContatoBemSucedido() {
		int contador = 0;
		for (Contato contato : agenda.getContatos()) {
			if (contato != null) {
				contador ++;
			}	
		}
		assertEquals(contador, 2);
	}
	
	//Esse teste verifica se estamos cadastrando um contato repetido
	@Test
	void cadastraContatoRepetido() {
		assertEquals(agenda.cadastraContato(1, "Fernando", "Gentil", "(33)1234567"),"CONTATO JA CADASTRADO");
	}
	
	@Test
	void cadastraPosiçaoInvalida() {
		assertEquals(agenda.cadastraContato(101, "Fernando", "Gentil", "(33)1234567"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void cadastraNomeVazio() {
		assertEquals(agenda.cadastraContato(1, "", "Gentil", "(33)1234567"), "CONTATO INVALIDO");
	}
	
	@Test
	void cadastraTelefoneVazio() {
		assertEquals(agenda.cadastraContato(1, "Fernando", "Gentil", ""), "CONTATO INVALIDO");
	}
	
	@Test
	void verificaTamanhoFavoritosTest() {
		assertEquals(agenda.getFavoritos().length, 10);
	}
	
	@Test
	void cadastraFavoritosBemSucedido() {
		int contador = 0;
		for(Contato favorito: agenda.getFavoritos()) {
			if(favorito != null) {
				contador ++;
			}
		}
		assertEquals(contador, 1);
	}
	
	@Test
	void cadastraContatoFavorito() {
		assertEquals(agenda.cadastraFavorito(1, 1), "ESSE CONTATO JÁ ESTÁ FAVORITADO!");
	}
	
	@Test
	void cadastraFavoritoInvalido() {
		assertEquals(agenda.cadastraFavorito(11, 1), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void removerFavoritoTest() {
		assertEquals(agenda.removerFavorito(1), "Favorito removido com sucesso");
	}
}
