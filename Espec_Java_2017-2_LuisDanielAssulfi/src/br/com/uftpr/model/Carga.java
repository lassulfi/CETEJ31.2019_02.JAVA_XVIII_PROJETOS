package br.com.uftpr.model;

import br.com.uftpr.model.exception.VelocException;
import br.com.uftpr.service.Calc;

public final class Carga extends Veiculo implements Calc{

	private int tara;
	private int cargaMax;
	
	public Carga() {
		super();
		this.tara = 0;
		this.cargaMax = 0;
	}
	
	public Carga(String placa, String marca, String modelo, int velocMax, Motor motor, 
			int tara, int cargaMax) {
		super(placa, marca, modelo, velocMax, motor);
		this.tara = tara;
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}

	public final void setTara(int tara) {
		this.tara = tara;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	@Override
	public final int calcVel() throws VelocException {
		if(super.getVelocMax() < 100 || super.getVelocMax() > 250) {
			throw new VelocException("A velocidade máxima está fora dos limites brasileiros");
		}
		final int factor = 1000 * 100; //1 km = 1000 m and 1 m = 100 cm
		return factor * super.getVelocMax();
	}
	
	@Override
	public final int calcular() {
		int soma = super.getVelocMax() +
				super.getMotor().getPotencia() +
				super.getMotor().getQtdPist();
		
		return soma;
	}

	@Override
	public final String toString() {
		int velocMax;
		try {
			velocMax = this.calcVel();
		} catch (VelocException e) {
			System.out.println(e.getMessage());
			velocMax = 120;
		}
		
		return "\nTipo de veículo: carga"
				+ super.toString()
				+ "\n\ttara: " + tara
				+ "\n\tcarga máxima: " + cargaMax
				+ "\n\tvelocidade máxima (centimetros por hora - cm/h): " + velocMax
				+ "\n\tsoma total dos valores inteiros: " + this.calcular();
	}		
}
