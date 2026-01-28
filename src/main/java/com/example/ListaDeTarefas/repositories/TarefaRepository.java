package com.example.ListaDeTarefas.repositories;

import com.example.ListaDeTarefas.models.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
