package br.com.uftpr.main;

import br.com.uftpr.model.Carga;
import br.com.uftpr.model.Motor;
import br.com.uftpr.model.Passeio;
import br.com.uftpr.model.Veiculo;

public class Teste {

	public static void main(String[] args) {
		
		Veiculo veiculoPasseio1 = new Passeio();
		
		System.out.println(veiculoPasseio1);
		
		veiculoPasseio1.setPlaca("EEV4956");
		veiculoPasseio1.setMarca("Ford");
		veiculoPasseio1.setModelo("Ford Fiesta");
		veiculoPasseio1.setMotor(new Motor(5, 130));
		veiculoPasseio1.getMotor().getVeiculos().add(veiculoPasseio1);
		veiculoPasseio1.setVelocMax(200);
		
		System.out.println(veiculoPasseio1);
		
		Passeio veiculoPasseio2 = new Passeio("AAZ9053", "Chevrolet", "Celta", 150, new Motor(4, 80), 4);
		veiculoPasseio2.getMotor().getVeiculos().add(veiculoPasseio2);
		
		System.out.println(veiculoPasseio2);
		
		Veiculo veiculoPasseio3 = new Passeio("KFL4563", "Fiat", "Uno", 140, new Motor(4, 70), 4);
		veiculoPasseio3.getMotor().getVeiculos().add(veiculoPasseio3);
		
		System.out.println(veiculoPasseio3);
		
		Veiculo veiculoCarga1 = new Carga();
		
		System.out.println(veiculoCarga1);
		
		veiculoCarga1.setPlaca("DKF5642");
		veiculoCarga1.setMarca("Volvo");
		veiculoCarga1.setModelo("Euro Truck");
		veiculoCarga1.setMotor(new Motor(10, 300));
		veiculoCarga1.getMotor().getVeiculos().add(veiculoCarga1);
		veiculoCarga1.setVelocMax(150);
		
		System.out.println(veiculoCarga1);
		
		Veiculo veiculoCarga2 = new Carga("ZDF4567", "Scania", "SC4000", 130, new Motor(8, 250), 7000, 15000);
		veiculoCarga2.getMotor().getVeiculos().add(veiculoCarga2);
		
		System.out.println(veiculoCarga2);
		
		Carga veiculoCarga3 = new Carga("JFK5693", "Mercedes", "M5600", 120, new Motor(8, 2000), 6000, 10000);
		veiculoCarga3.getMotor().getVeiculos().add(veiculoCarga3);
		
		System.out.println(veiculoCarga3);
		
	}		
}
