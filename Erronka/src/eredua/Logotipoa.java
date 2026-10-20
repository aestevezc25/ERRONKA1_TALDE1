
package eredua;

public class Logotipoa {

    public static void main(String[] args) {

        Logotipoa logo = new Logotipoa();

        // Imprimir el logotipo completo
        logo.inprimatuLogotipoa();
    }

    // Metodo que imprime todas las figuras del logotipo
    public void inprimatuLogotipoa() {

        // Primer triangulo relleno invertido
        trianguloRellenoInvertido(4);

        // Segundo triangulo relleno normal
        trianguloRellenoNormal(4);

        // Tercer triangulo hueco normal
        trianguloHuecoNormal(5);

        // Cuarto triangulo: punto arriba y base abajo
        trianguloPuntoBase(4);

        // Quinto triangulo: estrellas huecas
        trianguloEstrellasHueco(4);
    }

    // Triangulo relleno invertido
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

    // Triangulo relleno normal
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

    // Triangulo hueco normal
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

    // Triangulo con punto arriba y base abajo
    private void trianguloPuntoBase(int aldea) {

        // Punto arriba y filas intermedias
        for (int i = 0; i < aldea - 1; i++) {

            for (int j = 0; j < aldea - 1; j++) {
                System.out.print(" ");
            }

            System.out.println("*");
        }

        // Base completa
        for (int i = 0; i < aldea * 2 - 1; i++) {
            System.out.print("*");
        }

        System.out.println();
    }

    // Quinto triangulo: estrellas huecas
    private void trianguloEstrellasHueco(int aldea) {

        for (int i = 0; i < aldea; i++) {

            // Espacios antes de cada estrella
            for (int j = 0; j < aldea - i - 1; j++) {
                System.out.print(" ");
            }

            // Estrella izquierda
            System.out.print("*");

            // Espacios interiores y estrella derecha
            if (i > 0) {

                for (int j = 0; j < i * 2 - 1; j++) {
                    System.out.print(" ");
                }

                System.out.print("*");
            }

            System.out.println();
        }
    }
}
