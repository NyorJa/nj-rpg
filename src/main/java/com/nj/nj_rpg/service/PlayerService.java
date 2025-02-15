package com.nj.nj_rpg.service;

import com.nj.nj_rpg.dto.PlayerDTO;
import com.nj.nj_rpg.bo.PlayerBO;
import com.nj.nj_rpg.mapper.PlayerMapper;
import com.nj.nj_rpg.model.Player;
import com.nj.nj_rpg.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;

    public List<PlayerBO> getAll() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(playerMapper::mapFromEntityToBo).toList();
    }

    public PlayerBO create(PlayerDTO playerDTO) {
        PlayerBO playerBO = playerMapper.mapFromDtoToBo(playerDTO);
        Player player = playerMapper.mapFromBoToEntity(playerBO);
        player = playerRepository.save(player);
        return playerMapper.mapFromEntityToBo(player);
    }

    @Scheduled(fixedRate = 5000)
    public void applyPoison() {
        List<Player> poisonedPlayers = playerRepository.findAllByIsPoisonedAndHealthGreaterThan(true, 0);
        for (Player poisonedPlayer : poisonedPlayers) {
            Integer poisonedHealth = poisonedPlayer.getHealth() - 1;
            poisonedPlayer.setHealth(poisonedHealth);
            LocalDateTime localDateTime = LocalDateTime.now();
            log.info("Player {} is poisoned current health is {}, time: {}", poisonedPlayer.getName(), poisonedHealth, localDateTime);
            if (poisonedHealth <= 0) {
                log.info("Player {} is dead", poisonedPlayer.getName());
            }
        }
        playerRepository.saveAll(poisonedPlayers);
    }
}
