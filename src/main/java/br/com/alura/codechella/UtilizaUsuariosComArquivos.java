package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuariosEmArquivos;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivos {

    public static void main(String[] args) {
        RepositorioDeUsuariosEmArquivos repositorioDeUsuariosEmArquivos = new RepositorioDeUsuariosEmArquivos();

        repositorioDeUsuariosEmArquivos.cadastrarUsuario(new Usuario("456.789.888-88", "João",
                LocalDate.parse("2000-10-15"), "joao@gmail.com"));

        repositorioDeUsuariosEmArquivos.cadastrarUsuario(new Usuario("456.789.888-88", "João",
                LocalDate.parse("2000-10-15"), "maria@gmail.com"));

        repositorioDeUsuariosEmArquivos.cadastrarUsuario(new Usuario("456.789.888-88", "João",
                LocalDate.parse("2000-10-15"), "vinicios@gmail.com"));

        repositorioDeUsuariosEmArquivos.cadastrarUsuario(new Usuario("456.789.888-88", "João",
                LocalDate.parse("2000-10-15"), "caio@gmail.com"));

//        System.out.println(repositorioDeUsuariosEmArquivos.listarTodos());
        repositorioDeUsuariosEmArquivos.gravaEmArquivo("usuarios.txt");

    }
}
