package br.com.empresa.gerenciadortarefas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


import br.com.empresa.gerenciadortarefas.model.Tarefa;
import br.com.empresa.gerenciadortarefas.repository.TarefaRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TarefaRepository taskRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void limparBanco() {
        taskRepository.deleteAll();
    }

    @Test
    void deveCriarTarefaComSucesso() throws Exception {
        Tarefa novaTask = new Tarefa();
        novaTask.setTitulo("Estudar Spring Boot");

        mockMvc.perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(novaTask)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Estudar Spring Boot"))
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void deveListarTarefas() throws Exception {
        Tarefa task = new Tarefa();
        task.setTitulo("Tarefa de teste");
        taskRepository.save(task);

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Tarefa de teste"));
    }
}
