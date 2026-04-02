package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.timeAdversario.TimeAdversario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class TimeAdversarioRepositoryTest {

    @Autowired
    private TimeAdversarioRepository timeAdversarioRepository;

    @Test
    public void testInserir() {
        TimeAdversario timeAdversario = new TimeAdversario();
        timeAdversario.setNome("Palmeiras");
        timeAdversario.setTecnicoAdversario("Abel Ferreira");
        timeAdversario.setPontos_fortes("Jogo Aereo");
        timeAdversario.setPontos_fracos("Lado esquerdo");
        timeAdversarioRepository.save(timeAdversario);

        TimeAdversario timeAdversarioInserido = timeAdversarioRepository.findById(timeAdversario.getCodigo()).get();

        Assertions.assertNotNull(timeAdversarioInserido, "O time Adversario não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        TimeAdversario timeAdversario = new TimeAdversario();
        timeAdversario.setNome("Palmeiras");
        timeAdversario.setTecnicoAdversario("Abel Ferreira");
        timeAdversario.setPontos_fortes("Jogo Aereo");
        timeAdversario.setPontos_fracos("Lado esquerdo");
        timeAdversarioRepository.save(timeAdversario);

        TimeAdversario timeAdversarioAlterar = timeAdversarioRepository.save(timeAdversario);

        timeAdversarioAlterar.setNome("Sociedade Esportiva Palmeiras");

        timeAdversarioAlterar = timeAdversarioRepository.save(timeAdversarioAlterar);

        TimeAdversario timeAdversarioAlterado = timeAdversarioRepository.findById(timeAdversarioAlterar.getCodigo()).get();

        Assertions.assertEquals("Sociedade Esportiva Palmeiras", timeAdversarioAlterado.getNome(), "O nome do time Adversario não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        TimeAdversario timeAdversario = new TimeAdversario();
        timeAdversario.setNome("Palmeiras");
        timeAdversario.setTecnicoAdversario("Abel Ferreira");
        timeAdversario.setPontos_fortes("Jogo Aereo");
        timeAdversario.setPontos_fracos("Lado esquerdo");
        timeAdversarioRepository.save(timeAdversario);
        TimeAdversario timeAdversarioDeletar = timeAdversarioRepository.save(timeAdversario);
        timeAdversarioRepository.delete(timeAdversarioDeletar);

        TimeAdversario timeAdversarioDeletado = timeAdversarioRepository.findById(timeAdversario.getCodigo()).orElse(null);
        Assertions.assertNotNull(timeAdversarioDeletado,"O time Adversario ainda se encontra no banco.");
    }

    @Test
    public void testBuscarNome(){
        TimeAdversario timeAdversario = new TimeAdversario();
        timeAdversario.setNome("Palmeiras");
        timeAdversario.setTecnicoAdversario("Abel Ferreira");
        timeAdversario.setPontos_fortes("Jogo Aereo");
        timeAdversario.setPontos_fracos("Lado esquerdo");
        timeAdversarioRepository.save(timeAdversario);

        timeAdversarioRepository.save(timeAdversario);

        List<TimeAdversario> timesAdversarios = timeAdversarioRepository.findByNome("Palmeiras");
        Assertions.assertFalse(timesAdversarios.isEmpty(),"Time Adversario não encontrado.");
    }
}
