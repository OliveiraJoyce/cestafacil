package br.com.cestafacil;

import java.util.Scanner;

public class Main {

	static int opcao;
	static String cpfAtual;
	static String cnpjAtual;

	public static void main(String[] args) {
		cpfAtual = null;
		cnpjAtual = null;

		telaInicial();
		switch (opcao) {
		case 1:
			Dados.pessoas.get(cpfAtual).doar(1, cpfAtual);
			cpfAtual = null;
			break;
		case 2:
			Dados.empresas.get(cnpjAtual).doar(2, cnpjAtual);
			cnpjAtual = null;
			break;
		case 3:
			if (cpfAtual != null) {
				Dados.pessoas.get(cpfAtual).doar(1, cpfAtual);
				break;
			} else if (cnpjAtual != null) {
				Dados.empresas.get(cnpjAtual).doar(2, cnpjAtual);
				break;
			}
		}
	}

	static void telaInicial() {
		System.out.println("------------------ Cesta FÃ¡cil ------------------");
		System.out.println("\n1 - Cadastro de pessoa         2 - Cadastro de empresa");
		System.out.println("3 - Login                      4 - Doar alimentos");
		System.out.println("5 - Mostrar cestas");
		System.out.println("\n-------------------------------------------------");

		System.out.print("\nOpção: ");
		getOpcao();
	}

	static void getOpcao() {
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		opcao = read.nextInt();

		switch (opcao) {
		case 1:
			cpfAtual = Dados.cadastrarPessoa();
			cnpjAtual = null;
			break;
		case 2:
			cnpjAtual = Dados.cadastrarEmpresa();
			cpfAtual = null;
			break;
		case 3:
			String temp = Dados.login();
			if (temp.length() == 11) {
				cpfAtual = temp;
				break;
			} else {
				cnpjAtual = temp;
				break;
			}
		case 4:
			if (cpfAtual != null) {
				Dados.pessoas.get(cpfAtual).doar(1, cpfAtual);
				break;
			} else if (cnpjAtual != null) {
				Dados.empresas.get(cnpjAtual).doar(2, cnpjAtual);
				break;
			} else {
				System.out.println("\n-----------------------\n"
						+ "Você não está logado\n-----------------------\n");
				main(null);
			}
		case 5:
			Cesta.contagemCesta();
			main(null);
			break;
		}
	}
}
