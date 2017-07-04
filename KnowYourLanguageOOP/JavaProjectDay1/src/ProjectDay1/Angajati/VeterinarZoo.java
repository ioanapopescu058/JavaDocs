package ProjectDay1.Angajati;

import ProjectDay1.Animale.Animal;
import ProjectDay1.Animale.AnimalZooFeroce;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class VeterinarZoo implements AngajatZoo {

    int bonusVeterinar;

    public void lucreaza(Animal animal) {
        System.out.println("Veterinarul are grija de animal");

        if (animal instanceof AnimalZooFeroce)
            animal.faceBaie();

        this.calculeazaBonusSalarial();
    }

    public void calculeazaBonusSalarial() {
        bonusVeterinar += valoareBonusPerAnimal * 2;
    }
}
