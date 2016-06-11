package com.exemplo.service;

import com.exemplo.ApplicationMain;
import com.exemplo.domain.Usuario;
import com.exemplo.repository.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMain.class)
@WebAppConfiguration
public class UsuarioServiceTest {

    @Inject
    private UsuarioRepository usuarioRepository;

    @Inject
    private UsuarioService usuarioService;

    @Test
    public void should_find_the_user_after_a_save() {

        Usuario usuario = new Usuario();
        usuario.setUsername("toto");
        usuario.setPassword("toto");
        usuario.setEmail("toto@mail.me");

        Usuario savedUsuario = usuarioService.incluir(usuario);

        List<Usuario> usuarios = usuarioRepository.findAll();
        assertThat(usuarios, is(not(empty())));
        assertThat(usuarios, hasItem(savedUsuario));

    }

}