package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticasAdversario.EstatisticasAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticasAdversario.EstatisticasAdversarioDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticasAdversario.EstatisticasAdversarioRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstatisticasAdversarioMapper {

    @Mapping(target = "codigo", ignore = true)
    @Mapping(target = "timeAdversario", source = "timeAdversarioCodigo")
    @Mapping(target = "torneio", source = "torneioCodigo")
    EstatisticasAdversario requestDTOToEntity(EstatisticasAdversarioRequestDTO requestDTO);

    @Mapping(target = "timeAdversarioCodigo", source = "timeAdversario.codigo")
    @Mapping(target = "torneioCodigo", source = "torneio.codigo")
    EstatisticasAdversarioDetailDTO entityToDetailDTO(EstatisticasAdversario estatisticasAdversario);

    default TimeAdversario mapTimeAdversario(Long codigo) {
        if (codigo == null) {
            return null;
        }
        TimeAdversario timeAdversario = new TimeAdversario();
        timeAdversario.setCodigo(codigo);
        return timeAdversario;
    }

    default Torneio mapTorneio(Long codigo) {
        if (codigo == null) {
            return null;
        }
        Torneio torneio = new Torneio();
        torneio.setCodigo(codigo);
        return torneio;
    }
}

