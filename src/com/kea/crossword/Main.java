package com.kea.crossword;

public class Main {

    public static void main(String[] args) {
        char k[][] = {{'a','b','e'},{'l','e','j'},{'e','n','e'}};
        Krydsord kryds = new Krydsord(k);

        //indlæs alle ord i HashSet
        kryds.readOrd();
        System.out.println("Ordliste:");
        kryds.printOrd();
        //System.out.println(kryds.checkKrydsord());
        //kryds.printKrydsord();

        kryds.solve();



        //iterer kolonner (3 niveauer)
        //iterer mulige ord og indsæt
        //hvis løst så return udskriv, hvis niveau 3
        //hvis ikke løst så fjern ord og return false
    //hvis alle iterationer gennemført uden løsning, så return false
    //test om ordene i krydsordsrækkerne findes
    //test at ordene er unikke (indsæt alle ord i sæt og kontroller size()


    }
}
