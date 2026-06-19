package br.edu.ifpr.bsi.sistemaclubesoft.facade;

import br.edu.ifpr.bsi.sistemaclubesoft.Mapper.JogadorMapper;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoResponseDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.Mapper.ContratoMapper;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.services.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JogadorFacadeImpl implements JogadorFacade {

    @Autowired
    private JogadorMapper jogadorMapper;

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private ContratoMapper contratoMapper;

    @Override
    @Transactional
    public JogadorDetailDTO criarJogadorComContrato(JogadorRequestDTO jogadorRequestDTO, Contrato contrato) {
        // Converte request DTO para entidade
        Jogador jogador = this.jogadorMapper.requestDTOToEntity(jogadorRequestDTO);

        // vincula contrato à entidade jogador
        jogador.setContrato(contrato);

        // Cria um JogadorRequestDTO atualizado para reutilizar a lógica existente do serviço
        // Salva via JogadorService que já trata lesões e persistência
        JogadorDetailDTO jogadorSalvo = this.jogadorService.salvar(jogadorRequestDTO);

        // retornar DTO de detalhe
        return jogadorSalvo;
    }

    @Override
    @Transactional
    public JogadorDetailDTO criarJogadorComContrato(JogadorRequestDTO jogadorRequestDTO) {
        ContratoResponseDTO contratoDto = jogadorRequestDTO.contrato();
        Contrato contrato = null;
        if (contratoDto != null) {
            contrato = this.contratoMapper.toEntity(contratoDto);
        }
        return criarJogadorComContrato(jogadorRequestDTO, contrato);
    }
}
