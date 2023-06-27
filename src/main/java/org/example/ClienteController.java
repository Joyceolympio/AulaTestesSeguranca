package org.example;

public class ClienteController {

    BancoDeClientes bancoDeClientes = new BancoDeClientes();

    public void cadastraCliente(Cliente cliente){

        if (bancoDeClientes.clienteJaExistente(cliente.getCpf())){
            throw new IllegalArgumentException("Cliente já é existente!");
        }

        bancoDeClientes.adicionarCliente(cliente);
    }


}
