package br.com.cestafacil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dados {

	public static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	public static List<Empresa> empresas = new ArrayList<Empresa>();

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

	public static void cadastrarPessoa() {
		Scanner read = new Scanner(System.in);

		pessoas.add(pessoas.size(), new Pessoa());

		System.out.println("================");
		System.out.println("Cadastro de pessoa");
		System.out.println("================");

		String cpf = "";
		while (validarCpf(cpf, false) == false) {
			System.out.print("Digite seu CPF: ");
			cpf = read.next();
			validarCpf(cpf, true);
		}
		pessoas.get(pessoas.size() - 1).setCpf(cpf);

		System.out.print("Digite seu nome: ");
		pessoas.get(pessoas.size() - 1).setNome(read.next());

		System.out.print("Digite seu sobrenome: ");
		pessoas.get(pessoas.size() - 1).setSobrenome(read.next());
		
		System.out.println("Cadastro realizado com sucesso!");
	}

	public static void cadastrarEmpresa() {
		Scanner read = new Scanner(System.in);

		empresas.add(empresas.size(), new Empresa());

		String cnpj = "";
		while (validarCpf(cnpj, false) == false) {
			System.out.print("Digite seu CPF: ");
			cnpj = read.next();
			validarCpf(cnpj, true);
		}
		empresas.get(empresas.size() - 1).setCnpj(cnpj);
	}

	public static void login() {
		Scanner read = new Scanner(System.in);

		System.out.println("------- Login -------");
		String cpf = "";
		while (validarCpf(cpf, false) == false) {
			System.out.print("Digite seu CPF: ");
			cpf = read.next();
			validarCpf(cpf, true);
		}
	}
}
