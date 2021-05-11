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

    private static final String csv_file = "src/main/resources/data/heritage_sites.csv";
    private static final String DELIMITER = ";";

    private final ObservableList<HeritagePM> allSites = FXCollections.observableArrayList();

    public PM() throws FileNotFoundException {
        System.out.println(getApplicationTitle());
        allSites.addAll(readFromFile());
    }


    private List<HeritagePM> readFromFile() {
        try (BufferedReader reader = getReader(csv_file)) { // get reader
            return reader
                    .lines()
                    .skip(1) // skip first line, header
                    .map(line -> new HeritagePM(line.replaceAll(";;;;", "").split(DELIMITER, 10))) // 10,  transform each line into an obect
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalStateException("no bueno - file not found");
        }
    }

    // get file reader
    private BufferedReader getReader(String fileName) throws FileNotFoundException {
        FileReader reader = new FileReader(fileName);
        return new BufferedReader(reader);
    }


    // add new entry
    public void save() {
        try (BufferedWriter writer = getWriter(csv_file)) {
            writer.write("Das;ist;einTest");
            writer.newLine();
            allSites.stream()
                    .map(result -> result.infoAsLine(DELIMITER))
                    .forEach(line -> {
                        try {
                            writer.write(line);
                            writer.newLine();
                        } catch (IOException e) {
                            throw new IllegalStateException(e);
                        }
                    });
        } catch (IOException e) {
            throw new IllegalStateException("save failed");
        }
    }

    // writes new entry into file
    private BufferedWriter getWriter(String fileName) {
        try {
            String file = getClass().getResource(fileName).getFile();
            return new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IllegalStateException("wrong file " + fileName);
        }
    }

    // delete site
    public void deleteSite(HeritagePM eins) {
        allSites.remove(eins);
    }

    // add site
    public void addSite() {
        allSites.add(getAllSites().get(0));
    }


    // counter
    public int getTotalCountries() {
        return (int) allSites.stream().count();
    }

    // counter // todo adapt stream to get some with visited true, but first i need to geta new column to each object with default false
    //public int getVisitedCountryCounter() {
      // return (int) allSites.stream().filter(s -> s.getVisited().equals(true)).count();
   // }

    /// Getter & Setter

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


