package bussineslogic;
import java.util.Scanner;

import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

public class Login {
	private final String erabiltzailea = "admin";
	private final String pasahitza = "1234";
	
	private String erabiltzaileKredentziala;
	private String pasahitzaKredentziala;
	
	boolean balioztatu = false;
	
	public Login() {
	}
	
	private void kredentzialakEskatu() {
		Kontsola.idatzi("Sartu erabiltzailea");
		String erabiltzaileKredentziala = Teklatua.irakurri();
		Kontsola.idatzi("Sartu pasahitza");
		String pasahitzaKredentziala = Teklatua.irakurri();
	}
	
	private void kredentzialakBalioztatu() {
		while(balioztatu=false) {
			if (erabiltzaileKredentziala.equals(erabiltzailea) && pasahitzaKredentziala.equals(pasahitza)){
				balioztatu = true;
			} else {
				Kontsola.idatzi("Kredentzialak okerrak dira, saiatu berriro:");
				kredentzialakEskatu();
			}
		}
	}
}
