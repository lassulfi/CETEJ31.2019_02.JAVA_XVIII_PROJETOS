package br.com.utfpr.sistemabancario.model;

/**
 * Classe responsável por armazenar informações referente ao endereco do correntista
 * 
 * @author Luis Daniel Assulfi
 *
 */
public final class Endereco {

	private String rua = new String(" ");
	
	private int num = 0;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
