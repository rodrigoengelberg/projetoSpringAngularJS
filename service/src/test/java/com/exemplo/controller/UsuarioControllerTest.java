package com.exemplo.controller;

import com.exemplo.ApplicationMain;
import com.exemplo.service.UsuarioService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class)
@WebAppConfiguration
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    private MockMvc restUserMockMvc;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);
        UsuarioRestController usuarioRestController = new UsuarioRestController();
        ReflectionTestUtils.setField(usuarioRestController, "usuarioService", usuarioService);
        this.restUserMockMvc = MockMvcBuilders.standaloneSetup(usuarioRestController).build();

    }
}