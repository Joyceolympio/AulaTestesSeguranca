package org.example;

import java.util.ArrayList;
import java.util.List;

public class BancoDeClientes {

    private List<Cliente> clientes = new ArrayList<>();

    //Métodos
    public boolean clienteJaExistente(String cpf){
        for (Cliente cliente : this.clientes){
            if (cliente.getCpf().equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso! :D");
    }

    public void iniciarBancoDeClientes(){
        adicionarCliente(new Cliente("Joy", 22, "223.927.840-43",
                "joyce@zup.com", "12345"));
        adicionarCliente(new Cliente("João", 19, "166.293.860-86",
                "joão@zup.com", "67890"));
        adicionarCliente(new Cliente("Maria", 49, "781.184.380-31",
                "joyce@zup.com", "12345"));
    }

    public void setClientes(List<Cliente> clientes){
        this.clientes = clientes;
    }

    public List<Cliente> getClientes(){
        return clientes;
    }

    public boolean verificaClienteExistente(String cpf){
        if (cpf == null){
            return true;
        }else{
            return false;
        }
    }
}
