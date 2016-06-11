package com.exemplo.repository;

import com.exemplo.domain.Endereco;
import com.exemplo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNome(Usuario usuario);

    @Query("select u.endereco from Usuario u where u.matricula = ?u")
    List<Endereco> findByMatricula(String matricula);

    Usuario findByEmail(String email);

}