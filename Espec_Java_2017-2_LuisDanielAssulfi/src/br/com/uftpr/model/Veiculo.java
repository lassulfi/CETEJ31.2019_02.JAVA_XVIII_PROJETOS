package br.com.uftpr.model;

import br.com.uftpr.model.exception.VelocException;

public abstract class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private int velocMax;
	private Motor motor;
	
	public Veiculo() {
		this.placa = " ";
		this.marca = " ";
		this.modelo = " ";
		this.velocMax = 0;
		this.motor = new Motor();
	}

	public Veiculo(String placa, String marca, String modelo, int velocMax, Motor motor) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.velocMax = velocMax;
		this.motor = motor;
	}
	
	public abstract int calcVel() throws VelocException;

	public String getPlaca() {
		return placa;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(int velocMax) {
		this.velocMax = velocMax;
	}

	public Motor getMotor() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "\nInformações do veículo: \n"
				+ "\tplaca: " + placa 
				+ "\n\tmarca: " + marca 
				+ "\n\tmodelo: " + modelo 
				+ motor;
	}	
}
