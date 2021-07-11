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
		return true;
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
		return true;
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

		System.out.println("\n----------------------------\n"
				+ "Cadastro realizado com sucesso!\n----------------------------");

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

		System.out.println("\n----------------------------\n"
				+ "Cadastro realizado com sucesso!\n----------------------------");

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
		}
		else if (opcao == 1) {
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
