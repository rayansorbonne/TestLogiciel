package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class VoitureTest {

    Voiture voiture;

    @BeforeEach
    void init(){
        voiture = new Voiture();
    }

    @Test
    void constructeurParDefaut(){
        assertNotNull(voiture);
        assertNull(voiture.getMarque());
        assertEquals(0, voiture.getPrix());
        assertEquals(0, voiture.getId());
    }

    @Test
    void constructeurAvecParametres(){
        Voiture v = new Voiture("Citroen", 8000);

        assertEquals("Citroen", v.getMarque());
        assertEquals(8000, v.getPrix());
    }

    @Test
    void getEtSetMarque(){
        voiture.setMarque("Renault");

        assertEquals("Renault", voiture.getMarque());
    }

    @Test
    void getEtSetPrix(){
        voiture.setPrix(12000);

        assertEquals(12000, voiture.getPrix());
    }

    @Test
    void getEtSetId(){
        voiture.setId(7);

        assertEquals(7, voiture.getId());
    }

    @Test
    void verifierToString(){
        voiture.setMarque("Renault");
        voiture.setPrix(12000);
        voiture.setId(7);

        assertEquals("Car{marque='Renault', prix=12000, id=7}", voiture.toString());
    }

}
