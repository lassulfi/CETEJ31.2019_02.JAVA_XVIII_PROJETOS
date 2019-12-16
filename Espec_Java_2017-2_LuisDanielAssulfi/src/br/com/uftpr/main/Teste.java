package br.com.uftpr.main;

import java.util.Random;
import java.util.Scanner;

import br.com.uftpr.data.BDVeiculos;
import br.com.uftpr.data.exception.VeicExistException;
import br.com.uftpr.model.Carga;
import br.com.uftpr.model.Motor;
import br.com.uftpr.model.Passeio;
import br.com.uftpr.view.Tela;

public class Teste {
	
	private static BDVeiculos bd = new BDVeiculos();

	public static void main(String[] args) {
		adicionarDadosBanco(bd);
		
		Scanner in = new Scanner(System.in);
		
		int opcao = -1;
		do {
			Tela.exibirMenuPrincipal();
			try {
				opcao = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				Tela.exibirMensagem("A opção deve ser um número entre 1 e 9");
			}
			tratarOpcao(opcao, in);
			if(opcao < 1 || opcao > 10) Tela.exibirMensagem("Opção inválida. Escolha uma nova opção.");
			if(opcao == 9) sairDoSistema(in);
		} while (opcao < 1 || opcao > 10 || opcao != 9);
		
	}
	
	private static void tratarOpcao(int opcao, Scanner in) {
		switch (opcao) {
		case 1:
			cadastrarVeiculoPasseio(in);
			break;
		case 2:
			cadastrarVeiculoCarga(in);
			break;
		case 3:
			listarVeiculosPasseio();
			break;
		case 4:
			listarVeiculosCarga();
			break;
		case 5:
			exibirVeiculoPasseioPorPlaca(in);
			break;
		case 6:
			exibirVeiculoCargaPorPlaca(in);
			break;
		case 7:
			alterarVeiculoPasseioPelaPlaca(in);
			break;
		case 8:
			alterarVeiculoCargaPelaPlaca(in);
			break;
		default:
			break;
		}
	}
	
	public static void cadastrarVeiculoPasseio(Scanner in) {		
		Passeio passeioTemp = Tela.exibirTelaCadastroPasseio(in);
		
		try {
			bd.adicionarVeiculoPasseio(passeioTemp);
			Tela.exibirMensagem("Veículo de passeio cadastrado com sucesso!");
		} catch (VeicExistException e) {
			System.out.println(e.getMessage());
			int opcao = Tela.exibirOpcaoParaSobrescreverVeiculo(in);
			if (opcao == 1) {
				bd.atualizarVeiculoPasseioPelaPlaca(passeioTemp);
				Tela.exibirMensagem("Veículo de passeio atualizado com sucesso!");
			} else {
				cadastrarVeiculoPasseio(in);
			}
		}
	}
	
	public static void cadastrarVeiculoCarga(Scanner in) {
		Carga cargaTemp = Tela.exibirTelaCadastroCarga(in);
		
		try {
			bd.adicionarVeiculoCarga(cargaTemp);
			System.out.println("Veículo de carga adicionado com sucesso!");
		} catch (VeicExistException e) {
			System.out.println(e.getMessage());
			int opcao = Tela.exibirOpcaoParaSobrescreverVeiculo(in);
			if(opcao == 1) {
				bd.atualizarVeiculoCargaPelaPlaca(cargaTemp);
			} else {
				cadastrarVeiculoCarga(in);
			}
		}
	}
		
	private static void listarVeiculosPasseio() {;
		Tela.exibirListagemDeVeiculosDePasseio(bd.recuperarTodosVeiculosPasseio());
	}
	
	private static void listarVeiculosCarga() {
		Tela.exibirListagemDeVeiculosDeCarga(bd.recuperarTodosVeiculosCarga());
	}
	
	private static void exibirVeiculoPasseioPorPlaca(Scanner in) {
		Tela.exibirVeiculoPasseioPorPlaca(bd, in);
	}
	
	private static void exibirVeiculoCargaPorPlaca(Scanner in) {
		Tela.exibirVeiculoCargaPorPlaca(bd, in);
	}
	
	public static void alterarVeiculoPasseioPelaPlaca(Scanner in) {
		Tela.alterarVeiculoPasseioPorPlaca(bd, in);
	}
	
	public static void alterarVeiculoCargaPelaPlaca(Scanner in) {
		Tela.alterarVeiculoCargaPelaPlaca(bd, in);
	}
	
	private static void sairDoSistema(Scanner in) {
		Tela.exibirMensagem("Obrigado por utilizar nosso sistema!");
		if(in != null) in.close();
		System.exit(0);
	}
	
	/**
	 * Esse metodo adiciona dados ao banco de dados ao iniciar a aplicação
	 * Serve somente para auxiliar os testes.
	 * @param bd
	 */
	private static void adicionarDadosBanco(BDVeiculos bd) {
		String[] marcas = {"FORD", "CHEVROLET", "FIAT", "VOLKSWAGEN", "SCANIA", "VOLVO", 
				"ACURA", "MAZDA", "HYUNDAI", "TESLA", "PEUGEOT", "RENAULT"};
		String[] modelosPasseio = {"New Fiesta", "Agile", "Gol", "NSX", "HB20", "Focus", "Uno", 
				"Moby", "207", "308", "Clio", "RX-7", "MX-5", "Prisma", "Ka", "Toro"};
		String[] modelosCarga = {"24250", "8150", "710", "9150", "13180", "FH 460", 
				"Atego 2425", "Accelo 815", "VM 260", "R440"};
		
		Random random = new Random();
		
		//Adicionando veículos de passeio
		for(int i = 0; i < 10; i++) {
			String placaTemp = gerarPlacasAleatorias();
			Passeio passeio = new Passeio(placaTemp, 
					marcas[random.nextInt(marcas.length - 1)], modelosPasseio[random.nextInt(modelosPasseio.length - 1)], 
					random.nextInt((250 - 60 + 1) + 60), 
					new Motor(random.nextInt((5 - 2 + 1) + 2), random.nextInt((700 - 60 + 1) + 60)), 
					random.nextInt((5 - 2 + 1) + 2));
			bd.recuperarTodosVeiculosPasseio().add(passeio);
		}
		
		//Adicionando veículos de carga
		for(int i = 0; i < 10; i++) {
			String placaTemp = gerarPlacasAleatorias();
			Carga carga = new Carga(placaTemp, 
					marcas[random.nextInt(marcas.length - 1)],  
					modelosCarga[random.nextInt(modelosCarga.length - 1)], 
					random.nextInt((200 - 60 + 1) + 60), 
					new Motor(random.nextInt((5 - 2 + 1) + 2), random.nextInt((1500 - 500 + 1) + 500)), 
					random.nextInt((7000 - 3000 + 1) + 3000), 
					random.nextInt((15000 - 5000 + 1) + 5000));
			bd.recuperarTodosVeiculosCarga().add(carga);
		}
	}
	
	
	private static String gerarPlacasAleatorias() {
		int limiteEsquerdo = 97;
		int limiteDireito = 122;
		
		Random random = new Random();
		StringBuilder placa = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			placa.append((char) (limiteEsquerdo + (int)(random.nextFloat() * (limiteDireito - limiteEsquerdo + 1))));
		}
		placa.append("-");
		for(int i = 0; i < 4; i++) {
			placa.append(random.nextInt(9));
		}
		
		return placa.toString().toUpperCase();
	}
}
