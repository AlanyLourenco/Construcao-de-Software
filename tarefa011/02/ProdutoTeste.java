import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nomeloja;
    private double preco;
    private String descricao;

    public String getNomeloja() {
        return nomeloja;
    }

    public void setNomeloja(String nomeloja) {
        this.nomeloja = nomeloja;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return "Produto de informática";
    }
}

class Mouse extends Produto {
    private String tipo;

    public Mouse(String descricao) {
        super();
        setDescricao(descricao);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " - " + tipo;
    }
}

class Livro extends Produto {
    private String autor;

    public Livro(String descricao) {
        super();
        setDescricao(descricao);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " - " + autor;
    }
}

public class ProdutoTeste {
    public static void main(String[] args) {
        List<Produto> carrinho = new ArrayList<>();

        Mouse mouse1 = new Mouse("Mouse ótico, Saída USB. 1.600 dpi");
        mouse1.setTipo("Mouse com fio");
        carrinho.add(mouse1);

        Mouse mouse2 = new Mouse("Mouse sem fio, Bluetooth");
        mouse2.setTipo("Mouse sem fio");
        carrinho.add(mouse2);

        Livro livro1 = new Livro("Harry Potter e a Pedra Filosofal");
        livro1.setAutor("J.K. Rowling");
        carrinho.add(livro1);

        Livro livro2 = new Livro("1984");
        livro2.setAutor("George Orwell");
        carrinho.add(livro2);

        for (Produto produto : carrinho) {
            System.out.println(produto.getDescricao());
        }
    }
}
