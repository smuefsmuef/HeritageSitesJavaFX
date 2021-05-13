package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


public class WorldHeritagesPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");

   // private final IntegerProperty selectedHeritageId = new SimpleIntegerProperty(-1);
//private final HeritagePM heritageProxy = new HeritagePM();


    private static final String csv_file = "src/main/resources/data/heritage_sites.csv";
    private static final String DELIMITER = ";";

    private final ObservableList<HeritagePM> allSites = FXCollections.observableArrayList();


    public WorldHeritagesPM() throws FileNotFoundException {
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




    ///  Save, Add, Remove

    // delete site
    public void deleteSite(HeritagePM eins) {
        allSites.remove(eins);
    }

    // add site
    public void addSite() {
        allSites.add(getAllSites().get(0));
    }

    ///  Counters

    // counter total sites, ok
    public int getTotalSites() {
        return (int) allSites.stream().count();
    }

    // counter for visited sites, todo
    public int getVisitedSitesCounter() {
     return (int) allSites.stream().filter(s -> s.isVisited()).count();
    }

    // counter for visited countries, ok
    public int getVisitedCountriesCounter() {
        return (int) allSites.stream().
                filter(s -> s.isVisited()).
        map(HeritagePM::getStates).distinct().count();
    }

    /// Visited yes, no?

    // todo add visited checkbox
    public void storeVisitedStatus() {

    }

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

  //  public HeritagePM getHeritage(int id) {
    //    return allSites.get(id);
    //}


}


