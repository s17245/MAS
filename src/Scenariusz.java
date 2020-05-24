/*
s17245
 */

import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public class Scenariusz extends Zapis {


    public String nazwa;
    private String text;
    private Gielda gielda; //asocjacja 1..* - licznośc 1


    public Scenariusz (String nazwa, String text) {

        this.gielda = gielda;
        this.nazwa = nazwa;
        //System.out.println("Scenariusz " + nazwa + " uruchomiony: " + text);

        if(nazwa.equals("")){
            System.out.println("podano niewłaściwe dane");
        }

    }

//setter
    public void ustawGielde(Gielda gielda) {
        this.gielda = gielda;

    }
//getter
    public Gielda pobierzScenariusz(Gielda gielda){
        return gielda;
    }

    @Override
    public String toString(){
        String text = "Gielda: " + nazwa + "\n";
        return text ;
    }
}
