package br.com.uftpr.view;

import java.util.List;
import java.util.Scanner;

import br.com.uftpr.data.BDVeiculos;
import br.com.uftpr.model.Carga;
import br.com.uftpr.model.Motor;
import br.com.uftpr.model.Passeio;

public class Tela {
	
	public static void exibirMenuPrincipal() {
		System.out.println(" \n=== SISTEMA DE GESTÃO DE VEICULOS ===");
		System.out.println(" ===         Menu Inicial          ===");
		System.out.println("\nSelecione uma das opções abaixo:");
		System.out.println("[1] => Cadastrar veículo de passeio");
		System.out.println("[2] => Cadastrar veículo de carga");
		System.out.println("[3] => Imprimir todos os veículos de passeio");
		System.out.println("[4] => Imprimir todos os veículos de carga");
		System.out.println("[5] => Imprimir veículo de passeio pela placa");
		System.out.println("[6] => Imprimir veículo de carga pela placa");
		System.out.println("[7] => Alterar dados do veículo de passeio pela placa");
		System.out.println("[8] => Alterar dados do veículo de carga pela placa");
		System.out.println("[9] => Sair do sistema");
		System.out.print("Opcao: ");
	}
	
	public static void exibirMensagem(String msg) {
		System.out.println(msg);
	}
	
	public static void exibirListagemDeVeiculosDePasseio(List<Passeio> lista) {
		if(lista.size() == 0) {
			System.out.println("Nenhum veículo de passeio cadastrado");
		} else {
			lista.forEach(System.out::println);
		}
	}
	
	public static Passeio exibirTelaCadastroPasseio(Scanner in) {
		String placaTemp, marcaTemp, modeloTemp;
		int velocTemp = 0, qtdPistTemp = 0, potenciaTemp = 0, qtdePassageirosTemp = 0;
		
		System.out.println("[1] - Cadastrar um veículo de passeio");
		System.out.print("Informe a placa do veículo: ");
		placaTemp = in.nextLine();
		System.out.print("Informe a marca do veículo: ");
		marcaTemp = in.nextLine();
		System.out.print("Informe o modelo do veículo: ");
		modeloTemp = in.nextLine();
		System.out.print("Informe a velocidade máxima do veículo, em km/h: ");
		try {
			velocTemp = in.nextInt();	
		} catch (Exception e) {
			exibirMensagem("A velocidade deve ser um número inteiro.");
		}
		in.nextLine();
		System.out.print("Informe a quantidade de pistões do motor: ");
		try {
			qtdPistTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A quantidade de pistões deve ser um número inteiro");
		}
		in.nextLine();
		System.out.print("Informe a potência do motor: ");
		try {
			potenciaTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A potência do motod deve ser um número inteiro");
		}
		in.nextLine();
		System.out.print("Informe a quantidade de passageiros por veículo: ");
		try {
			qtdePassageirosTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A quantidade de passegeiros deve ser um número inteiro");
		}
		in.nextLine();
		
		Motor motorTemp = new Motor(qtdPistTemp, potenciaTemp);
		Passeio passeioTemp = new Passeio(placaTemp, marcaTemp, modeloTemp, velocTemp, motorTemp, qtdePassageirosTemp);
		
		return passeioTemp;
	}
	
