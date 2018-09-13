package br.com.farmacia.domain;

public class Clientes {
	
	private Long codigo;
	private String nome;
	private String logradouro;
	private String cep;
	private String cpf;
	private String numero;
	private String rg;

	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	@Override
	public String toString() {
		return "Clientes [codigo=" + codigo + ", nome=" + nome + ", logradouro=" + logradouro + ", cep=" + cep
				+ ", cpf=" + cpf + ", numero=" + numero + ", rg=" + rg + "]";
	}

}
