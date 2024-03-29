//Luis Daniel Assulfi
package veiculo;

public class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private float velocMax;
	private Motor motor;
	
	public Veiculo() {
		this.placa = " ";
		this.marca = " ";
		this.modelo = " ";
		this.velocMax = 0.0f;
		motor = new Motor();
	}
	
	public Veiculo (String placa, String marca, String modelo, float velocMax) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.velocMax = velocMax;
	}
	
	public Veiculo(String placa, String marca, String modelo, float velocMax, Motor motor) {
		this(placa, marca, modelo, velocMax);
		this.motor = motor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getVelocMax() {
		return velocMax;
	}

	public void setVelocMax(float velocMax) {
		this.velocMax = velocMax;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Veiculo"
				+ "\n placa = " + placa + 
				",\n marca = " + marca + 
				"\n modelo = " + modelo + 
				"\n velocidade maxima = " + String.format("%.2f", velocMax)
				+ motor;
	}
	
	
}
