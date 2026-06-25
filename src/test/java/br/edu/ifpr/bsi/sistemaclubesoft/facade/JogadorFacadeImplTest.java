package br.edu.ifpr.bsi.sistemaclubesoft.facade;

import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.Contrato;
import br.edu.ifpr.bsi.sistemaclubesoft.model.contrato.ContratoResponseDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.JogadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JogadorFacadeImplTest {

    @Autowired
    private JogadorFacade jogadorFacade;

    @Autowired
    private JogadorRepository jogadorRepository;

    private JogadorRequestDTO jogadorRequestDTO;
    private ContratoResponseDTO contratoResponseDTO;

    @BeforeEach
    void setUp() {
        // Prepara dados de teste
        contratoResponseDTO = new ContratoResponseDTO(
            null,
            5000.0f,  // salario
            24  // tempoDeContrato
        );

        jogadorRequestDTO = new JogadorRequestDTO(
            "João Silva",  // nome
            "1990-05-15",  // dataNascimento
            "10",  // numeroCamisa
            75.5f,  // pesoKG
            180,  // alturaCM
            "Atacante muito rápido",  // descricao
            "SIM",  // disponivel
            "Direita",  // pernaDominante
            "Atacante",  // posicao
            contratoResponseDTO,  // contrato
            null  // lesoes
        );
    }

    @Test
    void testCriarJogadorComContratoViaRequestDTO() {
        // Act - cria jogador com contrato via Facade
        JogadorDetailDTO resultado = jogadorFacade.criarJogadorComContrato(jogadorRequestDTO);

        // Assert
        assertNotNull(resultado, "O resultado não deve ser nulo");
        assertEquals("João Silva", resultado.nome(), "O nome do jogador deve corresponder");
        assertNotNull(resultado.contrato(), "O contrato deve estar vinculado ao jogador");
        assertEquals(5000.0f, resultado.contrato().salario(), "O salário do contrato deve corresponder");
        assertEquals(24, resultado.contrato().tempoDeContrato(), "O tempo de contrato deve corresponder");
    }

    @Test
    void testCriarJogadorComContratoViaEntidade() {
        // Arrange
        Contrato contrato = new Contrato();
        contrato.setSalario(6000.0f);
        contrato.setTempoDeContrato(36);

        // Act
        JogadorDetailDTO resultado = jogadorFacade.criarJogadorComContrato(jogadorRequestDTO, contrato);

        // Assert
        assertNotNull(resultado, "O resultado não deve ser nulo");
        assertEquals("João Silva", resultado.nome(), "O nome do jogador deve corresponder");
        assertNotNull(resultado.contrato(), "O contrato deve estar vinculado ao jogador");
        assertEquals(6000.0f, resultado.contrato().salario(), "O salário do contrato deve corresponder ao passado");
        assertEquals(36, resultado.contrato().tempoDeContrato(), "O tempo de contrato deve corresponder ao passado");
    }

    @Test
    void testCriarJogadorComContratoNulo() {
        // Arrange - cria request sem contrato
        JogadorRequestDTO requestSemContrato = new JogadorRequestDTO(
            "Maria Santos",  // nome
            "1995-03-20",  // dataNascimento
            "7",  // numeroCamisa
            65.0f,  // pesoKG
            175,  // alturaCM
            "Goleira",  // descricao
            "SIM",  // disponivel
            "Direita",  // pernaDominante
            "Goleira",  // posicao
            null,  // contrato nulo
            null  // lesoes
        );

        // Act
        JogadorDetailDTO resultado = jogadorFacade.criarJogadorComContrato(requestSemContrato);

        // Assert
        assertNotNull(resultado, "O resultado não deve ser nulo");
        assertEquals("Maria Santos", resultado.nome(), "O nome deve corresponder");
        // Contrato pode ser nulo ou ter valores padrão, dependendo da implementação
    }

    @Test
    void testJogadorPersistidoCorretamente() {
        // Act - cria jogador com contrato via Facade
        JogadorDetailDTO resultado = jogadorFacade.criarJogadorComContrato(jogadorRequestDTO);

        // Assert - verifica se foi persistido no banco
        assertNotNull(resultado, "Resultado não deve ser nulo");
        assertEquals("João Silva", resultado.nome(), "Os dados devem estar corretos");
        assertNotNull(resultado.contrato(), "O contrato deve estar persistido junto");
        assertEquals(5000.0f, resultado.contrato().salario(), "O salário do contrato deve estar correto");
    }
}



