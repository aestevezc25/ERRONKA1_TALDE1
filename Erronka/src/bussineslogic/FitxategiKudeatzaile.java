package bussineslogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import ikuspegia.Kontsola;

public class FitxategiKudeatzaile {
	private String fitxategiIzena;

	public FitxategiKudeatzaile() {
	}

	public FitxategiKudeatzaile(String fitxategiIzena) {
		this.fitxategiIzena = fitxategiIzena;
	}

	public static void fitxategiaIrakurri(String bidea) {
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



}
