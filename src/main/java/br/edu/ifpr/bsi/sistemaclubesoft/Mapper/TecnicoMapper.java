package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico.Tecnico;
import br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico.TecnicoDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico.TecnicoRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TecnicoMapper {
	Tecnico requestDTOToEntity(TecnicoRequestDTO tecnicoRequestDTO);

	TecnicoDetailDTO entityToDetailDTO(Tecnico tecnico);
}
