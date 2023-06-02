// Classe Animal
public class Animal {
    protected String nome;
    protected String som;

    public Animal(String nome, String som) {
        this.nome = nome;
        this.som = som;
    }

    public void emitirSom() {
        System.out.println(nome + " emite o som: " + som);
    }
}

// Classe Cachorro
public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome, "Au Au");
    }

    public void correr() {
        System.out.println(nome + " está correndo.");
    }
}

// Classe Cavalo
public class Cavalo extends Animal {
    public Cavalo(String nome) {
        super(nome, "Relincha");
    }

    public void correr() {
        System.out.println(nome + " está correndo.");
    }
}

// Classe Preguica
public class Preguica extends Animal {
    public Preguica(String nome) {
        super(nome, "Zzzzz");
    }

    public void subirArvore() {
        System.out.println(nome + " está subindo na árvore.");
    }
}
