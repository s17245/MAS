import java.io.Serializable;
import java.util.ArrayList;

public class Gielda extends Zapis implements Serializable {

    public String nazwa;
    public int ocena;
    public ArrayList<Scenariusz> listaScenariuszy = new ArrayList<>(); //asocjacja 1..* - licznośc *

    public Gielda(String nazwa, int ocena) {
        this.nazwa = nazwa;
        this.ocena = ocena;

    }

    public void dodajScenariusz(Scenariusz nowyScenariusz) throws Exception {

        if (!listaScenariuszy.contains(nowyScenariusz)) {
            this.listaScenariuszy.add(nowyScenariusz);
            nowyScenariusz.ustawGielde(this);

        }else{
            throw new Exception("scenariusz już istnieje");
        }
    }

    public void usuńScenarius(Scenariusz scenariusz) throws Exception {

        if(listaScenariuszy.contains(scenariusz)) {

        }else {
        listaScenariuszy.remove(scenariusz);
        }
    }



    @Override
    public String toString() {
        String text = "Gielda: " + nazwa + "\n";

        for (Scenariusz a : listaScenariuszy) {
            text += " " + a.nazwa + "\n";
        }
        return text;

    }
}
