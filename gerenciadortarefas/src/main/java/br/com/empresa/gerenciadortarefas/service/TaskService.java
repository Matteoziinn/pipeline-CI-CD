package br.com.empresa.gerenciadortarefas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.gerenciadortarefas.model.Tarefa;
import br.com.empresa.gerenciadortarefas.repository.TarefaRepository;

@Service
public class TaskService {

    private final TarefaRepository tarefaRepository;

    @Autowired
    public TaskService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Tarefa createTask(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("A tarefa não pode ser nula.");
        }

        String title = tarefa.getTitulo();

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título da tarefa não pode ser nulo ou vazio.");
        }

        
        tarefa.setConcluida(false); 

        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

        return tarefaSalva;
    }
}
