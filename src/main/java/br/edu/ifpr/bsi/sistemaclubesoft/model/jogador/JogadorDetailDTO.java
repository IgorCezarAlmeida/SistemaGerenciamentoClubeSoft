package br.edu.ifpr.bsi.sistemaclubesoft.model.jogador;

import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.LesaoRequestDTO;

import java.util.List;

public record JogadorDetailDTO(String nome,
                               String dataNascimento,
                               String numeroCamisa,
                               float pesoKG,
                               int alturaCM,
                               String descricao,
                               String disponivel,
                               String pernaDominante,
                               String posicao,
                               String urlFotoJogador,
                               ContratoRequestDTO contrato,
                               List<LesaoRequestDTO> lesoes
) {
}
