package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.*;

import jakarta.validation.Valid;
import med.voll.api.dto.DtoAutenticacao;
import med.voll.api.dto.DtoToken;
import med.voll.api.entity.Usuario;
import med.voll.api.repository.UsuarioRepository;
import med.voll.api.service.TokenService;

@RequestMapping("/login")
@RestController
public class AutentitcacaoController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepository repository;

    @Autowired
    TokenService tokenService;
    
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DtoAutenticacao dto){
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
        var authenticated = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authenticated.getPrincipal());
        return ResponseEntity.ok(new DtoToken(tokenJWT));
        
    }
}
