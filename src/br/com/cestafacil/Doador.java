package br.com.cestafacil;

import java.util.Scanner;

public class Doador {

	public void doar(int tipo, String doc) {

		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		String info;
		if (tipo == 1) {
			Pessoa target = Dados.pessoas.get(doc);
			info = target.getNomeCompleto();
			info += " | CPF: " + target.getCpf();
		} else {
			Empresa target = Dados.empresas.get(doc);
			info = target.getNome();
			info += " | CNPJ: " + target.getCnpj();
		}

		System.out.println("\n-------- Doação de Alimentos --------");
		System.out.println("\nLogado como: " + info);
		System.out.println("\n1 - Arroz            2 - Feijão");
		System.out.println("3 - Açúcar           4 - Macarrão");
		System.out.println("5 - Óleo             6 - Café");
		System.out.println("7 - Pão de forma     8 - Farinha");
		System.out.println("9 - Sal              10 - Molho de tomate");
		System.out.print("\nEscolha o tipo de alimento: ");

		int alimento;
		while (true) {
			alimento = read.nextInt();
			if (alimento < 1 || alimento > 10) {
				System.out.print("Opção inválida, tente novamente: ");
			} else {
				break;
			}
		}

		System.out.print("Digite a quantidade: ");
		int quantidade = read.nextInt();

		switch (alimento) {
		case 1:
			Cesta.arroz += quantidade;
			break;
		case 2:
			Cesta.feijao += quantidade;
			break;
		case 3:
			Cesta.acucar += quantidade;
			break;
		case 4:
			Cesta.macarrao += quantidade;
			break;
		case 5:
			Cesta.oleo += quantidade;
			break;
		case 6:
			Cesta.cafe += quantidade;
			break;
		case 7:
			Cesta.paodeforma += quantidade;
			break;
		case 8:
			Cesta.farinha += quantidade;
			break;
		case 9:
			Cesta.sal += quantidade;
		case 10:
			Cesta.molho += quantidade;
		}

		System.out.print("Deseja doar mais algum alimento? 1 - sim  2 - não: ");
		if (read.nextInt() == 1)
			doar(tipo, doc);

		System.out.println("\n-----------------------\n"
				+ "Obrigado pela doação!\n-----------------------\n");
		Main.main(null);
	}

}
