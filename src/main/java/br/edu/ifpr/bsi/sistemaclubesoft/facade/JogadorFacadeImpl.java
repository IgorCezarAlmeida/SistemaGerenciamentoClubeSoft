package br.edu.ifpr.bsi.sistemaclubesoft.facade;

import br.edu.ifpr.bsi.sistemaclubesoft.Mapper.JogadorMapper;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoResponseDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.Mapper.ContratoMapper;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.JogadorRepository;
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

    @Autowired
    private JogadorRepository jogadorRepository;

    @Override
    @Transactional
    public JogadorDetailDTO criarJogadorComContrato(JogadorRequestDTO jogadorRequestDTO, Contrato contrato) {
        Jogador jogador = this.jogadorMapper.requestDTOToEntity(jogadorRequestDTO);
        jogador.setContrato(contrato);
        if (jogador.getLesoes() != null && !jogador.getLesoes().isEmpty()) {
            jogador.getLesoes().forEach(lesao -> lesao.setJogador(jogador));
        }
        return this.jogadorMapper.entityToDetailDTO(this.jogadorRepository.save(jogador));
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
