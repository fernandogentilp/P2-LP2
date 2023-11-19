package agenda;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100
 * contatos.
 *
 * @author nazareno
 */
public class Agenda {

	private static final int TAMANHO_AGENDA = 100;

	private Contato[] contatos;
	
	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
	}

	/**
	 * Acessa a lista de contatos mantida.
	 *
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
	
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 *
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao - 1];
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe
	 * sobrescreve o anterior.
	 *
	 * @param posicao   Posição do contato.
	 * @param nome      Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone  Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		Contato contato = new Contato(nome, sobrenome, telefone);

		if (nome == null || nome.isBlank() || nome.isEmpty()) {
			return "CONTATO INVALIDO";
		}

		if (telefone == null || telefone.isBlank() || telefone.isEmpty()) {
			return "CONTATO INVALIDO";
		}

		if (posicao < 1 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA";
		}

		if (temContato(nome, sobrenome)) {
			return "CONTATO JA CADASTRADO";
		}

		this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
		return "CADASTRO REALIZADO";
	}
	
	/**
	 * Esse método favorita um contato já cadastrado através da posição atual
	 * até a posição especificada
	 * @param posicao Posição do favorito.
	 * @param contato Posição do contato a ser favoritado.
	 * @return basicamete retorna o estado do favorito, se foi cadastrado, se já está cadastrado, se a posição
	 * é inválida e etc.
	 */
	public String cadastraFavorito(int posicao, int contato) {
		if(posicao < 1 || posicao > 10) {
			return "POSIÇÃO INVÁLIDA";
		}
		
		if(temFavorito(contatos[contato-1])) {
			return "ESSE CONTATO JÁ ESTÁ FAVORITADO!";
		}
		
		this.favoritos[posicao - 1] = this.contatos[contato - 1];
		return "CONTATO FAVORITADO NA POSIÇÃO" + posicao;
	}
	
	
	
		
	
	/**
	 * Basicamente remove o favorito. Como está passand por um array, e não pode remover um favorito
	 * ele simplesmente atribui o valor de favoritos para null, para substituir algo existente por null.
	 * @param posicao a posição do contato favoritado.
	 * @return retorna se a posição é inválida ou se o favorito já foi removido.
	 */
	public String removerFavorito(int posicao) {
		if(posicao < 1 || posicao > 10) {
			return "POSIÇÃO INVÁLIDA";
		}
		
		this.favoritos[posicao - 1] = null;
		return "Favorito removido com sucesso";
	}
	
	/**
	 * Esse método basicamente verifica se o array tem o contato
	 * @param nome o nome do contato
	 * @param sobrenome o sobrenome do contato
	 * @return ele retorna true se tem o contato, e se não tem, ele retorna false
	 */
	private boolean temContato(String nome, String sobrenome) {
		for (Contato c : contatos) {
			if (c != null) {
				if (c.getNome().equals(nome) || c.getSobrenome().equals(sobrenome)) {
					return true;
				}
			}

		}
		return false;
	}
	/**
	 * Mesma lógica do método temContato. Ele verifica no array se tem favorito no array favoritos
	 * @param c Objeto contato para facilitar a utilização do equals no método
	 * @return retorna true se tem favorito e retorna false se não tem favorito
	 */
	private boolean temFavorito(Contato c) {
		for(Contato favorito : favoritos) {
			if(favorito != null) {
				if(favorito.equals(c)) {
					return true;
				}
			}
		}
		return false;
	}

}