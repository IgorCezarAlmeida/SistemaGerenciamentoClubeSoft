package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorSummaryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {LesaoMapper.class, ContratoMapper.class, EstatisticasMapper.class})
public interface JogadorMapper {

    Jogador requestDTOToEntity(JogadorRequestDTO jogadorRequestDTO);

    JogadorDetailDTO entityToDetailDTO(Jogador jogador);

    JogadorSummaryDTO entityToSummaryDTO(Jogador jogador);
}
