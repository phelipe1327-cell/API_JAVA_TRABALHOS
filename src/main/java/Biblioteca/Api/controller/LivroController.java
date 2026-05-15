package Biblioteca.Api.controller;

import Biblioteca.Api.domain.Editora;
import Biblioteca.Api.domain.Livro;
import Biblioteca.Api.repository.EditoraRepository;
import Biblioteca.Api.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EditoraRepository editoraRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro inserir(@Valid @RequestBody Livro livro) {

        Long idEditora = livro.getEditora().getId();

        Editora editora = editoraRepository.findById(idEditora)
                .orElseThrow();

        livro.setEditora(editora);

        return livroRepository.save(livro);
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(livroRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return livroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}