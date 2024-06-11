package br.com.alura.codechella.naousar.repository.service;

import br.com.alura.codechella.naousar.repository.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();
}
