package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.scene.control.SplitPane;

// Splitpane is containing 2 panels, a left and a right one.
// left: vbox, list
// right: vbox, form field


public class SplitView extends SplitPane {
    private final WorldHeritagesPM model;

    public SplitView(WorldHeritagesPM model) {
        this.model = model;
        layoutControls();
    }


    private void layoutControls() {
        // links --> über neues UI lösen
        TableView left = new TableView(model);

        // rechts --> über neues UI lösen
        FormView right = new FormView(model);

        // fit both sides together
        getItems().addAll(left, right);


    }


}
