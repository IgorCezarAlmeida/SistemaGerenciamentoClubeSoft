package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.escalacao.Escalacao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class EscalacaoRepositoryTest {

    @Autowired
    private EscalacaoRepository escalacaoRepository;

    @Test
    public void testInserir() {
        Escalacao escalacao = new Escalacao();
        escalacao.setEsquemaTatico("4-4-2");
        escalacao.setIstrucoes("Jogar no contra ataque.");
        escalacaoRepository.save(escalacao);

        Escalacao escalacaoInserida = escalacaoRepository.findById(escalacao.getCodigo()).get();

        Assertions.assertNotNull(escalacaoInserida, "A escalação não foi inserida.");
    }

    @Test
    public void testAtualizar() {
        Escalacao escalacao = new Escalacao();
        escalacao.setEsquemaTatico("4-4-2");
        escalacao.setIstrucoes("Jogar no contra ataque.");

        Escalacao escalacaoAlterar = escalacaoRepository.save(escalacao);

        escalacaoAlterar.setEsquemaTatico("4-3-3");

        escalacaoAlterar = escalacaoRepository.save(escalacaoAlterar);

        Escalacao escalacaoAlterada = escalacaoRepository.findById(escalacaoAlterar.getCodigo()).get();

        Assertions.assertEquals("4-3-3", escalacaoAlterada.getEsquemaTatico(), "O Esquema tatico não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Escalacao escalacao = new Escalacao();
        escalacao.setEsquemaTatico("4-4-2");
        escalacao.setIstrucoes("Jogar no contra ataque.");
        Escalacao escalacaoDeletar = escalacaoRepository.save(escalacao);
        escalacaoRepository.delete(escalacaoDeletar);

        Escalacao escalacaoDeletada = escalacaoRepository.findById(escalacao.getCodigo()).orElse(null);
        Assertions.assertNotNull(escalacaoDeletada,"A escalação ainda se encontra no banco.");
    }

    @Test
    public void testBuscarEsquemaTatico() {
        Escalacao escalacao = new Escalacao();
        escalacao.setEsquemaTatico("4-4-2");
        escalacao.setIstrucoes("Jogar no contra ataque.");

        escalacaoRepository.save(escalacao);

        List<Escalacao> escalacoes = escalacaoRepository.findByEsquemaTatico("4-4-2");
        Assertions.assertFalse(escalacoes.isEmpty(),"Escalação não encontrada.");
    }
}
