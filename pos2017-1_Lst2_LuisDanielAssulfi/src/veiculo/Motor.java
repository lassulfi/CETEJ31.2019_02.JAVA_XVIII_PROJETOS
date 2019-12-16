//Luis Daniel Assulfi
package veiculo;

import java.util.ArrayList;
import java.util.List;

public class Motor {

	private int qtdPist;
	private int potencia;
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Motor() {
		this.qtdPist = 0;
		this.potencia = 0;
	}
	
	public Motor(int qtdPist, int potencia) {
		this.qtdPist = qtdPist;
		this.potencia = potencia;
	}

	public int getQtdPist() {
		return qtdPist;
	}

	public void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	@Override
	public String toString() {
		return "\n Motor"
				+ "\n\tquantidade de pistoes = " + qtdPist + 
				"\n\tpotencia = " + potencia;
	}
}
