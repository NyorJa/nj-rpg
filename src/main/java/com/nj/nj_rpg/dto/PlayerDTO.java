package com.nj.nj_rpg.dto;

import com.nj.nj_rpg.model.LifeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

    private String name;
    private Integer health;
    private Boolean isPoisoned;
    private LifeStatus lifeStatus;
}
