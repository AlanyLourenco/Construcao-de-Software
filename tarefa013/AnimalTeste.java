class Animal {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void emitirSom() {
        System.out.println("O animal emite um som.");
    }
}

class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O cachorro late: Au Au!");
    }

    public void correr() {
        System.out.println("O cachorro está correndo.");
    }
}

class Gato extends Animal {
    public Gato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O gato mia: Miau!");
    }

    public void correr() {
        System.out.println("O gato está correndo.");
    }
}

class Pato extends Animal {
    public Pato(String nome) {
        super(nome);
    }

    @Override
    public void emitirSom() {
        System.out.println("O pato faz: Quack!");
    }
}

class AnimalInvalidoException extends Exception {
    public AnimalInvalidoException() {
        super("Tipo de Animal Inválido");
    }
}

class Veterinario {
    public void examinar(Animal animal) throws AnimalInvalidoException {
        if (animal instanceof Cachorro || animal instanceof Gato || animal instanceof Pato) {
            animal.emitirSom();
        } else {
            throw new AnimalInvalidoException();
        }
    }
}

class Zoologico {
    private Animal[] jaulas;

    public Zoologico() {
        jaulas = new Animal[10];
        jaulas[0] = new Cachorro("Rex");
        jaulas[1] = new Gato("Mimi");
        jaulas[2] = new Pato("Donald");
        // Preencha as outras jaulas com animais de sua escolha
    }

    public void emitirSons() {
        for (Animal animal : jaulas) {
            if (animal != null) {
                animal.emitirSom();
                if (animal instanceof Cachorro) {
                    ((Cachorro) animal).correr();
                } else if (animal instanceof Gato) {
                    ((Gato) animal).correr();
                }
            }
        }
    }
}


public class AnimalTeste {
    public static void main(String[] args) {
        Veterinario veterinario = new Veterinario();

        Animal cachorro = new Cachorro("Rex");
        Animal gato = new Gato("Mimi");
        Animal pato = new Pato("Donald");

        try {
            veterinario.examinar(cachorro);
            veterinario.examinar(gato);
            veterinario.examinar(pato);
        } catch (AnimalInvalidoException e) {
            System.out.println(e.getMessage());
        }

        Zoologico zoologico = new Zoologico();
        zoologico.emitirSons();
    }
}
