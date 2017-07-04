package ProjectDay1;

import ProjectDay1.Angajati.AngajatZoo;
import ProjectDay1.Angajati.IngrijitorZoo;
import ProjectDay1.Angajati.VeterinarZoo;
import ProjectDay1.Animale.AnimalZooFeroce;
import ProjectDay1.Animale.AnimalZooRar;
import ProjectDay1.exceptions.AnimalManancaOmException;
import ProjectDay1.exceptions.AnimalPeCaleDeDisparitieException;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public class GradinaZooMain {

    public static void main(String[] args) throws AnimalManancaOmException, AnimalPeCaleDeDisparitieException{
        AnimalZooRar animal1 = new AnimalZooRar("Pinguin");
        AnimalZooRar animal2 = new AnimalZooRar("Elefant","Africa");
        AnimalZooRar animal3 = new AnimalZooRar();

        AnimalZooFeroce animalFeroce = new AnimalZooFeroce();

        AngajatZoo angajat1 = new IngrijitorZoo();
        IngrijitorZoo angajat2 = new IngrijitorZoo();

        AngajatZoo angajat3 = new VeterinarZoo();
        VeterinarZoo angajat4 = new VeterinarZoo();

        System.out.println(animal1.getNume());
        System.out.println(animal1.getNumeTaraOrigine());
        System.out.println(animal2.getNume());
        System.out.println(animal2.getNumeTaraOrigine());

        angajat3.lucreaza(animal1);
        angajat3.lucreaza(animal2);
        angajat3.lucreaza(animal3);
        angajat4.lucreaza(animal1);
        angajat4.lucreaza(animal2);
        angajat4.lucreaza(animal3);

        angajat1.lucreaza(animal1);
        angajat1.lucreaza(animal2);
        angajat1.lucreaza(animal3);

        angajat2.lucreaza(animal1);
        angajat2.lucreaza(animal2);
        angajat2.lucreaza(animal3);

        try {
            angajat2.lucreaza(animal1, null);
        }
        catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("continua");
        }

        try {
            angajat2.lucreaza(animal1, angajat1);
        }
        catch (AnimalManancaOmException | AnimalPeCaleDeDisparitieException e) {
            System.out.println("continua");
        }

        try {
            angajat2.lucreaza(animal1, new String("Mancare"));
        }
        catch (AnimalManancaOmException | AnimalPeCaleDeDisparitieException e) {
                System.out.println("continua");
        }

        angajat2.lucreaza(animalFeroce);

        try {
            angajat2.lucreaza(animalFeroce, null);
        }
        catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("continua");
        }

        try {
            angajat2.lucreaza(animalFeroce, new String("Mancare"));
        }
        catch (AnimalPeCaleDeDisparitieException e) {
            System.out.println("continua");
        }

        System.out.println("Finish!");

    }
}
