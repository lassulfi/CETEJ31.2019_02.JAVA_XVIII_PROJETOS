//Luis Daniel Assulfi
package veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {
	
	private static List<Veiculo> veiculos = new ArrayList<>();
	
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("- SITEMA DE CADASTRO DE VEÍCULOS -");
		for(int i = 0; i < 10; i++) {
			cadastrarVeiculo(veiculos, i, in);
		}
		System.out.println(" - VISUALIZAR INFORMAÇÕES DOS VEÍCULOS CADASTRADOS - ");
		visualizarVeiculosCadastrados(veiculos);
	}
	
	private static void cadastrarVeiculo(List<Veiculo> veiculos, int i, Scanner in) {
		System.out.println("\nCadastar veículo # " + (i + 1));
		String placaTemp, marcaTemp, modeloTemp;
		float velocMaxTemp = 0.0f;
		System.out.print("Placa do veículo: ");
		placaTemp = in.nextLine();
		System.out.print("Marca do veículo: ");
		marcaTemp = in.nextLine();
		System.out.print("Modelo do veívulo: ");
		modeloTemp = in.nextLine();
		System.out.print("Velocidade máxima: ");
		try {
			velocMaxTemp = in.nextFloat();
		} catch(Exception e) {
			System.out.println("O valor informado deve ser do tipo float");
		}
		Veiculo veiculo = new Veiculo(placaTemp, marcaTemp, modeloTemp, velocMaxTemp);
		
		Motor motor = cadastrarMotor(in);
		motor.getVeiculos().add(veiculo);
		
		veiculo.setMotor(motor);
		
		veiculos.add(veiculo);
	}
	
	private static Motor cadastrarMotor(Scanner in) {
		int qtdPistTemp = 0, potenciaTemp = 0;
		
		System.out.println(" -- Informações do motor --");
		System.out.print("Quantidade de pistões: ");
		try {
			qtdPistTemp = in.nextInt();
		} catch (Exception e) {
			System.out.println("A quantidade de pistões deve ser um número inteiro");
		}
		System.out.print("Potência do motor: ");
		try {
			potenciaTemp = in.nextInt();
			in.nextLine();
		} catch (Exception e) {
			System.out.println("A quantidade de pistões deve ser um número inteiro");
		}
		
		return new Motor(qtdPistTemp, potenciaTemp);
	}
	
	private static void visualizarVeiculosCadastrados(List<Veiculo> veiculos) {
		int index = 1;
		for(Veiculo veiculo : veiculos) {
			System.out.println("Exibindo informações do veículo #" + index);
			System.out.println(veiculo);
		}
	}
}
