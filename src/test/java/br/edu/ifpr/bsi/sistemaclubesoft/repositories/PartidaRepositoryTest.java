package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.partida.Partida;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
public class PartidaRepositoryTest {
    @Autowired
    private PartidaRepository partidaRepository;

    @Test
    public void testInserir() {
        Partida partida = new Partida();
        partida.setLocal("Maracanã");
        partida.setHora("21:30");
        partida.setData(new Date("25/03/2026"));
        partidaRepository.save(partida);

        Partida partidaInserida = partidaRepository.findById(partida.getCodigo()).get();

        Assertions.assertNotNull(partidaInserida, "A partida não foi inserida.");
    }

    @Test
    public void testAtualizar() {
        Partida partida = new Partida();
        partida.setLocal("Maracanã");
        partida.setHora("21:30");
        partida.setData(new Date("25/03/2026"));

        Partida partidaAlterar = partidaRepository.save(partida);

        partidaAlterar.setLocal("Pacaembu");

        partidaAlterar = partidaRepository.save(partidaAlterar);

        Partida partidaAlterada = partidaRepository.findById(partidaAlterar.getCodigo()).get();

        Assertions.assertEquals("Pacaembu", partidaAlterada.getLocal(), "O local da partida não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Partida partida = new Partida();
        partida.setLocal("Maracanã");
        partida.setHora("21:30");
        partida.setData(new Date("25/03/2026"));

        Partida partidaDeletar = partidaRepository.save(partida);
        partidaRepository.delete(partidaDeletar);

        Partida partidaDeletada = partidaRepository.findById(partida.getCodigo()).orElse(null);
        Assertions.assertNull(partidaDeletada,"A partida ainda se encontra no banco.");
    }

    @Test
    public void testBuscarLocal(){
        Partida partida = new Partida();
        partida.setLocal("Maracanã");
        partida.setHora("21:30");
        partida.setData(new Date("25/03/2026"));

        partidaRepository.save(partida);

        List<Partida> partidas = partidaRepository.findByLocal("Maracanã");
        Assertions.assertFalse(partidas.isEmpty(),"Partida não encontrada.");
    }
}
