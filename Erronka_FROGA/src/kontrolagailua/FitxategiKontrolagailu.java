package kontrolagailua;
import ikuspegia.*;
import kontrolagailua.*;
import bussineslogic.*;
public class FitxategiKontrolagailu {

	private FitxategiKudeatzaile fitxKud;


	public FitxategiKontrolagailu() {
		this.fitxKud = new FitxategiKudeatzaile();
	}

	public void erakutsiMenua() {
		int aukera = 0;
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

			try {
				aukera = Integer.parseInt(Teklatua.irakurri());
			} catch(NumberFormatException e) {
				aukera = -1;
			}
			switch (aukera) {

			case 1:

				this.fitxKud.fitxategiaIrakurri("./src/fitxategiak/bezeroak.txt");
				break;

			case 2:
				this.fitxKud.fitxategiaIrakurri("./src/fitxategiak/bezeroa_telefonoak.txt");
				break;

			case 3:
				this.fitxKud.fitxategiaIrakurri("./src/fitxategiak/eskari_lerroak.txt");
				break;

			case 4:
				this.fitxKud.fitxategiaIrakurri("./src/fitxategiak/eskariak.txt");
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

