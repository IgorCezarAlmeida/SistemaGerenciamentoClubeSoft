package br.edu.ifpr.bsi.sistemaclubesoft.Mapper;

import br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao.Escalacao;
import br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao.EscalacaoDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao.EscalacaoRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EscalacaoMapper {

	@Mapping(target = "codigo", ignore = true)
	@Mapping(target = "partida", source = "partidaCodigo")
	@Mapping(target = "istrucoes", source = "instrucoes")
	Escalacao requestDTOToEntity(EscalacaoRequestDTO escalacaoRequestDTO);

	@Mapping(target = "partidaCodigo", source = "partida.codigo")
	@Mapping(target = "instrucoes", source = "istrucoes")
	EscalacaoDetailDTO entityToDetailDTO(Escalacao escalacao);

	default Partida map(Long codigo) {
		if (codigo == null) {
			return null;
		}
		Partida partida = new Partida();
		partida.setCodigo(codigo);
		return partida;
	}
}
