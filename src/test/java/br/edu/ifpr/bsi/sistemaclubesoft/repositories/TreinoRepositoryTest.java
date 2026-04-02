package br.edu.ifpr.bsi.sistemaclubesoft.repositories;


import br.edu.ifpr.bsi.sistemaclubesoft.model.treino.Treino;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class TreinoRepositoryTest {

    @Autowired
    private TreinoRepository treinoRepository;

    @Test
    public void testInserir() {
        Treino treino = new Treino();
        treino.setClima("Ensolarado");
        treino.setDescricao("Treinamento Tatico");
        treino.setFocoTatico("Jogadas Ensaiadas");
        treino.setIntensidade("Forte");

        treinoRepository.save(treino);

        Treino treinoInserido = treinoRepository.findById(treino.getCodigo()).get();

        Assertions.assertNotNull(treinoInserido, "O torneio não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        Treino treino = new Treino();
        treino.setClima("Ensolarado");
        treino.setDescricao("Treinamento Tatico");
        treino.setFocoTatico("Jogadas Ensaiadas");
        treino.setIntensidade("Forte");

        Treino treinoAlterar = treinoRepository.save(treino);

        treinoAlterar.setIntensidade("Media");

        treinoAlterar = treinoRepository.save(treinoAlterar);

        Treino treinoAlterado = treinoRepository.findById(treinoAlterar.getCodigo()).get();

        Assertions.assertEquals("Media", treinoAlterado.getIntensidade(), "O Intensidade do treino não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Treino treino = new Treino();
        treino.setClima("Ensolarado");
        treino.setDescricao("Treinamento Tatico");
        treino.setFocoTatico("Jogadas Ensaiadas");
        treino.setIntensidade("Forte");
        Treino treinoDeletar = treinoRepository.save(treino);
        treinoRepository.delete(treinoDeletar);

        Treino treinoDeletado = treinoRepository.findById(treino.getCodigo()).orElse(null);
        Assertions.assertNotNull(treinoDeletado,"O treino ainda se encontra no banco.");
    }

    @Test
    public void testBuscarFocoTatico() {
        Treino treino = new Treino();
        treino.setClima("Ensolarado");
        treino.setDescricao("Treinamento Tatico");
        treino.setFocoTatico("Jogadas Ensaiadas");
        treino.setIntensidade("Forte");

        treinoRepository.save(treino);

        List<Treino> treinos = treinoRepository.findByFocoTatico("Jogadas Ensaiadas");
        Assertions.assertFalse(treinos.isEmpty(),"Treino não encontrado.");
    }
}
