package kontrolagailua;

import bussineslogic.LangileKudeatzaile;
import ikuspegia.Kontsola;

public class LangileKontrolagailu {

	private LangileKudeatzaile langileKud;

	public LangileKontrolagailu() {
		this.langileKud = new LangileKudeatzaile();
	}

	public void erakutsiMenua() {
		int aukera = 0;
		do {
			Kontsola.idatzi("\n===== LANGILEAK =====");
			Kontsola.idatzi("1. Kontsultatu langile baten informazioa");
			Kontsola.idatzi("2. Nagusi baten langileen zerrenda erakutsi");
			Kontsola.idatzi("0. Atzera joan");
			Kontsola.idatzi("Aukeratu aukera bat:");

			try {
				aukera = Integer.parseInt(Teklatua.irakurri());
			} catch (NumberFormatException e) {
				aukera = -1;
			}

			switch (aukera) {
			case 1:
				Kontsola.idatzi("Sartu langilearen ID-a:");
				String id = Teklatua.irakurri();
				langileKud.bilatuEtaInprimatu(id); //
				break;

			case 2:
				Kontsola.idatzi("Sartu nagusiaren ID-a:");
				String nagusiId = Teklatua.irakurri();
				langileKud.nagusiakBilatuetaInprimatu(nagusiId);
				break;

			case 0:
				Kontsola.idatzi("Menu nagusira itzultzen...");
				break;

			default:
				Kontsola.idatzi("Aukera okerra.");
				break;
			}
		} while (aukera != 0);
	}
}