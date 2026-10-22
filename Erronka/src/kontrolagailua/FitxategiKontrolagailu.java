package kontrolagailua;
import ikuspegia.*;
import kontrolagailua.*;
import bussineslogic.*;
public class FitxategiKontrolagailu {
	
	private FitxategiKudeatzaile fitxKud;
	int aukera = 0;
	
	public FitxategiKontrolagailu() {
		this.fitxKud = new FitxategiKudeatzaile();
	}

	public void erakutsiMenua() {
	
    do {
        Kontsola.idatzi("");
        Kontsola.idatzi("===== FITXATEGIAK =====");
        Kontsola.idatzi("1. Bezeroak.txt");
        Kontsola.idatzi("2. BezeroaTelefonoak.txt");
        Kontsola.idatzi("3. Eskari_Lerroak.txt");
        Kontsola.idatzi("4. Eskariak.txt");
        Kontsola.idatzi("5. Langileak.txt");
        Kontsola.idatzi("6. Itzuli menu nagusira");
        Kontsola.idatzi("Aukeratu bat:");

        int aukera = Integer.parseInt(Teklatua.irakurri());

        switch (aukera) {

            case 1:
 
            	this.fitxKud.fitxategiaIrakurri("fitxategiak/Bezeroak.txt");
                break;

            case 2:
            	this.fitxKud.fitxategiaIrakurri("Fitxategiak/BezeroaTelefonoak.txt");
                break;

            case 3:
            	this.fitxKud.fitxategiaIrakurri("Fitxategiak/Eskari_Lerroak.txt");
                break;

            case 4:
            	this.fitxKud.fitxategiaIrakurri("Fitxategiak/Eskariak.txt");
                break;

            case 5:
            	this.fitxKud.fitxategiaIrakurri("./src/fitxategiak/langileak.txt");
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



}

