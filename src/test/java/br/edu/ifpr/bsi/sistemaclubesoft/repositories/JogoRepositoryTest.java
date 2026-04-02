package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.jogo.Jogo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class JogoRepositoryTest {
    @Autowired
    private JogoRepository jogoRepository;


    @Test
    public void testInserir() {
        Jogo jogo = new Jogo();
        jogo.setMandoDeCampo("Casa");
        jogo.setResultadoFinal("1 X 0");
        jogoRepository.save(jogo);

        Jogo jogoInserido = jogoRepository.findById(jogo.getCodigo()).get();

        Assertions.assertNotNull(jogoInserido, "O Jogo não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        Jogo jogo = new Jogo();
        jogo.setMandoDeCampo("Casa");
        jogo.setResultadoFinal("1 X 0");

        Jogo jogoAlterar = jogoRepository.save(jogo);

        jogoAlterar.setMandoDeCampo("Fora");

        jogoAlterar = jogoRepository.save(jogoAlterar);

        Jogo jogoAlterado = jogoRepository.findById(jogoAlterar.getCodigo()).get();

        Assertions.assertEquals("Fora", jogoAlterado.getMandoDeCampo(), "O Mando do jogo não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Jogo jogo = new Jogo();
        jogo.setMandoDeCampo("Casa");
        jogo.setResultadoFinal("1 X 0");
        Jogo jogoDeletar = jogoRepository.save(jogo);
        jogoRepository.delete(jogoDeletar);

        Jogo jogoDeletado = jogoRepository.findById(jogo.getCodigo()).orElse(null);
        Assertions.assertNotNull(jogoDeletado,"O jogo ainda se encontra no banco.");
    }

    @Test
    public void testBuscarMandoDeCampo() {
        Jogo jogo = new Jogo();
        jogo.setMandoDeCampo("Casa");
        jogo.setResultadoFinal("1 X 0");

        jogoRepository.save(jogo);

        List<Jogo> jogos = jogoRepository.findByMandoDeCampo("Casa");
        Assertions.assertFalse(jogos.isEmpty(),"Jogo não encontrado.");
    }
}
