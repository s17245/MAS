import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pesel {


    protected String nazwa;
    protected String pesel;

    private Map<String, Gracz> peselMap = new TreeMap<>();

    public Pesel(String nazwa, String pesel) throws Exception {

        this.pesel=pesel;
        this.nazwa= nazwa;
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(pesel);


        if (pesel.length()!=11 &&  !matcher.find()) {
            throw new Exception("pesel jest niewłaściwy");
        };
        //na potrzeby projektu,nie będę walidował prawdziwych nr pesel


    }

    public void dodajPeselDoGracza(Gracz gracz){

        if(!peselMap.containsKey(gracz.nick)){
            peselMap.put(gracz.nick, gracz);
            gracz.dodajPesel(this);

        }
    }

    public Gracz znajdźPeselGracza(String nick) throws Exception {

        if(!peselMap.containsKey(nick)){
            throw new Exception("nie ma takiego nicka: " + nick) ;
         }
        return peselMap.get(nick);

    }

    @Override
    public String toString() {

        return "pesel: " + pesel;

    }
}
