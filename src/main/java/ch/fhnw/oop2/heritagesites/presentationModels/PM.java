package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// analog Gesamtresult
// todo: file rcihtig einlesen

public class PM {
    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");

  //  private static final String csv_file = "/data/heritage_sites.csv";
   private static final String csv_file = "/data/text.txt";
    private static final String DELIMITER = "";

    private final ObservableList<HeritagePM> allSites = FXCollections.observableArrayList();

    public PM() {
      //  allSites.addAll(readFromFile()); // todo: fails here
        System.out.println(getApplicationTitle());
    }


    private List<HeritagePM> readFromFile() {
        try (BufferedReader reader = getReader(csv_file)) {
            return reader.lines()
                    .skip(1)                                              // erste Zeile ist die Headerzeile; ueberspringen
                    .map(line -> new HeritagePM(line.split(DELIMITER, 200))) // aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());                        // alles aufsammeln
        } catch (IOException e) {
            throw new IllegalStateException("failed");
        }
    }


//    // recheck if needed
//    public void save() {
//        try (BufferedWriter writer = getWriter(FILE_NAME)) {
//            writer.write("Das;ist;einTest");
//            writer.newLine();
//            allSites.stream()
//                    .map(resultat -> resultat.infoAsLine(DELIMITER))
//                    .forEach(line -> {
//                        try {
//                            writer.write(line);
//                            writer.newLine();
//                        } catch (IOException e) {
//                            throw new IllegalStateException(e);
//                        }
//                    });
//        } catch (IOException e) {
//            throw new IllegalStateException("save failed");
//        }
//    }

    private BufferedReader getReader(String fileName) {
        InputStream inputStream = getClass().getResourceAsStream(fileName);  // damit kann man vom File lesen
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); // lesen von Text-File
        return new BufferedReader(reader);  // damit man zeilenweise lesen kann
    }

//    private BufferedWriter getWriter(String fileName) {
//        try {
//            String file = getClass().getResource(fileName).getFile();
//            return new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
//        } catch (IOException e) {
//            throw new IllegalStateException("wrong file " + fileName);
//        }
//    }


    /// Getter & Setter

    // app title, ok
    public String getApplicationTitle() {
        return applicationTitle.get();
    }
    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }


    public ObservableList<HeritagePM> getAllSites() {
        return allSites;
    }
}


