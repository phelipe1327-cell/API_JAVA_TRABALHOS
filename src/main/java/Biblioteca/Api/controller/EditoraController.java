package Biblioteca.Api.controller;

import Biblioteca.Api.domain.Editora;
import Biblioteca.Api.repository.EditoraRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    @Autowired
    private EditoraRepository editoraRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Editora inserir(@Valid @RequestBody Editora editora) {
        return editoraRepository.save(editora);
    }

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(editoraRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Editora> buscarPorId(@PathVariable Long id) {
        return editoraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}