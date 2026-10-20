
package bussineslogic;

import ikuspegia.Kontsola;
import kontrolagailua.Teklatua;

public class Login {

    private final String erabiltzailea = "admin";
    private final String pasahitza = "1234";

    private String erabiltzaileKredentziala;
    private String pasahitzaKredentziala;

    private boolean balioztatu = false;

    public Login() {
        kredentzialakEskatu();
        kredentzialakBalioztatu();
    }

    private void kredentzialakEskatu() {

        Kontsola.idatzi("Sartu erabiltzailea:");
        erabiltzaileKredentziala = Teklatua.irakurri();

        Kontsola.idatzi("Sartu pasahitza:");
        pasahitzaKredentziala = Teklatua.irakurri();
    }

    private void kredentzialakBalioztatu() {

        while (!balioztatu) {

            if (erabiltzaileKredentziala.equals(erabiltzailea)
                    && pasahitzaKredentziala.equals(pasahitza)) {

                balioztatu = true;

                Kontsola.idatzi("Login zuzena!");

            } else {

                Kontsola.idatzi(
                    "Kredentzialak okerrak dira. Saiatu berriro:"
                );

                kredentzialakEskatu();
            }
        }
    }

    public boolean balioztatuDa() {
        return balioztatu;
    }
    
}
