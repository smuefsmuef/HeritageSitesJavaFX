package ch.fhnw.oop2.heritagesites.views;

import ch.fhnw.oop2.heritagesites.presentationModels.HeritagePM;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public class SiteTableCell extends TableCell<HeritagePM, Boolean> {
    private static final Map<Boolean, Image> YES = new HashMap<>();
    private static final Insets INSETS = new Insets(1, 8, 1, 5);
    private static final String yes = "/data/yes.png";

    @Override
    protected void updateItem(Boolean item, boolean empty) {
        setText("");
        setGraphic(null);
        if (!empty) {
            Image img = YES.get(item);
            if (item.booleanValue() == true) {
                img = new Image(getClass().getResource(yes)
                        .toExternalForm(), 18, 18, true, true, true);
                YES.put(item, img);
            }

            ImageView imageView = new ImageView(img);
            setGraphic(imageView);
            setTooltip(new Tooltip("Yes! I visted the site"));
            setAlignment(Pos.CENTER);
            setPadding(INSETS);
        }

    }


}
