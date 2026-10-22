package kontrolagailua;

import bussineslogic.*;
import ikuspegia.*;

public class KontrolagailuNagusi {


    private LangileKontrolagailu langileCtrl;
    private BezeroKontrolagailu bezeroCtrl;
    private FitxategiKontrolagailu fitxCtrl;

    public KontrolagailuNagusi() {
       
        Login login = new Login();
        login.run();

        Logotipoa logo = new Logotipoa();
        logo.run();
        
      
        this.langileCtrl = new LangileKontrolagailu();
        this.fitxCtrl = new FitxategiKontrolagailu();
        
        menuNagusia();
    }


    private void menuNagusia() {
        int aukera;
        String erantzuna;

        do {
            Kontsola.idatzi("\n===== MENU NAGUSIA =====");
            Kontsola.idatzi("1. Langileak");
            Kontsola.idatzi("2. Bezeroak");
            Kontsola.idatzi("3. Fitxategiak");
            Kontsola.idatzi("4. Saioa Itxi");
            Kontsola.idatzi("Aukeratu aukera bat:");

            try {
                aukera = Integer.parseInt(Teklatua.irakurri());
            } catch (NumberFormatException e) {
                aukera = -1;
            }

            switch (aukera) {

                case 1:
                    this.langileCtrl.erakutsiMenua();
                    break;

                case 2:
                    Kontsola.idatzi("Aukera 2 aukeratu duzu.");
                    break;

                case 3:
                    this.fitxCtrl.erakutsiMenua();
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

    public static void main(String[] args) {
        new KontrolagailuNagusi();
    }
}