	public static Carga exibirTelaCadastroCarga(Scanner in) {
		String placaTemp, marcaTemp, modeloTemp;
		int velocTemp = 0, qtdPistTemp = 0, potenciaTemp = 0, taraTemp = 0, cargaMaxTemp = 0;
		
		System.out.println("[2] - Cadastrar um veículo de carga");
		System.out.print("Informe a placa do veículo: ");
		placaTemp = in.nextLine();
		System.out.print("Informe a marca do veículo: ");
		marcaTemp = in.nextLine();
		System.out.print("Informe o modelo do veículo: ");
		modeloTemp = in.nextLine();
		System.out.print("Informe a velocidade máxima do veículo, em km/h: ");
		try {
			velocTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A velocidade deve ser um número inteiro");
		}
		in.nextLine();
		System.out.print("Informe a quantidade de pistões do motor: ");
		try {
			qtdPistTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A quantidade de pistões deve ser um  número inteiro");
		}
		in.nextLine();
		System.out.print("Informe a potência do motor: ");
		try {
			potenciaTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A potência do motor deve ser um número inteiro.");
		}
		in.nextLine();
		System.out.print("Informe a tara do veículo: ");
		try {
			taraTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A tara do veículo dove ser um número inteiro.");
		}
		in.nextLine();
		System.out.print("Informe a capacidade máxima de carga do veículo: ");
		try {
			cargaMaxTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A carga máxima do veículo deve ser um número inteiro.");
		}
		in.nextLine();
		
		Motor motorTemp = new Motor(qtdPistTemp, potenciaTemp);
		
		Carga cargaTemp = new Carga(placaTemp, marcaTemp, modeloTemp, velocTemp, motorTemp, taraTemp, cargaMaxTemp);
		
		return cargaTemp;
	}
	
	public static int exibirOpcaoParaSobrescreverVeiculo(Scanner in) {
		int opcao = -1;
		do {
			System.out.println("Escolha a opção abaixo: ");
			System.out.println("[1] - Sobrescrever veículo cadastrado");
			System.out.println("[2] - Cadastrar outro veículo do mesmo tipo");
			System.out.print("Opção: ");
			try {
				opcao = in.nextInt();
				in.nextLine();
			} catch (Exception e) {
				System.out.println("A opção informada deve ser um número.");
			}
			if(opcao < 1 || opcao > 2) System.out.println("Opção inválida.");
		} while (opcao < 1 || opcao > 2);
		
		return opcao;
	}
	
	public static void exibirListagemDeVeiculosDeCarga(List<Carga> lista) {
		System.out.println("[4] - Imprimir listagem de veículos de carga cadastrados");
		if(lista.size() == 0) {
			System.out.println("Nenhum veículo de carga cadastrado");
		} else {
			lista.forEach(System.out::println);
		}
	}
	
	public static void exibirVeiculoPasseioPorPlaca(BDVeiculos bd, Scanner in) {
		String placa;
		
		System.out.println("\n[5] - Imprimir veículo de passeio pela placa");
		placa = recuperarPlacaVeiculo(in);
		
		Passeio passeio = bd.recuperarVeiculoPasseioPorPlaca(placa);
		
		if(passeio != null) {
			System.out.printf("\nInformações do veículo: %s", passeio);
		} else {
			System.out.println("Nenhum veículo com placa " + placa + " encontrado");
		}
	}
	
	public static void exibirVeiculoCargaPorPlaca(BDVeiculos bd, Scanner in) {
		String placa;
		
		System.out.println("[6] - Imprimir veículo de carga pela placa");
		placa = recuperarPlacaVeiculo(in);
		
		Carga carga = bd.recuperarVeiculoCargaPorPlaca(placa);
		
		if(carga != null) {
			System.out.println("Informações do veículo: " + carga);
		} else {
			System.out.println("Nenhum veículo com placa " + placa + " encontrado");
		}
	}
	
