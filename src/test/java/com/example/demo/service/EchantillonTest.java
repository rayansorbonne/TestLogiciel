package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EchantillonTest {

    Echantillon echantillon;

    @BeforeEach
    void init(){
        echantillon = new Echantillon();
    }

    @Test
    void constructeurAvecParametres(){
        Echantillon e = new Echantillon(4, 9000);

        assertEquals(4, e.getNombreDeVoitures());
        assertEquals(9000, e.getPrixMoyen());
    }

    @Test
    void getEtSetNombreDeVoitures(){
        echantillon.setNombreDeVoitures(6);

        assertEquals(6, echantillon.getNombreDeVoitures());
    }

    @Test
    void getEtSetPrixMoyen(){
        echantillon.setPrixMoyen(13000);

        assertEquals(13000, echantillon.getPrixMoyen());
    }

}
