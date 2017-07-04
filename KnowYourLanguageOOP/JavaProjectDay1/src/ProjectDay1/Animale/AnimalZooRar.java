package ProjectDay1.Animale;

import ProjectDay1.Angajati.AngajatZoo;
import ProjectDay1.exceptions.AnimalManancaAnimalException;
import ProjectDay1.exceptions.AnimalManancaOmException;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class AnimalZooRar extends Animal {

    public AnimalZooRar() {
        super();
    }

    public AnimalZooRar(String nume) {
        super(nume);
    }

    public AnimalZooRar(String nume, String numeTaraOrigine) {
        super(nume, numeTaraOrigine);
    }

    public void mananca(Object obj) throws AnimalManancaOmException, AnimalManancaAnimalException {

        if (obj instanceof AngajatZoo)
            throw new AnimalManancaOmException("AnimalManancaOmException");
        else
            System.out.println("AnimalZooRar mananca");

        if (obj instanceof Animal)
            throw new AnimalManancaAnimalException("AnimalManancaAnimalException");
    }
    public void seJoaca() {
        System.out.println("AnimalulZooRar se joaca");
        super.doarme();
    }
    public void faceBaie() {
        System.out.println("AnimalulZooRar face baie");
    }


}
