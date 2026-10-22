package bussineslogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import ikuspegia.*;

import eredua.Langilea;

public class LangileKudeatzaile {
	private String id;
	private String fitxategiIzena;
	private Map<String, Langilea> mapa = new HashMap<String, Langilea>();
	
	public LangileKudeatzaile(){
		this.fitxategiIzena = "./src/fitxategiak/langileak.txt";
	}
	
	public LangileKudeatzaile(String fitxategiIzena) {
		this.fitxategiIzena = fitxategiIzena;
	}
	
	
	public void fitxategiaIrakurri() {
		try {
			FileReader fr = new FileReader(fitxategiIzena);
		 	BufferedReader br = new BufferedReader(fr);
			br.readLine();
			do {
				String lerroa = br.readLine();
				if (lerroa == null) {
					break;
				}
				String[] tokenak = lerroa.split("\t");
				Langilea l = new Langilea();
				l.setId(tokenak[0]);
				l.setIzena(tokenak[1]);
				l.setAbizena(tokenak[2]);
				l.setPostaElektronikoa(tokenak[3]);
				l.setTelefonoa(tokenak[4]);
				l.setKontratazio_data(tokenak[5]);
				l.setId_nagusi(tokenak[6]);
				mapa.put(tokenak[0], l);
			} while (true);
			br.close();
			fr.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		}
	
	public void menua(){
		System.out.println("Sartu ID bat: ");
		Scanner scanner = new Scanner(System.in);
		id = scanner.nextLine();
		 
	}
	public void bilatuEtaInprimatu(String id) {
		if (mapa.isEmpty()) {
			fitxategiaIrakurri();
		}

		Langilea l = mapa.get(id);

		if (l != null) {
			Kontsola.idatzi("\n--- LANGILEAREN INFORMAZIOA ---");
			Kontsola.idatzi("Izen-abizenak: " + l.getIzena() + " " + l.getAbizena());
			Kontsola.idatzi("Telefonoa: " + l.getTelefonoa());
			Kontsola.idatzi("Alta-eguna: " + l.getKontratazio_data());
		} else {
			Kontsola.idatzi("Langilea ez da existitzen (ID: " + id + "). Saiatu berriro.");
		}
	}
	
	public void nagusiakBilatuetaInprimatu(String nagusiId) {
	    if (mapa.isEmpty()) {
	        fitxategiaIrakurri();
	    }

	    boolean aurkitua = false;

	    for (Langilea l : mapa.values()) {
	      
	        if (l.getId_nagusi() != null && l.getId_nagusi().equals(nagusiId)) {
	            if (!aurkitua) {
	                Kontsola.idatzi(nagusiId + "NAGUSIAREN LANGILEAK");
	                aurkitua = true;
	            }
	            Kontsola.idatzi("Izen-abizenak: " + l.getIzena() + " " + l.getAbizena());
	            Kontsola.idatzi("Emaila: " + l.getPostaElektronikoa());
	            Kontsola.idatzi("----------------------------------");
	        }
	    }

	    if (!aurkitua) {
	        Kontsola.idatzi("Ez da aurkitu mendeko langilerik (Nagusi ID: " + nagusiId + ").");
	    }
	}
	
	
	
	public void setIzena(String fitxategiIzena) {

		this.fitxategiIzena = fitxategiIzena;

	}

}
