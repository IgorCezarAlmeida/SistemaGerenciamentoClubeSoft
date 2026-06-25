package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorResponseDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorSummaryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {LesaoMapper.class, ContratoMapper.class, EstatisticasMapper.class})
public interface JogadorMapper {

    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "urlFotoJogador", ignore = true)
    Jogador requestDTOToEntity(JogadorRequestDTO jogadorRequestDTO);

    JogadorDetailDTO entityToDetailDTO(Jogador jogador);

    JogadorResponseDTO entityToResponseDTO(Jogador jogador);

    JogadorSummaryDTO entityToSummaryDTO(Jogador jogador);
}
