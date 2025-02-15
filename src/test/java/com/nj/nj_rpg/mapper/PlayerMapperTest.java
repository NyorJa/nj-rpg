package com.nj.nj_rpg.mapper;

import com.nj.nj_rpg.bo.PlayerBO;
import com.nj.nj_rpg.model.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlayerMapperTest {

    private PlayerMapper playerMapper;

    @BeforeEach
    void setUp() {
        playerMapper = new PlayerMapperImpl();
    }

    @AfterEach
    void tearDown() {
        playerMapper = null;
    }

    @Test
    void testMapping() {
        String name = "Piolo Pascual";
        PlayerBO playerBO = playerMapper.mapFromEntityToBo(Player.builder()
                        .name(name)
                .build());

        Assertions.assertThat(playerBO.getName()).isEqualTo(name);
    }
}