package br.com.utfpr.sistemabancario.model;

/**
 * Classe responsável por gerar uma instancia de objeto para armanzenar dados de pessoa juridica
 * 
 * @author Luis Daniel Assulfi
 *
 */
public final class PessoaJuridica extends ClienteBanco {

	private int cnpj = 0;
	
	private PessoaFisica responsavel = new PessoaFisica();

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public PessoaFisica getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(PessoaFisica responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public void verifDoc() {
		if (this.cnpj >= 50 && this.cnpj <= 100) {
			System.out.println("CNPJ válido.");
		} else {
			System.out.println("CNPJ inválido.");
		}
	}
}
