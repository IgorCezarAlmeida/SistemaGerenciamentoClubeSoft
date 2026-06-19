package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.LesaoRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LesaoMapper {

    Lesao requestDTOEntity(LesaoRequestDTO lesaoRequestDTO);

    LesaoRequestDTO entityToSummaryDTO(Lesao lesao);
}
