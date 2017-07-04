package ProjectDay1.Animale;

import ProjectDay1.Angajati.AngajatZoo;
import ProjectDay1.exceptions.AnimalManancaAnimalException;
import ProjectDay1.exceptions.AnimalManancaOmException;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class AnimalZooFeroce extends Animal {

    public void mananca(Object obj) throws AnimalManancaOmException, AnimalManancaAnimalException {
        if (obj instanceof AngajatZoo)
            throw new AnimalManancaOmException("AnimalManancaOmException");
        else
            System.out.println("AnimalZooFeroce mananca");

        if (obj instanceof Animal)
            throw new AnimalManancaAnimalException("AnimalManancaAnimalException");
    }
    public void seJoaca() {
        System.out.println("Animalul feroce se joaca");
    }
    public void faceBaie() {
        System.out.println("Animalul feroce face baie");
    }

    public void doarme() {
        super.doarme();
        System.out.println("Animalul feroce vaneaza");
    }

}
