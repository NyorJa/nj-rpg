package com.nj.nj_rpg.mapper;

import com.nj.nj_rpg.dto.PlayerDTO;
import com.nj.nj_rpg.bo.PlayerBO;
import com.nj.nj_rpg.model.LifeStatus;
import com.nj.nj_rpg.model.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    @Mappings({
            @Mapping(source = "health", target = "lifeStatus", qualifiedByName = "buildStatus")
    })
    PlayerBO mapFromDtoToBo(PlayerDTO playerDTO);
    PlayerBO mapFromEntityToBo(Player player);
    Player mapFromBoToEntity(PlayerBO playerBO);
    @Mappings({
            @Mapping(source = "health", target = "lifeStatus", qualifiedByName = "buildStatus")
    })
    PlayerDTO mapFromBoToDTO(PlayerBO playerBO);

    @Named("buildStatus")
    default LifeStatus buildStatus(Integer health) {
        return health >0 ? LifeStatus.ALIVE : LifeStatus.DEAD;
    }
}
