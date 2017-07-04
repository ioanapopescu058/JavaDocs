package ro.teamnet.zerotohero.oop.runapp;

import java.util.Date;

/**
 * Created by Ioana.Popescu on 7/4/2017.
 */
public final class ImmutableClass {

    private final double fMass;
    private final String fName;
    private final Date fDateOfDiscovery;

    public ImmutableClass(double aMass, String aName, Date aDateOfDiscovery) {
        fMass = aMass;
        fName = aName;
        fDateOfDiscovery = new Date(aDateOfDiscovery.getTime());
    }
}
