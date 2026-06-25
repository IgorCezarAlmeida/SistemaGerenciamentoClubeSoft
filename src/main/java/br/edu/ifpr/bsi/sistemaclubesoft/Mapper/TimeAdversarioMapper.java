package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversarioDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversarioRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TimeAdversarioMapper {

  @Mapping(target = "codigo", ignore = true)
  @Mapping(target = "partidas", ignore = true)
  @Mapping(target = "pontos_fortes", source = "pontosFortes")
  @Mapping(target = "pontos_fracos", source = "pontosFracos")
    TimeAdversario requestDTOToEntity(TimeAdversarioRequestDTO timeAdversarioRequestDTO);

    @Mapping(target = "pontosFortes", source = "pontos_fortes")
    @Mapping(target = "pontosFracos", source = "pontos_fracos")
    TimeAdversarioDetailDTO entityToDetailDTO(TimeAdversario timeAdversario);
}

