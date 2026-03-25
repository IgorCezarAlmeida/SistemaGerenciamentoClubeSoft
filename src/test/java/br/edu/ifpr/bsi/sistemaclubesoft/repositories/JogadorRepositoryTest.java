package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class JogadorRepositoryTest {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Test
    public void testInserir() {
        Jogador jogador = new Jogador();
        jogador.setNome("Jogador 1");
        jogador.setAltura(180);
        jogador.setPeso(70);
        jogador.setNumeroCamisa("10");
        jogador.setPosicao("Atacante");
        jogador.setPernaDominante("Direita");
        jogador.setDescricao("Jogador de Area para terminar as jogadas.");
        jogadorRepository.save(jogador);

        Jogador jogadorInserido = jogadorRepository.findById(jogador.getCodigo()).get();

        Assertions.assertNotNull(jogadorInserido, "O jogador não foi inserido.");
    }
}
