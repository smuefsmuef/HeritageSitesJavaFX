package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.PM;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class BorderUI extends BorderPane {
    private final PM model;
    private  SplitUI split;

    private Button topButton;
    private Button   bottomButton;
    private Button   leftButton;
    private Button   rightButton;
    private TextArea textArea;

    public BorderUI(PM model) {
        this.model = model;
        initializeControls();
        layoutControls();
    }

    private void initializeControls() {
        topButton    = new Button("top");
        bottomButton = new Button("bottom");
        leftButton   = new Button("left");
        rightButton  = new Button("right");
        textArea     = new TextArea();
        split = new SplitUI(model);
    }

    private void layoutControls() {
        topButton.setMaxWidth(Double.MAX_VALUE);
        bottomButton.setMaxWidth(Double.MAX_VALUE);

        setMargin(topButton   , new Insets(5));
        setMargin(bottomButton, new Insets(5));
        setMargin(leftButton  , new Insets(0, 5, 0, 5));
        setMargin(rightButton , new Insets(0, 5, 0, 5));

        setTop(topButton);

        setBottom(bottomButton);
        // setCenter(textArea);
        setCenter(split);
    }

}
