package br.com.alura.codechella.naousar.repository;

import br.com.alura.codechella.naousar.repository.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
