package ch.fhnw.oop2.heritagesites.presentationModels;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.*;

public class PM {
    private final StringProperty applicationTitle = new SimpleStringProperty("World Heritage Sites");
    private final StringProperty  spalte1      = new SimpleStringProperty();
    private final StringProperty  spalte2   = new SimpleStringProperty();

    private final ObservableList<PM> alleResultate = FXCollections.observableArrayList();




    public ObservableList<PM> getAlleResultate() {
        return alleResultate;
    }


    /// Getter & Setter

    // app title, ok
    public String getApplicationTitle() {
        return applicationTitle.get();
    }
    public StringProperty applicationTitleProperty() {
        return applicationTitle;
    }
    public void setApplicationTitle(String applicationTitle) {
        this.applicationTitle.set(applicationTitle);
    }

    public String getSpalte1() {
        return spalte1.get();
    }
    public StringProperty spalte1Property() {
        return spalte1;
    }
    public void setSpalte1(String spalte1) {
        this.spalte1.set(spalte1);
    }

    public String getSpalte2() {
        return spalte2.get();
    }
    public StringProperty spalte2Property() {
        return spalte2;
    }
    public void setSpalte2(String spalte2) {
        this.spalte2.set(spalte2);
    }
}


