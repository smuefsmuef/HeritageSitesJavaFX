package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.*;

public class HeritagePM {

    private final StringProperty category = new SimpleStringProperty();
    private final StringProperty dateInscribed = new SimpleStringProperty();
    private final IntegerProperty  id = new SimpleIntegerProperty();
    private final StringProperty imgageURL = new SimpleStringProperty();
    private final StringProperty codeISO = new SimpleStringProperty();
    private final StringProperty location = new SimpleStringProperty();
    private final StringProperty region = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final StringProperty site = new SimpleStringProperty();
    private final StringProperty states = new SimpleStringProperty();
    private final BooleanProperty visited = new SimpleBooleanProperty();


    public HeritagePM() { // set some default values to get an empty title in the start of the applciation
        setSite("");
        setDateInscribed("");
    }

//    // todo add the rest...maybe
//    public HeritagePM(String site, String date, String category, String location, int id ) {
//        setVisited(false); // default
//        setCategory(category); // name from formfield
//        setLocation(location); // name from formfield
//        setSite(site); // name from formfield
//        setDateInscribed(date); // name from formfield
//        setId(id); // fortlaufend
//    }


    public HeritagePM(String[] line) {
        setCategory(line[0]);
        setDateInscribed(line[1]);
        setId(Integer.parseInt(line[2]));
        setImgageURL(line[3]);
        setCodeISO(line[4]);
        setLocation(line[5]);
        setRegion(line[6]);
        setDescription(line[7]);
        setSite(line[8]);
        setStates(line[9]);
        setVisited(Boolean.parseBoolean("false")); // default wert
    }

    public String infoAsLine(String delimiter) {
        return String.join(delimiter,
                getCategory(),
                getDateInscribed(),
                Integer.toString(getId()),
                getImgageURL(),
                getCodeISO(),
                getLocation(),
                getRegion(),
                getDescription(),
                getSite(),
                getStates(),
                Boolean.toString(isVisited())
        );
    }

    // getter & setter

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getDateInscribed() {
        return dateInscribed.get();
    }

    public StringProperty dateInscribedProperty() {
        return dateInscribed;
    }

    public void setDateInscribed(String dateInscribed) {
        this.dateInscribed.set(dateInscribed);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getImgageURL() {
        return imgageURL.get();
    }

    public StringProperty imgageURLProperty() {
        return imgageURL;
    }

    public void setImgageURL(String imgageURL) {
        this.imgageURL.set(imgageURL);
    }

    public String getCodeISO() {
        return codeISO.get();
    }

    public StringProperty codeISOProperty() {
        return codeISO;
    }

    public void setCodeISO(String codeISO) {
        this.codeISO.set(codeISO);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public String getRegion() {
        return region.get();
    }

    public StringProperty regionProperty() {
        return region;
    }

    public void setRegion(String region) {
        this.region.set(region);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getSite() {
        return site.get();
    }

    public StringProperty siteProperty() {
        return site;
    }

    public void setSite(String site) {
        this.site.set(site);
    }

    public String getStates() {
        return states.get();
    }

    public StringProperty statesProperty() {
        return states;
    }

    public void setStates(String states) {
        this.states.set(states);
    }

    public Boolean isVisited() {
        return visited.get();
    }

    public BooleanProperty visitedProperty() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited.set(visited);
    }

}
