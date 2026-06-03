package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StatistiqueTests {

    @Test
    void prixMoyenSansVoiture(){
        StatistiqueImpl statistique = new StatistiqueImpl();

        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }

    @Test
    void prixMoyen(){
        StatistiqueImpl statistique = new StatistiqueImpl();
        statistique.ajouter(new Voiture("Renault", 10000));
        statistique.ajouter(new Voiture("Peugeot", 20000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(2, echantillon.getNombreDeVoitures());
        assertEquals(15000, echantillon.getPrixMoyen());
    }

}
