package br.com.utfpr.sistemabancario;

import java.util.Scanner;

import br.com.utfpr.sistemabancario.model.PessoaJuridica;

/**
 * Classe que contém o método que inicia a aplicação e trata os eventos de tela
 * 
 * @author Luis Daniel Assulfi
 *
 */
public class TstConta {
	
	private static PessoaJuridica empresa = new PessoaJuridica();
	
	public static void main(String[] args) {		
		Scanner in = new Scanner(System.in);
		
		int opcao = -1;
		do {
			System.out.println("\nBem vindo ao banco da UTFPR");
			System.out.println("Escolha a uma opção: ");
			System.out.println("[1] - Quero abrir minha conta como pessoa jurídica");
			System.out.println("[2] - Quero ver meus dados");
			System.out.println("[3] - Quero sair da aplição");
			System.out.print("Minha opção é: ");
			try {
				opcao = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				System.out.println("A opção informada deve ser um número entre 1 e 3");
			}
			tratarOpcao(opcao, in);
		} while (opcao >= 1 && opcao <= 3);
	}
	
	private static void tratarOpcao(int opcao, Scanner in) {
		switch (opcao) {
		case 1:
			cadastrarPessoaJuridica(in);
			break;
		case 2: 
			exibirDados();
			break;
		case 3:
			sairDoSistema();
			break;
		default:
			System.out.println("Opção inválida");
			break;
		}
	}

	private static void cadastrarPessoaJuridica(Scanner in) {
	
		System.out.println("\nVamos cadastrar o responsável pela conta? ");
		System.out.print("Qual o nome do responsável pela conta? ");
		String tempNome = in.nextLine();
		System.out.print("E qual é o CPF? ");
		int cpf = in.nextInt();
		in.nextLine();
		
		empresa.getResponsavel().setNome(tempNome);
		empresa.getResponsavel().setCpf(cpf);
		
		System.out.println("O responśavel foi cadastrado! Vamos cadastrar a empresa? ");
		System.out.print("Qual é o nome da rua? ");
		String tempRua = in.nextLine();
		System.out.print("E qual é o número? ");
		int tempNumero = in.nextInt();
		in.hasNextLine();
		
		empresa.getEnder().setRua(tempRua);
		empresa.getEnder().setNum(tempNumero);
		
		System.out.print("E qual vai ser o número da sua conta? ");
		int numeroContaTemp = in.nextInt();
		in.nextLine();
		System.out.print("E qual é o CNPJ da empresa? ");
		int cnpjTemp = in.nextInt();
		in.nextLine();
		
		empresa.setNumeroConta(numeroContaTemp);
		empresa.setCnpj(cnpjTemp);
		
		System.out.print("Qual vai ser o nome da sua conta? ");
		String nomeContaTemp = in.nextLine();
		
		empresa.setNome(nomeContaTemp);
	}
	
	private static void exibirDados() {
		if(empresa.getCnpj() != 0) {
			System.out.println("\nDados do responsável da conta");
			System.out.printf("Nome do responsável: %s ", empresa.getResponsavel().getNome());
			System.out.printf("\nCPF do responsável: %s ", empresa.getResponsavel().getCpf());
			empresa.getResponsavel().verifDoc();
			System.out.println("Dados da empresa");
			System.out.printf("Rua da empresa: %s ", empresa.getEnder().getRua());
			System.out.printf("\nNúmero da rua: %s \n", empresa.getEnder().getNum());
			System.out.println("Dados da conta");
			System.out.printf("Numero da conta: %s ", empresa.getNumeroConta());
			empresa.validar();
			System.out.printf("Nome da conta: %s ", empresa.getNome());
			System.out.printf("\nCNPJ da empresa: %s ", empresa.getCnpj());
			empresa.verifDoc();
			empresa.validar();
		} else {
			System.out.println("\nNenhuma empresa cadastrada");
		}
	}
	
	private static void sairDoSistema() {
		System.out.println("Obrigado por utilizar nosso sistema!");
		System.exit(0);
	}
}
