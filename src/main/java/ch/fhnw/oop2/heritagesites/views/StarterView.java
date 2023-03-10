package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.WorldHeritagesPM;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StarterView extends BorderPane implements ViewMixin {
    private final WorldHeritagesPM model;
    private String icon = getClass().getResource("/data/info.png").toString();
    private BackgroundImage myBI;
    private Label petra;
    private Label title;

    public StarterView(WorldHeritagesPM model) {
        this.model = model;
        init();
    }

    @Override
    public void initializeControls() {
        myBI = new BackgroundImage(new Image(icon, 350, 350, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);

        petra = new Label("Petra Kohler - FS2021");
        title = new Label("World Heritage Site FX");
    }

    @Override
    public void layoutControls() {
        title.setId("infoTitle");
        setAlignment(title, Pos.BOTTOM_CENTER);
        setBottom(title);

        petra.setId("infoPetra");
        setAlignment(petra, Pos.TOP_CENTER);
        setTop(petra);

        setBackground(new Background(myBI));
    }

}
