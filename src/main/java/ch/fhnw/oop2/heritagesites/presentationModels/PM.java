package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


public class PM {
    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");

    //  private static final String csv_file = "/data/heritage_sites.csv";
   //  private static final String csv_file = "resources/data/test.txt";
    private static final String csv_file = "src/main/resources/data/test.txt";
    private static final String DELIMITER = "\t";

    private final ObservableList<HeritagePM> allSites = FXCollections.observableArrayList();

    public PM() throws FileNotFoundException {
        System.out.println(getApplicationTitle());
        allSites.addAll(readFromFile()); // todo: fails here
    }


    private List<HeritagePM> readFromFile() { //file not found-exception

        try (BufferedReader reader = getReader(csv_file)) { // Try/Catch Block
            return reader
                    .lines()
                    .skip(1)                                              // erste Zeile ist die Headerzeile; ueberspringen
                    .map(line -> new HeritagePM(line.split(DELIMITER, 10))) // 10,  aus jeder Zeile ein Objekt machen
                    .collect(Collectors.toList());                        // alles aufsammeln
        } catch (IOException e) {
            throw new IllegalStateException("xdfdddddddddddddddd");
        }
    }

    private BufferedReader getReader(String fileName) throws FileNotFoundException { // https://www.baeldung.com/java-buffered-reader
        FileReader reader = new FileReader(fileName);
        return new BufferedReader(reader);
    }


//    // add new entry
//    public void save() {
//        try (BufferedWriter writer = getWriter(csv_file)) {
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


//
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


