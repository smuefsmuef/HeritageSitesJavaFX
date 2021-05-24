package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.scene.layout.*;

public class ApplicationUI extends BorderPane {
    private final WorldHeritagesPM model;
    private SplitView split;
    private HeaderView top;
    private HBox bottom;

    public ApplicationUI(WorldHeritagesPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
    }

    private void initializeSelf() {
        // css file in app starter, will be universal for all UI
    }

    private void initializeControls() {
        top = new HeaderView(model);
        split = new SplitView(model);
        bottom = new FooterView(model);
    }

    private void layoutControls() {
        setTop(top);
        setCenter(split);
        setBottom(bottom);
    }
}