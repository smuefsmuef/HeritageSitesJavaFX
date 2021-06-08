package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.scene.control.SplitPane;

public class SplitView extends SplitPane implements ViewMixin{
    private final WorldHeritagesPM model;
    private TableVV left;
    private FormView right;
    private StarterView rightInitialView;

    public SplitView(WorldHeritagesPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        // table on the right
        rightInitialView = new StarterView(model);
        right = new FormView(model);

        // table on the left
        left = new TableVV(model);
    }

    @Override
    public void layoutControls() {
        getItems().addAll(left, rightInitialView);
    }

    @Override
    public void setupValueChangedListeners() {
        HeritagePM proxy = model.getHeritageProxy();
        proxy.idProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.intValue() == 0) {
                getItems().addAll(right);
            }
            getItems().remove(this.rightInitialView);
        });
    }

}


