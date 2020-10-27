package com.onecar.api.Service;

import com.onecar.api.Entity.Usuario;
import com.onecar.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;

    @Value("${contato.disco.raiz}")
    private String raiz;

    @Value("${contato.disco.diretorio-fotos}")
    private String diretorioFotos;

    public Usuario buscarPorId(Integer idUsuario) {
        return repository.findById(idUsuario).get();
    }

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }


    public Usuario buscarLogin(Usuario usuario) {
        Optional<Usuario> user = repository.findLoginAndSenha(usuario.getLogin(), usuario.getSenha());
        if (!user.isPresent()) {
            throw new RuntimeException("Credenciais nao encontradas");
        }
        return user.get();
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        Optional<Usuario> cpf = repository.findByCpf(usuario.getCpf());
        if (cpf.isPresent()) {
            throw new RuntimeException("Ja existe Usuario com esse cpf");
        }
        return repository.save(usuario);
    }


    public void salvarAvatar(MultipartFile arquivo, Integer idUsuario) {
        Path diretorioPath = Paths.get(this.raiz, this.diretorioFotos);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        Usuario usuario = repository.findById(idUsuario).get();
        usuario.setAvatar(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());
            repository.save(usuario);
        } catch (IOException e) {
            throw new RuntimeException("Problemas na tentativa de salvar arquivo.", e);
        }

    }


}
