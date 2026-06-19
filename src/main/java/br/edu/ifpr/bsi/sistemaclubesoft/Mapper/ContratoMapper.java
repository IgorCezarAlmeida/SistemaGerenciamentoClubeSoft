package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import org.mapstruct.Mapper;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoResponseDTO;

@Mapper(componentModel = "spring")
public interface ContratoMapper {
    Contrato toEntity(ContratoResponseDTO dto);

    ContratoResponseDTO toDto(Contrato contrato);
}
