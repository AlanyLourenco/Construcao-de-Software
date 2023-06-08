import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contato {
    private String nome;
    private String email;

    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public Contato buscarContato(String nomeOuEmail) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nomeOuEmail) || contato.getEmail().equals(nomeOuEmail)) {
                return contato;
            }
        }
        return null;
    }

    public void excluirContato(String nome) {
        Contato contatoParaRemover = null;
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                contatoParaRemover = contato;
                break;
            }
        }
        if (contatoParaRemover != null) {
            contatos.remove(contatoParaRemover);
        }
    }

    public List<Contato> listarContatos() {
        return contatos;
    }
}

public class AgendaTeste {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Buscar contato");
            System.out.println("3. Excluir contato");
            System.out.println("4. Listar contatos");
            System.out.println("0. Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do contato:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email do contato:");
                    String email = scanner.nextLine();
                    Contato novoContato = new Contato(nome, email);
                    agenda.adicionarContato(novoContato);
                    System.out.println("Contato adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Digite o nome ou email do contato:");
                    String nomeOuEmail = scanner.nextLine();
                    Contato contatoEncontrado = agenda.buscarContato(nomeOuEmail);
                    if (contatoEncontrado != null) {
                        System.out.println("Contato encontrado:");
                        System.out.println("Nome: " + contatoEncontrado.getNome());
                        System.out.println("Email: " + contatoEncontrado.getEmail());
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Digite o nome do contato a ser excluído:");
                    String nomeExcluir = scanner.nextLine();
                    agenda.excluirContato(nomeExcluir);
                    System.out.println("Contato excluído com sucesso!");
                    break;
                case 4:
                    List<Contato> contatos = agenda.listarContatos();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato adicionado na agenda.");
                    } else {
                        System.out.println("Contatos na agenda:");
                        for (Contato contato : contatos) {
                            System.out.println("Nome: " + contato.getNome());
                            System.out.println("Email: " + contato.getEmail());
                            System.out.println("-----");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite um número válido.");
                    break;
            }

            System.out.println(); // Nova linha para separar as opções
        } while (opcao != 0);

        scanner.close();
    }
}
