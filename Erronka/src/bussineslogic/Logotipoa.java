package bussineslogic;

public class Logotipoa {

	public Logotipoa() {

	}

	private void trianguloRellenoInvertido(int aldea) {
		for (int i = 0; i < aldea; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int p = 0; p < aldea * 2 - 1 - i * 2; p++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private void trianguloRellenoNormal(int aldea) {
		for (int i = 1; i < aldea; i++) {
			for (int j = aldea - 2; j >= i; j--) {
				System.out.print(" ");
			}
			for (int p = 0; p < i * 2 + 1; p++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}


	private void trianguloHuecoNormal(int aldea) {
		for (int i = 0; i < aldea; i++) {
			for (int j = aldea - 2; j > i; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			if (i > 0 && i < aldea - 1) {
				for (int p = 0; p < i * 2 - 1; p++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}

			if (i == aldea - 1) {
				for (int p = 1; p < aldea * 2 - 3; p++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	private void trianguloPuntoBase(int aldea) {
		for (int i = 0; i < aldea - 1; i++) {
			for (int j = 0; j < aldea - 1; j++) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		for (int i = 0; i < aldea * 2 - 1; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

	private void trianguloEstrellasHueco(int aldea) {

		for (int i = 0; i < aldea; i++) {
			for (int j = 0; j < aldea - i - 1; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			if (i > 0) {

				for (int j = 0; j < i * 2 - 1; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void run() {
		trianguloRellenoInvertido(4);
		trianguloRellenoNormal(4);
		trianguloHuecoNormal(5);
		trianguloPuntoBase(4);
		trianguloEstrellasHueco(4);
	}




}