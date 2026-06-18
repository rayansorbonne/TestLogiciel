package com.example.demo.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EchantillonTest {

    @Test
    void creerEchantillon(){
        Echantillon echantillon = new Echantillon(5, 12000);

        assertEquals(5, echantillon.getNombreDeVoitures());
        assertEquals(12000, echantillon.getPrixMoyen());
    }

    @Test
    void modifierEchantillon(){
        Echantillon echantillon = new Echantillon();
        echantillon.setNombreDeVoitures(3);
        echantillon.setPrixMoyen(8000);

        assertEquals(3, echantillon.getNombreDeVoitures());
        assertEquals(8000, echantillon.getPrixMoyen());
    }

}
