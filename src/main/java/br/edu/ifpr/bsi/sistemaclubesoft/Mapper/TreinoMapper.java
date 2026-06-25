package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.treino.Treino;
import br.edu.ifpr.bsi.sistemaclubesoft.model.treino.TreinoDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.treino.TreinoRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TreinoMapper {
	@Mapping(target = "codigo", ignore = true)
	Treino requestDTOToEntity(TreinoRequestDTO treinoRequestDTO);

	TreinoDetailDTO entityToDetailDTO(Treino treino);
}
