package com.nj.nj_rpg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nj.nj_rpg.dto.PlayerDTO;
import com.nj.nj_rpg.model.Player;
import com.nj.nj_rpg.repository.PlayerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository.save(Player.builder()
                        .name("Piolo")
                        .isPoisoned(false)
                        .health(100)
                .build());
    }

    @AfterEach
    void tearDown() {
        playerRepository.deleteAll();
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get("/player"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testCreate() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writeValueAsString(PlayerDTO.builder()
                .name("Sam")
                .isPoisoned(false)
                .health(100)
                .build());
        mockMvc.perform(post("/player")
                        .accept(MediaType.APPLICATION_JSON)
                        .content(payload)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}