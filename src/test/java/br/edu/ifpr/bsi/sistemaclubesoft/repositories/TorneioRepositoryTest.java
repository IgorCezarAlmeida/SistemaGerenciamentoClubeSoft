package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import br.edu.ifpr.bsi.sistemaclubesoft.model.torneio.Torneio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
public class TorneioRepositoryTest {

    @Autowired
    private TorneioRepository torneioRepository;

    @Test
    public void testInserir() {
        Torneio torneio = new Torneio();
        torneio.setNome("Brasileirão");
        torneio.setTipo("Liga");
        torneio.setTemporada("2026");
        torneioRepository.save(torneio);

        Torneio torneioInserido = torneioRepository.findById(torneio.getCodigo()).get();

        Assertions.assertNotNull(torneioInserido, "O torneio não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        Torneio torneio = new Torneio();
        torneio.setNome("Brasileirão");
        torneio.setTipo("Liga");
        torneio.setTemporada("2026");

        Torneio torneioAlterar = torneioRepository.save(torneio);

        torneioAlterar.setNome("Brasileirão Betano");

        torneioAlterar = torneioRepository.save(torneioAlterar);

        Torneio torneioAlterado = torneioRepository.findById(torneioAlterar.getCodigo()).get();

        Assertions.assertEquals("Brasileirão Betano", torneioAlterado.getNome(), "O nome do torneio não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Torneio torneio = new Torneio();
        torneio.setNome("Brasileirão");
        torneio.setTipo("Liga");
        torneio.setTemporada("2026");
        Torneio torneioDeletar = torneioRepository.save(torneio);
        torneioRepository.delete(torneioDeletar);

        Torneio torneioDeletado = torneioRepository.findById(torneio.getCodigo()).orElse(null);
        Assertions.assertNotNull(torneioDeletado,"O torneio ainda se encontra no banco.");
    }

    @Test
    public void testBuscarNome(){
        Torneio torneio = new Torneio();
        torneio.setNome("Brasileirão");
        torneio.setTipo("Liga");
        torneio.setTemporada("2026");

        torneioRepository.save(torneio);

        List<Torneio> torneios = torneioRepository.findByNome("Brasileirao");
        Assertions.assertFalse(torneios.isEmpty(),"Torneio não encontrado.");
    }

    @Test
    public void testInserirPartida(){
        Torneio torneio = new Torneio();
        torneio.setNome("Brasileirão");
        torneio.setTipo("Liga");
        torneio.setTemporada("2026");

        List<Partida>  partidas = new ArrayList<>();
        Partida p1 = new Partida();
        p1.setTorneio(torneio);
        p1.setData(new Date("11/11/2026"));
        p1.setHora("21:30");
        p1.setLocal("Maracanã");
        partidas.add(p1);

        torneio.setPartidas(partidas);
        Torneio torneioInserir = torneioRepository.save(torneio);
        Torneio torneioInserido = torneioRepository.findById(torneioInserir.getCodigo()).get();
        Assertions.assertNotNull(torneioInserido.getPartidas());
        Assertions.assertFalse(torneioInserido.getPartidas().isEmpty(),"As partidas do torneio não foram inseridas corretamente.");

    }
}
