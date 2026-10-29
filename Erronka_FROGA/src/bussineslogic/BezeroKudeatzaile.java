package bussineslogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eredua.Bezeroa;
import eredua.EskariLerroa;
import eredua.Eskaria;
import ikuspegia.Kontsola;

public class BezeroKudeatzaile {
	private String id;
	private String bezeroFitxategiIzena;
	private String eskariFitxategi;
	private String eskariLerroFitxategi;
	
	private Map<String, Bezeroa> mapa = new HashMap<String, Bezeroa>();
	private List<Eskaria> eskariZerrenda = new ArrayList<Eskaria>();
	private List<EskariLerroa> lerroZerrenda = new ArrayList<EskariLerroa>();

	public BezeroKudeatzaile() {
		this.bezeroFitxategiIzena = "./src/fitxategiak/bezeroak.txt";
		this.eskariFitxategi = "./src/fitxategiak/eskariak.txt";
		this.eskariLerroFitxategi = "./src/fitxategiak/eskari_lerroak.txt";
	}

	public void fitxategiakIrakurri() {
		// Bezeroak irakurri
		try (BufferedReader br = new BufferedReader(new FileReader(bezeroFitxategiIzena))) {
			br.readLine();
			String lerroa;
			while ((lerroa = br.readLine()) != null) {
				String[] tokenak = lerroa.split("\t");
				if (tokenak.length >= 5) {
					Bezeroa b = new Bezeroa();
					b.setId(tokenak[0]);
					b.setIzena(tokenak[1]);
					b.setAbizena(tokenak[2]);
					b.setHelbidea(tokenak[3]);
					b.setEmaila(tokenak[4]);
					mapa.put(tokenak[0], b);
				}
			}
		} catch (Exception e) {
			Kontsola.idatzi("Errorea bezeroak irakurtzean: " + e.getMessage());
		}

		// Eskariak irakurri
		try (BufferedReader br = new BufferedReader(new FileReader(eskariFitxategi))) {
			br.readLine();
			String lerroa;
			while ((lerroa = br.readLine()) != null) {
				String[] tokenak = lerroa.split("\t");
				if (tokenak.length >= 4) {
					Eskaria e = new Eskaria();
					e.setId(tokenak[0]);
					e.setIdBezero(tokenak[1]);
					e.setIdEgoera(tokenak[2]);
					e.setEskaeraData(tokenak[3]);
					eskariZerrenda.add(e);
				}
			}
		} catch (Exception e) {
			Kontsola.idatzi("Errorea eskariak irakurtzean: " + e.getMessage());
		}

		// Eskari Lerroak irakurri
		try (BufferedReader br = new BufferedReader(new FileReader(eskariLerroFitxategi))) {
			br.readLine();
			String lerroa;
			while ((lerroa = br.readLine()) != null) {
				String[] tokenak = lerroa.split("\t");
				if (tokenak.length >= 5) {
					EskariLerroa el = new EskariLerroa();
					el.setIdEskari(tokenak[0]);
					el.setIdLerro(tokenak[1]);
					el.setiDProduktu(tokenak[2]);
					el.setKopurua(tokenak[3]);
					el.setSalneurria(tokenak[4]);
					lerroZerrenda.add(el);
				}
			}
		} catch (Exception e) {
			Kontsola.idatzi("Errorea eskari lerroak irakurtzean: " + e.getMessage());
		}
	}

	public void bilatuEtaInprimatu(String id) {
		if (mapa.isEmpty()) {
			fitxategiakIrakurri();
		}

		Bezeroa b = mapa.get(id);

		if (b != null) {
			Kontsola.idatzi("\n--- BEZEROEN INFORMAZIOA ---");
			Kontsola.idatzi("Izen-abizenak: " + b.getIzena() + " " + b.getAbizena());
			Kontsola.idatzi("Helbidea: " + b.getHelbidea());
			Kontsola.idatzi("Emaila: " + b.getEmaila());
		} else {
			Kontsola.idatzi("Bezero hori ez da existitzen (ID: " + id + "). Saiatu berriro.");
		}
	}

	public void fakturaSortuEtaGorde(String eskariId) {
		if (mapa.isEmpty() || eskariZerrenda.isEmpty() || lerroZerrenda.isEmpty()) {
			fitxategiakIrakurri();
		}

		Eskaria aurkitutakoEskaria = null;
		for (Eskaria e : eskariZerrenda) {
			if (e.getId().equals(eskariId)) {
				aurkitutakoEskaria = e;
				break;
			}
		}

		if (aurkitutakoEskaria == null) {
			Kontsola.idatzi("Ez da aurkitu eskaerarik ID honekin: " + eskariId);
			return;
		}

		Bezeroa b = mapa.get(aurkitutakoEskaria.getIdBezero());

		List<EskariLerroa> eskaerarenLerroak = new ArrayList<>();
		for (EskariLerroa el : lerroZerrenda) {
			if (el.getIdEskari().equals(eskariId)) {
				eskaerarenLerroak.add(el);
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("=========================================\n");
		sb.append("               FAKTURA                   \n");
		sb.append("=========================================\n");
		sb.append("Eskaera Zenbakia: ").append(aurkitutakoEskaria.getId()).append("\n");
		sb.append("Eskaera Data: ").append(aurkitutakoEskaria.getEskaeraData()).append("\n");
		if (b != null) {
			sb.append("Bezeroa: ").append(b.getIzena()).append(" ").append(b.getAbizena()).append("\n");
			sb.append("Helbidea: ").append(b.getHelbidea()).append("\n");
			sb.append("Emaila: ").append(b.getEmaila()).append("\n");
		}
		sb.append("-----------------------------------------\n");
		sb.append(String.format("%-12s %-10s %-10s %-10s\n", "PRODUKTUA", "KOPURUA", "PREZIOA", "GUZTIRA"));
		sb.append("-----------------------------------------\n");

		double totala = 0.0;

		for (EskariLerroa el : eskaerarenLerroak) {
			try {
				int kopurua = Integer.parseInt(el.getKopurua());
				double prezioa = Double.parseDouble(el.getSalneurria().replace(",", "."));
				double subtot = kopurua * prezioa;
				totala += subtot;

				sb.append(String.format("%-12s %-10d %-10.2f %-10.2f\n",
						el.getiDProduktu(), kopurua, prezioa, subtot));
			} catch (Exception e) {
				Kontsola.idatzi("Errorea datuak konvertitzean lerro honetan: " + el.getIdLerro());
			}
		}

		double totalaBorobilduta = Math.round(totala * 100.0) / 100.0;

		sb.append("-----------------------------------------\n");
		sb.append(String.format("TOTALA: %.2f €\n", totalaBorobilduta));
		sb.append("=========================================\n");

		Kontsola.idatzi(sb.toString());

		String fitxategiBidea = "./src/fitxategiak/faktura_" + eskariId + ".txt";
		try (PrintWriter pw = new PrintWriter(new FileWriter(fitxategiBidea))) {
			pw.print(sb.toString());
			Kontsola.idatzi("Faktura beheko fitxategian gorde da:\n" + fitxategiBidea);
		} catch (Exception e) {
			Kontsola.idatzi("Ezin izan da faktura fitxategian gorde: " + e.getMessage());
		}
	}
}