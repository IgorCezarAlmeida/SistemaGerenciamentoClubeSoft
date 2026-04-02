package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class LesaoRepositoryTest {

    @Autowired
    private LesaoRepository lesaoRepository;

    @Test
    public void testInserir() {
        Lesao lesao = new Lesao();
        lesao.setPrevisaoRetorno("2 semanas");
        lesao.setInicio("01/01/2026");
        lesao.setGravidade("leve");
        lesao.setTipoLesao("Muscular");
        lesao.setObservacaoDP("Em fisioterapia");
        lesaoRepository.save(lesao);

        Lesao lesaoInserida = lesaoRepository.findById(lesao.getCodigo()).get();

        Assertions.assertNotNull(lesaoInserida, "A lesão não foi inserida.");
    }

    @Test
    public void testAtualizar() {
        Lesao lesao = new Lesao();
        lesao.setPrevisaoRetorno("2 semanas");
        lesao.setInicio("01/01/2026");
        lesao.setGravidade("leve");
        lesao.setTipoLesao("Muscular");
        lesao.setObservacaoDP("Em fisioterapia");

        Lesao lesaoAlterar = lesaoRepository.save(lesao);

        lesaoAlterar.setObservacaoDP("Voltando ao treinamento");

        lesaoAlterar = lesaoRepository.save(lesaoAlterar);

        Lesao lesaoAlterada = lesaoRepository.findById(lesaoAlterar.getCodigo()).get();

        Assertions.assertEquals("Voltando ao treinamento", lesaoAlterada.getObservacaoDP(), "O observação não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Lesao lesao = new Lesao();
        lesao.setPrevisaoRetorno("2 semanas");
        lesao.setInicio("01/01/2026");
        lesao.setGravidade("leve");
        lesao.setTipoLesao("Muscular");
        lesao.setObservacaoDP("Em fisioterapia");

        Lesao lesaoDeletar = lesaoRepository.save(lesao);
        lesaoRepository.delete(lesaoDeletar);

        Lesao lesaoDeletada = lesaoRepository.findById(lesao.getCodigo()).orElse(null);
        Assertions.assertNotNull(lesaoDeletada,"A lesao ainda se encontra no banco.");
    }

    @Test
    public void testBuscarTipoLesao() {
        Lesao lesao = new Lesao();
        lesao.setPrevisaoRetorno("2 semanas");
        lesao.setInicio("01/01/2026");
        lesao.setGravidade("leve");
        lesao.setTipoLesao("Muscular");
        lesao.setObservacaoDP("Em fisioterapia");

        lesaoRepository.save(lesao);

        List<Lesao> lesoes = lesaoRepository.findByTipoLesao("Muscular");
        Assertions.assertFalse(lesoes.isEmpty(),"Lesao não encontrada.");
    }
}
