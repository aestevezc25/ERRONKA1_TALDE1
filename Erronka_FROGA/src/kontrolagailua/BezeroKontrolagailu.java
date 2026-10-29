package kontrolagailua;

import bussineslogic.BezeroKudeatzaile;
import ikuspegia.Kontsola;

public class BezeroKontrolagailu {

	private BezeroKudeatzaile bezeroKud;
	private FakturaKontrolagailua fakturaCtrl;

	public BezeroKontrolagailu() {
		this.bezeroKud = new BezeroKudeatzaile();
		this.fakturaCtrl = new FakturaKontrolagailua();
	}

	public void erakutsiMenua() {
		int aukera = 0;
		do {
			Kontsola.idatzi("\n===== BEZEROAK =====");
			Kontsola.idatzi("1. Bezero baten kontaktua kontsultatu");
			Kontsola.idatzi("2. Erosketa baten faktura sortu");
			Kontsola.idatzi("0. Atzera joan");
			Kontsola.idatzi("Aukeratu aukera bat:");

			try {
				aukera = Integer.parseInt(Teklatua.irakurri());
			} catch (NumberFormatException e) {
				aukera = -1;
			}

			switch (aukera) {
			case 1:
				Kontsola.idatzi("Sartu bezeroaren ID-a:");
				String id = Teklatua.irakurri();
				bezeroKud.bilatuEtaInprimatu(id);
				break;

			case 2:
				fakturaCtrl.sortuFakturaProzesua();
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