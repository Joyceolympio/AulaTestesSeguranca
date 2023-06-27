import org.example.Cliente;
import org.example.ClienteController;
import org.example.ClienteLoginController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ClienteLoginController clienteController = new ClienteLoginController();

        System.out.println("Digite seu email: ");
        String email = entrada.next();

        System.out.println("Digite sua senha: ");
        String senha = entrada.next();

        Cliente cliente = new Cliente(email, senha);
        clienteController.cadastrarCliente(cliente);

        System.out.println("LOGIN");
        System.out.println("Digite sua senha: ");
        String senhaCadastrada = entrada.next();

        clienteController.login(senhaCadastrada);
    }

}
