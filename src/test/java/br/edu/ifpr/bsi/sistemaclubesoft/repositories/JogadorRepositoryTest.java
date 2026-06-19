package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class JogadorRepositoryTest {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Test
    public void testInserir() {
        Jogador jogador = new Jogador();
        jogador.setNome("Jogador 1");
        jogador.setAlturaCM(180);
        jogador.setPesoKG(70);
        jogador.setNumeroCamisa("10");
        jogador.setPosicao("Atacante");
        jogador.setPernaDominante("Direita");
        jogador.setDescricao("Jogador de Area para terminar as jogadas.");
        jogadorRepository.save(jogador);

        Jogador jogadorInserido = jogadorRepository.findById(jogador.getCodigo()).get();

        Assertions.assertNotNull(jogadorInserido, "O jogador não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        Jogador jogador = new Jogador();
        jogador.setNome("Jogador 1");
        jogador.setAlturaCM(180);
        jogador.setPesoKG(70);
        jogador.setNumeroCamisa("10");
        jogador.setPosicao("Atacante");
        jogador.setPernaDominante("Direita");
        jogador.setDescricao("Jogador experiente");

        Jogador jogadorAlterar = jogadorRepository.save(jogador);

        jogadorAlterar.setNome("Igor Cezar");

        jogadorAlterar = jogadorRepository.save(jogadorAlterar);

        Jogador jogadorAlterado = jogadorRepository.findById(jogadorAlterar.getCodigo()).get();

        Assertions.assertEquals("Igor Cezar", jogadorAlterado.getNome(), "O nome do jogador não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Jogador jogador = new Jogador();
        jogador.setNome("Jogador 1");
        jogador.setAlturaCM(180);
        Jogador jogadorDeletar = jogadorRepository.save(jogador);
        jogadorRepository.delete(jogadorDeletar);

        Jogador jogadorDeletado = jogadorRepository.findById(jogador.getCodigo()).orElse(null);
        Assertions.assertNotNull(jogadorDeletado,"O jogador ainda se encontra no banco.");
    }

    @Test
    public void testBuscarNome(){
        Jogador jogador = new Jogador();
        jogador.setNome("Igor");
        jogador.setPosicao("Atacante");

        jogadorRepository.save(jogador);

        List<Jogador> jogadores = jogadorRepository.findByNome("Igor");
        Assertions.assertFalse(jogadores.isEmpty(),"Jogador não encontrado.");
    }

    @Test
    public void testInserirLesao(){
        Jogador jogador = new Jogador();
        jogador.setNome("Igor");
        jogador.setPosicao("Atacante");

        List<Lesao> lesoes = new ArrayList<>();
        Lesao lesao = new Lesao();
        lesao.setTipoLesao("Estiramento muscular");
        lesao.setGravidade("Leve");
        lesao.setInicio("22/02/2026");
        lesao.setObservacaoDP("Recuperação em cerca de uma semana.");
        lesao.setPrevisaoRetorno("29/02/2026");
        lesoes.add(lesao);

        jogador.setLesoes(lesoes);
        Jogador jogadorInserir = jogadorRepository.save(jogador);
        Jogador jogadorInserido = jogadorRepository.findById(jogadorInserir.getCodigo()).get();
        Assertions.assertNotNull(jogadorInserido.getLesoes());
        Assertions.assertFalse(jogadorInserido.getLesoes().isEmpty(), "As lesoes do jogador não foram inseridas corretamente.");

    }
}
