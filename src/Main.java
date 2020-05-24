/*
s17245
 */

import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static String plikZapisu = "C:\\Users\\Lucek\\MP1\\MP1.bin";


    public static void main(String[] args) throws Exception {

        //System.out.println(System.getProperty("user.home"));
        //utworzGraczy();
        //utworzScenariusz();
        //System.out.println("liczba paragrafów: " + Paragraf.policzParagrafy());
//serializacja
/*      File plik = new File(plikZapisu);

        if (plik.exists()) {
            //odczyt
            ObjectInputStream strumieńOdczytu = new ObjectInputStream(new FileInputStream(plik));
            Zapis.czytajZapis(strumieńOdczytu);
            //Zapis.pokażZapis(Gracz.class);
            Zapis.pokażZapis(Paragraf.class);

            strumieńOdczytu.close();
            System.out.println("\n" + "zapis istnieje, odczytuję i usuwam");
            plik.delete();


        } else {
            // zapis
        // MP1
            //utworzGraczy();
            //utworzScenariusz();


            //Serializacja /*
            //System.out.println("liczba paragrafów: " + Paragraf.policzParagrafy());
            ObjectOutputStream strumieńZapisu = new ObjectOutputStream(new FileOutputStream(plik));
            Zapis.zrobZapis(strumieńZapisu);
            strumieńZapisu.close();
            System.out.println("\n" + "zapis nie istnieje, zapisuję");
            }
 */

        //asocjacja z atrybutem
        utworzParagrafMechanizm();

        //asocjacja 1..* przez referencje
        utworzGieldeScenariusz();

        //asocjacja Kompozycja
        utworzMachanizmBłąd();

        //asocjacja kwalifikowana
        utworzGraczPesel();
    }

    private static void utworzGraczPesel() throws Exception {
        Gracz gracz1 = new Gracz("Grzegorz","Brzęczyszczykiewicz","greg@greg.com", "greg789", 0, "tak");
        Pesel p1 = new Pesel("greg789","87654312345");
        p1.dodajPeselDoGracza(gracz1);
        //System.out.println("\n" + p1);
        //Gracz g = p1.znajdźPeselGracza("greg789");
        System.out.println(p1.znajdźPeselGracza("greg789"));

    }

    private static void utworzMachanizmBłąd() throws Exception {
        Mechanizm mechanizm = new Mechanizm( "Błąd audio" +"\n");
        mechanizm.zgłośBłąd("nie działa","nie słysze","15-07-2020");
        System.out.println(mechanizm);
    }

    public static void utworzGieldeScenariusz() throws Exception {

        Gielda gielda = new Gielda("Bajki dla dzieci",5);
        Scenariusz sc1 = new Scenariusz("pierwszy scenariusz", "ala ma kota1");
        Scenariusz sc2 = new Scenariusz("drugi scenariusz", "ala ma kota2");

        gielda.dodajScenariusz(sc1);
        gielda.dodajScenariusz(sc2);
        System.out.println(gielda);
    }

    public static void utworzParagrafMechanizm() throws Exception {

        Paragraf paragraf = new Paragraf("pierwszy","ala ma kotaaaa");
        Mechanizm mechanizm = new Mechanizm("audio");

        //System.out.println("liczba mechanizmów: " + mechanizm.policzMechanizmy());

    //IlośćWystąpień ilośćWystąpień = new IlośćWystąpień(5);  //nie moge dostać się do prywatnego konstruktora

        IlośćWystąpień.dodajMechanizmDoParagrafu(paragraf, mechanizm, 2);
        //System.out.println();
        System.out.println(paragraf);
        System.out.println(mechanizm + "\n");
    }



    /*
    MP2
####################################################################################
# • Zwykła przez referencje     *..*    giełda -> scenariusz
# • Z atrybutem           paragraf -> mechanizm -> ilośćWystąpień
• Kwalifikowana         scenariusz -> paragraf
#• Kompozycja            mechanizm -> błąd

            (w każdym przypadku: liczności
                    1-* lub *-* oraz automatyczne tworzenie poł. zwrotnego)

####################################################################################
*/
    public static void utworzGraczy() throws Exception {

        List<Gracz> lista = new ArrayList<>();
        lista.add(new Gracz("Maciek", "Skrzek", "s17245@pja.pl", "lucek", 1, "tak"));
        lista.add(new Gracz("Grzegorz", "Brzęczyszczykiewicz", "fdsf@fa.pl", "Greg", 2, "tak"));
        lista.add(new Gracz("Kokos", "Kokosowy", "kokos@kokos.pl", "koks", 0, "nie"));
        lista.add(new Gracz("fantom", "Jarek", "panda3@kokos.pl", "", 0, "nie"));

        //Gracz a1 = new Autor("a1", "na1", "a1@na1.pl", "autor1", 1, "tak");

        for (Gracz g : lista) {
            System.out.println(g);
        }
    }

//    public static void utworzScenariusz() {
//
//        Paragraf m1 = null, m2 = null, m3 = null, m4 = null;
//        String data = String.valueOf(new Data());
//
//        Paragraf start = new Paragraf("wstęp", "test1", "Drogie dzieci", m1, null);
//        m1 = new Paragraf("n1", start, m2, m3, "ala ma kota");
//        m2 = new Paragraf("n2", m1, "i kot ma ale");
//        m3 = new Paragraf("n3", m1, m4, "albo i nie");
//        m4 = new Paragraf("n4", m3, "KONIEC");
//        Scenariusz sc = new Scenariusz("scn 1", "test1", start, data, null);
//
//    }



//    public static void pokażDate() {
//        //Data d = new Data();
//        String data = String.valueOf(new Data());
//        System.out.println(data);
//    }


            /*



MP1
• Ekstensja                         # utworzGraczy()
• Ekst. - trwałość                  # Zapis
• Atr. złożony                      # Data - godzina
• Atr. opcjonalny                   # nick w graczu
• Atr. powt                         # rolaName w graczu
• Atr. klasowy                      # at = "@" w gracz
• Atr. pochodny, wyliczany          # liczba Paragrafów
• Met. klasowa                      # zrób zapis w Zapis, a np. konstruktor w graczu?
• Przesłonięcie,                    # paragraf
• przeciążenie                      # toString() w graczu
####################################################################################
         */


}
