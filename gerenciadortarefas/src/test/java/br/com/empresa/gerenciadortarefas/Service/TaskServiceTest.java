package br.com.empresa.gerenciadortarefas.Service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.empresa.gerenciadortarefas.model.Tarefa;
import br.com.empresa.gerenciadortarefas.repository.TarefaRepository;
import br.com.empresa.gerenciadortarefas.service.TaskService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Mock
    private TarefaRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarTarefaComSucesso() {
        // Dado (Given)
        Tarefa task = new Tarefa();
        task.setTitulo("Nova Tarefa");

        when(taskRepository.save(any(Tarefa.class))).thenReturn(task);

        // Quando (When)
        Tarefa resultado = taskService.createTask(task);

        // Então (Then)
        assertNotNull(resultado);
        assertEquals("Nova Tarefa", resultado.getTitulo());
        verify(taskRepository, times(1)).save(task);
    }

    @Test
    void deveLancarExcecaoAoCriarTarefaComTituloVazio() {
        // Dado
        Tarefa task = new Tarefa();
        task.setTitulo("");

        // Quando e Então
        assertThrows(IllegalArgumentException.class, () -> taskService.createTask(task));
        verify(taskRepository, never()).save(any(Tarefa.class));
    }
}