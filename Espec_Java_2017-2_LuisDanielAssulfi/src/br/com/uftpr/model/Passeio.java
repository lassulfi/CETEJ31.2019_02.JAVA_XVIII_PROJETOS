package br.com.uftpr.model;

import br.com.uftpr.model.exception.VelocException;
import br.com.uftpr.service.Calc;

public final class Passeio extends Veiculo implements Calc {

	private int qtdePassageiros;
	
	public Passeio() {
		super();
		this.qtdePassageiros = 0;
	}
		
	public Passeio(String placa, String marca, String modelo, int velocMax, Motor motor, 
			int qtdePassageiros) {
		super(placa, marca, modelo, velocMax, motor);
		this.qtdePassageiros = qtdePassageiros;
	}

		
	public int getQtdePassageiros() {
		return qtdePassageiros;
	}

	public final void setQtdePassageiros(int qtdePassageiros) {
		this.qtdePassageiros = qtdePassageiros;
	}

	@Override
	public final int calcVel() throws VelocException {
		if(super.getVelocMax() < 100 || super.getVelocMax() > 250) {
			throw new VelocException("A velocidade máxima está fora dos limites brasileiros");
		}
		final int factor = 1000;  //1 km = 1000 m
		return factor * super.getVelocMax();
	}
	
	@Override
	public final int calcular() {
		int caracteres = super.getMarca().length() +
				super.getModelo().length() +
				super.getPlaca().length();
		
		return caracteres;
	}

	@Override
	public final String toString() {
		int velocMax;
		try {
			velocMax = this.calcVel();
		} catch (VelocException e) {
			System.out.println(e.getMessage());
			velocMax = 150;
		}
		
		return "\nTipo de veículo: passeio"
				+ super.toString()
				+ "\n\tquantidade de passageiros: " + qtdePassageiros 
				+ "\n\tvelocidade máxima (metros/hora - m/h):" + velocMax 
				+ "\n\ttotal de caracteres: " + this.calcular();
	}	
}
