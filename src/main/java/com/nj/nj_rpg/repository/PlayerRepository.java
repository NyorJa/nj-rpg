package com.nj.nj_rpg.repository;

import com.nj.nj_rpg.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByIsPoisonedAndHealthGreaterThan(Boolean isPoisoned, Integer health);
}
