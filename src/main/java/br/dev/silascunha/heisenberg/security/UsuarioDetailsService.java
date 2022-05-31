package br.dev.silascunha.heisenberg.security;

import br.dev.silascunha.heisenberg.model.Usuario;
import br.dev.silascunha.heisenberg.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNomeUsuario(username).orElseThrow(() -> new UsernameNotFoundException("Usuario invalido"));

        return new User(usuario.getNomeUsuario(), usuario.getSenha(), carregarPermissoes(usuario));
    }

    private List<GrantedAuthority> carregarPermissoes(Usuario usuario) {
        List<GrantedAuthority> listaPermissoes = usuario.getPerfis().stream()
                .map(perfilUsuario -> "ROLE_" + perfilUsuario.getNome())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return listaPermissoes;
    }
}
