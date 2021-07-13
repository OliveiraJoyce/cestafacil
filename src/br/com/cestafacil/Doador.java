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
		String[] alimentoNome = { "arroz", "feijão", "açúcar", "macarrão", "óleo", "café", "pão de forma", "farinha",
				"sal", "molho de tomate" };
		System.out.println("\n-------- Doação de Alimentos --------");
		System.out.println("\nLogado como: " + info);
		for (int i = 0; i < alimentoNome.length; i++) {
			System.out.print("\nDigite a quantidade de " + alimentoNome[i] + ": ");
			int quantidade = read.nextInt();
			switch (i) {
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
				break;
			case 10:
				Cesta.molho += quantidade;
				break;
			}
		}

		System.out.print("Deseja doar mais algum alimento? 1 - sim  2 - não: ");
		if (read.nextInt() == 1)
			doar(tipo, doc);

		System.out.println("\n-----------------------\n" + "Agradecemos pela doação!\n-----------------------\n");
		Main.main(null);
	}

}
