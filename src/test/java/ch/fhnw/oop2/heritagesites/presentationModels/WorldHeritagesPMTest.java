package ch.fhnw.oop2.heritagesites.presentationModels;

import ch.fhnw.oop2.heritagesites.DemoClass;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class WorldHeritagesPMTest {


    @Test
    void testHelloWorld() {
        DemoClass demo = new DemoClass();
        assertEquals("Hello World", demo.helloWorld());
    }

    private WorldHeritagesPM gesamt;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        gesamt = new WorldHeritagesPM();
    }

    @Test
    void testGetResulate() {
        //given
        ObservableList<HeritagePM> resulate = gesamt.getAllSites();

        //then
        assertTrue(resulate.size() > 1);
        assertEquals("Natural", resulate.get(0).getCategory());
        assertEquals("Natural", resulate.get(resulate.size() - 1).getCategory());
        assertEquals(154, resulate.get(0).getId());
        assertEquals("Australia", resulate.get(0).getStates());
        assertEquals("Great Barrier Reef", resulate.get(0).getSite());
    }


    @Test
    void testSave() throws FileNotFoundException {
        //given
        //
        // todo: fix test for save method

        //when
        gesamt.getAllSites().get(0).setCategory("No Category");
        gesamt.save();

        WorldHeritagesPM secondWorldHeritagesPM = new WorldHeritagesPM();

        //then
        assertEquals(gesamt.getAllSites().size(), secondWorldHeritagesPM.getAllSites().size());
        assertEquals("Natural", secondWorldHeritagesPM.getAllSites().get(0).getCategory());

        for (int i = 1; i < gesamt.getAllSites().size(); i++) {
            assertEquals(gesamt.getAllSites().get(i).getCategory(), secondWorldHeritagesPM.getAllSites().get(i).getCategory());
        }

        //after
        gesamt.getAllSites().get(0).setCategory("Aliens");
       gesamt.save();
        //then
        assertEquals("Natural", secondWorldHeritagesPM.getAllSites().get(0).getCategory());
    }


    @Test
    void getApplicationTitle() {
    }

    @Test
    void applicationTitleProperty() {
    }

    @Test
    void getAllSites() {
    }
}