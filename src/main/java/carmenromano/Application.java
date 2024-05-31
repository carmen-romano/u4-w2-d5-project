package carmenromano;

import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.UUID;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Application {

    public static void main(String[] args) {
        Archivio archivio = new Archivio("src/archivio1.txt");
        try {
            archivio.riempiConLibriCasuali();
            archivio.riempiConRivisteCasuali();
            File archivioDisc = new File("src/archivio1.txt");

            for (Catalogo elemento : archivio.getCatalogoList()) {
                FileUtils.writeStringToFile(archivioDisc, elemento + System.lineSeparator(), StandardCharsets.UTF_8, true);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(archivio);

        archivio.aggiungiLibro("Titolo1", Genere.FANTASY, "Frank");
        archivio.aggiungiRivista("Titolo2", Periodicità.SEMESTRALE);

        archivio.searchByISBN("fe3ddb59-704b");
    }
}
