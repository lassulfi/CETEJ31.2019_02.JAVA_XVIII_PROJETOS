package br.com.utfpr.sistemabancario.model;

/**
 * Classe responsável por gerar uma instancia de um objeto para armazenar dados de uma pessoa fisica
 * 
 * @author Luis Daniel Assulfi
 *
 */
public final class PessoaFisica extends ClienteBanco {

	private int cpf = 0;

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	@Override
	public void verifDoc() {
		if(this.cpf >= 10 && this.cpf <= 20) {
			System.out.println("CPF válido.");
		} else {
			System.out.println("CPF inválido.");
		}
	}
}