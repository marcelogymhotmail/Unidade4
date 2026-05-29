package com.br.GerenciamentoPessoal.repository;

import com.br.GerenciamentoPessoal.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
