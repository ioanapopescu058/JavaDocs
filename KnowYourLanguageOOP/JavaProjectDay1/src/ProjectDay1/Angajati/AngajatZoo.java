package ProjectDay1.Angajati;

import ProjectDay1.Animale.Animal;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public interface AngajatZoo {

    int valoareBonusPerAnimal = 50;

    public void lucreaza(Animal animal);
    public void calculeazaBonusSalarial();
}
