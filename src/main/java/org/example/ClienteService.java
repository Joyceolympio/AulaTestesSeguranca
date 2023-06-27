package org.example;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    List<Cliente> clientes = new ArrayList<>();

    //Métodos
    public void adicionaCliente(Cliente cliente){
        criptografarSenha(cliente);
        clientes.add(cliente);
    }

    public void criptografarSenha(Cliente cliente){
        String hashDaSenha = BCrypt.hashpw(cliente.getSenha(), BCrypt.gensalt());
        cliente.setSenha(hashDaSenha);
    }

    public String mostraSenha(){
        return clientes.get(0).getSenha();
    }

    public boolean login(String senha){
        return BCrypt.checkpw(senha, clientes.get(0).getSenha());
    }



}
