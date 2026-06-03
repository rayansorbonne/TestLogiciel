package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StatistiqueTests {

    StatistiqueImpl statistique;

    @BeforeEach
    void init(){
        statistique = new StatistiqueImpl();
    }

    @Test
    void moyenneAvecPlusieursVoitures(){
        statistique.ajouter(new Voiture("Renault", 10000));
        statistique.ajouter(new Voiture("Peugeot", 20000));
        statistique.ajouter(new Voiture("Citroen", 30000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(3, echantillon.getNombreDeVoitures());
        assertEquals(20000, echantillon.getPrixMoyen());
    }

    @Test
    void moyenneAvecUneVoiture(){
        statistique.ajouter(new Voiture("Renault", 15000));

        Echantillon echantillon = statistique.prixMoyen();

        assertEquals(1, echantillon.getNombreDeVoitures());
        assertEquals(15000, echantillon.getPrixMoyen());
    }

    @Test
    void moyenneSansVoiture(){
        assertThrows(ArithmeticException.class, () -> statistique.prixMoyen());
    }

}
