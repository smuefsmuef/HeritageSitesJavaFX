package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.scene.layout.*;

public class ApplicationUI extends BorderPane implements ViewMixin {
    private final WorldHeritagesPM model;
    private SplitView split;
    private HeaderView top;
    private HBox bottom;

    public ApplicationUI(WorldHeritagesPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeSelf() {
        String path = this.getClass().getResource("/data/style.css").toExternalForm();
        getStylesheets().add(path);
    }

    @Override
    public void initializeControls() {
        top = new HeaderView(model);
        split = new SplitView(model);
        bottom = new FooterView(model);
    }

    @Override
    public void layoutControls() {
        setTop(top);
        setCenter(split);
        setBottom(bottom);
    }

}