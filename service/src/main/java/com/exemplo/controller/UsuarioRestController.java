package com.exemplo.controller;

import com.exemplo.domain.Usuario;
import com.exemplo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Usuario> incluir(@RequestBody Usuario usuario) {
        Usuario banco = usuarioService.incluir(usuario);
        return new ResponseEntity(banco, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> detalhar(@PathVariable("id") Long id) {
        return new ResponseEntity(usuarioService.detalhar(id), HttpStatus.OK);
    }

}
