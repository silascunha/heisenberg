package br.dev.silascunha.heisenberg.config;

import br.dev.silascunha.heisenberg.model.PerfilUsuario;
import br.dev.silascunha.heisenberg.model.Usuario;
import br.dev.silascunha.heisenberg.repository.PerfilRepository;
import br.dev.silascunha.heisenberg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UsuarioConfig implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    //cria um usuário admin padrão caso não exista nenhum usuário cadastrado
    @Override
    public void run(String... args) throws Exception {
        long quantidadeUsuarios = usuarioRepository.count();

        if (quantidadeUsuarios == 0) {
            String senhaAdmin = "unisalesBioFarm@2022";
            perfilRepository.deleteAll();

            PerfilUsuario perfil;

            List<PerfilUsuario> perfis = Arrays.asList(
                perfil = new PerfilUsuario(null, "admin")
            );

            Usuario usuarioAdmin = Usuario.builder()
                    .nomeCompleto("Usuario Admin")
                    .senha(passwordEncoder.encode(senhaAdmin))
                    .nomeUsuario("admin")
                    .build();

            usuarioAdmin.getPerfis().add(perfil);

            perfilRepository.saveAll(perfis);
            usuarioRepository.save(usuarioAdmin);
        }
    }
}
