package agenda;

public class Contato {
	private String nome;

	private String sobrenome;

	private String telefone;
	
	/**
	 * Cria um contato. Basicamente o construtor dessa classe.
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @param telefone telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * Pega o nome do contato.
	 * @return retorna o atributo nome.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Pega o sobrenome do contato.
	 * @return retorna o atributo sobrenome.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Pega o telefone do contato.
	 * @return retorna o atributo telefone.
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Método toString, que aplica a string formatada
	 * @return retorna a string formatada.
	 */
	@Override
	public String toString() {
		return nome + " " + sobrenome + "\n" + telefone;
	}
	/**
	 * Método auxiliar que só pega o nome e o sobrenome.
	 * @return retorna o atributo nome e o atributo sobrenome.
	 */
	public String pegaNome() {
		return nome + " " + sobrenome;
	}

}
