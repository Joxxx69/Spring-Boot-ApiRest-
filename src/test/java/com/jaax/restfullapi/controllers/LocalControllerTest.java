package com.jaax.restfullapi.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.jaax.restfullapi.entity.Local;
import com.jaax.restfullapi.service.LocalService;

@WebMvcTest(LocalController.class)
public class LocalControllerTest {
    @Autowired
    private MockMvc mockMvc; // permite hacer pruebas a nuestro controlador

    @MockBean
    private LocalService localService;
    
    private Local local;

    @BeforeEach
    void setUp() {
        local = Local.builder()
                .id(1L)
                .name("Cinema")
                .floor("Fourth Floor")
                .code("Cin-040-4")
                .build();
    }
    @Test
    public void saveLocal() throws Exception {
        Local postLocal = Local.builder()
                .name("Cinema")
                .floor("Fourth Floor")
                .code("Cin-040-4")
                .build();
                
        Mockito.when(localService.saveLocal(postLocal)).thenReturn(local);
        mockMvc.perform(post("/saveLocal").contentType(MediaType.APPLICATION_JSON)
                .content("{\n"+
                        "    \"name\":\"Cinema\",\n"+
                        "     \"floor\":\"Fourth Floor\",\n"+
                        "       \"code\":\"Cin-040-4\"\n"+
                        "}"))
                .andExpect(status().isOk());
    }
}
