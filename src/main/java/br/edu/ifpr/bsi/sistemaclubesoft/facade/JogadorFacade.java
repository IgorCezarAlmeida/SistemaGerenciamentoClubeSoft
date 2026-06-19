package br.edu.ifpr.bsi.sistemaclubesoft.facade;

import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;

public interface JogadorFacade {

    /**
     * Cria um jogador a partir do request DTO e de um Contrato já construído.
     */
    JogadorDetailDTO criarJogadorComContrato(JogadorRequestDTO jogadorRequestDTO, Contrato contrato);

    /**
     * Cria um jogador a partir do request DTO que já contém dados do contrato (campo contrato em JogadorRequestDTO).
     */
    JogadorDetailDTO criarJogadorComContrato(JogadorRequestDTO jogadorRequestDTO);

}
