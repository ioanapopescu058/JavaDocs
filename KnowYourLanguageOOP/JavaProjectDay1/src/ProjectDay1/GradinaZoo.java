package ProjectDay1;

import ProjectDay1.Angajati.IngrijitorZoo;
import ProjectDay1.Animale.AnimalZooRar;

import java.util.Date;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public final class GradinaZoo {

    private final String denumireGradinaZoo;
    private final Date dataDeschideriiGradinii;
    private final AnimalZooRar animalRar;
    private final IngrijitorZoo angajatulLunii;

    public GradinaZoo(String denumireGradinaZoo, Date dataDeschideriiGradinii, AnimalZooRar animalRar, IngrijitorZoo angajatulLunii) {
        this.denumireGradinaZoo = denumireGradinaZoo;
        this.dataDeschideriiGradinii = dataDeschideriiGradinii;
        this.animalRar = animalRar;
        this.angajatulLunii = angajatulLunii;
    }

    public String getDenumireGradinaZoo() {
        return denumireGradinaZoo;
    }

    public Date getDataDeschideriiGradinii() {
        return new Date(this.dataDeschideriiGradinii.getTime());
    }

    public AnimalZooRar getAnimalRar() {
        return animalRar;
    }

    public IngrijitorZoo getAngajatulLunii() {
        return angajatulLunii;
    }
}
