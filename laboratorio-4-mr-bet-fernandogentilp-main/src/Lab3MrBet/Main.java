package Lab3MrBet;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		MrBet mrbet = new MrBet();
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			comando(menu(scanner), mrbet, scanner);

		}
	}
	
	/**
	 * 
	 * @param scanner Esse é o que irá receber a entrada do método
	 * @return irá retornar a entrada com as letras maisculas/minusculas
	 */
	private static String menu(Scanner scanner) {
			
			System.out.println("(M)Minha inclusão de times" 
					+ "\n(R)Recuperar time" 
					+ "\n(.)Adicionar campeonato"
					+ "\n(B)Bora incluir time em campeonato e Verificar se time está em campeonato" 
					+ "\n(E)Exibir campeonatos que o time participa" 
					+ "\n(T)Tentar a sorte e status\n" + "(!)Já pode fechar o programa!"
					+ "\n Opção> ");
			
			return scanner.next().toUpperCase();
			
	}
		
		/**
		 * Esse método irá fazer o menu do sistema
		 * @param opcao Uma string opção
		 * @param mrbet um objeto do tipo MrBet
		 * @param scanner Um objeto Scanner
		 */
		private static void comando(String opcao, MrBet mrbet, Scanner scanner) {
			switch (opcao) {
			case "M":
				incluiTime(mrbet, scanner);
				break;
			case "R":
				recuperaTime(mrbet, scanner);
				break;
			case ".":
				adicionaCampeonato(mrbet, scanner);
				break;
			case "B":
				subMenu(mrbet, scanner);
				break;
			case "E":
				exibirCampeonato(mrbet, scanner);
				break;
			case "T":
				menuAposta(mrbet, scanner);
				break;
			case "!":
				sai();
				break;
			default:
				System.out.println("Opção inválida!"); }
		}
			
			/**
			 * Método que sai do menu
			 */
			private static void sai() {
				System.out.println("Por hoje é só pessoal!");
				System.exit(0);
			}
			/**
			 * Método que inclui times no menu
			 * @param mrbet objeto MrBet
			 * @param scanner objeto Scanner
			 */
			public static void incluiTime(MrBet mrbet, Scanner scanner) {
				System.out.println("\nCódigo: ");
				String codigo = scanner.next();
				System.out.println("\nNome: ");
				String nome = scanner.next();
				System.out.println("Mascote: ");
				String mascote = scanner.next();
				System.out.println(mrbet.incluiTime(codigo, nome, mascote));
			}
			/**
			 * Método que mostra o time cadastrado
			 * @param mrbet objeto MrBet
			 * @param scanner objeto Scanner
			 */
			public static void recuperaTime(MrBet mrbet, Scanner scanner) {
				System.out.println("\nCódigo: ");
				String codigo = scanner.next();
				System.out.println(mrbet.recuperaTime(codigo).toString());
			}
			/**
			 * Método que adiciona o campeonato no sistema
			 * @param mrbet Objeto MrBet
			 * @param scanner Objeto scanner
			 */
			public static void adicionaCampeonato(MrBet mrbet, Scanner scanner) {
				System.out.println("\nCampeonato: ");
				String campeonato = scanner.next();
				System.out.println("\nParticipantes: ");
				int participantes = scanner.nextInt();
				System.out.println(mrbet.adicionaCampeonato(campeonato, participantes));
			}
			
			/**
			 * Método que inclui times no campeonato no sistema
			 * @param mrbet objeto MrBet
			 * @param scanner objeto Scanner
			 */
			public static void incluirTimeCampeonato(MrBet mrbet, Scanner scanner) {
				System.out.println("\nCódigo: ");
				String codigo = scanner.next();
				System.out.println("\nCampeonato: ");
				String campeonato = scanner.next();
				System.out.println(mrbet.incluirTimeCampeonato(codigo, campeonato));
			}
			
			/**
			 * Método que verifica time no campeonato
			 * @param mrbet objeto mrbet
			 * @param scanner objeto scanner
			 */
			public static void verificaTimeCampeonato(MrBet mrbet, Scanner scanner) {
				System.out.println("\nCódigo: ");
				String codigo = scanner.next();
				System.out.println("\nCampeonato: ");
				String campeonato = scanner.next();
				System.out.println(mrbet.verificaTimeCampeonato(codigo, campeonato));
			}
			
			/**
			 * Método que cria um submenu para uma opção especifica do menu
			 * @param mrbet objeto mrbet
			 * @param scanner objeto scanner
			 */
			private static void subMenu(MrBet mrbet, Scanner scanner) {
				System.out.println("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
				String opcao = scanner.next();
				
				switch(opcao) {
					case "I":
						incluirTimeCampeonato(mrbet, scanner);
						break;
					case "V":
						verificaTimeCampeonato(mrbet, scanner);
						break;
				}
			}
			
			/**
			 * Outro método que cria um menu especificamente para apostas
			 * @param mrbet objeto mrbet
			 * @param scanner objeto scanner
			 */
			private static void menuAposta(MrBet mrbet, Scanner scanner) {
				System.out.println("(A)Apostar ou (S)Status das Apostas?");
				String opcao = scanner.next();
				
				switch(opcao) {
					case "A":
						apostar(mrbet, scanner);
						break;
					case "S":
						exibirStatusAposta(mrbet);
						break;
				}
			}
			
			/**
			 * Método que exibe o campeonato
			 * @param mrbet objeto mrbet
			 * @param scanner objeto Scanner
			 */
			public static void exibirCampeonato(MrBet mrbet, Scanner scanner) {
				System.out.println("\nTime: ");
				String time = scanner.next();
				System.out.println(mrbet.exibirCampeonato(time));
			}
			
			/**
			 * Método que faz as apostas do sistema.
			 * @param mrbet objeto mrbet
			 * @param scanner objeto scanner
			 */
			public static void apostar(MrBet mrbet, Scanner scanner) {
				System.out.println("\nCódigo: ");
				String codigo = scanner.next();
				System.out.println("\nCampeonato: ");
				String campeonato = scanner.next();
				System.out.println("\nColocação: ");
				int colocacao = scanner.nextInt();
				System.out.println("\nValor da aposta: ");
				double valor = scanner.nextDouble();
				System.out.println(mrbet.apostar(codigo, campeonato, colocacao, valor));
			}
			
			/**
			 * Metodo que exibe o status de uma aposta
			 * @param mrbet objeto mrbet
			 */
			public static void exibirStatusAposta(MrBet mrbet) {
				System.out.println("\nApostas:");
				System.out.println(mrbet.verificaStatusAposta());
			}
			
			
}
