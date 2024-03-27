import java.util.*;
import java.io.*;

class CadastroClientes implements Serializable {
    private ArrayList<Cliente> clientes;

    public CadastroClientes() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void visualizarClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void salvarClientes(String nomeArquivo) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            outputStream.writeObject(clientes);
        }
    }

    public void carregarClientes(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            clientes = (ArrayList<Cliente>) inputStream.readObject();
        }
    }
}
