package kontrolagailua;

import bussineslogic.BezeroKudeatzaile;
import ikuspegia.Kontsola;

public class FakturaKontrolagailua {

    private BezeroKudeatzaile bezeroKud;

    public FakturaKontrolagailua() {
        this.bezeroKud = new BezeroKudeatzaile();
    }

    public void sortuFakturaProzesua() {
        Kontsola.idatzi("Sartu eskaera zenbakia (ID): ");
        String eskaeraId = Teklatua.irakurri();
        bezeroKud.fakturaSortuEtaGorde(eskaeraId);
    }
}