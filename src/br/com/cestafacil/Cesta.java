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

	static int cestas = 0;

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
}
