package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.scene.control.SplitPane;

public class SplitView extends SplitPane {
    private final WorldHeritagesPM model;
    TableVV left;
    FormView right;
    StarterView rightInitialView;


    public SplitView(WorldHeritagesPM model) {
        this.model = model;
        layoutControls();
        setupValueChangedListeners();

    }

    private void layoutControls() {
        // table on the right
        rightInitialView = new StarterView(model);
        right = new FormView(model);

        // table on the left
        left = new TableVV(model);

        // fyi: some part of the layout controls were moved to the changeListener to enable the starter page
    }


    private void setupValueChangedListeners() {
        HeritagePM proxy = model.getHeritageProxy();
        getItems().addAll(left, rightInitialView);
        proxy.idProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.intValue() == 0) {
                getItems().addAll(right);
            }
            getItems().remove(this.rightInitialView);
        });
    }

}


