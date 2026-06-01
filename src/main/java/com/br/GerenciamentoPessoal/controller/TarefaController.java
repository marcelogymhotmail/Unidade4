package com.br.GerenciamentoPessoal.controller;

import com.br.GerenciamentoPessoal.model.Tarefa;
import com.br.GerenciamentoPessoal.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarefas")
@RequiredArgsConstructor

public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    @Operation(summary = "Lista todas as tarefas")
    public ResponseEntity<List<Tarefa>> listarTodas() {

        return ResponseEntity.ok(
                tarefaService.listarTodas()
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma tarefa pelo ID")
    public ResponseEntity<Tarefa> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                tarefaService.buscarPorId(id)
        );
    }

    @PostMapping
    @Operation(summary = "Cria uma nova tarefa")
    public ResponseEntity<Tarefa> criar(
            @Valid @RequestBody Tarefa tarefa) {

        Tarefa novaTarefa =
                tarefaService.salvar(tarefa);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaTarefa);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma tarefa")
    public ResponseEntity<Tarefa> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Tarefa tarefa) {

        return ResponseEntity.ok(
                tarefaService.atualizar(id, tarefa)
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove uma tarefa")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        tarefaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}