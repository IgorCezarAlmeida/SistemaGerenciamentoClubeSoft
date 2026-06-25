package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.LesaoRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.LesaoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LesaoMapper {

    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "jogador", ignore = true)
    Lesao requestDTOEntity(LesaoRequestDTO lesaoRequestDTO);

    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "jogador", ignore = true)
    @Mapping(target = "observacaoDP", source = "ObservacaoDP")
    @Mapping(target = "previsaoRetorno", source = "PrevisaoRetorno")
    Lesao responseDTOToEntity(LesaoResponseDTO lesaoResponseDTO);

    LesaoRequestDTO entityToSummaryDTO(Lesao lesao);

    @Mapping(target = "ObservacaoDP", source = "observacaoDP")
    @Mapping(target = "PrevisaoRetorno", source = "previsaoRetorno")
    LesaoResponseDTO entityToResponseDTO(Lesao lesao);
}
