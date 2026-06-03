package com.example.demo.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture voiture = new Voiture("Renault", 15000);

        assertEquals("Renault", voiture.getMarque());
        assertEquals(15000, voiture.getPrix());
    }

    @Test
    void modifierVoiture(){
        Voiture voiture = new Voiture();
        voiture.setMarque("Peugeot");
        voiture.setPrix(20000);
        voiture.setId(1);

        assertEquals("Peugeot", voiture.getMarque());
        assertEquals(20000, voiture.getPrix());
        assertEquals(1, voiture.getId());
    }

}
