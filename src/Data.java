/*
s17245
 */

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Data {

    //private LocalDateTime czas = LocalDateTime.now();
    private final LocalDateTime czas;// = LocalDateTime.now();

    private final DateTimeFormatter format;
    //private static final long serialVersionUID = 4156247124576225208L;

    public Data() {

        this.czas = LocalDateTime.now();
        this.format = DateTimeFormatter.ofPattern("HH:mm:ss");
    }



    @Override
    public String toString() {

        return czas.format(this.format);

    }
}
