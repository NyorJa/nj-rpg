package com.nj.nj_rpg.bo;

import com.nj.nj_rpg.model.LifeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerBO {
    private Long id;
    private String name;
    private Integer health;
    private Boolean isPoisoned;
    private LifeStatus lifeStatus;
}
