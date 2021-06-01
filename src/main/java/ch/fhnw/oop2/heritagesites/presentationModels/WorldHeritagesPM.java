package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class WorldHeritagesPM {
    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");
    private final IntegerProperty selectedHeritageId = new SimpleIntegerProperty(-1);
    private final SimpleIntegerProperty visitedSites = new SimpleIntegerProperty();
    private final SimpleIntegerProperty visitedCountries = new SimpleIntegerProperty();
    private final SimpleStringProperty visitedCountriesNames = new SimpleStringProperty();
    private final SimpleIntegerProperty sitesCounter = new SimpleIntegerProperty();
    private final ObservableList<HeritagePM> allSites = FXCollections.observableArrayList();
    public FilteredList<HeritagePM> filteredData = new FilteredList<>(allSites, p -> true);
    SortedList<HeritagePM> sortedList = new SortedList<>(filteredData);

    private static final String csv_file = "src/main/resources/data/heritage_sites.csv";
    private static final String csf_file_direct = "/data/heritage_sites.csv";
    private static final String DELIMITER = ";";

    // proxy to add bind all the views to the same object
    private final HeritagePM heritageProxy = new HeritagePM();

    public WorldHeritagesPM() throws FileNotFoundException {
        allSites.addAll(readFromFile());

        selectedHeritageIdProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("selected heritage, old value: " + oldValue);
            System.out.println("selected heritage, new value: " + newValue);
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


    //////////////////////////////////////  Reader & Writer  ////////////////////////////////


    private List<HeritagePM> readFromFile() {
        try (BufferedReader reader = getReader(csv_file)) { // get reader
            return reader
                    .lines()
                    .skip(1) // skip first line, header
                    .map(line -> new HeritagePM(line.replaceAll(";;;;", "").split(DELIMITER, 10))) // 10,  transform each line into an object
                    .collect(toList());
        } catch (IOException e) {
            throw new IllegalStateException("no bueno - file not found");
        }
    }

    // get file reader
    private BufferedReader getReader(String fileName) throws FileNotFoundException {
        FileReader reader = new FileReader(fileName);
        return new BufferedReader(reader);
    }

    // save current state of list into csv
    public void save() {
        try (BufferedWriter writer = getWriter(csf_file_direct)) { // todo: i use a different file path to read in, maybe change
            writer.write("Category;Date inscribed;ID;Image URL;Code ISO;Location;Region;Short Description;Site;States;;;;");
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


    //////////////////////////////////////  Binders for Proxy  ////////////////////////////////


    // getHeritage
    private HeritagePM getHeritage(int id) {
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


    //////////////////////////////////////  Add & Remove ////////////////////////////////


    // get the next free id - additional?
    public int getNextId() {
        int idtest = 0;
        for (HeritagePM site : allSites) {
            if (site.getId() > idtest) {
                idtest = site.getId();
            }
        }
        return idtest + 1;
    }

    // save
    public void addSite() {
        allSites.add(0, new HeritagePM(getNextId()));
        int firstOne = allSites.get(0).getId();
        setSelectedHeritageId(firstOne);
        updateCounters();
    }


    // delete site
    public void deleteSite(int eins) {
        System.out.println("delete: " + eins);
        for (HeritagePM site : allSites) {
            if (site.getId() == eins) {
                allSites.remove(site);
                break;
            }
        }
        updateCounters();
    }


    //////////////////////////////////////  Counters  ////////////////////////////////


    public void updateCounters() {
        totalSites();
        visitedSitesCounter();
        visitedCountriesCounter();
        visitedCountriesName();
    }

    // counter total sites
    public int totalSites() {
        int counter = (int) allSites.stream()
                .count();
        System.out.println("total Sites counter: " + counter);
        setSitesCounter(counter);
        return counter;
    }

    // counter for visited sites
    public int visitedSitesCounter() {
        int counter = (int) allSites.stream()
                .filter(s -> s.isVisited())
                .count();
        System.out.println("visited Sites counter: " + counter);
        setVisitedSites(counter);
        return counter;
    }

    // counter for visited countries
    public int visitedCountriesCounter() {
        int counter = (int) allSites.stream()
                .filter(s -> s.isVisited())
                .map(v -> Arrays.asList(v.getCodeISO().split(",")))
                .flatMap(List::stream)
                .distinct()
                .count();
        System.out.println("total visited countries: " + counter);
        setVisitedCountries(counter);
        return counter;
    }

    // counter string list all visited countries
    public String visitedCountriesName() {
        String list = allSites.stream()
                .filter(s -> s.isVisited())
                .map(v -> Arrays.asList(v.getCodeISO().split(",")))
                .flatMap(List::stream)
                .distinct()
                .collect(joining(", "));
        System.out.println("list visited countries: " + list);
        setVisitedCountriesNames(list);
        return list;
    }


    //////////////////////////////////////  Table Search  ////////////////////////////////


    public Predicate<HeritagePM> createPredicate(String searchText) {
        return s -> {
            if (searchText == null || searchText.isEmpty()) return true;
            System.out.println(searchFindsOrder(s, searchText));
            return searchFindsOrder(s, searchText);
        };
    }

    public FilteredList<HeritagePM> getFilteredData() {
        return filteredData;
    }

    public void setFilteredData(FilteredList<HeritagePM> filteredData) {
        this.filteredData = filteredData;
    }

    public SortedList<HeritagePM> getSortedList() {
        return sortedList;
    }

    public void setSortedList(SortedList<HeritagePM> sortedList) {
        this.sortedList = sortedList;
    }


    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE); // adapt
    }

    static int calculate(String x, String y) {
        int[][] dp = new int[x.length() + 1][y.length() + 1];

        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1]
                                    + costOfSubstitution(x.charAt(i - 1), y.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1);
                }
            }
        }

        return dp[x.length()][y.length()];
    }

    // Contains & Fuzzy Search (only for certain fields, didn't want to check for all of them)
    private boolean searchFindsOrder(HeritagePM site, String searchText) {
        int distanceSite = calculate(site.getSite().replaceAll("\\s", "").toLowerCase(), searchText.toLowerCase().replaceAll("\\s", ""));
        int distanceState = calculate(site.getStates().replaceAll("\\s", "").toLowerCase(), searchText.toLowerCase().replaceAll("\\s", ""));
        int toleranceSite = site.getSite().length()-site.getSite().length()+4;
        int toleranceState = site.getStates().length()-site.getStates().length()+3;

        Boolean containSearch = (site.getSite().toLowerCase().contains(searchText.toLowerCase())) ||
                (site.getStates().toLowerCase().contains(searchText.toLowerCase())) ||
                (site.getLocation().toLowerCase().contains(searchText.toLowerCase())) ||
                (site.getCategory().toLowerCase().contains(searchText.toLowerCase())) ||
                Integer.valueOf(site.getId()).toString().equals(searchText.toLowerCase());

        if (distanceState < toleranceSite || distanceSite < toleranceState || containSearch ) {
            return true;
        }
        return false;
    }


    //////////////////////////////////////  Getter & Setter  ////////////////////////////////


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
        return selectedHeritageId;
    }

    public void setSelectedHeritageId(int selectedHeritageId) {
        this.selectedHeritageId.set(selectedHeritageId);
    }

    public int getVisitedSites() {
        return visitedSites.get();
    }

    public SimpleIntegerProperty visitedSitesProperty() {
        return visitedSites;
    }

    public void setVisitedSites(int visitedSites) {
        this.visitedSites.set(visitedSites);
    }

    public int getVisitedCountries() {
        return visitedCountries.get();
    }

    public SimpleIntegerProperty visitedCountriesProperty() {
        return visitedCountries;
    }

    public void setVisitedCountries(int visitedCountries) {
        this.visitedCountries.set(visitedCountries);
    }

    public String getVisitedCountriesNames() {
        return visitedCountriesNames.get();
    }

    public SimpleStringProperty visitedCountriesNamesProperty() {
        return visitedCountriesNames;
    }

    public void setVisitedCountriesNames(String visitedCountriesNames) {
        this.visitedCountriesNames.set(visitedCountriesNames);
    }

    public int getSitesCounter() {
        return sitesCounter.get();
    }

    public SimpleIntegerProperty sitesCounterProperty() {
        return sitesCounter;
    }

    public void setSitesCounter(int sitesCounter) {
        this.sitesCounter.set(sitesCounter);
    }

}


