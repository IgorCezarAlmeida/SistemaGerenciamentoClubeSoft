package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.TorneioDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.TorneioRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TorneioMapper {
  @Mapping(target = "codigo", ignore = true)
  @Mapping(target = "partidas", ignore = true)
  @Mapping(target = "estatisticasAdversarios", ignore = true)
    Torneio requestDTOToEntity(TorneioRequestDTO torneioRequestDTO);

    TorneioDetailDTO entityToDetailDTO(Torneio torneio);
}

