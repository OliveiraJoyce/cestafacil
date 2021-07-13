package br.com.cestafacil;

public class Empresa extends Doador {
	
	private String nome, senha, cnpj;

	String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	String getSenha() {
		return senha;
	}

	void setSenha(String senha) {
		this.senha = senha;
	}

	String getCnpj() {
		return cnpj;
	}

	void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
