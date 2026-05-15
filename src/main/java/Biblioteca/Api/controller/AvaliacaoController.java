package Biblioteca.Api.controller;

import Biblioteca.Api.domain.Avaliacao;
import Biblioteca.Api.domain.Livro;
import Biblioteca.Api.repository.AvaliacaoRepository;
import Biblioteca.Api.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avaliacao inserir(@Valid @RequestBody Avaliacao avaliacao) {

        Long idLivro = avaliacao.getLivro().getId();

        Livro livro = livroRepository.findById(idLivro)
                .orElseThrow();

        avaliacao.setLivro(livro);

        return avaliacaoRepository.save(avaliacao);
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(avaliacaoRepository.findAll());
    }
}