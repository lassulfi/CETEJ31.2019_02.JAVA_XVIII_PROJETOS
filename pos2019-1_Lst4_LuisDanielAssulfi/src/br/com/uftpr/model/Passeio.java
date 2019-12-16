package br.com.uftpr.model;

public final class Passeio extends Veiculo {

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
	public int calcVel() {
		final int factor = 1000;  //1 km = 1000 m
		return factor * super.getVelocMax();
	}

	@Override
	public String toString() {
		return "\nTipo de veículo: passeio"
				+ super.toString()
				+ "\n\tquantidade de passageiros: " + qtdePassageiros 
				+ "\n\tvelocidade máxima (metros/hora - m/h):" + this.calcVel();
	}	
}
