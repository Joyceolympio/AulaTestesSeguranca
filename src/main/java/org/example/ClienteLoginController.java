package org.example;

public class ClienteLoginController {

    ClienteService clienteService = new ClienteService();

    //Métodos
    public void cadastrarCliente(Cliente cliente){
        clienteService.adicionaCliente(cliente);
    }

    public void login(String senha){

        if (clienteService.login(senha)){
            System.out.println("Bem-vindo! :D");
        }else {
            System.out.println("Sua senha está incorreta! :(");
        }

    }

}
