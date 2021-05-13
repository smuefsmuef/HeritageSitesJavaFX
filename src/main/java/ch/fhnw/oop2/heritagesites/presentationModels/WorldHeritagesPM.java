package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.Observable;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


public class WorldHeritagesPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");

   private final IntegerProperty selectedHeritageId = new SimpleIntegerProperty(0);

    private static final String csv_file = "src/main/resources/data/heritage_sites.csv";
    private static final String DELIMITER = ";";

    private final ObservableList<HeritagePM> allSites = FXCollections.observableArrayList();

    private final HeritagePM heritageProxy = new HeritagePM(); // proxy to add bind all the views to the same object



    public WorldHeritagesPM() throws FileNotFoundException {
        System.out.println(getApplicationTitle());
        allSites.addAll(readFromFile());
        
        selectedHeritageIdProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("recations of the listener" + oldValue);
            HeritagePM oldOne = getHeritage(oldValue.intValue());
            HeritagePM newOne = getHeritage(newValue.intValue());

            if (oldOne != null) {
                unbindFromProxy(oldOne);
            }

            if (newOne != null) {
                bindToProxy(newOne);
            }
            
        });
      
    }
    
    /// Reader


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

    /// Binder to Proxy
    
    // getHeritage
    private HeritagePM getHeritage(int id) {
        System.out.println("id transmitted to pm: " + id);
        return allSites.stream()
                .filter(site -> site.getId() == id)
                .findAny()
                .orElse(null);
    }

    public HeritagePM getHeritageProxy() {
        return heritageProxy;
    }

    private void bindToProxy(HeritagePM site) {
        heritageProxy.categoryProperty().bindBidirectional(site.categoryProperty());
        heritageProxy.dateInscribedProperty().bindBidirectional(site.dateInscribedProperty());
        heritageProxy.idProperty().bind(site.idProperty());
        heritageProxy.imgageURLProperty().bindBidirectional(site.imgageURLProperty());
        heritageProxy.codeISOProperty().bindBidirectional(site.codeISOProperty());
        heritageProxy.locationProperty().bindBidirectional(site.locationProperty());
        heritageProxy.regionProperty().bindBidirectional(site.regionProperty());
        heritageProxy.descriptionProperty().bindBidirectional(site.descriptionProperty());
        heritageProxy.siteProperty().bindBidirectional(site.siteProperty());
        heritageProxy.statesProperty().bindBidirectional(site.statesProperty());
        heritageProxy.visitedProperty().bindBidirectional(site.visitedProperty());
    }

    private void unbindFromProxy(HeritagePM site) {
        heritageProxy.categoryProperty().unbindBidirectional(site.categoryProperty());
        heritageProxy.dateInscribedProperty().unbindBidirectional(site.dateInscribedProperty());
        heritageProxy.idProperty().unbindBidirectional(site.idProperty());
        heritageProxy.imgageURLProperty().unbindBidirectional(site.imgageURLProperty());
        heritageProxy.codeISOProperty().unbindBidirectional(site.codeISOProperty());
        heritageProxy.locationProperty().unbindBidirectional(site.locationProperty());
        heritageProxy.regionProperty().unbindBidirectional(site.regionProperty());
        heritageProxy.descriptionProperty().unbindBidirectional(site.descriptionProperty());
        heritageProxy.siteProperty().unbindBidirectional(site.siteProperty());
        heritageProxy.statesProperty().unbindBidirectional(site.statesProperty());
        heritageProxy.visitedProperty().unbindBidirectional(site.visitedProperty());
    }


    ///  Save, Add, Remove Todo:

    // add site
    public void addSite() {
        allSites.add(getAllSites().get(0));
    }

    // delete site
    public void deleteSite(HeritagePM eins) {
        allSites.remove(eins);
    }




    ///  Counters // todo make sure the footer counters are updated after changing the checkboy visited

    // counter total sites, ok
    public int getTotalSites() {
        return (int) allSites.stream().count();
    }

    // counter for visited sites
    public int getVisitedSitesCounter() {
        return (int) allSites.stream().filter(s -> s.isVisited()).count();
    }


    // counter for visited countries, ok
    public int getVisitedCountriesCounter() {
        return (int) allSites.stream().
                filter(s -> s.isVisited()).
        map(HeritagePM::getStates).distinct().count();
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

    public int getSelectedHeritageId() {
        return selectedHeritageId.get();
    }

    public IntegerProperty selectedHeritageIdProperty() {
        System.out.println(selectedHeritageId);
        return selectedHeritageId;
    }

    public void setSelectedHeritageId(int selectedHeritageId) {
        this.selectedHeritageId.set(selectedHeritageId);

    }

}


