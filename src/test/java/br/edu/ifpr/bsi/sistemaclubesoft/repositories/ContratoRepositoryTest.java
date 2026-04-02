package br.edu.ifpr.bsi.sistemaclubesoft.repositories;

import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class ContratoRepositoryTest {

    @Autowired
    private ContratoRepository contratoRepository;

    @Test
    public void testInserir() {
        Contrato contrato = new Contrato();
        contrato.setTempoDeContrato(3);
        contrato.setSalario(1000000);
        contratoRepository.save(contrato);

        Contrato contratoInserido = contratoRepository.findById(contrato.getCodigo()).get();

        Assertions.assertNotNull(contratoInserido, "O contrato não foi inserido.");
    }

    @Test
    public void testAtualizar() {
        Contrato contrato = new Contrato();
        contrato.setTempoDeContrato(3);
        contrato.setSalario(1000000);

        Contrato contratoAlterar = contratoRepository.save(contrato);

        contratoAlterar.setSalario(1500000);

        contratoAlterar = contratoRepository.save(contratoAlterar);

        Contrato contratoAlterado = contratoRepository.findById(contratoAlterar.getCodigo()).get();

        Assertions.assertEquals(1500000, contratoAlterado.getSalario(), "O salario do contrato não foi atualizado.");
    }

    @Test
    public void testExcluir() {
        Contrato contrato = new Contrato();
        contrato.setTempoDeContrato(3);
        contrato.setSalario(1000000);
        Contrato contratoDeletar = contratoRepository.save(contrato);
        contratoRepository.delete(contratoDeletar);

        Contrato contratoDeletado = contratoRepository.findById(contrato.getCodigo()).orElse(null);
        Assertions.assertNotNull(contratoDeletado,"O contrato ainda se encontra no banco.");
    }

    @Test
    public void testBuscarSalario(){
        Contrato contrato = new Contrato();
        contrato.setTempoDeContrato(3);
        contrato.setSalario(1000000);

        contratoRepository.save(contrato);

        List<Contrato> contratos = contratoRepository.findBySalario(100000);
        Assertions.assertFalse(contratos.isEmpty(),"Contrato não encontrado.");
    }


}
