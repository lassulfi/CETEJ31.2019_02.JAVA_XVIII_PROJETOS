package br.com.uftpr.model;

public final class Carga extends Veiculo {

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
	public int calcVel() {
		final int factor = 1000 * 100; //1 km = 1000 m and 1 m = 100 cm
		return factor * super.getVelocMax();
	}

	@Override
	public String toString() {
		return "\nTipo de veículo: carga"
				+ super.toString()
				+ "\n\ttara: " + tara
				+ "\n\tcarga máxima: " + cargaMax
				+ "\n\tvelocidade máxima (centimetros por hora - cm/h): " + this.calcVel();
	}		
}
