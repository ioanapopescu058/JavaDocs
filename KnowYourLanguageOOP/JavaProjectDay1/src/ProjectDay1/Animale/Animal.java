package ProjectDay1.Animale;

import ProjectDay1.exceptions.AnimalManancaAnimalException;
import ProjectDay1.exceptions.AnimalManancaOmException;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public abstract class Animal {

    String nume, numeTaraOrigine;

    public String getNume() {
        return nume;
    }

    public String getNumeTaraOrigine() {
        return numeTaraOrigine;
    }

    public abstract void mananca(Object obj) throws AnimalManancaOmException, AnimalManancaAnimalException;
    public abstract void seJoaca();
    public abstract void faceBaie();

    public void doarme() {
        System.out.println("Animalul doarme");
    }

    public Animal() {
        System.out.println("Animal nou");
    }

    public Animal(String nume) {
        this.nume = nume;
    }

    public Animal(String nume, String numeTaraOrigine) {
        this.nume = nume;
        this.numeTaraOrigine = numeTaraOrigine;
    }
}
