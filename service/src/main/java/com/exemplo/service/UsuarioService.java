package com.exemplo.service;

import com.exemplo.domain.Usuario;
import com.exemplo.repository.UsuarioRepository;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario incluir(Usuario usuario) {
        Preconditions.checkNotNull(usuario.getMatricula(), "A mátricula do usuário é inválida.");
        return usuarioRepository.save(usuario);
    }

    public Usuario detalhar(Long id) {
        return usuarioRepository.findOne(id);
    }

}
