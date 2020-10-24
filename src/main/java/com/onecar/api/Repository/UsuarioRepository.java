package com.onecar.api.Repository;

import com.onecar.api.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer > {


    @Query("SELECT u FROM Usuario u WHERE u.login = ?1 AND u.senha = ?2")
    Optional<Usuario> findLoginAndSenha(String login,String senha);
    Optional<Usuario> findByCpf(String cpf);
}
