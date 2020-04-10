package legoset;

import jaxb.JAXBHelper;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.time.Year;

public class Main {

    public static void main(String args[]) throws Exception{
        LegoSet legoset = new LegoSet();
        legoset.setNumber("75211");
        legoset.setName("Imperial TIE Fighter");
        legoset.setTheme("Star Wars");
        legoset.setSubtheme("Solo");
        legoset.setYear(Year.of(2018));
        legoset.setPieces(519);

        Set<String> tags = new LinkedHashSet<>();
        tags.add("Starfighter");
        tags.add("Stormtrooper");
        tags.add("Star Wars");
        tags.add("Solo");
        legoset.setTags(tags);

        List<Minifig> minifigs = new ArrayList<>();
        minifigs.add( new Minifig( "Imperial Mudtrooper", 2));
        minifigs.add( new Minifig( "Imperial Pilot", 1));
        minifigs.add( new Minifig( "Mimban Stormtrooper", 1));
        legoset.setMinifigs(minifigs);

        legoset.setWeight(new Weight("kg", 0.89));

        legoset.setUrl("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter");

        JAXBHelper.toXML(legoset, System.out);

    }
}