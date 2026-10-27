package bussineslogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ikuspegia.*;
import kontrolagailua.Teklatua;
import eredua.*;

public class BezeroKudeatzaile {
	private String id;
	private String bezeroFitxategiIzena;
	private String eskariLerroFitxategi;
	private String eskariFitxategi;
	private Map<String, Bezeroa> mapa = new HashMap<String, Bezeroa>();
	private List<Eskaria> eskariZerrenda = new ArrayList<Eskaria>();
    private List<EskariLerroa> lerroZerrenda = new ArrayList<EskariLerroa>();

	public BezeroKudeatzaile(){
		this.bezeroFitxategiIzena = "./src/fitxategiak/bezeroak.txt";
	}

	public BezeroKudeatzaile(String fitxategiIzena) {
		this.bezeroFitxategiIzena = fitxategiIzena;
	}

	public void fitxategiakIrakurri() {
		try {
			FileReader fr = new FileReader(bezeroFitxategiIzena);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			do {
				String lerroa = br.readLine();
				if (lerroa == null) {
					break;
				}
				String[] tokenak = lerroa.split("\t");
				Bezeroa b = new Bezeroa();
				b.setId(tokenak[0]);
				b.setIzena(tokenak[1]);
				b.setAbizena(tokenak[2]);
				b.setHelbidea(tokenak[3]);
				b.setEmaila(tokenak[4]);
				mapa.put(tokenak[0], b);
			} while (true);
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	public void menua() {
	    Kontsola.idatzi("Sartu ID bat: ");
	    id = Teklatua.irakurri();
	}

	public void bilatuEtaInprimatu(String id) {
		if (mapa.isEmpty()) {
			fitxategiakIrakurri();
		}

		Bezeroa b = mapa.get(id);

		if (b != null) {
			Kontsola.idatzi("\n--- BEZEROEN INFORMAZIOA ---");
			Kontsola.idatzi("Izen-abizenak: " + b.getIzena() + " " + b.getAbizena());
			Kontsola.idatzi("Telefonoa: " + b.getHelbidea());
			Kontsola.idatzi("Alta-eguna: " + b.getEmaila());
		} else {
			Kontsola.idatzi("Bezero hori ez da existitzen (ID: " + id + "). Saiatu berriro.");
		}
	}

	public void fakturaSortuetaInprimatu(){
		if (mapa.isEmpty()) {
	        fitxategiakIrakurri();
	    }
		Bezeroa b = mapa.get(id);
		if (b != null) {
			Kontsola.idatzi("\n---  FAKTURA  ---");
			Kontsola.idatzi("Izen-abizenak: " + b.getIzena() + " " + b.getAbizena());
			Kontsola.idatzi("Telefonoa: " + b.getHelbidea());
			Kontsola.idatzi("Alta-eguna: " + b.getEmaila());
		} else {
			Kontsola.idatzi("Bezero hori ez da existitzen (ID: " + id + "). Saiatu berriro.");
		}
	}


}
