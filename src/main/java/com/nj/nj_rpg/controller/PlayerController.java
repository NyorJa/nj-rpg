package com.nj.nj_rpg.controller;

import com.nj.nj_rpg.bo.PlayerBO;
import com.nj.nj_rpg.dto.PlayerDTO;
import com.nj.nj_rpg.mapper.PlayerMapper;
import com.nj.nj_rpg.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @GetMapping
    public List<PlayerDTO> getAll() {
        return playerService.getAll().stream().map(playerMapper::mapFromBoToDTO).toList();
    }

    @PostMapping
    public PlayerDTO create(@RequestBody PlayerDTO playerDTO) {
        PlayerBO playerBO = playerService.create(playerDTO);
        return playerMapper.mapFromBoToDTO(playerBO);
    }
}
