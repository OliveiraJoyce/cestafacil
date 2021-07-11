package br.com.cestafacil;

public class Pessoa extends Doador {
	
	private String cpf, nome, sobrenome, senha;

	String getCpf() {
		return cpf;
	}

	void setCpf(String cpf) {
		this.cpf = cpf;
	}

	String getNome() {
		return nome;
	}

	void setNome(String nome) {
		this.nome = nome;
	}

	String getSobrenome() {
		return sobrenome;
	}

	void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	String getNomeCompleto() {
		String nomeCompleto = this.nome + " " + this.sobrenome;
		return nomeCompleto;
	}

	String getSenha() {
		return senha;
	}

	void setSenha(String senha) {
		this.senha = senha;
	}
	
}
