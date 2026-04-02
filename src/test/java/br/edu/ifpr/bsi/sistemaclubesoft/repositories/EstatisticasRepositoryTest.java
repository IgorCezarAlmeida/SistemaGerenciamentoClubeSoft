package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.estatisticas.Estatisticas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class EstatisticasRepositoryTest {

    @Autowired
    private EstatisticasRepository estatisticasRepository;

    @Test
    public void testInserir() {
        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setGols(20);
        estatisticas.setAssistencias(5);
        estatisticas.setDesarmes(2);
        estatisticas.setJogos(40);
        estatisticas.setPasses(90);
        estatisticas.setCartoesAmarelos(1);
        estatisticas.setCartoesVermelhos(0);
        estatisticas.setMinutosJogados(2500);
        estatisticasRepository.save(estatisticas);

        Estatisticas estatisticasInserido = estatisticasRepository.findById(estatisticas.getCodigo()).get();

        Assertions.assertNotNull(estatisticasInserido, "As estatisticas não foram inseridas.");
    }

    @Test
    public void testAtualizar() {
        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setGols(20);
        estatisticas.setAssistencias(5);
        estatisticas.setDesarmes(2);
        estatisticas.setJogos(40);
        estatisticas.setPasses(90);
        estatisticas.setCartoesAmarelos(1);
        estatisticas.setCartoesVermelhos(0);
        estatisticas.setMinutosJogados(2500);

        Estatisticas estatisticasAlterar = estatisticasRepository.save(estatisticas);

        estatisticasAlterar.setJogos(44);

        estatisticasAlterar = estatisticasRepository.save(estatisticasAlterar);

        Estatisticas estatisticasAlterada = estatisticasRepository.findById(estatisticasAlterar.getCodigo()).get();

        Assertions.assertEquals(44, estatisticasAlterada.getJogos(), "Os jogos do jogador não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setGols(20);
        estatisticas.setAssistencias(5);
        estatisticas.setDesarmes(2);
        estatisticas.setJogos(40);
        estatisticas.setPasses(90);
        estatisticas.setCartoesAmarelos(1);
        estatisticas.setCartoesVermelhos(0);
        estatisticas.setMinutosJogados(2500);
        Estatisticas estatisticasDeletar = estatisticasRepository.save(estatisticas);
        estatisticasRepository.delete(estatisticasDeletar);

        Estatisticas estatisticasDeletado = estatisticasRepository.findById(estatisticas.getCodigo()).orElse(null);
        Assertions.assertNotNull(estatisticasDeletado,"As estatisticas ainda se encontram no banco.");
    }

    @Test
    public void testBuscarGols(){
        Estatisticas estatisticas = new Estatisticas();
        estatisticas.setGols(20);
        estatisticas.setAssistencias(5);
        estatisticas.setDesarmes(2);
        estatisticas.setJogos(40);
        estatisticas.setPasses(90);
        estatisticas.setCartoesAmarelos(1);
        estatisticas.setCartoesVermelhos(0);
        estatisticas.setMinutosJogados(2500);

        estatisticasRepository.save(estatisticas);

        List<Estatisticas> estatisticas1 = estatisticasRepository.findByGols(20);
        Assertions.assertFalse(estatisticas1.isEmpty(),"Estatistica não encontrada.");
    }
}
