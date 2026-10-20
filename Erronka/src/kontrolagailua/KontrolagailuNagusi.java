
package kontrolagailua;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import bussineslogic.Login;
import ikuspegia.Kontsola;
import eredua.Logotipoa;

public class KontrolagailuNagusi {

	public KontrolagailuNagusi() {

	    Login login = new Login();

	    if (login.balioztatuDa()) {
	        begiztaNagusia();
	    }
	}

    // MENÚ PRINCIPAL
    private void begiztaNagusia() {

        int aukera;
        String erantzuna;

        do {
        	  // Imprimir el logotipo debajo del titulo
            Logotipoa logo = new Logotipoa();
            logo.inprimatuLogotipoa();

            // Opciones del menu
            Kontsola.idatzi("1. Aukera 1");
            Kontsola.idatzi("2. Aukera 2");
            Kontsola.idatzi("3. Fitxategiak");
            Kontsola.idatzi("4. Saioa Itxi");
            Kontsola.idatzi("Aukeratu aukera bat:");

            aukera = Integer.parseInt(Teklatua.irakurri());

            switch (aukera) {

                case 1:
                    Kontsola.idatzi("Aukera 1 aukeratu duzu.");
                    break;

                case 2:
                    Kontsola.idatzi("Aukera 2 aukeratu duzu.");
                    break;

                case 3:
                    fitxategiakMenua();
                    break;

                case 4:
                    Kontsola.idatzi("Saioa itxi nahi duzu? (bai/ez)");
                    erantzuna = Teklatua.irakurri();

                    if (erantzuna.equalsIgnoreCase("bai")) {
                        Kontsola.idatzi("Saioa itxi da.");
                    } else {
                        Kontsola.idatzi("Menu nagusira itzultzen...");
                        aukera = 0;
                    }
                    break;

                default:
                    Kontsola.idatzi("Aukera okerra. Saiatu berriro.");
                    break;
            }

        } while (aukera != 4);
    }

    // MENÚ DE ARCHIVOS
    private void fitxategiakMenua() {

        int aukera;

        do {
            Kontsola.idatzi("");
            Kontsola.idatzi("===== FITXATEGIAK =====");
            Kontsola.idatzi("1. Bezeroak.txt");
            Kontsola.idatzi("2. BezeroaTelefonoak.txt");
            Kontsola.idatzi("3. Eskari_Lerroak.txt");
            Kontsola.idatzi("4. Eskariak.txt");
            Kontsola.idatzi("5. Langileak.txt");
            Kontsola.idatzi("6. Itzuli menu nagusira");
            Kontsola.idatzi("Aukeratu aukera bat:");

            aukera = Integer.parseInt(Teklatua.irakurri());

            switch (aukera) {

                case 1:
                    fitxategiaIrakurri("Fitxategiak/Bezeroak.txt");
                    break;

                case 2:
                    fitxategiaIrakurri("Fitxategiak/BezeroaTelefonoak.txt");
                    break;

                case 3:
                    fitxategiaIrakurri("Fitxategiak/Eskari_Lerroak.txt");
                    break;

                case 4:
                    fitxategiaIrakurri("Fitxategiak/Eskariak.txt");
                    break;

                case 5:
                    fitxategiaIrakurri("Fitxategiak/Langileak.txt");
                    break;

                case 6:
                    Kontsola.idatzi("Menu nagusira itzultzen...");
                    break;

                default:
                    Kontsola.idatzi("Aukera okerra. Saiatu berriro.");
                    break;
            }

        } while (aukera != 6);
    }

    // LEER EL CONTENIDO DE UN ARCHIVO
    private void fitxategiaIrakurri(String bidea) {

        try (BufferedReader br =
                 new BufferedReader(new FileReader(bidea))) {

            String lerroa;

            Kontsola.idatzi("");
            Kontsola.idatzi("===== FITXATEGIAREN EDUKIA =====");

            while ((lerroa = br.readLine()) != null) {
                Kontsola.idatzi(lerroa);
            }

            Kontsola.idatzi("===== AMAIERA =====");

        } catch (IOException e) {
            Kontsola.idatzi(
                "Ezin izan da fitxategia irakurri: " + bidea
            );
        }
    }

    public static void main(String[] args) {
        new KontrolagailuNagusi();
    }
}

