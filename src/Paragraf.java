/*
s17245
 */

import java.util.List;

public class Paragraf extends Zapis {


    private Paragraf paragraf;
    private static int licznik;
    public String nazwa;
    private final String text;
    private List<Mechanizm> mechanizm;


    // pierwszy
    public Paragraf(String nazwa, String text) {

        //this.mechanizm = mechanizm;List<Mechanizm> mechanizm
        this.nazwa = nazwa;
        this.text = text;

        //System.out.println(text);
        licznik++;
    }


    public static int policzParagrafy() {

        return licznik;
    }


    public int usuńLicznik(int licznik) {
        Paragraf.licznik = licznik;
        licznik = 0;
        return licznik;
    }

    public void dodajMechanizm() {
    }

    @Override
    public String toString() {

        return "paragraf: " + nazwa + " tekst: " + text;

    }

}
