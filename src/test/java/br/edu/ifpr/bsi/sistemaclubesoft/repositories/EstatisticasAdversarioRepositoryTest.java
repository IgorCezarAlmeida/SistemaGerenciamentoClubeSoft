package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticasAdversario.EstatisticasAdversario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class EstatisticasAdversarioRepositoryTest {

    @Autowired
    private EstatisticasAdversarioRepository estatisticasAdversarioRepository;

    @Test
    public void testInserir() {
        EstatisticasAdversario estatisticasAdversario = new EstatisticasAdversario();
        estatisticasAdversario.setFormacaoComum("4-3-3");
        estatisticasAdversario.setGolsSofridos("20");
        estatisticasAdversario.setPosseMediaBola("50");
        estatisticasAdversarioRepository.save(estatisticasAdversario);

        EstatisticasAdversario estatisticasAdversarioInserido = estatisticasAdversarioRepository.findById(estatisticasAdversario.getCodigo()).get();

        Assertions.assertNotNull(estatisticasAdversarioInserido, "As estatisticas não foram inseridas.");
    }

    @Test
    public void testAtualizar() {
        EstatisticasAdversario estatisticasAdversario = new EstatisticasAdversario();
        estatisticasAdversario.setFormacaoComum("4-3-3");
        estatisticasAdversario.setGolsSofridos("20");
        estatisticasAdversario.setPosseMediaBola("50");

        EstatisticasAdversario estatisticasAdversarioAlterar = estatisticasAdversarioRepository.save(estatisticasAdversario);

        estatisticasAdversarioAlterar.setFormacaoComum("4-2-3-1");

        estatisticasAdversarioAlterar = estatisticasAdversarioRepository.save(estatisticasAdversarioAlterar);

        EstatisticasAdversario estatisticasAdversarioAlterada = estatisticasAdversarioRepository.findById(estatisticasAdversarioAlterar.getCodigo()).get();

        Assertions.assertEquals("4-2-3-1", estatisticasAdversarioAlterada.getFormacaoComum(), "A formação comum não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        EstatisticasAdversario estatisticasAdversario = new EstatisticasAdversario();
        estatisticasAdversario.setFormacaoComum("4-3-3");
        estatisticasAdversario.setGolsSofridos("20");
        estatisticasAdversario.setPosseMediaBola("50");
        EstatisticasAdversario estatisticasAdversarioDeletar = estatisticasAdversarioRepository.save(estatisticasAdversario);
        estatisticasAdversarioRepository.delete(estatisticasAdversarioDeletar);

        EstatisticasAdversario estatisticasAdversarioDeletado = estatisticasAdversarioRepository.findById(estatisticasAdversario.getCodigo()).orElse(null);
        Assertions.assertNotNull(estatisticasAdversarioDeletado,"As estatisticas ainda se encontra no banco.");
    }

    @Test
    public void testBuscarFormacaoComum() {
        EstatisticasAdversario estatisticasAdversario = new EstatisticasAdversario();
        estatisticasAdversario.setFormacaoComum("4-3-3");
        estatisticasAdversario.setGolsSofridos("20");
        estatisticasAdversario.setPosseMediaBola("50");

        estatisticasAdversarioRepository.save(estatisticasAdversario);

        List<EstatisticasAdversario> estatisticasAdversarios = estatisticasAdversarioRepository.
                findByFormacaoComum("4-3-3");
        Assertions.assertFalse(estatisticasAdversarios.isEmpty(),"Estatisticas do Adversario não encontrado.");
    }
}
