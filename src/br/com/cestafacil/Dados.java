package br.com.cestafacil;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Dados {

	public static Map<String, Pessoa> pessoas = new HashMap<String, Pessoa>();
	public static Map<String, Empresa> empresas = new HashMap<String, Empresa>();

	private static boolean validarCpf(String cpf, boolean printar) {
		//variaveis para realizar os calculos na aplica��o
		char digitos10, digitos11;
		int  i, resto11, converterNum, soma, conteDecrescente;
		
		//verificanddo se os digitos digitados s�o aceitos
		if (cpf == "00000000000" ||
			cpf == "11111111111" ||
			cpf == "22222222222" ||
			cpf == "33333333333" ||
			cpf == "44444444444" ||
			cpf == "55555555555" ||
			cpf == "66666666666" ||
			cpf == "77777777777" ||
			cpf == "88888888888" ||
			cpf == "99999999999" ||
			(cpf.length() != 11)) 
		{
				//se os valores forem iguais aos de cima o programa retor um erro
				return false;
				
		}
			//fim do 1� if verifica��o de cpf
		
		//cpf 53838253043
		
        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		//verificando se o cpf � valido
		try {
			
			//new BigInteger(cpf);
			//iniciando a variavel soma e o contador decrescente
			soma=0; conteDecrescente= 10;
			
			//verificando o 10� para saber se � valido ou n�o
			for ( i = 0; i < 9; i++) {
				
		        // por exemplo, transforma o caractere '0' no inteiro 0
		        // (48 eh a posicao de '0' na tabela ASCII)
				//convertendo String para a numero
				converterNum = (int)(cpf.charAt(i) - 48);
				
				//a soma recebe o valor da mulpica��o e soma os resultados
				soma += (converterNum * conteDecrescente);
				
				//o contador fica negativo pois a multiplica��o fica em ordem decrescente
				conteDecrescente--;
				
				
			}
			
			resto11 = 11 - (soma % 11);
			
			//verificando a igauldade dos resultados 
			if (resto11 == 10 || resto11 == 11) {
				
				digitos10 = '0';
								
			}
			else {
				
				digitos10 = (char)(resto11 + 48);
			}
			
			//verificando o 11� para saber se � valido ou n�o
			//iniciando a variavel soma e o contador decrescente
			soma=0; conteDecrescente= 11;
			
			for ( i = 0; i < 10; i++) {
				
				//convertendo a string para numero na posi��o 0
				converterNum = (int)(cpf.charAt(i) - 48);
				
				//soma recebe o valor das multiplica��es e soma
				soma += (converterNum * conteDecrescente);
				
				//contador descrencente multiplica
				conteDecrescente--;
				
			}
			
			//verificando o rssto da divis�o por 11
			resto11 = 11 - (soma % 11);
			
			//verificando valores
			if (resto11 == 10 || resto11 == 11) {
				
				digitos11 = '0';
				
			} else {
				
				digitos11 = (char)(resto11 + 48);
			}
						
	        // Verifica se os digitos calculados conferem com os digitos informados.
			if ((digitos10 == cpf.charAt(9)) && (digitos11 == cpf.charAt(10))) {
				
				return true;	
				
			}else {
				
				System.out.println("CPF inv�lido!");

				return false;				

			}
			
		}catch (InputMismatchException erro) {
			
				return false;
			
        }
		
	//fim public static boolean valida
	}
	
	

	private static boolean validarCnpj(String cnpj, boolean printar) {
		
		
		//verificando valores n�o aceitos ou menor que 14 digitos
		if(cnpj == "00000000000000" ||
		   cnpj == "11111111111111" ||
		   cnpj == "22222222222222" ||
		   cnpj == "33333333333333" ||
		   cnpj == "44444444444444" ||
		   cnpj == "55555555555555" ||
		   cnpj == "66666666666666" ||
		   cnpj == "77777777777777" ||
		   cnpj == "88888888888888" ||
		   cnpj == "99999999999999" ||
		   (cnpj.length() != 14) ){
										
					return false;
		}
		
		
		//variaveis para calculo
		char digito13, digito14;
	    int soma, i, resto, numConverte, contadorCrescente;
	    
		///teste cnpj 65261832000107
		try {
			
			new BigInteger(cnpj);
			
			//calculando o 1� digotp
			  soma = 0;
			  contadorCrescente = 2;
		      
		      for (i = 11; i >= 0; i--) {
		    	  
		    	// por exemplo, transforma o caractere '0' no inteiro 0
		        // (48 eh a posicao de '0' na tabela ASCII)
				//convertendo String para a numero
		    	  
		    	  numConverte = (int)(cnpj.charAt(i) - 48);
		          soma += (numConverte * contadorCrescente);
		          contadorCrescente++;
		          
		          if (contadorCrescente == 10)
		          {
		        	  contadorCrescente = 2;

		          }//fim if
		      
		      }//fim for
		      
		      resto = soma % 11;
		      
		      if ((resto == 0) ||(resto == 1)) {
		    	  
		    	  digito13 = '0';
				
		      }
		      else {
		    	  digito13 = (char)((11 - resto) + 48);
				
			}
		      
		    //calculando 2� digito
		      soma = 0;
		      contadorCrescente = 2;
		      
		      for ( i = 12; i >= 0; i--) {
		    	  
		    	  numConverte = (int)(cnpj.charAt(i) - 48);
		    	  soma += (numConverte * contadorCrescente);
		    	  contadorCrescente++;
		    	  
		    	  if (contadorCrescente == 10) {
					
		    		  contadorCrescente = 2;
		    	  }//fim if
		    	  
		      }//fim for
			
			resto =  soma % 11;
			
			if ((resto == 0) || (resto == 11)) {
				
				digito14 = '0';
								
			}
			else {
				
				digito14 = (char)((11 - resto ) + 48);
			}
			
			// Verifica se os d�gitos calculados conferem com os d�gitos informados.
			if ((digito13 == cnpj.charAt(12)) && (digito14 == cnpj.charAt(13))) {
				
				return true;
				
			} else {
				
				System.out.println("CNPJ inv�lido!");

				return false;
			}
			
		} catch (InputMismatchException erro) {
						
			return false;
		}
		

		//return false;
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
				System.out.println("Senha inv�lida!");
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
				System.out.println("Senha inv�lida!");
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
					System.out.println("CPF n�o cadastrado.");
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
					System.out.println("CNPJ n�o cadastrado.");
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
			System.out.println("Op��o inv�lida");
			login();
		}
		return null;
	}
}
