package bussineslogic;

import ikuspegia.Kontsola;
import kontrolagailua.KontrolagailuNagusi;
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
		Kontsola.idatzi("Sartu erabiltzailea: ");
		this.erabiltzaileKredentziala = Teklatua.irakurri();
		Kontsola.idatzi("Sartu pasahitza: ");
		this.pasahitzaKredentziala = Teklatua.irakurri();
	}
	
	private void kredentzialakBalioztatu() {
		while(balioztatu == false) {
			if (erabiltzaileKredentziala.equals(erabiltzailea) && pasahitzaKredentziala.equals(pasahitza)){
				balioztatu = true;
			} else {
				Kontsola.idatzi("Kredentzialak okerrak dira, saiatu berriro:");
				kredentzialakEskatu();
			}
		}
	
	}
	
	public void run() {
		kredentzialakEskatu();
		kredentzialakBalioztatu();
	}
	
	
	
}
