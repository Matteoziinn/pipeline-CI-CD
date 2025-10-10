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
    private TarefaRepository tarefaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void limparBanco() {
        tarefaRepository.deleteAll();
    }

    @Test
    void deveCriarTarefaComSucesso() throws Exception {
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setTitulo("Estudar Spring Boot");

        mockMvc.perform(post("/api/tarefas") // 🔹 caminho ajustado
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(novaTarefa)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Estudar Spring Boot")) // 🔹 campo ajustado
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void deveListarTarefas() throws Exception {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo("Tarefa de teste");
        tarefaRepository.save(tarefa);

        mockMvc.perform(get("/api/tarefas")) // 🔹 caminho ajustado
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Tarefa de teste")); // 🔹 campo ajustado
    }
}
