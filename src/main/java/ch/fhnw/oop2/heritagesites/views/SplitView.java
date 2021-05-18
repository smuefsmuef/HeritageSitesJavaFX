package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.scene.control.SplitPane;

public class SplitView extends SplitPane {
    private final WorldHeritagesPM model;

    public SplitView(WorldHeritagesPM model) {
        this.model = model;
        layoutControls();
    }

    private void layoutControls() {
        // table on the left
        TableVV left = new TableVV(model);

        // form on the right
        FormView right = new FormView(model);

        // fit both sides together
        getItems().addAll(left, right);


    }


}
