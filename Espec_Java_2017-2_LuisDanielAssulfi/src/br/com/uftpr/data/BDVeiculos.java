package br.com.uftpr.data;

import java.util.ArrayList;
import java.util.List;

import br.com.uftpr.data.exception.VeicExistException;
import br.com.uftpr.model.Carga;
import br.com.uftpr.model.Passeio;

public final class BDVeiculos {

	private List<Passeio> veiculosPasseio = new ArrayList<>();
	private List<Carga> veiculosCarga = new ArrayList<>();

	public BDVeiculos() {
	}
	
	public Passeio atualizarVeiculoPasseioPelaPlaca(Passeio passeio) {
		Passeio passeioTemp = this.recuperarVeiculoPasseioPorPlaca(passeio.getPlaca());
		int position = this.veiculosPasseio.lastIndexOf(passeioTemp);
		this.veiculosPasseio.set(position, passeio);
		
		return passeio;
	}
	
	public Carga atualizarVeiculoCargaPelaPlaca(Carga carga) {
		Carga cargaTemp = this.recuperarVeiculoCargaPorPlaca(carga.getPlaca());
		int position = this.veiculosCarga.lastIndexOf(cargaTemp);
		this.veiculosCarga.set(position, carga);
		
		return carga;
	}
	
	public Passeio recuperarVeiculoPasseioPorPlaca(String placa) {
		Passeio passeio = veiculosPasseio.stream()
				.filter(veiculo -> placa.equals(veiculo.getPlaca()))
				.findAny()
				.orElse(null);

		return passeio;
	}

	public Carga recuperarVeiculoCargaPorPlaca(String placa) {
		Carga carga = veiculosCarga.stream()
				.filter(veiculo -> placa.equals(veiculo.getPlaca()))
				.findAny()
				.orElse(null);

		return carga;
	}

	public List<Passeio> recuperarTodosVeiculosPasseio() {
		return veiculosPasseio;
	}

	public List<Carga> recuperarTodosVeiculosCarga() {
		return veiculosCarga;
	}

	public Passeio adicionarVeiculoPasseio(Passeio veiculo) throws VeicExistException {
		// Verifica se o veículo já está cadastrado.
		Passeio obj = this.recuperarVeiculoPasseioPorPlaca(veiculo.getPlaca());
		if (obj != null) {// Veiculo já esta cadastrado
			throw new VeicExistException("Veiculo " + obj.getPlaca() + " já cadastrado");
		} else {
			this.veiculosPasseio.add(veiculo);
		}
		
		return veiculo;
	}

	public Carga adicionarVeiculoCarga(Carga veiculo) throws VeicExistException {
		// Verifica se o veículo já está cadastrado.
		Carga obj = this.recuperarVeiculoCargaPorPlaca(veiculo.getPlaca());
		if (obj != null) {// Veiculo já esta cadastrado
			throw new VeicExistException("Veiculo " + obj.getPlaca() + " já cadastrado");
		} else {
			this.veiculosCarga.add(veiculo);
		}
		
		return veiculo;
	}
}
