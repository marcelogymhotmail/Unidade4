package com.br.GerenciamentoPessoal.service;

import com.br.GerenciamentoPessoal.exception.RecursoNaoEncontradoException;
import com.br.GerenciamentoPessoal.model.Tarefa;
import com.br.GerenciamentoPessoal.repository.TarefaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public List<Tarefa> listarTodas() {
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(Long id) {

        return tarefaRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNaoEncontradoException(
                                "Tarefa não encontrada"));
    }

    public Tarefa salvar(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa atualizar(Long id, Tarefa tarefaAtualizada) {

        Tarefa tarefa = buscarPorId(id);

        tarefa.setTitulo(tarefaAtualizada.getTitulo());
        tarefa.setDescricao(tarefaAtualizada.getDescricao());
        tarefa.setConcluida(tarefaAtualizada.getConcluida());

        return tarefaRepository.save(tarefa);
    }

    public void deletar(Long id) {

        Tarefa tarefa = buscarPorId(id);

        tarefaRepository.delete(tarefa);
    }
}