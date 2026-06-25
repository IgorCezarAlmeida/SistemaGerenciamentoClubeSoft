package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    @Mapping(target = "codigo", ignore = true)
    Contrato toEntity(ContratoRequestDTO dto);

    Contrato toEntity(ContratoResponseDTO dto);

    ContratoRequestDTO toRequestDto(Contrato contrato);

    ContratoResponseDTO toDto(Contrato contrato);
}
