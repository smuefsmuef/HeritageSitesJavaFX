package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.SplitPane;

// Splitpane is containing 2 panels, a left and a right one.
// left: vbox, list
// right: vbox, form field


public class SplitUI extends SplitPane {
    private final PM model;

    public SplitUI(PM model) {
        this.model = model;
        layoutControls();
    }


    private void layoutControls() {
        // links --> über neues UI lösen
        ListApplicationUI left = new ListApplicationUI(model);

        // rechts --> über neues UI lösen
        FormApplicationUI right = new FormApplicationUI(model);

        // fit both sides together
        getItems().addAll(left, right);


    }


}
