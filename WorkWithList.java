import java.util.ArrayList;
import java.util.List;

public class Controller {
    // Atributo para armazenar a lista de livros
    private List<Livro> lista;

    // Construtor para inicializar os atributos
    public Controller() {
        // Inicializando a lista
        lista = new ArrayList<>();

        // Criando e adicionando um livro à lista
        Livro livro = new Livro("O Senhor dos Anéis", "Tolkien", "HarperCollins", "123456789", "1954", "Fantasia", "1ª Edição");
        lista.add(livro);
    }

    // Método para exibir os itens da lista
    public void exibirLista() {
        for (Livro livro : lista) {
            if(livro.getTitulo().equals("O Senhor dos Anéis") && livro.getAutor().equals("Tolkien") && livro.getEditora().equals("HarperCollins"))
                System.out.println("O Livro Já está cadastrado");
             else
                System.out.println("Item da lista: " + livro);
        }

    }

    // Método principal
    public static void main(String[] args) {
        // Instanciando a classe Controller
        Controller controller = new Controller();

        // Chamando o método para exibir a lista
        controller.exibirLista();
    }
}

