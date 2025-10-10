package br.com.empresa.gerenciadortarefas.service;

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
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarTarefaComSucesso() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Nova Tarefa");

        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa resultado = taskService.createTask(tarefa);

        assertNotNull(resultado);
        assertEquals("Nova Tarefa", resultado.getTitulo());
        verify(tarefaRepository, times(1)).save(tarefa);
    }

    @Test
    void deveLancarExcecaoAoCriarTarefaComTituloVazio() {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("");

        assertThrows(IllegalArgumentException.class, () -> taskService.createTask(tarefa));
        verify(tarefaRepository, never()).save(any(Tarefa.class));
    }
}
