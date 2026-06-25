package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.Estatisticas;
import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.EstatisticasDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.EstatisticasRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.EstatisticasSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = JogadorMapper.class)
public interface EstatisticasMapper {
	@Mapping(target = "codigo", ignore = true)
	@Mapping(target = "partida", ignore = true)
	Estatisticas requestDTOToEntity(EstatisticasRequestDTO estatisticasRequestDTO);

	EstatisticasDetailDTO entityToDetailDTO(Estatisticas estatisticas);

	EstatisticasSummaryDTO entityToSummaryDTO(Estatisticas estatisticas);
}
