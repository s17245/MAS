/*
s17245
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Zapis implements Serializable {

    //private static List<Zapis> listaZapisu = new ArrayList<>();
    private static Map<Class, List<Zapis>> listaZapisu = new Hashtable<>();

    public Zapis() {

        List<Zapis> lista = null;
        Class klasa = this.getClass();

        if (listaZapisu.containsKey(klasa)) {
            lista = listaZapisu.get(klasa);
        } else {
            lista = new ArrayList();
            listaZapisu.put(klasa, lista);
        }
        lista.add(this);
    }

    public static <T> Iterable<T> zwrócZapis(Class<T> typ) throws ClassNotFoundException {
        if (listaZapisu.containsKey(typ)) {

            return (Iterable<T>) listaZapisu.get(typ);

        }
        throw new ClassNotFoundException(
                String.format("nie znaleziono: ", typ.toString(), listaZapisu.keySet()));
    }


    public static void zrobZapis(ObjectOutputStream stream) throws IOException {

        stream.writeObject(listaZapisu);

    }

    public static void czytajZapis(ObjectInputStream stream) throws IOException, ClassNotFoundException {

        listaZapisu = (Hashtable) stream.readObject();

    }

    public static void pokażZapis(Class klasa) throws Exception {

        List<Zapis> lista = null;

        if (listaZapisu.containsKey(klasa)) {

            lista = listaZapisu.get(klasa);

        } else {
            throw new Exception("nieznana klasa: " + klasa);
        }

        System.out.println("zapisano: " + klasa.getSimpleName());

        for (Object obiekt : lista) {
            System.out.println(obiekt);
        }
    }
}
