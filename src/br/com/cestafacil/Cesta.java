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

	private static int cestas = 0;

	public static int getCestas() {
		return cestas;
	}

	private static boolean checkCestas() {
		if (arroz == 0 || feijao == 0 || acucar == 0 || macarrao == 0 || oleo == 0 || cafe == 0 || paodeforma == 0
				|| farinha == 0 || sal == 0 || molho == 0) {
			return false;
		}
		return true;
	}

	public static void contagemCesta() {
		while (checkCestas()) {
			arroz -= 1;
			feijao -= 1;
			acucar -= 1;
			macarrao -= 1;
			oleo -= 1;
			cafe -= 1;
			paodeforma -= 1;
			farinha -= 1;
			sal -= 1;
			molho -= 1;

			cestas++;
		}
	}

	/*
	 * public static void alimentosRestantes() { if (arroz + feijao + acucar +
	 * macarrao + oleo + cafe + paodeforma + farinha + sal + molho != 0) {
	 * System.out.println("Sobraram..."); if (arroz != 0) System.out.println(arroz +
	 * " pacotes de arroz"); if (feijao != 0) System.out.println(feijao +
	 * " pacotes de feijão"); if (acucar != 0) System.out.println(acucar +
	 * " pacotes de arroz"); if (macarrao != 0) System.out.println(macarrao +
	 * " pacotes de macarrão"); if (oleo != 0) System.out.println(oleo +
	 * " garrafas de óleo"); if (cafe != 0) System.out.println(cafe +
	 * " pacotes de café"); if (paodeforma != 0) System.out.println(paodeforma +
	 * " pacotes de pão de forma"); if (farinha != 0) System.out.println(farinha +
	 * " pacotes de farinha"); if (sal != 0) System.out.println(sal +
	 * " pacotes de sal"); if (molho != 0) System.out.println(molho +
	 * " pacotes de molho de tomate"); } }
	 */
}
