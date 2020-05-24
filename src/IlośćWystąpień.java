

public class IlośćWystąpień extends ZapisPlus{

    private int licznik;
    protected String nazwa = "ilośćWystąpień";

    private IlośćWystąpień(int licznik) {
        super();
        this.licznik = licznik;

    }

    public static void dodajMechanizmDoParagrafu(Paragraf paragraf, Mechanizm mechanizm, int licznik) throws Exception {

        if(paragraf != null && mechanizm != null){
            for(int i = 0; licznik <= mechanizm.policzMechanizmy(); i++) {

                IlośćWystąpień ilośćWystąpień = new IlośćWystąpień(licznik);
                ilośćWystąpień.addLink(mechanizm.nazwa, ilośćWystąpień.nazwa, mechanizm);
                ilośćWystąpień.addLink(paragraf.nazwa, ilośćWystąpień.nazwa, paragraf);
                //licznik--;
            }
            //paragraf.usuńLicznik(licznik);
        }
        else{
            throw new Exception("nie udało się dodać mechanizmu do paragrafu");
        }
    }

//    public String showMechanizmParagraf(){
//
//    }

    @Override
    public String toString() {
        return "użyto" + licznik + "mechanizmów";
    }
}
