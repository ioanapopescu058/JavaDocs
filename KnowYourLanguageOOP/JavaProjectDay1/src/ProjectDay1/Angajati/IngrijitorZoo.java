package ProjectDay1.Angajati;

import ProjectDay1.Animale.Animal;
import ProjectDay1.Animale.AnimalZooRar;
import ProjectDay1.exceptions.AnimalManancaOmException;
import ProjectDay1.exceptions.AnimalPeCaleDeDisparitieException;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class IngrijitorZoo implements AngajatZoo {

    int bonusIngrijitor;

    public void lucreaza(Animal animal) {
        System.out.println("Ingrijitorul intra in cusca animalului");
    }

    public void lucreaza(Animal animal, Object mancare) throws AnimalManancaOmException, AnimalPeCaleDeDisparitieException{

        if (animal instanceof AnimalZooRar && mancare == null)
            throw new AnimalPeCaleDeDisparitieException("Animal pe care de disparitie");
        else {
            this.lucreaza(animal);
            this.calculeazaBonusSalarial();
            animal.doarme();
            animal.seJoaca();
            animal.mananca(mancare);
        }
    }

    public void calculeazaBonusSalarial() {
        bonusIngrijitor += valoareBonusPerAnimal * 3;
    }

}
