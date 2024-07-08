package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.entities.usuario.FabricaDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Jacque",
                        LocalDate.parse("2001-11-19"), "caio@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999", "Caio",
                        LocalDate.parse("2001-11-19"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Fulano",
                        LocalDate.parse("2001-11-19"), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabricaDeUsuario = new FabricaDeUsuario();
        Usuario usuario = fabricaDeUsuario.comNomeCpfNascimento("Caio", "192.168.897-88",
                LocalDate.parse("2001-11-19"));

        Assertions.assertEquals("Caio", usuario.getNome());

        usuario = fabricaDeUsuario.incluiEndereco("07179222", 123, "");

        Assertions.assertEquals("", usuario.getEndereco().getComplemento());
    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {

        // Crio uma data de nascimento que subtrai 17 anos da data atual
        LocalDate dataNascimento = LocalDate.now().minusYears(17);  // Um usuário com 17 anos

        // Crio uma exceção e atribuo a ela o resultado do teste de idade mínima, pois o correto é que a exceção seja lançada.
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-00", "Fulano", dataNascimento, "fulano@example.com");
        });

        // Confiro se a mensagem da exceção é a mensagem que eu esperava, referente à idade inferior
        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }
}
