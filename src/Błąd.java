import java.io.Serializable;

public class Błąd extends ZapisPlus implements Serializable {

    protected String nazwa;
    private String data;
    private String opis;

    private Błąd(String nazwa, String opis, String data) {

        this.nazwa = nazwa;
        this.opis = opis;

    }

    protected static Błąd zgłośBłąd(String nazwa, String opis, String nowaData) {

        Błąd błąd = new Błąd(nazwa, opis, nowaData);

        return błąd;

    }

    public String zwrócDate() {
        return data;
    }

    @Override
    public String toString() {
        return "błąd: " + nazwa;

    }
}
