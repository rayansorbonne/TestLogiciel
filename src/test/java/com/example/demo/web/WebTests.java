package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getStatistiqueOk() throws Exception {
        Echantillon echantillon = new Echantillon(2, 15000);
        when(statistiqueImpl.prixMoyen()).thenReturn(echantillon);

        mockMvc.perform(get("/statistique").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(2))
                .andExpect(jsonPath("$.prixMoyen").value(15000));
    }

    @Test
    void getStatistiqueSansVoiture() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenThrow(new ArithmeticException());

        mockMvc.perform(get("/statistique").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void mauvaiseUrl() throws Exception {
        mockMvc.perform(get("/mauvaise-url").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void creerVoiture() throws Exception {
        String json = "{\"marque\":\"Renault\",\"prix\":10000}";

        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(statistiqueImpl, times(1)).ajouter(any(Voiture.class));
    }

}
