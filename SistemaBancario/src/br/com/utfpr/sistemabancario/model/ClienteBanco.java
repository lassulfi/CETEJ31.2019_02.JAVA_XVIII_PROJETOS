package br.com.utfpr.sistemabancario.model;

import br.com.utfpr.sistemabancario.services.Verifica;

/**
 * Classe abstrata responsável por gerar uma 
 * 
 * @author Luis Daniel Assulfi
 */
public abstract class ClienteBanco implements Verifica {

	private String nome = new String(" ");
	
	private int numeroConta = 0;
	
	private Endereco ender = new Endereco();
	
	public abstract void verifDoc();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Endereco getEnder() {
		return ender;
	}

	public void setEnder(Endereco ender) {
		this.ender = ender;
	}

	@Override
	public void validar() {
		if(this.numeroConta % 2 == 0) {
			System.out.println("O número da conta corrente é par.");
		} else {
			System.out.println("O número da conta corrente é impar.");
		}
	}
}