	public static void alterarVeiculoPasseioPorPlaca(BDVeiculos bd, Scanner in) {
		String placaTemp, marcaTemp, modeloTemp;
		int velocTemp = 0, qtdPistTemp = 0, potenciaTemp = 0, qtdePassageirosTemp = 0;
		
		System.out.println("[7] - Alterar dados do veiculo de passeio por placa");
		System.out.print("Informe a placa do veículo: ");
		placaTemp = in.nextLine();
		Passeio passeioTemp = bd.recuperarVeiculoPasseioPorPlaca(placaTemp);
		if(passeioTemp == null) {
			System.out.println("Veículo de passeio com a placa " + placaTemp + " não cadastrado.");
		} else {
			System.out.print("Informe a marca do veículo: ");
			marcaTemp = in.nextLine();
			System.out.print("Informe o modelo do veículo: ");
			modeloTemp = in.nextLine();
			System.out.print("Informe a velocidade máxima do veículo, em km/h: ");
			try {
				velocTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A velocidade máxima do veículo deve ser um número inteiro.");
			}
			in.nextLine();
			System.out.print("Informe a quantidade de pistões do motor: ");
			try {
				qtdPistTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A quantidade de pistões deve ser um número inteiro.");
			}
			in.nextLine();
			System.out.print("Informe a potência do motor: ");
			try {
				potenciaTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A potência do motor deve ser um número inteiro.");
			}
			in.nextLine();
			System.out.print("Informe a quantidade de passageiros por veículo: ");
			try {
				qtdePassageirosTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A quantidade de passageiros deve ser um número inteiro.");
			}
			in.nextLine();
			
			passeioTemp.setMarca(marcaTemp);
			passeioTemp.setModelo(modeloTemp);
			passeioTemp.setVelocMax(velocTemp);
			passeioTemp.getMotor().setQtdPist(qtdPistTemp);
			passeioTemp.getMotor().setPotencia(potenciaTemp);
			passeioTemp.setQtdePassageiros(qtdePassageirosTemp);
			bd.atualizarVeiculoPasseioPelaPlaca(passeioTemp);
		}
		
	}
	
	public static void alterarVeiculoCargaPelaPlaca(BDVeiculos bd, Scanner in) {
		String placaTemp, marcaTemp, modeloTemp;
		int velocTemp = 0, qtdPistTemp = 0, potenciaTemp = 0, taraTemp = 0, cargaMaxTemp = 0;
		
		System.out.println("[8] => Alterar dados do veículo de carga pela placa");
		System.out.print("Informe a placa do veículo: ");
		placaTemp = in.nextLine();
		Carga cargaTemp = bd.recuperarVeiculoCargaPorPlaca(placaTemp);
		if(cargaTemp == null) {
			System.out.println("Veículo de passeio com a placa " + placaTemp + " não cadastrado.");
		} else {
			System.out.print("Informe a marca do veículo: ");
			marcaTemp = in.nextLine();
			System.out.print("Informe o modelo do veículo: ");
			modeloTemp = in.nextLine();
			System.out.print("Informe a velocidade máxima do veículo, em km/h: ");
			try {
				velocTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A velocidade máxima deve ser um número inteiro");
			}
			in.nextLine();
			System.out.print("Informe a quantidade de pistões do motor: ");
			try {
				qtdPistTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A quantidade de pistões deve ser um número inteiro.");
			}
			in.nextLine();
			System.out.print("Informe a potência do motor: ");
			try {
				potenciaTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A potência do motor deve ser um número inteiro.");
			}
			in.nextLine();
			System.out.print("Informe a tara do veículo: ");
			try {
				taraTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A tara do veículo deve ser um número inteiro");
			}
			in.nextLine();
			System.out.print("Informe a capacidade máxima de carga do veículo: ");
			try {
				cargaMaxTemp = in.nextInt();
			} catch (Exception e) {
				System.out.println("A carga máxima do veículo deve ser um número inteiro.");
			}
			in.nextLine();
			
			cargaTemp.setMarca(marcaTemp);
			cargaTemp.setModelo(modeloTemp);
			cargaTemp.setVelocMax(velocTemp);
			cargaTemp.getMotor().setQtdPist(qtdPistTemp);
			cargaTemp.getMotor().setPotencia(potenciaTemp);
			cargaTemp.setTara(taraTemp);
			cargaTemp.setCargaMax(cargaMaxTemp);
			bd.atualizarVeiculoCargaPelaPlaca(cargaTemp);
		}
	}
	
	private static String recuperarPlacaVeiculo(Scanner in) {
		System.out.print("Informe a placa do veículo: ");
		
		return in.nextLine();
	}

}
