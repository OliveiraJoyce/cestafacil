package br.com.cestafacil;

public class Cesta {
	
	static int arroz = 0;
	static int feijao = 0;
	static int acucar = 0;
	static int macarrao = 0;
	static int oleo = 0;
	static int cafe = 0;
	static int paodeforma = 0;
	static int farinha = 0;
	static int sal = 0;
	static int molho = 0;
	
	private static int arroz2, feijao2, acucar2, macarrao2, oleo2, cafe2, paodeforma2, farinha2, sal2, molho2;

	private static int cestas = 0;
	
	private static boolean checkCestas() {
		if (arroz2 == 0 || feijao2 == 0 || acucar2 == 0 || macarrao2 == 0 || oleo2 == 0 || cafe2 == 0 || paodeforma2 == 0
				|| farinha2 == 0 || sal2 == 0 || molho2 == 0) {
			return false;
		}
		return true;
	}

	private static void montarCesta() {
		arroz2 -= 2;
		feijao2 -= 2;
		acucar2 -= 1;
		macarrao2 -= 1;
		oleo2 -= 1;
		cafe2 -= 1;
		paodeforma2 -= 1;
		farinha2 -= 1;
		sal2 -= 1;
		molho2 -= 2;
		
		cestas++;
	}
	
	public static void contagemCesta() {
		arroz2 = arroz;
		feijao2 = feijao;
		acucar2 = acucar;
		macarrao2 = macarrao;
		oleo2 = oleo;
		cafe2 = cafe;
		paodeforma2 = paodeforma;
		farinha2 = farinha;
		sal2 = sal;
		molho2 = molho;
		
		while (checkCestas()) {
			montarCesta();
		}
		System.out.println("\nConseguimos montar " + cestas + " cestas básicas completas!\n");
	}
}
