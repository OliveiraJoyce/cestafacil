package br.com.cestafacil;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dados {

	public static Map<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
	public static Map<String, Empresa> empresas = new HashMap<String, Empresa>();

	private static boolean validarCpf(String cpf, boolean printar) {
		try {
			new BigInteger(cpf);
		} catch (NumberFormatException e) {
			if (printar == true) {
				System.out.println("CPF inválido!");
			}
			return false;
		}

		if (cpf.length() != 11) {
			if (printar == true) {
				System.out.println("CPF inválido!");
			}
			return false;
		}

		if (cpf == "00000000000" || cpf == "11111111111" || cpf == "22222222222" || cpf == "33333333333"
				|| cpf == "44444444444" || cpf == "55555555555" || cpf == "66666666666" || cpf == "77777777777"
				|| cpf == "88888888888" || cpf == "99999999999") {
			if (printar == true) {
				System.out.println("CPF inválido!");
			}
			return false;

		}

		int soma = 0;
		int conteDecrescente = 10;
		int converterNum;

		for (int i = 0; i < 9; i++) {
			converterNum = (int) (cpf.charAt(i) - 48);

			soma += (converterNum * conteDecrescente);
			conteDecrescente--;
		}

		int resto11;
		int digitos10;

		resto11 = 11 - (soma % 11);

		if (resto11 == 10 || resto11 == 11) {
			digitos10 = '0';

		} else {
			digitos10 = (char) (resto11 + 48);
		}

		soma = 0;
		conteDecrescente = 11;

		for (int i = 0; i < 10; i++) {
			converterNum = (int) (cpf.charAt(i) - 48);
			soma += (converterNum * conteDecrescente);
			conteDecrescente--;
		}

		resto11 = 11 - (soma % 11);

		int digitos11;

		if (resto11 == 10 || resto11 == 11) {
			digitos11 = '0';
		} else {
			digitos11 = (char) (resto11 + 48);
		}
		if ((digitos10 == cpf.charAt(9)) && (digitos11 == cpf.charAt(10))) {
			return true;
		} else {
			if (printar == true) {
				System.out.println("CPF inválido!");
			}
			return false;
		}
	}

	private static boolean validarCnpj(String cnpj, boolean printar) {
		try {
			new BigInteger(cnpj);
		} catch (NumberFormatException e) {
			if (printar == true) {
				System.out.println("CNPJ inválido!");
			}
			return false;
		}

		if (cnpj.length() != 14) {
			if (printar == true) {
				System.out.println("CNPJ inválido!");
			}
			return false;
		}
		if (cnpj == "00000000000000" || cnpj == "11111111111111" || cnpj == "22222222222222" || cnpj == "33333333333333"
				|| cnpj == "44444444444444" || cnpj == "55555555555555" || cnpj == "66666666666666"
				|| cnpj == "77777777777777" || cnpj == "88888888888888" || cnpj == "99999999999999") {
			if (printar == true) {
				System.out.println("CNPJ inválido!");
			}
			return false;
		}

		char digito13, digito14;
		int soma, i, resto, numConverte, contadorCrescente;

		soma = 0;
		contadorCrescente = 2;

		for (i = 11; i >= 0; i--) {

			numConverte = (int) (cnpj.charAt(i) - 48);
			soma += (numConverte * contadorCrescente);
			contadorCrescente++;

			if (contadorCrescente == 10) {
				contadorCrescente = 2;
			}
		}

		resto = soma % 11;

		if ((resto == 0) || (resto == 1)) {

			digito13 = '0';

		} else {
			digito13 = (char) ((11 - resto) + 48);
		}
		soma = 0;
		contadorCrescente = 2;

		for (i = 12; i >= 0; i--) {

			numConverte = (int) (cnpj.charAt(i) - 48);
			soma += (numConverte * contadorCrescente);
			contadorCrescente++;

			if (contadorCrescente == 10) {
				contadorCrescente = 2;
			}
		}

		resto = soma % 11;

		if ((resto == 0) || (resto == 11)) {
			digito14 = '0';
		} else {
			digito14 = (char) ((11 - resto) + 48);
		}
		if ((digito13 == cnpj.charAt(12)) && (digito14 == cnpj.charAt(13))) {

			return true;

		} else {
			if (printar == true) {
				System.out.println("CNPJ inválido!");
			}
			return false;
		}
	}

	private static boolean confirmarSenha(String senha, String confSenha) {
		if (senha.equals(confSenha))
			return true;
		return false;
	}

	public static String cadastrarPessoa() {
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		System.out.println("================");
		System.out.println("Cadastro de pessoa");
		System.out.println("================");

		String cpf = "";
		while (!validarCpf(cpf, false)) {
			System.out.print("Digite seu CPF: ");
			cpf = read.next();
			validarCpf(cpf, true);
		}

		pessoas.put(cpf, new Pessoa());
		pessoas.get(cpf).setCpf(cpf);

		System.out.print("Digite seu nome: ");
		pessoas.get(cpf).setNome(read.next());

		System.out.print("Digite seu sobrenome: ");
		pessoas.get(cpf).setSobrenome(read.next());

		System.out.print("Crie uma senha: ");
		String senha = read.next();

		while (true) {
			System.out.print("Confirme a senha: ");
			if (confirmarSenha(senha, read.next())) {
				break;
			} else {
				System.out.println("Senha inválida!");
			}
		}

		pessoas.get(cpf).setSenha(senha);

		System.out.println(
				"\n----------------------------\nCadastro realizado com sucesso!\n----------------------------");

		return cpf;
	}

	public static String cadastrarEmpresa() {
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		String cnpj = "";
		while (!validarCnpj(cnpj, false)) {
			System.out.print("Digite seu CNPJ: ");
			cnpj = read.next();
			validarCnpj(cnpj, true);
		}

		empresas.put(cnpj, new Empresa());
		empresas.get(cnpj).setCnpj(cnpj);

		System.out.print("Digite o nome da empresa: ");
		empresas.get(cnpj).setNome(read.next());

		System.out.print("Crie uma senha: ");
		String senha = read.next();

		while (true) {
			System.out.print("Confirme a senha: ");
			if (confirmarSenha(senha, read.next())) {
				break;
			} else {
				System.out.println("Senha inválida!");
			}
		}

		empresas.get(cnpj).setSenha(senha);

		System.out.println(
				"\n----------------------------\n" + "Cadastro realizado com sucesso!\n----------------------------");

		return cnpj;
	}

	public static String login() {
		@SuppressWarnings("resource")
		Scanner read = new Scanner(System.in);

		System.out.println("------- Login -------");
		System.out.print("1 - Pessoa  2 - Empresa  3 - Tela inicial: ");
		int opcao = read.nextInt();
		if (opcao == 3) {
			Main.main(null);
		} else if (opcao == 1) {
			Pessoa pessoaAtual = null;
			String cpf = "";
			while (true) {
				while (validarCpf(cpf, false) == false) {
					System.out.print("Digite seu CPF: ");
					cpf = read.next();
					validarCpf(cpf, true);
					pessoaAtual = pessoas.get(cpf);
				}
				if (pessoaAtual == null) {
					System.out.println("CPF não cadastrado.");
					cpf = "";
				} else {
					break;
				}
			}
			while (true) {
				System.out.print("Digite a senha: ");
				String senha = read.next();
				System.out.println("Senha: " + pessoaAtual.getSenha());
				if (senha.equals(pessoaAtual.getSenha())) {
					break;
				} else {
					System.out.println("Senha incorreta");
				}
			}
			return cpf;
		} else if (opcao == 2) {
			Empresa empresaAtual = null;
			String cnpj = "";
			while (true) {
				while (validarCnpj(cnpj, false) == false) {
					System.out.print("Digite seu CNPJ: ");
					cnpj = read.next();
					validarCnpj(cnpj, true);
					empresaAtual = empresas.get(cnpj);
				}
				if (empresaAtual == null) {
					System.out.println("CNPJ não cadastrado.");
					cnpj = "";
				} else {
					break;
				}
			}
			while (true) {
				System.out.print("Digite a senha: ");
				if (read.next().equals(empresaAtual.getSenha())) {
					break;
				} else {
					System.out.println("Senha incorreta");
				}
			}
			return cnpj;
		} else {
			System.out.println("Opção inválida");
			login();
		}
		return null;
	}
}
