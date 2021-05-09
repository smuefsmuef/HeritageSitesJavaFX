package ch.fhnw.oop2.heritagesites.presentationModels;

import ch.fhnw.oop2.heritagesites.DemoClass;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PMTest {


    @Test
    void testHelloWorld(){
        DemoClass demo = new DemoClass();
        assertEquals("Hello World", demo.helloWorld());
    }

    private PM gesamt;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        gesamt = new PM();
    }

    @Test
    void testGetResulate() {
        //given
        ObservableList<HeritagePM> resulate = gesamt.getAllSites();

        //then
        assertTrue(resulate.size() > 1);
      //  assertEquals("Aeugst am Albis"    , resulate.get(0).getCategory());
        // assertEquals("GE-CH de l'étranger", resulate.get(resulate.size() - 1).getCategory());
    }

//
//    @Test
//    void testSave() {
//        //given
//
//        //when
//        gesamt.getAllSites().get(0).setCategory("NN");
//        gesamt.save();
//
//        PM secondPM = new PM();
//
//        //then
//        assertEquals(gesamt.getAllSites().size(), secondPM.getAllSites().size());
//        assertEquals("NN", secondPM.getAllSites().get(0).getCategory());
//
//        for (int i = 1; i < gesamt.getAllSites().size(); i++) {
//            assertEquals(gesamt.getAllSites().get(i).getCategory(), secondPM.getAllSites().get(i).getCategory());
//        }
//
//        //after
//        gesamt.getAllSites().get(0).setCategory("Aliens");
//        gesamt.save();
//    }
//

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