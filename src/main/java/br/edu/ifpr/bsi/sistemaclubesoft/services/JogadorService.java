package br.edu.ifpr.bsi.sistemaclubesoft.services;

import br.edu.ifpr.bsi.sistemaclubesoft.Mapper.JogadorMapper;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.Jogador;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorDetailDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.jogador.JogadorRequestDTO;
import br.edu.ifpr.bsi.sistemaclubesoft.model.lesao.Lesao;
import br.edu.ifpr.bsi.sistemaclubesoft.repositories.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.beans.Transient;
import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorMapper jogadorMapper;

    @Autowired
    private StorageService storageService;


    public List<JogadorDetailDTO> listar() {
        List<Jogador> clientes = jogadorRepository.findAll();
        return clientes.stream()
                .map(this.jogadorMapper::entityToDetailDTO)
                .toList();
    }

    public JogadorDetailDTO salvar(JogadorRequestDTO request) {
        Jogador jogador = this.jogadorMapper.requestDTOToEntity(request);
        if (jogador.getLesoes() != null && !jogador.getLesoes().isEmpty()) {
            jogador.getLesoes().forEach(lesao -> lesao.setJogador(jogador));
        }
        return this.jogadorMapper.entityToDetailDTO(this.jogadorRepository.save(jogador));
    }

    @Transactional
    public JogadorDetailDTO atualizar(Long codigo, JogadorRequestDTO request, MultipartFile imagem) {
        this.jogadorRepository.findById(codigo).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado"));
        Jogador jogador = this.jogadorMapper.requestDTOToEntity(request);
        jogador.setCodigo(codigo);

        if(imagem != null) {
            String urlImagem = storageService.upload(
                    "clientes",
                    imagem,
                    "imagem_cliente" + codigo
            );
            jogador.setUrlFotoJogador(urlImagem);
        }

        return this.jogadorMapper.entityToDetailDTO(this.jogadorRepository.save(jogador));
    }

    @Transactional
    public void excluir(Long codigo){
        try {
            Jogador jogadorExcluir = this.jogadorRepository.findById(codigo).orElse(null);
            jogadorRepository.delete(jogadorExcluir);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Jogador não encontrado" );
        }
    }
}
