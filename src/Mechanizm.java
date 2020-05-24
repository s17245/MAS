import java.io.Serializable;

public class Mechanizm extends ZapisPlus implements Serializable {

    //to do, multimedia

    private static int licznik;
    public String nazwa;


    public Mechanizm(String nazwa) {

        this.nazwa = nazwa;
        licznik++;
    }

    public static int policzMechanizmy() {
        return licznik;
    }

    @Override
    public String toString() {

        return "mechanizm: " + nazwa;// + " liczba " + licznik;

    }

    public void zgłośBłąd(String nazwa, String opis, String data) throws Exception {

        if (this != null) {

            Błąd błąd = Błąd.zgłośBłąd(nazwa, opis, data);

            this.addPart(błąd.nazwa, this.nazwa,  błąd.zwrócDate(), błąd);

        } else {

            System.out.println("Pojazd nie istenieje");

        }

    }

}
