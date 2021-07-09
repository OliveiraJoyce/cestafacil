package br.com.cestafacil;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dados {
	
	static Map<String, Pessoa> pessoa = new HashMap<String, Pessoa>();
	static Map<String, Empresa> empresa = new HashMap<String, Empresa>();

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

	public static Pessoa cadastrarPessoa() {
		Scanner read = new Scanner(System.in);

		Pessoa pessoa1 = new Pessoa();
		
		System.out.println("================");
		System.out.println("Cadastro de pessoa");
		System.out.println("================");

		String cpf = "";
		while (validarCpf(cpf, false) == false) {
			System.out.print("Digite seu CPF: ");
			cpf = read.next();
			validarCpf(cpf, true);
		}
		pessoa1.setCpf(cpf);

		System.out.print("Digite seu nome: ");
		pessoa1.setNome(read.next());

		System.out.print("Digite seu sobrenome: ");
		pessoa1.setSobrenome(read.next());
		
		pessoa.put(cpf, pessoa1);
		
		return pessoa1;
	}
	
	public static Empresa cadastrarEmpresa() {
		Empresa empresa1 = new Empresa();
		return empresa1;
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
