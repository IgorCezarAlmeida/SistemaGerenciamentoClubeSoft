package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.tecnico.Tecnico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class TecnicoRepositoryTest {
    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Test
    public void testInserir() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Igor");
        tecnico.setDataNascimento("04/10/2005");
        tecnico.setEmail("ii@gmail.com");
        tecnico.setSenha("123456");
        tecnicoRepository.save(tecnico);

        Tecnico tecnicoInserido = tecnicoRepository.findById(tecnico.getCodigo()).get();

        Assertions.assertNotNull(tecnicoInserido, "O tecnico não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Igor");
        tecnico.setDataNascimento("04/10/2005");
        tecnico.setEmail("ii@gmail.com");
        tecnico.setSenha("123456");

        Tecnico tecnicoAlterar = tecnicoRepository.save(tecnico);

        tecnicoAlterar.setNome("Igor Cezar");

        tecnicoAlterar = tecnicoRepository.save(tecnicoAlterar);

        Tecnico tecnicoAlterado = tecnicoRepository.findById(tecnicoAlterar.getCodigo()).get();

        Assertions.assertEquals("Igor Cezar", tecnicoAlterado.getNome(), "O nome do tecnico não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Tecnico tecnico = new Tecnico();
        tecnico.setNome("Igor");
        tecnico.setDataNascimento("04/10/2005");
        tecnico.setEmail("ii@gmail.com");
        tecnico.setSenha("123456");
        Tecnico tecnicoDeletar = tecnicoRepository.save(tecnico);
        tecnicoRepository.delete(tecnicoDeletar);

        Tecnico tecnicoDeletado = tecnicoRepository.findById(tecnico.getCodigo()).orElse(null);
        Assertions.assertNotNull(tecnicoDeletado,"O tecnico ainda se encontra no banco.");
    }

}
