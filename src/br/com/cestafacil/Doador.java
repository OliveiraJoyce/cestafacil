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
			int quantidade = Integer.parseInt(read.nextLine());
			switch (i) {
			case 0:
				Cesta.arroz += quantidade;
				break;
			case 1:
				Cesta.feijao += quantidade;
				break;
			case 2:
				Cesta.acucar += quantidade;
				break;
			case 3:
				Cesta.macarrao += quantidade;
				break;
			case 4:
				Cesta.oleo += quantidade;
				break;
			case 5:
				Cesta.cafe += quantidade;
				break;
			case 6:
				Cesta.paodeforma += quantidade;
				break;
			case 7:
				Cesta.farinha += quantidade;
				break;
			case 8:
				Cesta.sal += quantidade;
				break;
			case 9:
				Cesta.molho += quantidade;
				break;
			}
		}

		System.out.print("Deseja doar mais algum alimento? 1 - sim  2 - n�o: ");
		if (read.nextInt() == 1)
			doar(tipo, doc);

		Cesta.contagemCesta();
		System.out.println("\nConseguimos montar " + Cesta.getCestas() + " cestas b�sicas completas!\n");
		Cesta.alimentosRestantes();

		System.out.println("\n-----------------------\n" + "Agradecemos pela doa��o!" + "\n-----------------------\n");
		Main.main(null);
	}
}
