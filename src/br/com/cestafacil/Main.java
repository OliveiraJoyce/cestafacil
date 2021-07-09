package br.com.cestafacil;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		telaInicial();
	}
	
	static void telaInicial() {
		System.out.println("------------------ Cesta Fácil ------------------");
		System.out.println("\n1 - Cadastro de pessoa         2 - Cadastro de empresa");
		System.out.println("3 - Login                      4 - Doar alimentos");
		System.out.println("\n-------------------------------------------------");
		
		System.out.print("\nOpção: ");
		getOpcao();
	}
	
	static void getOpcao() {
		Scanner read = new Scanner(System.in);
		
		int opcao = read.nextInt();
		
		switch(opcao) {
		case 1:
			Dados.cadastrarPessoa();
			break;
		case 2:
			Dados.cadastrarEmpresa();
			break;
		case 3:
			Dados.login();
			break;
		}
	}
}
