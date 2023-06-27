package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @Mock
    private BancoDeClientes bancoDeClientes;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void cadastraClienteComCpfRepetido(){

        Cliente cliente = new Cliente("Marcos", 28, "166.293.860-86",
                "marcos@zup.com", "00000");

        //quando eu chamar o método clienteJaExistente, me retorna um true
        when(bancoDeClientes.clienteJaExistente(cliente.getCpf())).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> clienteController.cadastraCliente(cliente));

        //verifica se eu nunca salvei esse cliente
        verify(bancoDeClientes, never()).adicionarCliente(cliente);

    }

    @Test
    public void cadastraClienteComCpfNovo(){

        Cliente cliente = new Cliente("João", 33, "000.000.000-1",
                "joao@zup.com", "11111");

        when(bancoDeClientes.clienteJaExistente(cliente.getCpf())).thenReturn(false);
        clienteController.cadastraCliente(cliente);
        verify(bancoDeClientes, times(1)).adicionarCliente(cliente);

    }




}
