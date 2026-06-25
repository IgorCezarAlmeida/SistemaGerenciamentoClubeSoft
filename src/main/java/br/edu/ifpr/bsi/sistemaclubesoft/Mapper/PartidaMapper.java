package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.PartidaDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.PartidaRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PartidaMapper {

    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "estatisticas", ignore = true)
    @Mapping(target = "torneio", source = "torneioCodigo")
    @Mapping(target = "timeAdversario", source = "timeAdversarioCodigo")
    Partida requestDTOToEntity(PartidaRequestDTO partidaRequestDTO);

    @Mapping(target = "torneioCodigo", source = "torneio.codigo")
    @Mapping(target = "timeAdversarioCodigo", source = "timeAdversario.codigo")
    PartidaDetailDTO entityToDetailDTO(Partida partida);

    default Torneio mapTorneio(Long codigo) {
        if (codigo == null) {
            return null;
        }
        Torneio torneio = new Torneio();
        torneio.setCodigo(codigo);
        return torneio;
    }

    default TimeAdversario mapTimeAdversario(Long codigo) {
        if (codigo == null) {
            return null;
        }
        TimeAdversario timeAdversario = new TimeAdversario();
        timeAdversario.setCodigo(codigo);
        return timeAdversario;
    }
}

