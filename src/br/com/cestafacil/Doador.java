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
		String[] alimentoNome = { "arroz", "feij�o", "a��car", "macarr�o", "�leo", "caf�", "p�o de forma", "farinha",
				"sal", "molho de tomate" };
		System.out.println("\n-------- Doa��o de Alimentos --------");
		System.out.println("\nLogado como: " + info);
		for (int i = 0; i < alimentoNome.length; i++) {
			System.out.print("\nDigite a quantidade de " + alimentoNome[i] + ": ");
			int quantidade = read.nextInt();
			switch (i) {
			case 1:
				Cesta.arroz += quantidade;
				Cesta.cestas++;
				
				break;
			case 2:
				Cesta.feijao += quantidade;
				Cesta.cestas++;

				break;
			case 3:
				Cesta.acucar += quantidade;
				Cesta.cestas++;

				break;
			case 4:
				Cesta.macarrao += quantidade;
				Cesta.cestas++;

				break;
			case 5:
				Cesta.oleo += quantidade;
				Cesta.cestas++;

				break;
			case 6:
				Cesta.cafe += quantidade;
				Cesta.cestas++;

				break;
			case 7:
				Cesta.paodeforma += quantidade;
				Cesta.cestas++;

				break;
			case 8:
				Cesta.farinha += quantidade;
				Cesta.cestas++;

				break;
			case 9:
				Cesta.sal += quantidade;
				Cesta.cestas++;

				break;
			case 10:
				Cesta.molho += quantidade;
				Cesta.cestas++;

				break;
			}
		}

		System.out.print("Deseja doar mais algum alimento? 1 - sim  2 - n�o: ");
		if (read.nextInt() == 1)
			doar(tipo, doc);

		System.out.println("\nConseguimos montar " + Cesta.cestas + " cestas b�sicas completas!\n");

		System.out.println("\n-----------------------\n" + "Agradecemos pela doa��o!\n-----------------------\n");
		Main.main(null);
	}

}
