package org.serratec.aula03.controller;

import jakarta.validation.Valid;
import org.serratec.aula03.domain.ClientePremium;
import org.serratec.aula03.repository.ClientePremiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente-premium")
public class ClientePremiumController {
    @Autowired
    private ClientePremiumRepository clientePremiumRepository;

    @GetMapping
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(clientePremiumRepository.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientePremium> buscarPorId(@PathVariable Long id) {
        return clientePremiumRepository.findById(id)
                .map(clientePremium -> ResponseEntity.ok(clientePremium))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<ClientePremium> salvar(@Valid @RequestBody ClientePremium clientePremium) {
        ClientePremium clienteSalvo = clientePremiumRepository.save(clientePremium);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientePremium> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClientePremium clientePremium) {

        if (!clientePremiumRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clientePremium.setId(id);
        ClientePremium clienteAtualizado = clientePremiumRepository.save(clientePremium);

        return ResponseEntity.ok(clienteAtualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!clientePremiumRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        clientePremiumRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}